package com.zyh.controller.oss;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyh.entity.common.ResponeToWeb;
import com.zyh.service.oss.IOssService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/oss")
public class OssController {

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IOssService ossService;
	
	@RequestMapping(value = "/headImgUpload", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ResponeToWeb headImgUpload(HttpServletRequest request, MultipartFile file) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<>();
		try {
			String url = ossService.uploadImg(file);
			responeToWeb.setMsg("图片上传成功");
			responeToWeb.setSuccess(true);
			map.put("resule", url);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

}
