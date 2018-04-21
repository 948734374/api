package com.mcfish.util.common;


public class StringUtil {
    
	
	/**
	 * ****************************************
	 * function: 判断对象是否为空(如果为空,return true)
	 * @param str
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-13下午1:11:04
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static boolean isEmpty(Object str) {
		if ((str == null) || ("null".equals(str))) 
		{
		      return true;
	    }
	    return String.valueOf(str).length() < 1;		
	}
	
	/**
	 * ****************************************
	 * function: 判断字符串是否为空(空 ,return true)
	 * @param cs
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-13下午1:15:30
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0)
		{
			return true;
		}			
		for (int i = 0; i < strLen; i++)
		{
			if (!Character.isWhitespace(cs.charAt(i)))
			{
				return false;
			}
				
		}
		return true;
	}
	
	
}
