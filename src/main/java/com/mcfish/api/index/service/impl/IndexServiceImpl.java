package com.mcfish.api.index.service.impl;

import com.mcfish.base.exception.MyException;
import com.mcfish.base.exception.SystemError;
import com.mcfish.common.model.ArticleAuthStatus;
import com.mcfish.common.model.TbArticle;
import com.mcfish.common.model.TbArticleAuth;
import com.mcfish.common.model.TbArticleAuthRange;
import com.mcfish.common.model.TbUserFamily;
import com.mcfish.common.model.TbUserFriends;
import com.mcfish.common.model.TbUserFriendsApply;
import com.mcfish.util.common.StringUtil;
import com.mcfish.util.resultutil.ResultUtil;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi.OAEP;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mcfish.api.index.service.IIndexService;
import com.mcfish.base.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("unchecked")
@Service
public class IndexServiceImpl extends BaseService implements IIndexService {

	@Override
	public Object sendFriedsApply(Integer uid, Integer touid, String comment) {
		if(uid == touid || StringUtil.isEmpty(comment)) {
			return ResultUtil.returnError(SystemError.INVALID_PARAM.getCode(),
					SystemError.INVALID_PARAM.getMessage());
		}
		
		Map<Object, Object> param = new HashMap<>();
		param.put("uid", uid);
		param.put("touid", touid);
		//根据自己的id和另一个用户id判断是否是好友
		List<Map<String, Object>> resList = baseDao.selectListByOne("TbUserFriends_selectFriendByeEachId", param);

		if(!resList.isEmpty()) {
			return ResultUtil.returnError(SystemError.ALREADY_FRIEND.getCode(),
					SystemError.ALREADY_FRIEND.getMessage()); //已经是好友
		}

		//创建申请记录
		TbUserFriendsApply userFriendsApply = new TbUserFriendsApply();
		userFriendsApply.setUserId(uid);
		userFriendsApply.setApplyId(touid);
		userFriendsApply.setComment(comment);
		userFriendsApply.setStatus((byte) 0);
		if(tbUserFriendsApplyMapper.insert(userFriendsApply) != 1) {
			return ResultUtil.returnError(SystemError.OPERATION_FAILURE.getCode(),
					SystemError.OPERATION_FAILURE.getMessage());
		}
		return ResultUtil.returnSuccess(null, 0);
	}

	@Override
	public Object getHomeList(Integer uid, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<Map<String, Object>> canViewArticles = baseDao.selectListByOne("TbArticle_selectCanViewArticle", uid);
		return ResultUtil.returnSuccess(canViewArticles, canViewArticles.size());
	}

	@Override
	public Object getArticleComments(int uid, Integer articleId) throws MyException {
		ArticleAuthStatus articleAuthStatus = selectArticleAuthStatus(uid, articleId);
		if(articleAuthStatus.getStatus() == 1) {
			return ResultUtil.returnFail("文章已经被冻结", 1);
		}
		if(articleAuthStatus.getHaveAuth() != 1) {
			return ResultUtil.returnFail("没有查看此文章评论的权限", 1);
		}
		
		List<Map<String, Object>> resList = baseDao.selectListByOne("TbArticleComment_selectArticleComments", articleId);
		return ResultUtil.returnSuccess(resList, resList.size());
	}

	@Override
	public Object getGoodFamily(int uid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("maxCount", 5);
		List<TbUserFamily> familys = baseDao.selectObjectByMap("TbUserFamily_selectFamilysRand", map);
		return ResultUtil.returnSuccess(familys, familys.size());
	}

	@Override
	public Object getGoodUsers(int uid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("meuid", uid);
		map.put("maxCount", 20);
		List<Map<String, Object>> users = baseDao.selectObjectByMap("TbUser_selectUsersRand", map);
		return ResultUtil.returnSuccess(users, users.size());
	}

	@Override
	public Object getLikeFamily(int uid) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("maxCount", 5);
		List<TbUserFamily> familys = baseDao.selectObjectByMap("TbUserFamily_selectFamilysRand", map);
		return ResultUtil.returnSuccess(familys, familys.size());
	}

	@Override
	public Object selectArticle(Integer uid, String keyword) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("keyword", keyword);
		List<TbArticle> articles = baseDao.selectListByOne("TbArticle_selectCanViewArticleByKeyWord", map); 
		return ResultUtil.returnSuccess(articles, articles.size());
	}
}
