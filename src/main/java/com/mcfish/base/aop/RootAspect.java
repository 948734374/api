package com.mcfish.base.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcfish.base.exception.MyException;
import com.mcfish.base.exception.SystemError;
import com.mcfish.util.redisutil.RedisUtils;
import com.mcfish.util.resultutil.ResultUtil;


@Component
@Aspect
public class RootAspect {
     
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private RedisUtils redisUtils;
	
	/******log record******/
	protected Logger log = Logger.getLogger(RootAspect.class);
	
	/**
	 * 权限验证
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.mcfish.api.*.controller.*.*Root(..))") 
	public Object VaApp(ProceedingJoinPoint jp) throws Throwable{
		
         try {
//        	 
//        	 //获取类名
//      		 String className = jp.getThis().toString();  
//      		 //获取方法名
//      	     String methodName = jp.getSignature().getName();
      	    
         	// String paramStr = "?";
     		 String ad = req.getHeader("uid");
     		 Object result = null;
     		 
     		 //Enumeration<String> enu = req.getParameterNames();
     		 
    		 if(ad==""||ad==null)
    		 {
    			  return ResultUtil.returnFail(SystemError.LOGIN_FAIL.getMessage(), 
						  SystemError.LOGIN_FAIL.getCode());
    		 }  
    		 else
    		 {    
    			  String u = (String) redisUtils.getCache(ad);
    			  if(u==null) {
    				  return ResultUtil.returnFail(SystemError.LOGIN_FAIL.getMessage(), 
    						  SystemError.LOGIN_FAIL.getCode());
    			  }
    			  //用户传输的token
    			  String token = req.getHeader("token");
    			  if(u.equals(token))
    			  {  				  
    				  result = jp.proceed();   								  
    				  return result; 
    			  }
    			  else
    			  {
    				  return ResultUtil.returnFail(SystemError.TOKEN_OVER.getMessage(), 
    						  SystemError.TOKEN_OVER.getCode());
    			  }
    		 }
		} catch (Exception e) {
			
			//获取类名
    		String className = jp.getThis().toString();  
    		//获取方法名
    	    String methodName = jp.getSignature().getName();
			
    	    if (e instanceof MyException) {
				
				return ResultUtil.returnError(((MyException) e).getCode(),((MyException) e).getMessage());
			}else {
				
				log.error("\n类名:" + className + " ,\n" +
		  	    		  "方法名:" + methodName + " ,\n"+"异常连接--》",e);
				return ResultUtil.returnError(SystemError.OTHER_EXCEPTION.getCode(),
						SystemError.OTHER_EXCEPTION.getMessage());
			}
		}
   }
		
}
