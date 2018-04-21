package com.mcfish.api.collection.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcfish.base.controller.BaseController;

/**
 * 收藏模块
 * @TODO
 * @author Macro
 * @date 2018年3月26日下午4:20:08
 * @description
 *
 */
@RestController
@RequestMapping("/collection")
public class CollectionController extends BaseController{

    /**
     * 1，我收藏的帖子
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/myCollectionArticle",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object myCollectionArticleRoot(
            HttpServletRequest req) throws Exception{
        return collectionService.myCollectionArticle(req.getIntHeader("uid"));
    }


    /**
     * 2，帖子分类
     * @param folderId
     * @param articleId
     * @param type
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/editArticlefolder",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object editArticlefolderRoot(
            @RequestParam(required = true) Integer folderId,
            @RequestParam(required = true) Integer articleId,
            @RequestParam(required = true) Integer type,
            HttpServletRequest req) throws Exception{
        return collectionService.editArticlefolder(req.getIntHeader("uid"), folderId, articleId, type);
    }


    /**
     * 3，我收藏夹
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/myCollectionfolder",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object myCollectionfolderRoot(
            HttpServletRequest req) throws Exception{
        return collectionService.myCollectionfolder(req.getIntHeader("uid"));
    }


    /**
     * 4，收藏夹编辑
     * @param folderId
     * @param name
     * @param image
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/editCollectionfolder",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object editCollectionfolderRoot(
            @RequestParam(required = true) Integer folderId,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String image,
            HttpServletRequest req) throws Exception{
        return collectionService.editCollectionfolder(req.getIntHeader("uid"), folderId, name, image);
    }


    /**
     * 5，我收藏夹内容
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/myCollectionfolderDetail",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object myCollectionfolderDetailRoot(
            @RequestParam(required = true) Integer folderid,
            HttpServletRequest req) throws Exception{
        return collectionService.myCollectionfolderDetail(req.getIntHeader("uid"), folderid);
    }


    /**
     * 6，获取我收藏的家庭
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/myCollectionFamily",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object myCollectionFamilyRoot(
            HttpServletRequest req) throws Exception{
        return collectionService.myCollectionFamily(req.getIntHeader("uid"));
    }
}
