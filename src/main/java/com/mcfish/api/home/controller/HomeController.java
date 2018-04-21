package com.mcfish.api.home.controller;

import com.mcfish.base.controller.BaseController;
import com.mcfish.common.model.TbUser;
import com.mcfish.common.model.TbUserFamily;
import com.mcfish.common.model.TbUserFamilyMember;
import com.mcfish.common.model.TbUserFamilyMoment;
import com.mcfish.constant.Dictionary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 家庭模块
 * @TODO
 * @author Macro
 * @date 2018年4月11日上午11:40:28
 * @description
 *
 */
@RestController
@RequestMapping("/family")
public class HomeController extends BaseController{

    /**
     * 获取我的家庭列表
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/getFamilyList",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object getFamilyListRoot(
    		@RequestParam(required = false) Integer id,
            HttpServletRequest req) throws Exception{
    	if(id==null) {
    		id = req.getIntHeader(Dictionary.UID);
    	}
        return homeService.getFamilyList(id);
    }


    /**
     * 获取我的家庭详情
     * @param familyId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/getFamilyDetail",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object getFamilyDetailRoot(
            @RequestParam(required = true) Integer familyId,
            HttpServletRequest req) throws Exception{
    	
        return homeService.getFamilyDetail(familyId);
    }


    /**
     * 获取我的家庭资料
     * @param familyId
     * @param type 0-图片、视频  1-成员 2-申请列表
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/getFamilyProfile",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    public Object getFamilyProfileRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = true) Byte type,
            HttpServletRequest req) throws Exception{
        return homeService.getFamilyProfile(familyId, type);
    }


    /**
     * 4，修改我的家庭个人资料
     * @param familyId
     * @param petname
     * @param second_language
     * @param third_language
     * @param education
     * @param work
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/editFamilyUserInfo",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object editFamilyUserInfoRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = false) String petname,
            @RequestParam(required = false) String second_language,
            @RequestParam(required = false) String third_language,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) String work,
            HttpServletRequest req) throws Exception{
    	int uid = req.getIntHeader(Dictionary.UID);
    	//个人资料
    	TbUser tu = new TbUser();
    	tu.setId(uid);
    	tu.setSecondLanguage(third_language);
    	tu.setFirstLanguage(second_language);
    	tu.setEducationExperience(education);
    	tu.setWord(work);
    	//家庭资料
    	TbUserFamilyMember tm = new TbUserFamilyMember();
    	tm.setFamilyId(familyId);
    	tm.setUserId(uid);
    	tm.setRelationship(petname);   	
        return homeService.updateFamilyUserInfo(tu,tm);
    }


    /**
     * 创建家庭
     * @param name
     * @param address
     * @param head
     * @param uids
     * @param desc
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/newFamily",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object newFamilyRoot( 
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String address,
            @RequestParam(required = false) String head,
            @RequestParam(required = false) String uids,
            @RequestParam(required = false) String desc,
            HttpServletRequest req) throws Exception{
    	
    	int uid = req.getIntHeader(Dictionary.UID);
    	//创建家庭
    	TbUserFamily tu = new TbUserFamily();
    	tu.setCreater(uid);
    	tu.setName(name);
    	tu.setHead(head);
    	tu.setDesc(desc);
    	tu.setAddress(address); 	
        return homeService.addFamily(tu,uids);
    }


    /**
     * 家庭申请
     * @param familyId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/joinFamily",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object joinFamilyRoot(
            @RequestParam(required = true) Integer familyId,
            HttpServletRequest req) throws Exception{
    	
        return homeService.joinFamily(req.getIntHeader(Dictionary.UID), familyId);
    }


    /**
     * 家庭邀请
     * @param user_id 被邀请者id
     * @param familyId 家庭id
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/inviteFamilyUser",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object inviteFamilyUserRoot(
    		@RequestParam(required = true) Integer user_id,
            @RequestParam(required = true) Integer familyId,
            HttpServletRequest req) throws Exception{ 
    	
        return homeService.addFamilyUser(req.getIntHeader(Dictionary.UID),user_id, familyId);
    }


    /**
     * 删除家庭成员
     * @param familyId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/delFamilyUser",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object delFamilyUserRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = true) Integer userId,
                    HttpServletRequest req) throws Exception{
        return homeService.delFamilyUser(req.getIntHeader(Dictionary.UID), familyId, userId);
    }


    /**
     * 退出家庭
     * @param familyId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/outFamily",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object outFamilyRoot(
            @RequestParam(required = true) Integer familyId,
            HttpServletRequest req) throws Exception{
        return homeService.outFamily(req.getIntHeader(Dictionary.UID), familyId);
    }

    /**
     * 收藏家庭
     * @param familyId
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/collectionFamily",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object collectionFamilyRoot(
            @RequestParam(required = true) Integer familyId,
            HttpServletRequest req) throws Exception{
        return homeService.collectionFamily(req.getIntHeader(Dictionary.UID), familyId);
    }


    /**
     * 管理家庭
     * @param familyId
     * @param name
     * @param address
     * @param head
     * @param desc
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/editFamily",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object editFamilyRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String head,
            @RequestParam(required = false) String desc,
            HttpServletRequest req) throws Exception{
    	
    	//更新信息
    	TbUserFamily tf = new TbUserFamily();
    	tf.setId(familyId);
    	tf.setName(name);
    	tf.setAddress(address);
    	tf.setHead(head);
    	tf.setDesc(desc);
    	  	
        return homeService.editFamily(req.getIntHeader(Dictionary.UID), tf);
    }


    /**
     * 家庭资源上传
     * @param familyId
     * @param url
     * @param type 0-图片  1-视频
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/uploadFamilyResources",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object uploadFamilyResourcesRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = true) String url,
            @RequestParam(required = true) Byte type,
            HttpServletRequest req) throws Exception{
    	//获取用户id
    	int uid = req.getIntHeader(Dictionary.UID);
    	//插入记录
    	TbUserFamilyMoment tm = new TbUserFamilyMoment();
    	tm.setFamilyId(familyId);
    	tm.setUserId(uid);
    	tm.setUrl(url);
    	tm.setType(type);
    	tm.setStatus((byte) 0);
    	
        return homeService.addTbUserFamilyMoment(uid, tm);
    }


    /**
     * 删除家庭资源
     * @param familyId
     * @param id 资源记录id
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/delFamilyResources",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public Object delFamilyResourcesRoot(
            @RequestParam(required = true) Integer familyId,
            @RequestParam(required = true) Integer id,
            HttpServletRequest req) throws Exception{
        return homeService.delFamilyResources(req.getIntHeader(Dictionary.UID), familyId, id);
    }

}
