package com.mcfish.util.mongodbutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


public class MongodbUtil {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
}
