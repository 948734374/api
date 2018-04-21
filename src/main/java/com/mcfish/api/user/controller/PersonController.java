package com.mcfish.api.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcfish.api.user.vo.UserVo;
import com.mcfish.base.controller.BaseController;
import com.mcfish.base.exception.SystemError;
import com.mcfish.common.model.TbUser;
import com.mcfish.constant.Dictionary;
import com.mcfish.util.resultutil.ResultUtil;

/**
 * 个人信息模块
 * @TODO
 * @author Macro
 * @date 2018年3月26日上午9:53:34
 * @description
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController{
	
	
	/**
	 * 获取用户个人中心统计信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getProfile",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getProfileRoot(HttpServletRequest req) throws Exception {
		
		String uid = req.getHeader(Dictionary.UID);
		
		Map<String, Object> ret= personService.selectProfile(Integer.parseInt(uid));
		return ResultUtil.returnSuccess(ret, 1);
	}
	
	/**
	 * 获取用户个人信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getUserInfo",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getUserInfoRoot(HttpServletRequest req) throws Exception {
		
		String uid = req.getHeader(Dictionary.UID);
		
		UserVo ret= personService.selectUserInfo(Integer.parseInt(uid));
		return ResultUtil.returnSuccess(ret, 1);
	}
	
	/**
	 * 用户完善信息
	 * @param id 用户id
	 * @param password 登录密码（MD5）
	 * @param country 国家
	 * @param region 地区
	 * @param gender 性别 0-男 1-女
	 * @param age 年龄
	 * @param first_language 母语
	 * @param second_language 第二语言
	 * @param industry 行业
	 * @param post 岗位类型
	 * @param education 学历
	 * @param religion 宗教
	 * @param school 毕业学校
	 * @param interests 兴趣爱好
	 * @param declaration 交友宣言
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uptUserInfo",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String uptUserInfoRoot(
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String head,
			@RequestParam(required=false) String country,
			@RequestParam(required=false) String region,
			@RequestParam(required=false) Byte gender,
			@RequestParam(required=false) Integer age,
			@RequestParam(required=false) String first_language,
			@RequestParam(required=false) String second_language,
			@RequestParam(required=false) String industry,
			@RequestParam(required=false) String post,
			@RequestParam(required=false) String education,
			@RequestParam(required=false) String religion,
			@RequestParam(required=false) String school,
			@RequestParam(required=false) String interests,
			@RequestParam(required=false) String declaration,
			HttpServletRequest req) throws Exception {
		
		String uid = req.getHeader(Dictionary.UID);
		
		TbUser tu = new TbUser();
		tu.setId(Integer.parseInt(uid));
		tu.setHead(head);
		tu.setName(name);
	    tu.setCountry(country);
	    tu.setRegion(region);
	    tu.setGender(gender);
	    tu.setAge(age);
	    tu.setFirstLanguage(first_language);
	    tu.setSecondLanguage(second_language);
	    tu.setIndustry(industry);
	    tu.setPost(post);
	    tu.setEducation(education);
	    tu.setReligion(religion);
	    tu.setSchool(school);
	    tu.setInterests(interests);
	    tu.setDeclaration(declaration);
	    personService.updateTbUser(tu);
		return ResultUtil.returnSuccess(null, 1);
	}
	
	
	/**
	 * 获取用户信息
	 * @param id 用户id
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getOtherInfo",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getOtherInfoRoot(@RequestParam(required=true) Integer id,
			HttpServletRequest req) throws Exception {
		
		UserVo ret= personService.selectOtherInfo(id);
		return ResultUtil.returnSuccess(ret, 1);
	}
	
	/**
	 * 获取用户帖子列表
	 * @param id 用户id
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getArticles",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getArticlesRoot(@RequestParam(required=false) Integer id,
			HttpServletRequest req) throws Exception {
		String uid = req.getHeader(Dictionary.UID);
		List<Map<String, Object>> ret = null;
		if(id==null) {
			ret = personService.selectArticles(Integer.parseInt(uid));
		}else {
			ret = personService.selectArticles(id);
		}	
		return ResultUtil.returnSuccess(ret, ret.size());
	}
	
	/**
	 * 获取我参与的评论
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getMyComment",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getMyCommentRoot(HttpServletRequest req) throws Exception {
		String uid = req.getHeader(Dictionary.UID);
		List<Map<String, Object>> ret= personService.selelctMyComment(Integer.parseInt(uid));
		return ResultUtil.returnSuccess(ret, ret.size());
	}
	
	/**
	 * 获取好友列表
	 * @param id 用户id
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getMyFriends",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getMyFriendsRoot(@RequestParam(required=false) Integer id,
			HttpServletRequest req) throws Exception {
		String uid = req.getHeader(Dictionary.UID);
		List<Map<String, Object>> ret = null;
		if(id==null) {
			ret = personService.selectMyFriends(Integer.parseInt(uid));
		}else {
			ret = personService.selectMyFriends(id);
		}	
		return ResultUtil.returnSuccess(ret, ret.size());
	}
	
	/**
	 * 获取我的粉丝列表
	 * @param id 用户id
	 * @param status 1-我关注的  2-关注我的
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getMyFans",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
	public String getMyFansRoot(@RequestParam(required=false) Integer id,
			@RequestParam(required=false,defaultValue="1") Byte status,
			HttpServletRequest req) throws Exception {
		String uid = req.getHeader(Dictionary.UID);
		List<Map<String, Object>> ret = null;
		if(id==null) {
			ret = personService.selectMyFans(Integer.parseInt(uid),status);
		}else {
			ret = personService.selectMyFans(id,status);
		}	
		return ResultUtil.returnSuccess(ret, ret.size());
	}
	
	/**
	 * 设置个人隐私
	 * @param friends_verification 是否开启好友验证 0-不需要  1-需要
	 * @param family_accpet 家庭是否接受新成员  0-不接受 1-接受
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/setPrivacy",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String setPrivacyRoot(@RequestParam(required=false) Byte friends_verification,
			@RequestParam(required=false) Byte family_accpet,
			HttpServletRequest req) throws Exception {
		
		if(friends_verification==null&&family_accpet==null) {
			return ResultUtil.returnFail(SystemError.PARAMETER_NULL.getMessage(),
					SystemError.PARAMETER_NULL.getCode());
		}
		String uid = req.getHeader(Dictionary.UID);
		
		personService.updatePrivacy(Integer.parseInt(uid), 
				friends_verification, family_accpet);
	
		return ResultUtil.returnSuccess(null, 1);
	}
	
	

}
