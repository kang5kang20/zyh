package com.zyh.service.oss;

import org.springframework.web.multipart.MultipartFile;

public interface IOssService {
	
	public String uploadImg(MultipartFile file)throws Exception;
}
