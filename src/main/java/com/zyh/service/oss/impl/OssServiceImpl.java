package com.zyh.service.oss.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyh.service.oss.IOssService;
import com.zyh.service.oss.util.OssClientUtil;

@Service("ossService")
public class OssServiceImpl implements IOssService {

	@Override
	public String uploadImg(MultipartFile file) throws Exception {
		OssClientUtil ossClient = new OssClientUtil();
		String name = ossClient.uploadImg2Oss(file);
		String imgUrl = ossClient.getImgUrl(name);
		String[] split = imgUrl.split("\\?");
		return split[0];
	}

}
