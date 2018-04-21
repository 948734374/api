package com.mcfish.base.hystrix;

import org.springframework.stereotype.Component;

import com.mcfish.base.exception.SystemError;
import com.mcfish.base.feignclient.UserClient;
import com.mcfish.util.resultutil.ResultUtil;

@Component
public class SchedualServiceHiHystric implements UserClient{

	@Override
	public String sendPhoneCode(String phone) {
		return ResultUtil.returnError(SystemError.USER_API_ERRRO.getCode(),
				SystemError.USER_API_ERRRO.getMessage());
	}

	@Override
	public String getSystemConfig() {
		return ResultUtil.returnError(SystemError.USER_API_ERRRO.getCode(),
				SystemError.USER_API_ERRRO.getMessage());
	}
}
