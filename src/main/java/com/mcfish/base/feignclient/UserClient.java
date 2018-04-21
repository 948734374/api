package com.mcfish.base.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcfish.base.hystrix.SchedualServiceHiHystric;

/**
 * 用户端feign
 * @author ASLONGYOULOVEME
 * @Date 2018年2月8日 上午11:13:28
 */
//@FeignClient(value = "user-service",fallback = SchedualServiceHiHystric.class)  //服务名称
public interface UserClient {

	/**
	 * 用户端发送验证码
	 * @param phone
	 * @return
	 */
	//@GetMapping(value = "/userController/sendPhoneCode")
	String sendPhoneCode(@RequestParam("phone") String phone);
	
	/**
	 * 获取系统配置信息
	 * @return
	 */
	//@GetMapping(value = "/systemController/getSystemConfig")
	String getSystemConfig();
}
