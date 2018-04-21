package com.mcfish.api.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcfish.api.user.service.UserService;
import com.mcfish.api.user.vo.UserVo;
import com.mcfish.base.service.BaseService;
import com.mcfish.common.model.TbUser;

/**
 * 登录注册模块接口实现
 * @TODO
 * @author Macro
 * @date 2018年3月24日下午2:34:21
 * @description
 *
 */
@SuppressWarnings("unchecked")
@Service
public class UserServiceImpl extends BaseService implements UserService{

	@Override
	public UserVo login(String account, Byte type, String way) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		map.put("type", type);
		map.put("way", way);		
		List<UserVo> list = (List<UserVo>) baseDao.selectListByOne("TbUser_userlogin", map);
		if(list.size()>0){ 
			return list.get(0);
		}else{
            return null;
		}

	}

	@Override
	@Transactional
	public int addNewUser(TbUser tu) {
		//插入用户
		tbUserMapper.insert(tu);
		
		//创建环形账号
		int id = tu.getId();
		return id;
	}

	@Override
	public int updateTbUser(TbUser tu) {	
		return tbUserMapper.updateByPrimaryKeySelective(tu);
	}

	@Override
	public TbUser selectTbUserByPhone(String phone) {
		TbUser t1 = new TbUser();
		t1.setPhone(phone);
		return tbUserMapper.selectOne(t1);
	}
    
}
