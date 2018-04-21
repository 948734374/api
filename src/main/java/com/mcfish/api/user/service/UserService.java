package com.mcfish.api.user.service;

import com.mcfish.api.user.vo.UserVo;
import com.mcfish.common.model.TbUser;

/**
 * 登录注册模块接口
 * @TODO
 * @author Macro
 * @date 2018年3月24日上午10:03:06
 * @description
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param account 手机号  第三方授权码
	 * @param type 1-手机密码登录  2-第三方登录 
	 * @param way 'wx'微信 'facebook'facebook
	 * @return
	 */
	UserVo login(String account,Byte type,String way);
	
	/**
	 * 注册新用户
	 * @param tu
	 * @return
	 */
	int addNewUser(TbUser tu);
	
	/**
	 * 更新用户
	 * @param tu
	 * @return
	 */
	int updateTbUser(TbUser tu);
	
	/**
	 * 通过手机号获取用户信息
	 * @param phone
	 * @return
	 */
	TbUser selectTbUserByPhone(String phone);
	
}
