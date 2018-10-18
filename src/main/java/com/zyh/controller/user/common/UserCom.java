package com.zyh.controller.user.common;

public class UserCom {

	// 缓存时间
	public static final long  USER_SMSCACHETIME = 600;
	
	//产品名称:云通信短信API产品,开发者无需替换
    public static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    public  static final String domain = "dysmsapi.aliyuncs.com";
    //阿里秘钥
    public static final String accessKeyId = "LTAIuYFNoWwARpLU";
    public static final String accessKeySecret = "J1trjrkhmbacOYGtiqtFfAipeouDuu";
    public static final String endPoint = "oss-cn-beijing.aliyuncs.com";
    //超过缓存时间
    public static final String ERROR_CACHETIMEOUT = "cachetimeout";
  //验证码错误
    public static final String ERROR_VERICODEERROR = "vericoderror";
    public static final String ERROR_VERICODENULL = "vericodenull";
    //手机号不存在
    public static final String ERROR_NOPHONE = "phonenonexist";
  //用户名为空
    public static final String ERROR_USERNAMEEMPTY = "usernamenull";
    //用户名为空
    public static final String ERROR_USERNAMENON = "usernamenonexist";
  //密码为空
    public static final String ERROR_PWEMPTY = "passwordnull";
    //用户名或密码不正常
    public static final String ERROR_NAMEORPDERROR = "nameorpderror";
     //信息缺失
    public static final String ERROR_INFORERROR = "inforerror";
    //电话号码为空
    public static final String ERROR_PHONEEMPTY = "phonenull";
     //电话号码为空
    public static final String ERROR_TYPEEMPTY = "typenull";
    //黑名单
    public static final String ERROR_USERDISABLE = "userdisable";
    //userid为空
    public static final String ERROR_USERIDNULL = "useridnull";
    //username为空
    public static final String ERROR_USERNAMENULL = "usernamenull";
    //id不能为空
    public static final String ERROR_IDNULL = "idnull";
    //positionID不能为空
    public static final String ERROR_POSITIONIDNULL = "positionidnull";
  //positionID不能为空
    public static final String ERROR_POSITIONED = "isposted";
  //PARAMERNULL不能为空
    public static final String ERROR_PARAMERNULL = "paramernull";
    //用户注册模板
    public static final String SMS_MODEL_ZC = "SMS_147720192";
    //用户修改密码模板
    public static final String SMS_MODEL_XG = "SMS_147720191";
}
