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
//    public static final String ERROR_CACHETIMEOUT = "cachetimeout";
    public static final String ERROR_CACHETIMEOUT = "缓存超时";
  //验证码错误
//  public static final String ERROR_VERICODEERROR = "vericoderror";
    public static final String ERROR_VERICODEERROR = "验证码错误";
    
//    public static final String ERROR_VERICODENULL = "vericodenull";
    public static final String ERROR_VERICODENULL = "验证码为空";
    //手机号不存在
//    public static final String ERROR_NOPHONE = "phonenonexist";
    public static final String ERROR_NOPHONE = "手机号不存在";
    //手机号存在
//    public static final String ERROR_PHONEEXIST = "phoneexist";
    public static final String ERROR_PHONEEXIST = "手机号存在";
  //用户名为空
//    public static final String ERROR_USERNAMEEMPTY = "usernamenull";
    public static final String ERROR_USERNAMEEMPTY = "用户名为空";
    //用户名为空
//    public static final String ERROR_USERNAMENON = "usernamenonexist";
    public static final String ERROR_USERNAMENON = "用户名不存在";
  //用户名已经存在
//    public static final String ERROR_USERNAMEEXIST = "usernameexist";
    public static final String ERROR_USERNAMEEXIST = "用户名已经存在";
  //用户名已经存在
//    public static final String ERROR_NAMEEXIST = "nameexist";
    public static final String ERROR_NAMEEXIST = "名称存在";
  //密码为空
//    public static final String ERROR_PWEMPTY = "passwordnull";
    public static final String ERROR_PWEMPTY = "密码为空";
    //用户名或密码不正常
//    public static final String ERROR_NAMEORPDERROR = "nameorpderror";
    public static final String ERROR_NAMEORPDERROR = "用户名或密码错误";
     //信息缺失
//    public static final String ERROR_INFORERROR = "inforerror";
    public static final String ERROR_INFORERROR = "信息缺失";
    //电话号码为空
//    public static final String ERROR_PHONEEMPTY = "phonenull";
    public static final String ERROR_PHONEEMPTY = "电话号码为空";
     //电话号码为空
//    public static final String ERROR_TYPEEMPTY = "typenull";
    public static final String ERROR_TYPEEMPTY = "类型为空";
    //黑名单
//    public static final String ERROR_USERDISABLE = "userdisable";
    public static final String ERROR_USERDISABLE = "用户不可用";
    //userid为空
    public static final String ERROR_USERIDNULL = "useridnull";
    //username为空
//    public static final String ERROR_USERNAMENULL = "usernamenull";
    public static final String ERROR_USERNAMENULL = "用户名为空";
    //id不能为空
    public static final String ERROR_IDNULL = "idnull";
    //positionID不能为空
    public static final String ERROR_POSITIONIDNULL = "positionidnull";
    //positionType不能为空
    public static final String ERROR_POSITIONTYPENULL = "positiontypenull";
  //positionID不能为空
//    public static final String ERROR_POSITIONED = "isposted";
    public static final String ERROR_POSITIONED = "已经投递过";
  //PARAMERNULL不能为空
    public static final String ERROR_PARAMERNULL = "paramernull";
    //用户注册模板
    public static final String SMS_MODEL_ZC = "SMS_147720192";
    //用户修改密码模板
    public static final String SMS_MODEL_XG = "SMS_147720191";
    //绑定手机号
    public static final String SMS_MODEL_BD = "SMS_149421536";
    //position不为空
//    public static final String ERROR_POSITIONNOTNULL = "positionnotnull";
    public static final String ERROR_POSITIONNOTNULL = "招聘信息不为空";
  //用户没投该职位
//    public static final String ERROR_USERNOPOSITION = "usernotposition";
    public static final String ERROR_USERNOPOSITION = "用户没投递该职位";
  //position不为空
//    public static final String ERROR_TRAINNOTNULL = "trainnotnull";
    public static final String ERROR_TRAINNOTNULL = "培训项目不为空";
    //没此用户
    public static final String ERROR_NOUSER = "nouser";
  //usernotfind
//    public static final String ERROR_USERNOTEXIST = "usernitexist";
    public static final String ERROR_USERNOTEXIST = "用户不存在";
    public static final String ERROR_CONTENTNULL = "contentnull";
  //openid存在
    public static final String ERROR_OPENIDEXIST = "openidexist";
  //没有填写简历
//    public static final String ERROR_NORESUMEBASE = "noresumebase";
    public static final String ERROR_NORESUMEBASE = "未填写简历";
    //startdate空
    public static final String ERROR_NULLSTARTDATE = "nullstartdate";
  //enddate空
    public static final String ERROR_NULLENDDATE = "nullenddate";
}
