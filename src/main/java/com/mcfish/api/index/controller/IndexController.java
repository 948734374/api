package com.mcfish.api.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcfish.base.controller.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页模块
 * @author Macro
 * @date 2018年3月23日下午6:44:48
 * @description
 *
 */
@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{

	/**
	 * 1、好友申请
	 * @param touid
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/sendFriedsApply",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object sendFriedsApplyRoot(
			@RequestParam(required = true) Integer touid,
			@RequestParam(required = true) String comment,
			HttpServletRequest req) throws Exception{
		return indexService.sendFriedsApply(req.getIntHeader("uid"), touid, comment);
	}


	/**
	 * 2、获取帖子列表
	 * @param page
	 * @param size
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/getHomeList",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getHomeListRoot(
			@RequestParam(required = true) Integer page,
			@RequestParam(required = false, defaultValue="10") Integer size,
			HttpServletRequest req) throws Exception{
		return indexService.getHomeList(req.getIntHeader("uid"), page, size);
	}


	/**
	 * 3，获取帖子评论信息列表
	 * @param articleId
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/getArticleComments",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getArticleCommentsRoot(
			@RequestParam(required = true) Integer articleId,
			HttpServletRequest req) throws Exception{
		return indexService.getArticleComments(req.getIntHeader("uid"), articleId);
	}


	/**
	 * 4，获取推荐家庭列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/getGoodFamily",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getGoodFamilyRoot(
			HttpServletRequest req) throws Exception{
		return indexService.getGoodFamily(req.getIntHeader("uid"));
	}


	/**
	 * 5，获取推荐用户列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/getGoodUsers",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getGoodUsersRoot(
			HttpServletRequest req) throws Exception{
		return indexService.getGoodUsers(req.getIntHeader("uid"));
	}


	/**
	 * 6，猜你喜欢的家庭
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/getLikeFamily",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object getLikeFamilyRoot(
			HttpServletRequest req) throws Exception{
		return indexService.getLikeFamily(req.getIntHeader("uid"));
	}


	/**
	 * 7，搜索帖子
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(
			value = "/selectArticle",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object selectArticle(
			@RequestParam(required = false) String keyword,
			HttpServletRequest req) throws Exception{
		return indexService.selectArticle(req.getIntHeader("uid"), keyword);
	}
}
