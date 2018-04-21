package com.mcfish.util.weixinpay;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.mcfish.Application;
import com.mcfish.api.task.Task;
import com.mcfish.base.exception.MyException;
import com.mcfish.base.service.BaseService;
import com.mcfish.util.common.HttpUtil;
import com.mcfish.util.redisutil.RedisUtils;
import com.mcfish.util.weixinpay.config.BasicInfo;
import com.mcfish.util.weixinpay.util.SignUtil;

/**
 * 微信相关授权
 * @author ASLONGYOULOVEME
 *
 */
@Component
public class WxAuth extends BaseService{

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private Task task;
	
	private Logger log = LoggerFactory.getLogger(Application.class);
	
	/**
	 * 微信js授权
	 * @param url
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public Object WxJsAuth(String url) throws Exception{
		
		 HashMap<String, String> map=new HashMap<String, String>();
		 String jsapi_ticket = "";
		 String timestamp = Long.toString(System.currentTimeMillis()/1000);
		 log.info("timestamp:"+timestamp);
		 if(redisUtils.exists("jsapi_ticket_agent")) {
			 jsapi_ticket = (String) redisUtils.getCache("jsapi_ticket_agent");
			 if(jsapi_ticket == null || jsapi_ticket == "") {
				 task.getWxAccessToken();
				 jsapi_ticket = (String) redisUtils.getCache("jsapi_ticket_agent");
			 }
		 }else {
			 task.getWxAccessToken();
			 jsapi_ticket = (String) redisUtils.getCache("jsapi_ticket_agent");
		 }
		 
		 //生成签名
		 String nonce_str = UUID.randomUUID().toString();	
		 String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
	                + "&timestamp=" + timestamp  + "&url=" + url;
	     MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	     crypt.reset();
	     crypt.update(str.getBytes("UTF-8"));
	     String signature = SignUtil.byteToHex(crypt.digest());
	     map.put("appId", BasicInfo.appID);
	     map.put("timestamp", timestamp);
	     map.put("nonceStr", nonce_str);
	     map.put("signature", signature);
		 return map;
	}
	
	/**
	 * 微信用户授权
	 * @param code
	 * @return
	 * @throws MyException 
	 * @throws Exception 
	 */
	public void WxUserAuth(String code,Integer uid) throws Exception{
		
		String result=HttpUtil.post("https://api.weixin.qq.com/sns/oauth2/access_token",
				 "appid="+BasicInfo.appID+
				 "&secret="+BasicInfo.AppSecret+
				 "&code="+code+"&grant_type=authorization_code");
		
		JSONObject ret = JSONObject.parseObject(result);
		if(ret==null) throw new MyException(220, "微信授权失败");
		
		String openId = (String) ret.get("openid");
//		String userInfo = HttpUtil.post("https://api.weixin.qq.com/sns/userinfo",
//				 "access_token="+ret.get("access_token")+
//				 "&openid="+ret.get("openid")+
//				 "&lang=zh_CN ");
//		
//		if(userInfo == null || openId == null) throw new MyException(221, "微信授权失败，无法获取用户信息");
//		JSONObject userInfoObj = JSONObject.parseObject(userInfo);
	}
}
