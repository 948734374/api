package com.mcfish.base.exception;

/**
 * 定义返回错误码
 * 
 * @author wuhong  2017-7-21 下午5:26:36 
 * @version share 1.0
 */
public enum SystemError {

	/*0：成功

	100 - 199 ： 通用类型错误 + 登陆注册模块的错误信息； 对应 userController

	200 - 299  :用户个人中心操作类错误，对于 personController

	300 - 399 ： 钱包相关的错误，对于buniessController

	600 - 699 ： 各种系统类、系统配置类的错误码。对于systemController, 系统异常等。
	*/
	/***请求参数不合法***/
	PARAMETER_NULL(100, "请求参数有误"),
	/***用户名不存在***/
	LOGIN_FAILED_NAME(101,"用户名不存在"),
	/***密码不正确***/
	LOGIN_FAILED_PASSWORD(102,"密码不正确"),
	/***验证码已过期***/
	CODE_EXPIRE(203, "验证码已过期"),
	/***验证码错误***/
	CODE_NOT_EXIT(204, "验证码错误"),
	/***暂无权限***/
	LOGIN_FAIL(105, "暂无权限"),
	/***账号被冻结***/
	LOGIN_FREEZE(108,"账号被冻结"),
	/***手机号已被注册***/
	REGISTER_PHONE(109,"手机号已被注册"),
	/***TOKEN过期***/
	TOKEN_OVER(106, "token已过期"),
	/***TOKEN不存在***/
	TOKEN_NULL(107, "token不存在"),
	/***短信验证码发送失败***/
	CODE_PHONE(110,"短信验证码发送失败"),
	/***发送验证码频率过快***/
	SEND_CODE_ERROR(114,"发送验证码频率过快"),
	
	/****文件上传失败*******/
	UPLOADFILE_FAIL(160,"文件上传失败"),
	

	
	/****支付金额有误*******/
	PROCESS_MONEY_BAD(150,"微信单笔交易不能超过200元"),
	/****微信提现失败*******/
	WX_RETREIEV_ERROR(151,"微信提现失败"),
	/****微信提现失败*******/
	WX_RETREIEV_ERR(152,"微信提现失败,你有未结束的订单"),
	/****支付宝提现失败*******/
	ALIPAY_RETREIEV_ERROR(153,"支付宝提现失败"),
	/****微信支付异常*******/
	WX_PAY_ERROR(154,"微信支付异常"),

	/**
	 * 已经好友
	 */
	ALREADY_FRIEND(200, "已经好友"),
	
	/****你不是该家庭成员*******/
	FAMILY_NOYOU(201, "你不是该家庭成员"),
	/****你不是该家庭管理员*******/
	FAMILY_ADMIN(202, "你不是该家庭管理员"),

	/**
	 * 操作失败
	 */
	OPERATION_FAILURE(261, "操作失败"),
	
	/***未知错误***/
	FAIL_NO_KNOW(600, "未知逻辑错误"),

	INVALID_PARAM(604, "无效的请求参数"),
    /****主线业务逻辑错误提示*******/
	
	/****userApi服务器异常，发送验证码失败******/
	USER_API_ERRRO(603, "用户服务器异常，发送验证码失败"),
	
	/****空指针异常******/
	NULL_EXCEPTION(601, "请求数据有误"),
	/****系统其他异常******/
	OTHER_EXCEPTION(602, "服务器异常，请联系管理员")
	;
	
	
	
	/**状态码**/
	private int code;
	/**信息**/
    private String message;

    SystemError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
	
	
}
