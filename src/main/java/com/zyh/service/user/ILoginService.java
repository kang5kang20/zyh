package com.zyh.service.user;

import com.zyh.controller.user.vo.SmsVO;
import com.zyh.entity.user.ZyhUser;

public interface ILoginService {
	
	public ZyhUser loginAndRegister(ZyhUser zyhUser) throws Exception;
	
	public ZyhUser loginByMM(ZyhUser zyhUser)throws Exception;
	
	public SmsVO smsService(String phone) throws Exception;
}
