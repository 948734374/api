package com.mcfish.constant;

public class UserConstant {
    
	
	/****正常*****/
	public static final Byte USER_STATUS_OK=Byte.decode("0");
	/****冻结*****/
	public static final Byte USER_STATUS_FAIL=Byte.decode("1");
	
	/****用户账号密码登录*****/
	public static final String USER_LOGIN_TYPE_ONE = "1";
	/****用户token登录*****/
	public static final String USER_LOGIN_TYPE_THREE = "3";
	/****用户第三方登录*****/
	public static final String USER_LOGIN_TYPE_TWO = "2";
}
