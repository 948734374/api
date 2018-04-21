package com.mcfish.api.article.service;

import com.mcfish.base.exception.MyException;
import com.mcfish.common.model.AddArticleMode;

public interface IArticleService {

   /**
    * 1，发帖
    * @param uid
    * @param model
    * @return
 * @throws MyException 
    */
    Object newArticle(int uid, AddArticleMode model) throws MyException;

    /**
     * 2，获取帖子详情
     * @param uid
     * @param articleId
     * @return
     */
    Object getArticleDetail(int uid, Integer articleId);

    /**
     * 3，评论帖子
     * @param uid
     * @param articleId
     * @param touid
     * @param cid 
     * @param comment
     * @return
     * @throws MyException 
     */
    Object publishArticleComment(int uid, Integer articleId, Integer touid, Integer cid, String comment) throws MyException;

    /**
     * 4，编辑帖子
     * @param uid
     * @param articleId
     * @param title
     * @param content
     * @return
     * @throws MyException 
     */
    Object editArticle(int uid, Integer articleId, String title, String content) throws MyException;

    /**
     * 5，删除帖子
     * @param uid
     * @param articleId
     * @return
     * @throws MyException 
     */
    Object deleArticle(int uid, Integer articleId) throws MyException;

    /**
     * 6，点赞帖子
     * @param uid
     * @param articleId
     * @return
     * @throws MyException 
     */
    Object likesArticle(int uid, Integer articleId) throws MyException;

    /**
     * 7，点赞回复
     * @param uid
     * @param commentId
     * @return
     * @throws MyException 
     */
    Object replyArticle(int uid, Integer commentId) throws MyException;

    /**
     * 8，收藏帖子
     * @param uid
     * @param articleId
     * @return
     * @throws MyException 
     */
    Object collectionArticle(int uid, Integer articleId) throws MyException;
}
