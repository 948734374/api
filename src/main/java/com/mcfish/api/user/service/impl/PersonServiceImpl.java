package com.mcfish.api.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcfish.api.user.service.PersonService;
import com.mcfish.api.user.vo.UserVo;
import com.mcfish.base.service.BaseService;
import com.mcfish.common.model.TbUser;
import com.mcfish.common.model.TbUserFamily;

/**
 * 个人模块接口实现
 * @TODO
 * @author Macro
 * @date 2018年3月24日上午10:25:09
 * @description
 *
 */
@SuppressWarnings("unchecked")
@Service
public class PersonServiceImpl extends BaseService implements PersonService{

	@Override
	public Map<String, Object> selectProfile(Integer uid) {
		Map<String, Object> ret = (Map<String, Object>) 
				baseDao.selectObjectByOne("TbUser_selectProfile", uid);
		return ret;
	}

	@Override
	public UserVo selectUserInfo(Integer uid) {
		UserVo uv = (UserVo) 
				baseDao.selectObjectByOne("TbUser_selectUserInfo", uid);
		return uv;
	}

	@Override
	public int updateTbUser(TbUser tu) {
		return tbUserMapper.updateByPrimaryKeySelective(tu);
	}

	@Override
	public UserVo selectOtherInfo(Integer uid) {
		UserVo uv = (UserVo) 
				baseDao.selectObjectByOne("TbUser_selectOtherInfo", uid);
		return uv;
	}

	@Override
	public List<Map<String, Object>> selectArticles(Integer uid) {
		List<Map<String, Object>> ret = 
				baseDao.selectListByOne("TbArticle_selectArticles", uid);
		return ret;
	}

	@Override
	public List<Map<String, Object>> selelctMyComment(Integer uid) {
		List<Map<String, Object>> ret = 
				baseDao.selectListByOne("TbArticleComment_selectMyComment", uid);
		return ret;
	}

	@Override
	public List<Map<String, Object>> selectMyFriends(Integer uid) {
		List<Map<String, Object>> ret = 
				baseDao.selectListByOne("TbUserFriends_selectMyFriends", uid);
		return ret;
	}

	@Override
	public List<Map<String, Object>> selectMyFans(Integer uid,Byte status) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uid", uid);
		param.put("status", status);
		List<Map<String, Object>> ret = 
				baseDao.selectListByOne("TbUserFans_selectMyFans", param);
		return ret;
	}

	@Override
	@Transactional
	public int updatePrivacy(Integer uid, Byte friends_verification, Byte family_accpet) {
		
		//更新用户信息
		TbUser tu = new TbUser();
		tu.setId(uid);
		tu.setFriendVerification(friends_verification);
		tu.setFamilyAccpet(family_accpet);
		tbUserMapper.updateByPrimaryKeySelective(tu);
	    //判断是否需要更新家庭信息
		if(family_accpet!=null) {
			//获取家庭信息
			TbUserFamily t1 = new TbUserFamily();
			t1.setCreater(uid);
			t1.setStatus((byte) 0);
			List<TbUserFamily> li = tbUserFamilyMapper.select(t1);
			//判断是否有家庭
			if(li.isEmpty()||li.size()<=0) {
				return 1;
			}
			//更新家庭
			TbUserFamily tf = null;
			for (int i = 0; i < li.size(); i++) {
				tf = li.get(i);
				tf.setAccpet(family_accpet);
				tbUserFamilyMapper.updateByPrimaryKey(tf);
			}
			return 1;
		}
		return 1;

	}
	
	
	

}
