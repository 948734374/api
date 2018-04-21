package com.mcfish.api.collection.service;

import java.util.List;
import java.util.Map;

import com.mcfish.common.model.TbUserCollection;
import com.mcfish.common.model.TbUserCollectionArticle;

/**
 * 收藏模块接口
 * @TODO
 * @author Macro
 * @date 2018年3月26日下午4:19:29
 * @description
 *
 */
public interface ICollectionService {
	/**
	 * 1，我收藏的帖子
	 * @param uid
	 * @return
	 */
	Object myCollectionArticle(int uid);

	/**
	 * 2，帖子分类
	 * @param uid
	 * @param folderId
	 * @param articleId
	 * @param type
	 * @return
	 */
	Object editArticlefolder(int uid, Integer folderId, Integer articleId, Integer type);

	/**
	 * 3，我收藏夹
	 * @param uid
	 * @return
	 */
	Object myCollectionfolder(int uid);

	/**
	 * 4，收藏夹编辑
	 *
	 * @param intHeader
	 * @param uid
	 * @param name
	 * @param image
	 * @return
	 */
	Object editCollectionfolder(int intHeader, int uid, String name, String image);

	/**
	 * 5，我收藏夹内容
	 * @param uid
	 * @param folderid
	 * @return
	 */
	Object myCollectionfolderDetail(int uid, Integer folderid);

	/**
	 * 6，获取我收藏的家庭
	 * @param uid
	 * @return
	 */
	Object myCollectionFamily(int uid);
}
