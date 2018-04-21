package com.mcfish.api.home.service;

import com.mcfish.common.model.TbUser;
import com.mcfish.common.model.TbUserFamily;
import com.mcfish.common.model.TbUserFamilyMember;
import com.mcfish.common.model.TbUserFamilyMoment;

/**
 * 家庭相关接口
 * @TODO
 * @author Macro
 * @date 2018年4月11日下午2:50:22
 * @description
 *
 */
public interface HomeService {

    /**
     * 1，获取我的家庭列表
     * @param uid
     * @return
     */
    Object getFamilyList(int uid);

    /**
     * 2，获取我的家庭详情
     * @param familyId
     * @return
     */
    Object getFamilyDetail(Integer familyId);

    /**
     * 获取我的家庭资料
     * @param familyId
     * @param type 0-图片、视频  1-成员 2-申请列表
     * @return
     */
    Object getFamilyProfile(Integer familyId, Byte type);

    /**
     * 修改家庭个人资料
     * @param tu
     * @param tfm
     * @return
     */
    Object updateFamilyUserInfo(TbUser tu,TbUserFamilyMember tfm);

    /**
     * 创建家庭
     * @param tf
     * @param uids 家庭成员（uid,uid,uid）
     * @return
     */
    Object addFamily(TbUserFamily tf,String uids);

    /**
     * 6，家庭申请
     * @param uid
     * @param familyId
     * @return
     */
    Object joinFamily(int uid, Integer familyId);

    /**
     * 家庭邀请
     * @param uid 邀请者id
     * @param userid 被邀请者id
     * @param familyId 家庭id
     * @return
     */
    Object addFamilyUser(int uid,int userid, Integer familyId);

    /**
     * 8，删除家庭成员
     * @param uid
     * @param familyId
     * @param userId
     * @return
     */
    Object delFamilyUser(int uid, Integer familyId, Integer userId);

    /**
     * 9，退出家庭
     * @param uid
     * @param familyId
     * @return
     */
    Object outFamily(int uid, Integer familyId);

    /**
     * 收藏家庭
     * @param uid
     * @param familyId
     * @return
     */
    Object collectionFamily(int uid, Integer familyId);

    /**
     * 管理家庭
     * @param uid 操作员
     * @param tf 家庭
     * @return
     */
    Object editFamily(int uid, TbUserFamily tf);

    /**
     * 家庭资源上传
     * @param ui
     * @return
     */
    Object addTbUserFamilyMoment(int uid,TbUserFamilyMoment tm);

    /**
     * 删除家庭资源
     * @param uid  操作员id
     * @param familyId 家庭id
     * @param id 资源记录id
     * @return
     */
    Object delFamilyResources(int uid, Integer familyId, Integer id);
}
