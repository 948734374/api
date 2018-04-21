package com.mcfish.base.controller;

import com.mcfish.api.article.service.IArticleService;
import com.mcfish.api.collection.service.ICollectionService;
import com.mcfish.api.home.service.HomeService;
import com.mcfish.api.index.service.IIndexService;
import com.mcfish.api.message.service.IMessageService;
import com.mcfish.api.system.service.SystemService;
import com.mcfish.api.user.service.PersonService;
import com.mcfish.api.user.service.UserService;
import com.mcfish.base.mongo.MongoBase;
import com.mcfish.util.redisutil.RedisUtils;
import com.mcfish.util.weixinpay.WxAuth;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制层基类
 * @TODO
 * @author Macro
 * @date 2018年3月24日下午6:17:18
 * @description
 *
 */
public class BaseController {

	
    @Autowired
    protected IIndexService indexService;

    @Autowired
    protected IMessageService messageService;

    @Autowired
    protected IArticleService articleService;

    @Autowired
    protected ICollectionService collectionService;

    @Autowired
    protected HomeService homeService;

    @Autowired
    protected UserService userService;
	
    @Autowired
    protected PersonService personService;

    @Autowired
    protected SystemService systemService;

    @Autowired
    protected MongoBase mongoBase;
    
    @Autowired
    protected RedisUtils redisUtils;

    @Autowired
    protected WxAuth wxAuth;
    
  
}
