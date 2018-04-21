package com.mcfish.api.system.controller;

import com.mcfish.common.model.*;
import com.mcfish.util.resultutil.ResultUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mcfish.base.controller.BaseController;

import java.util.List;
import java.util.Map;

/**
 * 系统配置Controller
 * @author  RenXiaoFeng
 * @date 2018/3/29 10:50
 * @return
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/system")
public class SystemController extends BaseController{

    /**
     * 获取帖子标签列表
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:08
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemLabel",
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemLabel(){

        List<TbSystemLabel> systemLabelList = (List<TbSystemLabel>)
                systemService.selectSystemLabel();
        if(systemLabelList != null && systemLabelList.size() > 0){
            return ResultUtil.returnSuccess(systemLabelList, systemLabelList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统下拉选择
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:13
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemChoice",
    		 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemChoice(@RequestParam(required=false) Byte type){

        List<TbSystemChoice> systemChoiceList = (List<TbSystemChoice>)
                systemService.selectSystemChoice(type);
        if(systemChoiceList != null && systemChoiceList.size() > 0){
            return ResultUtil.returnSuccess(systemChoiceList, systemChoiceList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统banner列表
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:17
     * @return java.lang.Object
     */
	@GetMapping(value = "/getSystemBanner", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemBanner(@RequestParam(required=false) Byte pos){

        List<TbSystemBanner> systemBannerList = (List<TbSystemBanner>)
                systemService.selectSystemBanner(pos);
        if(systemBannerList != null && systemBannerList.size() > 0){
            return ResultUtil.returnSuccess(systemBannerList, systemBannerList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取引导页列表信息
     * @author  RenXiaoFeng
     * @date 2018/3/30 9:49
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemGuide", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemGuide(){

        List<TbSystemGuide> systemGuideList = (List<TbSystemGuide>)
                systemService.selectSystemGuide();
        if(systemGuideList != null && systemGuideList.size() > 0){
            return ResultUtil.returnSuccess(systemGuideList, systemGuideList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统app版本信息
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:19
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemVersion", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemVersion(@RequestParam(required=false) Byte type){

        List<TbSystemVersion> systemVersionList = (List<TbSystemVersion>)
                systemService.selectSystemVersion(type);
        if(systemVersionList != null && systemVersionList.size() > 0){
            return ResultUtil.returnSuccess(systemVersionList.get(0),1);
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统国家列表
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:21
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemCountry", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemCountry(){

        List<TbSystemCrc> systemCountryList = (List<TbSystemCrc>)
                systemService.selectSystemCountry();
        if(systemCountryList != null && systemCountryList.size() > 0){
            return ResultUtil.returnSuccess(systemCountryList, systemCountryList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统区域列表
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:23
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemCity", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemCity(@RequestParam(required = true) Integer parent_id){

        List<TbSystemRegion> systemRegionList = (List<TbSystemRegion>)
                systemService.selectSystemCity(parent_id);
        if(systemRegionList != null && systemRegionList.size() > 0){
            return ResultUtil.returnSuccess(systemRegionList, systemRegionList.size());
        }
        return ResultUtil.returnNull();
    }

    /**
     * 获取系统配置信息
     * @author  RenXiaoFeng
     * @date 2018/3/29 11:25
     * @return java.lang.Object
     */
    @GetMapping(value = "/getSystemConfig", 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getSystemConfig(@RequestParam(required=false) String key){

        Map<String,Object> systemConfigMap =  (Map<String,Object>)
                systemService.selectSystemConfig(key);
        if(systemConfigMap != null && systemConfigMap.size() > 0){
            return ResultUtil.returnSuccess(systemConfigMap, systemConfigMap.size());
        }
        return ResultUtil.returnNull();
    }
}
