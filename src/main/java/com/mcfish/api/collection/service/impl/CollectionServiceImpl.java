package com.mcfish.api.collection.service.impl;

import java.util.List;
import java.util.Map;

import org.bouncycastle.jcajce.provider.symmetric.RC2;
import org.springframework.stereotype.Service;

import com.mcfish.api.collection.service.ICollectionService;
import com.mcfish.base.service.BaseService;
import com.mcfish.common.mapper.TbUserCollectionMapper;
import com.mcfish.common.model.TbUserCollection;
import com.mcfish.common.model.TbUserCollectionArticle;
import com.mcfish.util.resultutil.ResultUtil;

/**
 * 收藏模块接口实现
 * @TODO
 * @author Macro
 * @date 2018年3月26日下午4:19:03
 * @description
 *
 */
@SuppressWarnings("unchecked")
@Service
public class CollectionServiceImpl extends BaseService implements ICollectionService {

	@Override
	public Object myCollectionArticle(int uid) {
		TbUserCollectionArticle collectionArticle = new TbUserCollectionArticle();
		collectionArticle.setUserId(uid);
		List<Map<String, Object>> collectionArticleList =
				selectMyCollectionArticle(uid);
		return ResultUtil.returnSuccess(collectionArticleList, collectionArticleList.size());
	}

	@Override
	public Object editArticlefolder(int uid, Integer folderId, Integer articleId, Integer type) {
		TbUserCollectionArticle collectionArticle = new TbUserCollectionArticle();
		collectionArticle.setArticleId(articleId);
		collectionArticle.setCollectionId(folderId);
		tbUserCollectionArticleMapper.updateByPrimaryKeySelective(collectionArticle);
		return ResultUtil.returnNull();
	}

	@Override
	public Object myCollectionfolder(int uid) {
		TbUserCollection collection = new TbUserCollection();
		collection.setUserId(uid);
		List<TbUserCollection> collections = tbUserCollectionMapper.select(collection);
		return ResultUtil.returnSuccess(collections, collections.size());
	}

	@Override
	public Object editCollectionfolder(int intHeader, int uid, String name, String image) {
		TbUserCollection tc = new TbUserCollection();
		tc.setUserId(uid);
		tc.setName(name);
		tc.setImage(image);
		updateCollectionfolder(tc);
		return ResultUtil.returnNull();
	}

	@Override
	public Object myCollectionfolderDetail(int uid, Integer folderid) {
		return ResultUtil.returnSuccess(selectMyfolderCollection(uid, folderid), 1);
	}

	@Override
	public Object myCollectionFamily(int uid) {
		return ResultUtil.returnSuccess(selectMyCollectionFamily(uid), 1);
	}


	public List<Map<String, Object>> selectMyCollectionArticle(Integer uid) {
		List<Map<String, Object>> ret =
				baseDao.selectListByOne("TbUserCollectionArticle_selectMyCollectionArticle", uid);
		return ret;
	}


	public int updateArticlefolder(TbUserCollectionArticle ta) {
		return tbUserCollectionArticleMapper.updateByPrimaryKeySelective(ta);
	}


	public List<Map<String, Object>> selectMyCollectionfolder(Integer uid) {
		List<Map<String, Object>> ret =
				baseDao.selectListByOne("TbUserCollection_selectMyCollectionfolder", uid);
		return ret;
	}


	public int updateCollectionfolder(TbUserCollection tc) {
		return tbUserCollectionMapper.updateByPrimaryKeySelective(tc);
	}


	public List<Map<String, Object>> selectMyfolderCollection(Integer folderid, Integer uid) {
		List<Map<String, Object>> ret =
				baseDao.selectListByOne("TbUserCollection_selectMyFolderCollection", folderid);
		return ret;
	}


	public List<Map<String, Object>> selectMyCollectionFamily(Integer uid) {
		List<Map<String, Object>> ret =
				baseDao.selectListByOne("TbUserCollectionFamily_selectMyCollectionFamily", uid);
		return ret;
	}
}
