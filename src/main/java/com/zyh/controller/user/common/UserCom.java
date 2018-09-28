package com.zyh.controller.user.common;

public class UserCom {

	// 缓存时间
	public static final long  USER_SMSCACHETIME = 600;
	
	//产品名称:云通信短信API产品,开发者无需替换
    public static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    public  static final String domain = "dysmsapi.aliyuncs.com";
    //阿里秘钥
    public static final String accessKeyId = "你的阿里云keyId";
    public static final String accessKeySecret = "你的阿里云secret";
    //超过缓存时间
    public static final String ERROR_CACHETIMEOUT = "cachetimeout";
  //用户名为空
    public static final String ERROR_USERNAMEEMPTY = "usernamenull";
  //密码为空
    public static final String ERROR_PWEMPTY = "passwordnull";
    //用户名或密码不正常
    public static final String ERROR_NAMEORPDERROR = "nameorpderror";
     //信息缺失
    public static final String ERROR_INFORERROR = "inforerror";
    //电话号码为空
    public static final String ERROR_PHONEEMPTY = "phonenull";
    //黑名单
    public static final String ERROR_USERDISABLE = "userdisable";
    //userid为空
    public static final String ERROR_USERIDNULL = "useridnull";
    //id不能为空
    public static final String ERROR_IDNULL = "idnull";
    //positionID不能为空
    public static final String ERROR_POSITIONIDNULL = "positionidnull";
  //PARAMERNULL不能为空
    public static final String ERROR_PARAMERNULL = "paramernull";
    
}
