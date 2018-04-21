package com.mcfish.api.system.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mcfish.common.model.*;
import org.springframework.stereotype.Service;
import com.mcfish.api.system.service.SystemService;
import com.mcfish.base.service.BaseService;

/**
 * 系统功能模块接口实现
 * @TODO
 * @author RenXiaofeng
 * @date 2018年3月27日上午9:43:31
 * @description
 *
 */
@SuppressWarnings("unchecked")
@Service
public class SystemServiceImpl extends BaseService implements SystemService{

	@Override
	public Object selectSystemLabel() {
		TbSystemLabel systemLabel = new TbSystemLabel();
		systemLabel.setStatus((byte) 0);  //0-有效，1-无效
		return tbSystemLabelMapper.select(systemLabel);
	}

	@Override
	public Object selectSystemChoice(Byte type) {
		TbSystemChoice systemChoice = new TbSystemChoice();
		systemChoice.setStatus((byte) 0); //0-有效，1-无效
		//是否具有类型属性（没有则查询所有）
		if (!"".equals(type) && type != null){
			systemChoice.setStatus(type);
		}
		return tbSystemChoiceMapper.select(systemChoice);
	}

	@Override
	public Object selectSystemBanner(Byte pos) {
		TbSystemBanner systemBanner = new TbSystemBanner();
		systemBanner.setStatus((byte) 0); //0-有效，1-无效
		//是否具有类型属性（没有则查询所有）
		if (!"".equals(pos) && pos != null){
			systemBanner.setPos(pos);
		}
		return tbSystemBannerMapper.select(systemBanner);
	}

	@Override
	public Object selectSystemGuide() {
		TbSystemGuide systemGuide = new TbSystemGuide();
		systemGuide.setStatus((byte) 0); //0-有效，1-无效
		return tbSystemGuideMapper.select(systemGuide);
	}

	@Override
	public Object selectSystemVersion(Byte type) {
		List<TbSystemVersion> systemVersionList;
		TbSystemVersion systemVersion = new TbSystemVersion();
		systemVersion.setType(type);
		systemVersionList =  tbSystemVersionMapper.select(systemVersion);
		//JDK1.8新特性按对象属性排序
		List<TbSystemVersion> sortSystemVersionList = systemVersionList.stream().sorted(
				Comparator.comparing(TbSystemVersion::getVersion).reversed()).collect(Collectors.toList());

		return sortSystemVersionList;
	}

	@Override
	public Object selectSystemCountry() {
		return tbSystemCrcMapper.selectAll();
	}

	@Override
	public List<TbSystemRegion> selectSystemCity(Integer parent_id) {
		TbSystemRegion systemRegion = new TbSystemRegion();
		systemRegion.setParent_id(parent_id);
		return tbSystemRegionMapper.select(systemRegion);
	}

	@Override
	public Object selectSystemConfig(String key) {
		Map<Object,Object> systemConfigMap = new HashMap<>();
		List<TbSystemConfig> systemConfigList;
		TbSystemConfig systemConfig = new TbSystemConfig();
		//是否具有关键字属性（没有则查询所有）
		if (!"".equals(key) && key != null){
			systemConfig.setKey(key);
			systemConfigList = tbSystemConfigMapper.select(systemConfig);
		}else {
			systemConfigList = tbSystemConfigMapper.selectAll();
		}
		for (TbSystemConfig sysConfig : systemConfigList){
			systemConfigMap.put(sysConfig.getKey(),sysConfig.getValue());
		}
		return systemConfigMap;
	}

}
