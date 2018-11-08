package com.zyh.controller.resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.zyh.controller.resume.vo.ResumeBaseQueryVO;
import com.zyh.controller.resume.vo.ResumeVO;
import com.zyh.controller.user.common.UserCom;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeBaseExample;
import com.zyh.entity.resume.ZyhResumeBaseExample.Criteria;
import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeEducationExample;
import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeIntentionExample;
import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeSpecialityExample;
import com.zyh.entity.resume.ZyhResumeWork;
import com.zyh.entity.resume.ZyhResumeWorkExample;
import com.zyh.service.resume.IResumeBaseService;
import com.zyh.service.resume.IResumeEducationService;
import com.zyh.service.resume.IResumeIntentionService;
import com.zyh.service.resume.IResumeSpecialityService;
import com.zyh.service.resume.IResumeWorkService;
import com.zyh.service.resume.impl.ResumeIntentionServiceImpl;
import com.zyh.utils.PdfUtil;

@RestController
@RequestMapping("/resume")
public class ResumeController {

	private Logger log = Logger.getLogger("error");

	@Autowired
	private IResumeBaseService resumeBaseService;

	@Autowired
	private IResumeWorkService resumeWorkService;

	@Autowired
	private IResumeEducationService resumeEducationService;

	@Autowired
	private IResumeSpecialityService resumeSpecialityService;

	@Autowired
	private IResumeIntentionService resumeIntentionService;

	/**
	 * 添加简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addBase.act")
	public ResponeToWeb addResumeBase(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeBase zyhResumeBase = om.readValue(json, ZyhResumeBase.class);
			if (null != zyhResumeBase.getUserid() && !"".equals(zyhResumeBase.getUserid())) {
				resumeBaseService.addResumeBase(zyhResumeBase);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 修改简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateBase.act")
	public ResponeToWeb updateResumeBase(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeBase zyhResumeBase = om.readValue(json, ZyhResumeBase.class);
			if (null != zyhResumeBase.getId() && !"".equals(zyhResumeBase.getId())) {
				resumeBaseService.updateResumeBaseById(zyhResumeBase);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 删除简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delBase.act")
	public ResponeToWeb deleteResumeBase(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id = node.get("id").asText();
			if (null != id && !"".equals(id)) {
				resumeBaseService.delResumeBaseById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 通过userid查询简历基本信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/queryBase.act")
	public ResponeToWeb queryResumeBaseByUserId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String userid = node.get("userid").asText();
			if (null != userid && !"".equals(userid)) {
				ZyhResumeBaseExample zyhResumeBaseExample = new ZyhResumeBaseExample();
				zyhResumeBaseExample.createCriteria().andUseridEqualTo(userid);
				List<ZyhResumeBase> list = resumeBaseService.selectResumeBaseByExample(zyhResumeBaseExample);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 添加简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addWork.act")
	public ResponeToWeb addResumeWork(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeWork zyhResumeWork = om.readValue(json, ZyhResumeWork.class);
			if (null != zyhResumeWork.getUserid() && !"".equals(zyhResumeWork.getUserid())) {
				resumeWorkService.addResumeWork(zyhResumeWork);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 修改简历工作信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateWork.act")
	public ResponeToWeb updateResumeWork(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeWork zyhResumeWork = om.readValue(json, ZyhResumeWork.class);
			if (null != zyhResumeWork.getId() && !"".equals(zyhResumeWork.getId())) {
				resumeWorkService.updateResumeWorkById(zyhResumeWork);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 删除简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delWork.act")
	public ResponeToWeb deleteResumeWork(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id = node.get("id").asText();
			if (null != id && !"".equals(id)) {
				resumeWorkService.delResumeWorkById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 通过userid查询简历基本信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/queryWork.act")
	public ResponeToWeb queryResumeWorkByUserId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String userid = node.get("userid").asText();
			if (null != userid && !"".equals(userid)) {
				ZyhResumeWorkExample zyhResumeWorkExample = new ZyhResumeWorkExample();
				zyhResumeWorkExample.createCriteria().andUseridEqualTo(userid);
				List<ZyhResumeWork> list = resumeWorkService.selectResumeWorkByExample(zyhResumeWorkExample);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 添加简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addEducation.act")
	public ResponeToWeb addResumeEducation(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeEducation zyhResumeEducation = om.readValue(json, ZyhResumeEducation.class);
			if (null != zyhResumeEducation.getUserid() && !"".equals(zyhResumeEducation.getUserid())) {
				resumeEducationService.addResumeEducation(zyhResumeEducation);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 修改简历工作信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateEducation.act")
	public ResponeToWeb updateResumeEducation(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeEducation zyhResumeEducation = om.readValue(json, ZyhResumeEducation.class);
			if (null != zyhResumeEducation.getId() && !"".equals(zyhResumeEducation.getId())) {
				resumeEducationService.updateResumeEducationById(zyhResumeEducation);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 删除简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delEducation.act")
	public ResponeToWeb deleteResumeEducation(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id = node.get("id").asText();
			if (null != id && !"".equals(id)) {
				resumeEducationService.delResumeEducationById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 通过userid查询简历基本信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/queryEducation.act")
	public ResponeToWeb queryResumeEducationByUserId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String userid = node.get("userid").asText();
			if (null != userid && !"".equals(userid)) {
				ZyhResumeEducationExample zyhResumeEducationExample = new ZyhResumeEducationExample();
				zyhResumeEducationExample.createCriteria().andUseridEqualTo(userid);
				List<ZyhResumeEducation> list = resumeEducationService
						.selectResumeEducationByExample(zyhResumeEducationExample);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 添加简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addSpeciality.act")
	public ResponeToWeb addResumeSpeciality(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeSpeciality zyhResumeSpeciality = om.readValue(json, ZyhResumeSpeciality.class);
			if (null != zyhResumeSpeciality.getUserid() && !"".equals(zyhResumeSpeciality.getUserid())) {
				resumeSpecialityService.addResumeSpeciality(zyhResumeSpeciality);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 修改简历工作信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateSpeciality.act")
	public ResponeToWeb updateResumeSpeciality(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeSpeciality zyhResumeSpeciality = om.readValue(json, ZyhResumeSpeciality.class);
			if (null != zyhResumeSpeciality.getId() && !"".equals(zyhResumeSpeciality.getId())) {
				resumeSpecialityService.updateResumeSpecialityById(zyhResumeSpeciality);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 删除简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delSpeciality.act")
	public ResponeToWeb deleteResumeSpeciality(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id = node.get("id").asText();
			if (null != id && !"".equals(id)) {
				resumeSpecialityService.delResumeSpecialityById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 通过userid查询简历基本信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/querySpeciality.act")
	public ResponeToWeb queryResumeSpecialityByUserId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String userid = node.get("userid").asText();
			if (null != userid && !"".equals(userid)) {
				ZyhResumeSpecialityExample zyhResumeSpecialityExample = new ZyhResumeSpecialityExample();
				zyhResumeSpecialityExample.createCriteria().andUseridEqualTo(userid);
				List<ZyhResumeSpeciality> list = resumeSpecialityService
						.selectResumeSpecialityByExample(zyhResumeSpecialityExample);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/getResume.act")
	public ResponeToWeb getResume(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ResumeVO resumeVO = new ResumeVO();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			JsonNode jsonNode = om.readTree(json);
			String userid = jsonNode.get("userid").asText();
			ZyhResumeBaseExample zyhResumeBaseExample = new ZyhResumeBaseExample();
			zyhResumeBaseExample.createCriteria().andUseridEqualTo(userid);
			List<ZyhResumeBase> resumeBases = resumeBaseService.selectResumeBaseByExample(zyhResumeBaseExample);
			if (null != resumeBases && resumeBases.size() > 0) {
				ZyhResumeBase zyhResumeBase = resumeBases.get(0);
				resumeVO.setZyhResumeBase(zyhResumeBase);
			}
			ZyhResumeWorkExample zyhResumeWorkExample = new ZyhResumeWorkExample();
			zyhResumeWorkExample.createCriteria().andUseridEqualTo(userid);
			resumeVO.setZyhResumeWorks(resumeWorkService.selectResumeWorkByExample(zyhResumeWorkExample));
			ZyhResumeEducationExample zyhResumeEducationExample = new ZyhResumeEducationExample();
			zyhResumeEducationExample.createCriteria().andUseridEqualTo(userid);
			resumeVO.setZyhResumeEducations(
					resumeEducationService.selectResumeEducationByExample(zyhResumeEducationExample));
			ZyhResumeSpecialityExample zyhResumeSpecialityExample = new ZyhResumeSpecialityExample();
			zyhResumeSpecialityExample.createCriteria().andUseridEqualTo(userid);
			resumeVO.setZyhResumeSpecialities(
					resumeSpecialityService.selectResumeSpecialityByExample(zyhResumeSpecialityExample));
			ZyhResumeIntentionExample zyhResumeIntentionExample = new ZyhResumeIntentionExample();
			zyhResumeBaseExample.createCriteria().andUseridEqualTo(userid);
			resumeVO.setZyhResumeIntentions(
					resumeIntentionService.selectResumeIntentionByExample(zyhResumeIntentionExample));
			map.put("result", resumeVO);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 添加简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addIntention.act")
	public ResponeToWeb addResumeIntention(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeIntention zyhResumeIntention = om.readValue(json, ZyhResumeIntention.class);
			if (null != zyhResumeIntention.getUserid() && !"".equals(zyhResumeIntention.getUserid())) {
				resumeIntentionService.addResumeIntention(zyhResumeIntention);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 修改简历工作信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateIntention.act")
	public ResponeToWeb updateResumeIntention(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhResumeIntention zyhResumeIntention = om.readValue(json, ZyhResumeIntention.class);
			if (null != zyhResumeIntention.getId() && !"".equals(zyhResumeIntention.getId())) {
				resumeIntentionService.updateResumeIntentionById(zyhResumeIntention);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 删除简历基本信息
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delIntention.act")
	public ResponeToWeb deleteResumeIntention(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id = node.get("id").asText();
			if (null != id && !"".equals(id)) {
				resumeIntentionService.delResumeIntentionById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	/**
	 * 通过userid查询简历基本信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/queryIntention.act")
	public ResponeToWeb queryResumeIntentionyByUserId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String userid = node.get("userid").asText();
			if (null != userid && !"".equals(userid)) {
				ZyhResumeIntentionExample zyhResumeIntentionExample = new ZyhResumeIntentionExample();
				zyhResumeIntentionExample.createCriteria().andUseridEqualTo(userid);
				List<ZyhResumeIntention> list = resumeIntentionService
						.selectResumeIntentionByExample(zyhResumeIntentionExample);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/queryResumeBaseByPage.act")
	public ResponeToWeb queryResumeBaseByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ResumeBaseQueryVO resumeBaseQueryVO = om.readValue(json, ResumeBaseQueryVO.class);
			ZyhResumeBaseExample zyhResumeBaseExample = new ZyhResumeBaseExample();
			Criteria criteria = zyhResumeBaseExample.createCriteria();
			if (null!=resumeBaseQueryVO.getUserid()&&!"".equals(resumeBaseQueryVO.getUserid())) {
				criteria.andUseridEqualTo(resumeBaseQueryVO.getUserid());
			}
			if (null!=resumeBaseQueryVO.getSoldiercheckstate()&&!"".equals(resumeBaseQueryVO.getSoldiercheckstate())) {
				criteria.andSoldiercheckstateEqualTo(resumeBaseQueryVO.getSoldiercheckstate());
			}
			if (null!=resumeBaseQueryVO.getIdcheckstate()&&!"".equals(resumeBaseQueryVO.getIdcheckstate())) {
				criteria.andIdcheckstateEqualTo(resumeBaseQueryVO.getIdcheckstate());
			}
			map = resumeBaseService.findResumeBaseByPage(zyhResumeBaseExample, resumeBaseQueryVO.getPageNum(),
					resumeBaseQueryVO.getPageSize());
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	
	@RequestMapping("/exportResume.act")
	public void exportResume(HttpServletResponse response,HttpServletRequest request)throws Exception{
//		ObjectMapper om = new ObjectMapper();
//		JsonNode node = om.readTree(json);
//		String userid = node.get("userid").asText();
		String userid = request.getParameter("userid");
		if(null==userid || "".equals(userid)){
			log.error("userid为空");
			return;
		}
		ZyhResumeBaseExample baseexam = new ZyhResumeBaseExample();
		Criteria basecri = baseexam.createCriteria();
		basecri.andUseridEqualTo(userid);
		List<ZyhResumeBase> baselist = resumeBaseService.selectResumeBaseByExample(baseexam);
		if(null==baselist || baselist.size()<=0){
			log.error("简历不存在");
			return;
		}
		ZyhResumeWorkExample workexam = new ZyhResumeWorkExample();
		com.zyh.entity.resume.ZyhResumeWorkExample.Criteria workcri = 
				workexam.createCriteria();
		workcri.andUseridEqualTo(userid);
		List<ZyhResumeWork> worklist = resumeWorkService.selectResumeWorkByExample(workexam);
		
		ZyhResumeEducationExample eduexam = new ZyhResumeEducationExample();
		com.zyh.entity.resume.ZyhResumeEducationExample.Criteria educri = 
				eduexam.createCriteria();
		educri.andUseridEqualTo(userid);
		List<ZyhResumeEducation> edulist = resumeEducationService.selectResumeEducationByExample(eduexam);
		
		ZyhResumeIntentionExample intexam = new ZyhResumeIntentionExample();
		com.zyh.entity.resume.ZyhResumeIntentionExample.Criteria intcri = 
				intexam.createCriteria();
		intcri.andUseridEqualTo(userid);
		List<ZyhResumeIntention> intlist = resumeIntentionService.selectResumeIntentionByExample(intexam);
		
		ZyhResumeSpecialityExample speexam = new ZyhResumeSpecialityExample();
		com.zyh.entity.resume.ZyhResumeSpecialityExample.Criteria specri = 
				speexam.createCriteria();
		specri.andUseridEqualTo(userid);
		List<ZyhResumeSpeciality> spelist = resumeSpecialityService.selectResumeSpecialityByExample(speexam);
        Document document = new Document();
		try {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment;fileName=Resume.pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(PdfUtil.getTable(baselist.get(0),worklist,edulist,intlist,spelist));
			document.close();
		} catch (Exception e) {
			log.error("导出pdf失败");
			return;
		}
	}
}
