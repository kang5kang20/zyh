package com.zyh.service.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zyh.controller.user.vo.SmsVO;

public interface ISmsService {
	
	public SendSmsResponse sendSms(SmsVO smsVO) throws ClientException;
}
