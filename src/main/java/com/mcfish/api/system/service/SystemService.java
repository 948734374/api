package com.mcfish.api.system.service;

/**
 * 系统模块接口
 * @TODO
 * @author RenXiaoFeng
 * @date 2018年3月27日上午9:43:20
 * @description
 *
 */
public interface SystemService {

	/**
	 * 获取帖子标签列表
	 * @return
	 */
	Object selectSystemLabel();
	
	/**
	 * 获取系统下拉选择
	 * @author RenXiaofeng
	 * @param type 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
	 * @return
	 */
	Object selectSystemChoice(Byte type);
	
	/**
	 * 获取banner列表
	 * @author RenXiaofeng
	 * @param pos 显示位置
	 * @return
	 */
	Object selectSystemBanner(Byte pos);

	/**
	 * 获取引导页列表信息
	 * @author  RenXiaoFeng
	 * @date 2018/3/30 9:59
	 * @return java.lang.Object
	 */
	Object selectSystemGuide();
	
	/**
	 * 获取系统app版本信息
	 * @author RenXiaofeng
	 * @param type 0-ios 1-安卓
	 * @return
	 */
	Object selectSystemVersion(Byte type);
	
	/**
	 * 获取系统国家列表
	 * @author RenXiaofeng
	 * @return
	 */
	Object selectSystemCountry();
	
	/**
	 * 获取系统区域列表
	 * @author RenXiaofeng
	 * @return
	 */
	Object selectSystemCity(Integer parent_id);
	
	/**
	 * 获取系统配置信息
	 * @author RenXiaofeng
	 * @return
	 */
	Object selectSystemConfig(String key);
}
