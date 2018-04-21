package com.mcfish.base.mongo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mcfish.Application;

/**
 * Mongodb
 * @package com.mcfish.app.base.mongo
 * @description   
 * @author shangfei
 * @param <T>
 * @date 2018年1月22日
 *
 */
@SpringBootApplication
@Component
public class MongoBase{

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	private Logger log = LoggerFactory.getLogger(Application.class);
	
	/**
	 * mongoInsert 
	 * @param object
	 * @param collectionName 集合名称
	 */
	public void insert(Object object, String collectionName) {
		
		try {
			
			if(collectionName != null && collectionName != ""){
				mongoTemplate.insert(object, collectionName);
			}else {
				mongoTemplate.insert(object);
			}
			
		} catch (Exception e) {
			log.error("Mongodb insert异常:"+ e);
		}
		
	}
	
	/**
	 * mongoSave
	 * @param object
	 * @param collectionName 集合名称
	 */
	public void save(Object object, String collectionName) {

		try {
			
			if(collectionName != null && collectionName != ""){
				mongoTemplate.save(object, collectionName);
			}else {
				mongoTemplate.save(object);
			}
			
		} catch (Exception e) {
			log.error("Mongodb save异常:"+ e);
		}
	}
	
	/**
	 * mongoDelete
	 * @param object
	 * @param collectionName 集合名称
	 */
	public void delete(Object object, String collectionName) {

		try {
			
			if(collectionName != null && collectionName != ""){
				mongoTemplate.remove(object, collectionName);
			}else {
				mongoTemplate.remove(object);
			}
			
		} catch (Exception e) {
			log.error("Mongodb remove异常:"+ e);
		}
	}
	
	/**
	 * mongoFind
	 * @param <T>
	 * @param object
	 * @param collectionName 集合名称
	 */
	public <T> List<T> Find(Query query,Class<T> entityClass , String collectionName) {

		try {
			
			if(collectionName != null && collectionName != ""){
				List<T> res = mongoTemplate.find(query, entityClass, collectionName);
				return res;
			}else {
				List<T> res = mongoTemplate.find(query, entityClass);
				return res;
			}
			
		} catch (Exception e) {
			log.error("Mongodb find异常:"+ e);
			return null;
		}
	}
	
	/**
	 * mongoFindOne
	 * @param <T>
	 * @param object
	 * @param collectionName 集合名称
	 */
	public <T> T FindOne(Query query,Class<T> entityClass , String collectionName) {

		try {
			
			if(collectionName != null && collectionName != ""){
				T res = mongoTemplate.findOne(query, entityClass, collectionName);
				return res;
			}else {
				T res = mongoTemplate.findOne(query, entityClass);
				return res;
			}
			
		} catch (Exception e) {
			log.error("Mongodb findOne异常:"+ e);
			return null;
		}
	}
	


}
