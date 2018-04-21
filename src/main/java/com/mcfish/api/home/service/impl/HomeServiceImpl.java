package com.mcfish.api.home.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mcfish.api.home.service.HomeService;
import com.mcfish.base.exception.SystemError;
import com.mcfish.base.service.BaseService;
import com.mcfish.common.model.TbUser;
import com.mcfish.common.model.TbUserCollectionFamily;
import com.mcfish.common.model.TbUserFamily;
import com.mcfish.common.model.TbUserFamilyApply;
import com.mcfish.common.model.TbUserFamilyMember;
import com.mcfish.common.model.TbUserFamilyMoment;
import com.mcfish.common.model.TbUserMessage;
import com.mcfish.common.model.TbUserMessageNotice;
import com.mcfish.util.resultutil.ResultUtil;

/**
 * 家庭相关接口实现
 * @TODO
 * @author Macro
 * @date 2018年4月11日下午2:22:44
 * @description
 *
 */
@SuppressWarnings("unchecked")
@Service
public class HomeServiceImpl extends BaseService 
                                  implements HomeService{
	
    @Override
    public Object getFamilyList(int uid) {
		List<Map<String, Object>> ret =
    	baseDao.selectListByOne("TbUserFamily_selectMyFamily", uid); 	
        return ResultUtil.returnSuccess(ret, ret.size());
    }

    @Override
    public Object getFamilyDetail(Integer familyId) {    	
    	Map<String, Object> ret = (Map<String, Object>) 			 
    			baseDao.selectObjectByOne("TbUserFamily_selectFamilyDetail", familyId);
        return ResultUtil.returnSuccess(ret, 1);
    }

    @Override
    public Object getFamilyProfile(Integer familyId, Byte type) {
    	List<Map<String, Object>> ret = null;
    	if(type==0) { //图片、视频
    		ret = baseDao.selectListByOne("TbUserFamilyMoment_selectFamilyMoment", familyId); 
    	}else if(type==1) { //成员
    		ret = baseDao.selectListByOne("TbUserFamilyMember_selectFamilyMember", familyId); 
    	}else if(type==2) { //申请列表
    		ret = baseDao.selectListByOne("TbUserFamilyApply_selectFamilyApply", familyId); 
    	}else {
    		return ResultUtil.returnFail(SystemError.PARAMETER_NULL.getMessage(), 
    				SystemError.PARAMETER_NULL.getCode());
    	} 	
        return ResultUtil.returnSuccess(ret, ret.size());
    }

    @Override
    public Object updateFamilyUserInfo(TbUser tu,TbUserFamilyMember tfm) {
    	tbUserMapper.updateByPrimaryKeySelective(tu);   	  	
    	if(tfm.getRelationship()!=null) {
        	Map<String, Object> param = new HashMap<>();
        	param.put("familyId", tfm.getFamilyId());
        	param.put("uid", tu.getId());
        	param.put("relationship", tfm.getRelationship());
        	baseDao.selectObjectByOne("TbUserFamilyMember_update", param);
    	}
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object addFamily(TbUserFamily tf,String uids) {
    	//添加家庭
    	tbUserFamilyMapper.insert(tf);
    	//添加成员
	    List<Map<String, Object>> li = new ArrayList<>();
	    Map<String, Object> params = null;
		String[] users = uids.split(",");
    	if(users!=null&&users.length>0) {
    		//插入通知主消息
    		TbUserMessage tm = new TbUserMessage();
    		tm.setCreater(tf.getCreater());
    		tm.setTitle("用户***邀约加入家庭");
    		tm.setData(tf.getId()+"");
    		tm.setType((byte) 1);
    		tm.setStatus((byte) 0);
    		tbUserMessageMapper.insert(tm);
    		
    		//批量数据
    		for (int i = 0; i < users.length; i++) {
    			params = new HashMap<>();
    			params.put("familyId", tf.getId());
    			params.put("uid", users[i]);
    			params.put("identity", 0);
    			params.put("status", 2);
    			params.put("mid", tm.getId());
    			li.add(params);
			}
    		//插入通知消息
    		baseDao.selectObjectByOne("TbUserMessageNotice_bitchMessage", li);
    	}
    	//添加管理员
    	params = new HashMap<>();
		params = new HashMap<>();
		params.put("familyId", tf.getId());
		params.put("uid", tf.getCreater());
		params.put("identity", 1);
		params.put("status", 0);
		li.add(params);
		//插入成员
		baseDao.selectObjectByOne("TbUserFamilyMember_bitchUser", li);
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object joinFamily(int uid, Integer familyId) {
    	TbUserFamilyApply ta = new TbUserFamilyApply();
    	ta.setUserId(uid);
    	ta.setFamilyId(familyId);
    	ta.setStatus((byte) 0);
    	tbUserFamilyApplyMapper.insert(ta);
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object addFamilyUser(int uid,int userid, Integer familyId) {
    	//判断用户是否属于该家庭
    	TbUserFamilyMember t2 = new TbUserFamilyMember();
    	t2.setUserId(userid);
    	t2.setFamilyId(familyId);
    	List<TbUserFamilyMember> t4 = tbUserFamilyMemberMapper.select(t2);
    	if(t4.isEmpty()||t4.size()<=0) {
    		return ResultUtil.returnFail(SystemError.FAMILY_NOYOU.getMessage(),
    				SystemError.FAMILY_NOYOU.getCode());
    	}
    	
    	//添加家庭成员记录
    	TbUserFamilyMember tfm = new TbUserFamilyMember();
    	tfm.setFamilyId(familyId);
    	tfm.setUserId(uid);
    	tfm.setIdentity((byte) 0);
    	tfm.setStatus((byte) 2);
    	tbUserFamilyMemberMapper.insert(tfm);
		//插入通知主消息  	
		TbUserMessage tm = new TbUserMessage();
		tm.setCreater(uid);
		tm.setTitle("用户***邀约加入家庭");
		tm.setData(familyId+"");
		tm.setType((byte) 1);
		tm.setStatus((byte) 0);
		tbUserMessageMapper.insert(tm);
		//通知用户
		TbUserMessageNotice tn = new TbUserMessageNotice();
		tn.setMessageId(tm.getId());
		tn.setUserId(userid);
		tn.setStatus((byte) 0);
		tbUserMessageNoticeMapper.insert(tn);
        return  ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object delFamilyUser(int uid, Integer familyId, Integer userId) {
    	//获取用户身份
    	TbUserFamilyMember t2 = new TbUserFamilyMember();
    	t2.setUserId(uid);
    	t2.setFamilyId(familyId);
    	List<TbUserFamilyMember> t4 = tbUserFamilyMemberMapper.select(t2);
    	if(t4.isEmpty()||t4.size()<=0) {
    		return ResultUtil.returnFail(SystemError.FAMILY_NOYOU.getMessage(),
    				SystemError.FAMILY_NOYOU.getCode());
    	}
    	if(t4.get(0).getIdentity()!=1) { //不是管理员、无权限
    		return ResultUtil.returnFail(SystemError.FAMILY_ADMIN.getMessage(),
    				SystemError.FAMILY_ADMIN.getCode());
    	}
    	//更新用户状态
    	TbUserFamilyMember tm = new TbUserFamilyMember();
    	tm.setId(t4.get(0).getId());
    	tm.setFamilyId(familyId);
    	tm.setUserId(userId);
    	tm.setStatus((byte) 1);
    	tbUserFamilyMemberMapper.updateByPrimaryKeySelective(tm);  	
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object outFamily(int uid, Integer familyId) {
    	//更新用户状态
    	Map<String, Object> param = new HashMap<>();
    	param.put("familyId", familyId);
    	param.put("uid", uid);
    	param.put("status", 1);
    	baseDao.selectObjectByOne("TbUserFamilyMember_update", param);
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object collectionFamily(int uid, Integer familyId) {
    	TbUserCollectionFamily tc = new TbUserCollectionFamily();
    	tc.setUserId(uid);
    	tc.setFamilyId(familyId);
    	tbUserCollectionFamilyMapper.insert(tc);   	
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object editFamily(int uid, TbUserFamily tf) {
    	//获取用户身份
    	TbUserFamilyMember t2 = new TbUserFamilyMember();
    	t2.setUserId(uid);
    	t2.setFamilyId(tf.getId());
    	List<TbUserFamilyMember> t4 = tbUserFamilyMemberMapper.select(t2);
    	if(t4.isEmpty()||t4.size()<=0) {
    		return ResultUtil.returnFail(SystemError.FAMILY_NOYOU.getMessage(),
    				SystemError.FAMILY_NOYOU.getCode());
    	}
    	if(t4.get(0).getIdentity()!=1) { //不是管理员、无权限
    		return ResultUtil.returnFail(SystemError.FAMILY_ADMIN.getMessage(),
    				SystemError.FAMILY_ADMIN.getCode());
    	}
    	//更新家庭信息
    	tbUserFamilyMapper.updateByPrimaryKeySelective(tf);
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object addTbUserFamilyMoment(int uid,TbUserFamilyMoment tm) {
    	//判断用户身份位
     	TbUserFamilyMember t2 = new TbUserFamilyMember();
    	t2.setUserId(uid);
    	t2.setFamilyId(tm.getFamilyId());
    	List<TbUserFamilyMember> t4 = tbUserFamilyMemberMapper.select(t2);
    	if(t4.isEmpty()||t4.size()<=0) {
    		return ResultUtil.returnFail(SystemError.FAMILY_NOYOU.getMessage(),
    				SystemError.FAMILY_NOYOU.getCode());
    	}
        //插入记录
    	tbUserFamilyMomentMapper.insert(tm);
        return ResultUtil.returnSuccess(null, 1);
    }

    @Override
    public Object delFamilyResources(int uid, Integer familyId, Integer id) {
  
    	//获取用户身份
    	TbUserFamilyMember t2 = new TbUserFamilyMember();
    	t2.setUserId(uid);
    	t2.setFamilyId(familyId);
    	List<TbUserFamilyMember> t4 = tbUserFamilyMemberMapper.select(t2);
    	if(t4.isEmpty()||t4.size()<=0) {
    		return ResultUtil.returnFail(SystemError.FAMILY_NOYOU.getMessage(),
    				SystemError.FAMILY_NOYOU.getCode());
    	}
    	if(t4.get(0).getIdentity()!=1) { //不是管理员、无权限
    		return ResultUtil.returnFail(SystemError.FAMILY_ADMIN.getMessage(),
    				SystemError.FAMILY_ADMIN.getCode());
    	}
    	
    	//删除用户资源
    	TbUserFamilyMoment tm = new TbUserFamilyMoment();
    	tm.setId(id);
    	tm.setStatus((byte) 1);
    	tbUserFamilyMomentMapper.updateByPrimaryKeySelective(tm);
        return ResultUtil.returnSuccess(null, 1);
    }
    
    
}
