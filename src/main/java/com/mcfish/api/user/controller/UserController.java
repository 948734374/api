package com.mcfish.api.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mcfish.api.user.vo.UserVo;
import com.mcfish.base.controller.BaseController;
import com.mcfish.base.exception.SystemError;
import com.mcfish.common.model.TbUser;
import com.mcfish.constant.Dictionary;
import com.mcfish.constant.UserConstant;
import com.mcfish.util.common.CommonConstant;
import com.mcfish.util.common.IDUtil;
import com.mcfish.util.common.MD5;
import com.mcfish.util.common.VerifyCodeUtils;
import com.mcfish.util.resultutil.ResultUtil;

/**
 * 登录注册模块
 * @TODO
 * @author Macro
 * @date 2018年3月24日上午9:42:45
 * @description
 *
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

	
	/**
	 * 手机号注册
	 * @param phone
	 * @param code 验证码
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String register(@RequestParam(required=true) String phone,
			@RequestParam(required=true) String code,
			HttpServletRequest req) throws Exception {
		
		if(redisUtils.exists(CommonConstant.PHONE_CODE+phone+1)&&phone!=""&&phone!=null){
			String codeok = (String) redisUtils.getCache(CommonConstant.PHONE_CODE+phone+1);
			//移除code
			redisUtils.remove(CommonConstant.PHONE_CODE+phone+1);
			if(codeok.equals(code)){
				
				//判断手机号是否已经存在
				TbUser tu = userService.selectTbUserByPhone(phone);
				int id = 0;
				if(tu==null) {
					tu = new TbUser();
					tu.setPhone(phone);
					tu.setCode(IDUtil.getSixRandNum());
					tu.setFamilyAccpet((byte) 1);
					tu.setFriendVerification((byte) 1);
					tu.setStatus((byte) 0);
					id = userService.addNewUser(tu);
				}else {
					id = tu.getId();
				}				
				Map<String, Object> ret = new HashMap<>();
				ret.put("id", id);	
				return ResultUtil.returnSuccess(ret, 0);
			}else{
				return ResultUtil.returnFail(SystemError.CODE_NOT_EXIT.getMessage(), 
						SystemError.CODE_NOT_EXIT.getCode());
			}
	    }else{
	    	return ResultUtil.returnFail(SystemError.CODE_EXPIRE.getMessage(), 
					SystemError.CODE_EXPIRE.getCode());
	    }
		
	}
	
	/**
	 * 用户登录
	 * @param login_type 登录方式  1：账号，密码  2:第三方 3:token/uid
	 * @param open_type 第三方登录时的类型
	 * @param account 登录名/uid/open_id
	 * @param password 密码(MD5加密)/token
	 * @param code 图形验证码
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String userLogin(@RequestParam(required=true) Byte login_type,
			@RequestParam(required=false) String open_type,
			@RequestParam(required=true) String account,
			@RequestParam(required=false) String password,
			@RequestParam(required=false) String code,
			HttpServletRequest req) throws Exception {

			//token登录
			if(login_type==3){
                if(redisUtils.exists(password)){
                	UserVo uv = (UserVo) redisUtils.getCache(password);
                	redisUtils.setCache(password, uv, (long)(1000*60*60*24));
            		redisUtils.setCache(uv.getId().toString(), password, (long)(1000*60*60*24));
                	return ResultUtil.returnSuccess(uv, 1);
                }
			}
			//如果是手机号登录、判断图形验证码是否正确
			if(login_type==1) { 
				if(redisUtils.exists(CommonConstant.PHONE_CODE+account+10)
						&&account!=""&&account!=null){
					String codeok = (String) 
							redisUtils.getCache(CommonConstant.PHONE_CODE+account+10);
					//移除code
					redisUtils.remove(CommonConstant.PHONE_CODE+account+10);
					if(codeok.equalsIgnoreCase(code)){
						
						
					}else{
						return ResultUtil.returnFail(SystemError.CODE_NOT_EXIT.getMessage(), 
								SystemError.CODE_NOT_EXIT.getCode());
					}
			    }else{
			    	return ResultUtil.returnFail(SystemError.CODE_EXPIRE.getMessage(), 
							SystemError.CODE_EXPIRE.getCode());
			    }
			}
			
			//其他方式登录
			UserVo uv = userService.login(account,login_type,open_type);
            if(uv!=null){
            	 if(!uv.getPassword().equals(password)) { //密码不正确
					 return ResultUtil.returnFail(SystemError.LOGIN_FAILED_PASSWORD.getMessage(),
							 SystemError.LOGIN_FAILED_PASSWORD.getCode()); 
				 }
				 
				 if(UserConstant.USER_STATUS_FAIL.equals(uv.getStatus())) { //用户被冻结
					 return ResultUtil.returnFail(SystemError.LOGIN_FREEZE.getMessage(),
							 SystemError.LOGIN_FREEZE.getCode());
				 }
            	
            	
        		//用户信息redis存储
        		String str = uv.getId()+uv.getName()+
        				System.currentTimeMillis();
        		String token = MD5.stringToMD5(str.substring(0, str.length()-1));
        		uv.setToken(token);
        		uv.setPassword(null);
        		redisUtils.setCache(token, uv, (long)(1000*60*60*24));
        		redisUtils.setCache(uv.getId().toString(), token, (long)(1000*60*60*24));
        	        		
        		//返回信息
        		return ResultUtil.returnSuccess(uv, 1);
            	
            		
            }else{
            	return ResultUtil.returnFail(SystemError.LOGIN_FAILED_NAME.getMessage(), 
            			SystemError.LOGIN_FAILED_NAME.getCode());
            }

	}
	
	/**
	 * 用户修改密码
	 * @param phone 电话号码
	 * @param id 用户id
	 * @param code 验证码
	 * @param npwd 新密码（MD5）
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uptPassword",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String uptPasswordRoot(@RequestParam(required=true) String phone,
			@RequestParam(required=true) Integer id,
			@RequestParam(required=true) String code,
			@RequestParam(required=true) String npwd,
			HttpServletRequest req) throws Exception {
		
		if(redisUtils.exists(CommonConstant.PHONE_CODE+phone+2)&&phone!=""&&phone!=null){
			String codeok = (String) redisUtils.getCache(CommonConstant.PHONE_CODE+phone+2);
			//移除code
			redisUtils.remove(CommonConstant.PHONE_CODE+phone+2);
			if(codeok.equals(code)){
				TbUser tu = new TbUser();
				tu.setId(id);
				tu.setPassword(npwd);
			    userService.updateTbUser(tu);
				return ResultUtil.returnSuccess(null, 1);
			}else{
				return ResultUtil.returnFail(SystemError.CODE_NOT_EXIT.getMessage(), 
						SystemError.CODE_NOT_EXIT.getCode());
			}
	    }else{
	    	return ResultUtil.returnFail(SystemError.CODE_EXPIRE.getMessage(), 
					SystemError.CODE_EXPIRE.getCode());
	    }
		
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
	@RequestMapping(value="/perfect",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String perfectPerson(@RequestParam(required=true) Integer id,
			@RequestParam(required=false) String password,
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
				   
		    TbUser tu = new TbUser();
		    tu.setId(id);
		    tu.setPassword(password);
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
		    userService.updateTbUser(tu);
			return ResultUtil.returnSuccess(null, 0);
	}
	
	/**
	 * 绑定手机
	 * @param phone 电话号码
	 * @param code 验证码
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bindPhone",method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
	public String bindPhoneRoot(@RequestParam(required=true) String phone,
			@RequestParam(required=true) String code,
			HttpServletRequest req) throws Exception {
		
		if(redisUtils.exists(CommonConstant.PHONE_CODE+phone+3)&&phone!=""&&phone!=null){
			String codeok = (String) redisUtils.getCache(CommonConstant.PHONE_CODE+phone+3);
			//移除code
			redisUtils.remove(CommonConstant.PHONE_CODE+phone+3);
			if(codeok.equals(code)){
				//判断手机号是否已经存在
				TbUser tu = userService.selectTbUserByPhone(phone);
				if(tu!=null) {
					return ResultUtil.returnFail(SystemError.REGISTER_PHONE.getMessage(), 
							SystemError.REGISTER_PHONE.getCode());
				}
				tu = new TbUser();
				tu.setId(req.getIntHeader(Dictionary.UID));
				tu.setPhone(phone);
			    userService.updateTbUser(tu);
				return ResultUtil.returnSuccess(null, 1);
			}else{
				return ResultUtil.returnFail(SystemError.CODE_NOT_EXIT.getMessage(), 
						SystemError.CODE_NOT_EXIT.getCode());
			}
	    }else{
	    	return ResultUtil.returnFail(SystemError.CODE_EXPIRE.getMessage(), 
					SystemError.CODE_EXPIRE.getCode());
	    }
		
	}
	
	
	/**
	 * 发送手机验证码
	 * @param phone 电话号码
	 * @param used_to 1-注册 2-修改密码  3-绑定手机号
	 * @return
	 */
	@RequestMapping(value="/phoneCode",method = RequestMethod.GET,
			 produces = "text/json;charset=UTF-8")
	public String codeByPhone(@RequestParam(required=true) String phone,
			@RequestParam(required=true) Integer used_to){
			
			String code = "0001";
			redisUtils.setCache(CommonConstant.PHONE_CODE+phone+used_to, code, (long)120);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", code);
			return ResultUtil.returnSuccess(map, 1);
	}
	
	/**
	 * 获取图形验证码
	 * @param phone 手机号码
	 * @param response 响应
	 * @throws IOException
	 */
	@RequestMapping(value="/getVerification",method = RequestMethod.GET,
			 produces = "text/json;charset=UTF-8")
	public void getVerification(@RequestParam(required=true) String phone,
			             HttpServletResponse response) throws IOException{
			
		    response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/jpeg"); 
	        //获取验证码
	        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
			redisUtils.setCache(CommonConstant.PHONE_CODE+phone+10, verifyCode, (long)120);
			
			int w = 100, h = 30;  
		    VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
	}
	
	/**
	 * 用户注销登录
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/logOut",method = RequestMethod.POST, 
	         produces = "text/json;charset=UTF-8")
	public String logOutRoot(HttpServletRequest req) throws Exception{

		String token = req.getHeader(Dictionary.TOKEN);
		UserVo uv = (UserVo) redisUtils.getCache(token);
		
		redisUtils.remove(token);
		redisUtils.remove(uv.getId()+"");
		
		return ResultUtil.returnSuccess(null, 0);

	}
	
	
	
}
