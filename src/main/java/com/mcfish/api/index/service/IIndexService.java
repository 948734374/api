package com.mcfish.api.index.service;

import com.mcfish.base.exception.MyException;

/**
 * 首页相关接口
 * @TODO
 * @author Macro
 * @date 2018年3月23日下午6:44:22
 * @description
 *
 */
public interface IIndexService {

    /**
     *
     * @param uid
     * @param touid
     * @param comment
     * @return
     */
    Object sendFriedsApply(Integer uid, Integer touid, String comment);

    /**
     * 2，获取帖子列表
     * @param uid
     * @param touid
     * @param size
     * @return
     */
    Object getHomeList(Integer uid, Integer touid, Integer size);

    /**
     * 3，获取帖子评论信息列表
     * @param uid
     * @param articleId
     * @return
     * @throws MyException 
     */
    Object getArticleComments(int uid, Integer articleId) throws MyException;

    /**
     * 4，获取推荐家庭列表
     * @param uid
     * @return
     */
    Object getGoodFamily(int uid);

    /**
     * 5，获取推荐用户列表
     * @param uid
     * @return
     */
    Object getGoodUsers(int uid);

    /**
     * 6，猜你喜欢的家庭
     * @param uid
     * @return
     */
    Object getLikeFamily(int uid);

    /**
     * 7，搜索帖子
     * @param uid 
     * @param keyword
     * @return
     */
    Object selectArticle(Integer uid, String keyword);
}
