package com.mcfish.api.article.controller;

import com.mcfish.base.controller.BaseController;
import com.mcfish.common.model.AddArticleMode;
import com.mcfish.util.resultutil.ResultUtil;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{

    /**
     * 1，发帖
     * @param title
     * @param content
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/newArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object newArticleRoot(
            @Valid AddArticleMode model,
            BindingResult result,
            HttpServletRequest req) throws Exception{
    	if(result.hasErrors()) {
    		return ResultUtil.returnError(result);
    	}
        return articleService.newArticle(req.getIntHeader("uid"), model);
    }


    /**
     * 2，获取帖子详情
     * @param articleId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/getArticleDetail",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object getArticleDetailRoot(
            @RequestParam(required = true) Integer articleId,
            HttpServletRequest req) throws Exception{
        return articleService.getArticleDetail(req.getIntHeader("uid"), articleId);
    }


    /**
     * 3，评论帖子
     * @param articleId
     * @param touid
     * @param cmId
     * @param comment
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/publishArticleComment",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object publishArticleCommentRoot(
            @RequestParam(required = true) Integer articleId,
            @RequestParam(required = false) Integer touid,
            @RequestParam(required = false) Integer cmId,
            @RequestParam(required = true) String comment,
            HttpServletRequest req) throws Exception{
        return articleService.publishArticleComment(req.getIntHeader("uid"), articleId, touid, cmId, comment);
    }


    /**
     * 4，编辑帖子
     * @param articleId
     * @param status
     * @param title
     * @param content
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/editArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object editArticleRoot(
            @RequestParam(required = true) Integer articleId,
            @RequestParam(required = false) Byte status,
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String content,
            HttpServletRequest req) throws Exception{
        return articleService.editArticle(req.getIntHeader("uid"), articleId, title, content);
    }


    /**
     * 5，删除帖子
     * @param articleId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/deleArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object deleArticleRoot(
            @RequestParam(required = true) Integer articleId,
            HttpServletRequest req) throws Exception{
        return articleService.deleArticle(req.getIntHeader("uid"), articleId);
    }


    /**
     * 6，点赞帖子
     * @param articleId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/likesArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object likesArticleRoot(
            @RequestParam(required = true) Integer articleId,
            HttpServletRequest req) throws Exception{
        return articleService.likesArticle(req.getIntHeader("uid"), articleId);
    }


    /**
     * 7，点赞回复
     * @param commentId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/replyArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object replyArticleRoot(
            @RequestParam(required = true) Integer commentId,
            HttpServletRequest req) throws Exception{
        return articleService.replyArticle(req.getIntHeader("uid"), commentId);
    }


    /**
     * 8，收藏帖子
     * @param articleId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/collectionArticle",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object collectionArticleRoot(
            @RequestParam(required = true) Integer articleId,
            HttpServletRequest req) throws Exception{
        return articleService.collectionArticle(req.getIntHeader("uid"), articleId);
    }

}
