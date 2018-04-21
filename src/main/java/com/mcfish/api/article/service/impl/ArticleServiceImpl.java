package com.mcfish.api.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.alibaba.fastjson.JSON;
import com.mcfish.api.article.service.IArticleService;
import com.mcfish.base.exception.MyException;
import com.mcfish.base.service.BaseService;
import com.mcfish.common.model.AddArticleMode;
import com.mcfish.common.model.ArticleAuthStatus;
import com.mcfish.common.model.TbArticle;
import com.mcfish.common.model.TbArticleAuth;
import com.mcfish.common.model.TbArticleAuthRange;
import com.mcfish.common.model.TbArticleComment;
import com.mcfish.common.model.TbArticleCommentLikes;
import com.mcfish.common.model.TbArticleCommentReply;
import com.mcfish.common.model.TbArticleGood;
import com.mcfish.common.model.TbArticleMain;
import com.mcfish.common.model.TbUserCollectionArticle;
import com.mcfish.util.resultutil.ResultUtil;

@Service
public class ArticleServiceImpl extends BaseService implements IArticleService{
	
	@Override
	@Transactional
	public Object newArticle(int uid, AddArticleMode model)  {
		//插入文章
		TbArticle article = new TbArticle();
		article.setAddress(model.getAddress());
		article.setContent(model.getContent());
		article.setLat(model.getLat());
		article.setLng(model.getLng());
		article.setTag(model.getTag());
		article.setTitle(model.getTitle());
		article.setUrl(model.getUrl());
		tbArticleMapper.insertSelective(article);
		
		//插入文章描述清单
		TbArticleMain articleMain = new TbArticleMain();
		articleMain.setArticleId(article.getId());
		articleMain.setType(model.getType());
		articleMain.setOriginalArticleId(model.getOriginalArticleId());
		articleMain.setUserId(uid);
		tbArticleMainMapper.insertSelective(articleMain);
		
		//插入权限标识
		TbArticleAuth articleAuth = new TbArticleAuth();
		articleAuth.setArticleId(article.getId());
		articleAuth.setRange(model.getType());
		tbArticleAuthMapper.insertSelective(articleAuth);
		
		if(model.getRang() == 2) {
			if(model.getUserids() != null) {
				String[] uidArr = model.getUserids().split(",");
				for(String uidStr : uidArr) {
					Integer authUid = Integer.parseInt(uidStr);
					TbArticleAuthRange articleAuthRange = new TbArticleAuthRange();
					articleAuthRange.setAuthId(articleAuth.getId()); //关联权限标识id
					articleAuthRange.setUserId(authUid); //关联用户id
					tbArticleAuthRangeMapper.insertSelective(articleAuthRange);//插入能查看帖子的用户id
				}
			}
			
			//插入家庭成员权限标识
			if(model.getFamilyids() != null) {
				String[] familyIds = model.getFamilyids().split(",");
				for (String familyIdStr : familyIds) {
					Integer familyId = Integer.parseInt(familyIdStr);
					@SuppressWarnings("unchecked")
					List<Map<String, Object>> users = baseDao.selectListByOne("TbUserFamilyMember_selectFamilyMember", familyId);
					for(Map<String, Object> user : users) {
						TbArticleAuthRange articleAuthRange = new TbArticleAuthRange();
						articleAuthRange.setAuthId(articleAuth.getId());
						articleAuthRange.setUserId((Integer) user.get("uid"));
						tbArticleAuthRangeMapper.insertSelective(articleAuthRange);
					}
				}
			}
		}
		
		return ResultUtil.returnNull();
	}
	

	@Override
	public Object getArticleDetail(int uid, Integer articleId) {
		ArticleAuthStatus articleAuthStatus = selectArticleAuthStatus(uid, articleId);
		if(articleAuthStatus.getStatus() == 1) {
			return ResultUtil.returnFail("文章已经被冻结", 1);
		}
		if(articleAuthStatus.getHaveAuth() != 1) {
			return ResultUtil.returnFail("没有权限查看", 1);
		}
		Object article = baseDao.selectObjectByOne("TbArticle_selectArticleById", articleId);
		if(article == null) {
			return ResultUtil.returnFail("没有指定文章", 1);
		}
		return ResultUtil.returnSuccess(article, 1);
	}

	@Override
	public Object publishArticleComment(int uid, Integer articleId, Integer touid, Integer cid, String comment)  {
		TbArticleComment articleComment = null;
		if(touid != null && cid != null) {
			articleComment = tbArticleCommentMapper.selectByPrimaryKey(cid);
			if(tbArticleCommentMapper == null) {
				return ResultUtil.returnFail("评论不存在", 1);
			}
			TbArticleCommentReply articleCommentReply = new TbArticleCommentReply();
			articleCommentReply.setContent(comment);
			articleCommentReply.setToUid(touid);
			articleCommentReply.setFromUid(uid);
			articleCommentReply.setCommentId(cid);
			tbArticleCommentReplyMapper.insertSelective(articleCommentReply);
		} else {
			articleComment = new TbArticleComment();
			articleComment.setArticleId(articleId);
			articleComment.setContent(comment);
			articleComment.setUserId(uid);
			tbArticleCommentMapper.insertSelective(articleComment);
		}
		return ResultUtil.returnNull();
	}

	@Override
	public Object editArticle(int uid, Integer articleId, String title, String content)  {
		//判断是否是自己的帖子
		TbArticleMain articleMain = new TbArticleMain();
		articleMain.setArticleId(articleId);
		articleMain.setUserId(uid);
		List<TbArticleMain> list = TbArticleMainMapper.select(articleMain);
		if(list.isEmpty()) {
			return ResultUtil.returnFail("无权限编辑", 1);
		}
		TbArticle article = tbArticleMapper.selectByPrimaryKey(articleId);
		if(article == null) {
			return ResultUtil.returnFail("文章不存在", 1);
		}
		article.setTitle(title);
		article.setContent(content);
		tbArticleMapper.updateByPrimaryKey(article);
		return ResultUtil.returnNull();
	}


	@Override
	public Object deleArticle(int uid, Integer articleId)  {
		//判断是否是自己的帖子
		TbArticleMain articleMain = new TbArticleMain();
		articleMain.setArticleId(articleId);
		articleMain.setUserId(uid);
		List<TbArticleMain> list = TbArticleMainMapper.select(articleMain);
		if(list.isEmpty()) {
			return ResultUtil.returnFail("无权限删除", 1);
		}
		
		TbArticle article = tbArticleMapper.selectByPrimaryKey(articleId);
		if(article == null) {
			return ResultUtil.returnFail("文章不存在", 1);
		}
		
		//删除文章
		tbArticleMapper.deleteByPrimaryKey(article.getId());
		
		//删除权限标识
		TbArticleAuth articleAuth = new TbArticleAuth();
		articleAuth.setArticleId(articleId);
		tbArticleAuthMapper.delete(articleAuth);
		
		//删除权限范围记录
		List<TbArticleAuth> articleAuths = tbArticleAuthMapper.select(articleAuth);
		if (!articleAuths.isEmpty()) {
			tbArticleAuthMapper.delete(articleAuth);
			TbArticleAuthRange articleAuthRange = new TbArticleAuthRange();
			articleAuthRange.setAuthId(articleAuths.get(0).getId());
			tbArticleAuthRangeMapper.delete(articleAuthRange);
		}
		
		return ResultUtil.returnNull();
	}

	@Override
	public Object likesArticle(int uid, Integer articleId)  {
		TbArticleGood articleGood = new TbArticleGood();
		articleGood.setUserId(uid);
		articleGood.setArticleId(articleId);
		List<TbArticleGood> list = tbArticleGoodMapper.select(articleGood);
		if(!list.isEmpty()) {
			return ResultUtil.returnFail("已经点赞过该文章", 1);
		}
		
		tbArticleGoodMapper.insertSelective(articleGood);
		return ResultUtil.returnNull();
	}

	@Override
	public Object replyArticle(int uid, Integer commentId)  {
		TbArticleCommentLikes articleCommentLikes = new TbArticleCommentLikes();
		articleCommentLikes.setUserId(uid);
		articleCommentLikes.setCommentId(commentId);
		if(!tbArticleCommentLikesMapper.select(articleCommentLikes).isEmpty()) {
			return ResultUtil.returnFail("已经点赞过该评论", 1);
		}
		
		tbArticleCommentLikesMapper.insertSelective(articleCommentLikes);
		return ResultUtil.returnNull();
	}

	@Override
	public Object collectionArticle(int uid, Integer articleId)  {
		ArticleAuthStatus articleAuthStatus = selectArticleAuthStatus(uid, articleId);
		if(articleAuthStatus.getStatus() == 1) {
			return ResultUtil.returnFail("收藏失败，文章已经被冻结", 1);
		}
		if(articleAuthStatus.getHaveAuth() != 1) {
			return ResultUtil.returnFail("您无权收藏该文章", 1);
		}
		TbUserCollectionArticle userCollectionArticle = new TbUserCollectionArticle();
		userCollectionArticle.setArticleId(articleId);
		userCollectionArticle.setUserId(uid);
		if(!tbUserCollectionArticleMapper.select(userCollectionArticle).isEmpty()) {
			return ResultUtil.returnFail("已经书藏过该文章", 1);
		}
		tbUserCollectionArticleMapper.insertSelective(userCollectionArticle);
		return ResultUtil.returnNull();
	}

	
}
