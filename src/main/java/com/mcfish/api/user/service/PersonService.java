package com.mcfish.api.user.service;

import java.util.List;
import java.util.Map;

import com.mcfish.api.user.vo.UserVo;
import com.mcfish.common.model.TbUser;

/**
 * 个人模块接口
 * @TODO
 * @author Macro
 * @date 2018年3月24日上午10:24:59
 * @description
 *
 */
public interface PersonService {

	/**
	 * 获取用户个人中心统计信息
	 * @param uid
	 * @return
	 */
	Map<String, Object> selectProfile(Integer uid);
	
	/**
	 * 获取用户资料
	 * @param uid
	 * @return
	 */
	UserVo selectUserInfo(Integer uid);
	
	/**
	 * 更新用户信息
	 * @param tu
	 * @return
	 */
	int updateTbUser(TbUser tu);
	
	/**
	 * 获取用户个人信息
	 * @param uid
	 * @return
	 */
	UserVo selectOtherInfo(Integer uid);
	
	/**
	 * 获取用户帖子列表
	 * @param uid
	 * @return
	 */
	List<Map<String, Object>> selectArticles(Integer uid);
	
	/**
	 * 获取我参与的评论
	 * @param uid
	 * @return
	 */
	List<Map<String, Object>> selelctMyComment(Integer uid);
	
	/**
	 * 获取我的好友列表
	 * @param uid
	 * @return
	 */
	List<Map<String, Object>> selectMyFriends(Integer uid);
	
	/**
	 * 获取我的粉丝列表
	 * @param uid 用户id
	 * @param status 1-我关注的  2-关注我的
	 * @return
	 */
	List<Map<String, Object>> selectMyFans(Integer uid,Byte status);
	
	/**
	 * 设置个人隐私
	 * @param uid 用户id
	 * @param friends_verification 是否开启好友验证 0-不需要  1-需要
	 * @param family_accpet 家庭是否接受新成员  0-不接受 1-接受
	 * @return
	 */
	int updatePrivacy(Integer uid,Byte friends_verification,Byte family_accpet);
	
	
	
}
