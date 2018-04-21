package com.mcfish.base.service;

import com.mcfish.common.mapper.TbArticleAuthMapper;
import com.mcfish.common.mapper.TbArticleMainMapper;
import com.mcfish.common.model.*;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcfish.base.dao.BaseDao;

import tk.mybatis.mapper.common.Mapper;

/**
 * Service基类
 * @TODO
 * @author Macro
 * @date 2018年3月23日下午1:26:57
 * @description
 *
 */
public class BaseService {

    @Autowired
    protected BaseDao baseDao;

    @Autowired
    protected Mapper<TbArticle> tbArticleMapper;
    
    @Autowired
    protected Mapper<TbArticleAuth> tbArticleAuthMapper;
    
    @Autowired
    protected Mapper<TbArticleMain> tbArticleMainMapper;
    
    @Autowired
    protected Mapper<TbArticleAuthRange> tbArticleAuthRangeMapper;
    
    @Autowired
    protected Mapper<TbArticleComment> tbArticleCommentMapper;
    
    @Autowired
    protected Mapper<TbArticleCommentReply> tbArticleCommentReplyMapper;
    
    @Autowired
    protected Mapper<TbArticleGood> tbArticleGoodMapper;
    
    @Autowired
    protected Mapper<TbArticleCommentLikes> tbArticleCommentLikesMapper;
    
    @Autowired
    protected Mapper<TbUserCollectionArticle> tbUserCollectionArticleMapper;
    
    @Autowired
    protected Mapper<TbArticleMain> TbArticleMainMapper;
    
    @Autowired
    protected Mapper<TbUser> tbUserMapper;
    
    @Autowired
    protected Mapper<TbUserFamily> tbUserFamilyMapper;
    
    
    @Autowired
    protected Mapper<TbUserCollection> tbUserCollectionMapper;

    @Autowired
    protected Mapper<TbSystemLabel> tbSystemLabelMapper;

    @Autowired
    protected Mapper<TbSystemBanner> tbSystemBannerMapper;

    @Autowired
    protected Mapper<TbSystemChoice> tbSystemChoiceMapper;

    @Autowired
    protected Mapper<TbSystemVersion> tbSystemVersionMapper;

    @Autowired
    protected Mapper<TbSystemCrc> tbSystemCrcMapper;

    @Autowired
    protected Mapper<TbSystemRegion> tbSystemRegionMapper;

    @Autowired
    protected Mapper<TbSystemConfig> tbSystemConfigMapper;

    @Autowired
    protected Mapper<TbSystemGuide> tbSystemGuideMapper;

    @Autowired
    protected Mapper<TbUserFriends> tbUserFriendsMapper;

    @Autowired
    protected Mapper<TbUserFriendsApply> tbUserFriendsApplyMapper;
    
    @Autowired
    protected Mapper<TbUserFamilyMember> tbUserFamilyMemberMapper;
    
    @Autowired
    protected Mapper<TbUserFamilyApply> tbUserFamilyApplyMapper;
    
    @Autowired
    protected Mapper<TbUserMessage> tbUserMessageMapper;
    
    @Autowired
    protected Mapper<TbUserMessageNotice> tbUserMessageNoticeMapper;
    
    @Autowired
    protected Mapper<TbUserCollectionFamily> tbUserCollectionFamilyMapper;
    
    @Autowired
    protected Mapper<TbUserFamilyMoment> tbUserFamilyMomentMapper;
    
    
    /**
     * 判断用户是否有查看文章的权限
     * @param uid
     * @param articleId
     * @return
     */
	public ArticleAuthStatus selectArticleAuthStatus(int uid, Integer articleId) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("articleId", articleId);
		return (ArticleAuthStatus) baseDao.selectObjectByOne("TbArticleAuthRange_selectArticleAuthStatus", map);
	}
}
