package com.zyh.controller.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.company.vo.CompanyPositionVO;
import com.zyh.controller.company.vo.CompanyQueryVO;
import com.zyh.controller.company.vo.FirstQueryVO;
import com.zyh.controller.company.vo.PositionQueryVO;
import com.zyh.controller.company.vo.TrainQueryVO;
import com.zyh.controller.user.common.UserCom;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.company.ZyhCompanyExample;
import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.company.ZyhCompanyPositionExample;
import com.zyh.entity.company.ZyhCompanyPositionExample.Criteria;
import com.zyh.entity.company.ZyhCompanyTrain;
import com.zyh.entity.company.ZyhCompanyTrainExample;
import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.company.ICompanyPositionService;
import com.zyh.service.company.ICompanyService;
import com.zyh.service.company.ICompanyTrainService;
import com.zyh.service.user.IUserPostService;
import com.zyh.service.usercollect.IUserCollectService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private Logger log = Logger.getLogger("error");

	@Autowired
	private ICompanyService companyService;

	@Autowired
	private ICompanyPositionService companyPositionService;

	@Autowired
	private ICompanyTrainService companyTrainService;
	
	@Autowired
	private IUserPostService userPostServiceImpl;
	
	@Autowired
	private IUserCollectService userCollectService;

	@RequestMapping("/addCompany.act")
	public ResponeToWeb addCompany(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompany zyhCompany = om.readValue(json, ZyhCompany.class);
			companyService.addCompany(zyhCompany);
			responeToWeb.setMsg("添加成功");
			responeToWeb.setSuccess(true);
		} catch (Exception e) {
			log.error("添加失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/updateCompany.act")
	public ResponeToWeb updateCompany(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompany zyhCompany = om.readValue(json, ZyhCompany.class);
			if (null != zyhCompany.getId() && !"".equals(zyhCompany.getId())) {
				companyService.updateCompanyById(zyhCompany);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("修改失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/delCompany.act")
	public ResponeToWeb delCompany(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = om.readTree(json).get("id").asText();
			if (null != id && !"".equals(id)) {
				//查询公司下面 是否有职位或培训
				ZyhCompanyPositionExample zyhCompanyPositionExample = new ZyhCompanyPositionExample();
				Criteria criteria = zyhCompanyPositionExample.createCriteria();
				criteria.andCompanyidEqualTo(id);
				List<ZyhCompanyPosition> list = companyPositionService.selectCompanyPositionByExample(zyhCompanyPositionExample);
				if (null!=list&&list.size()>0) {
					log.error("删除失败：公司提供职位不为空" );
					responeToWeb.setMsg(UserCom.ERROR_POSITIONNOTNULL);
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				ZyhCompanyTrainExample zyhCompanyTrainExample = new ZyhCompanyTrainExample();
				com.zyh.entity.company.ZyhCompanyTrainExample.Criteria criteria2 = zyhCompanyTrainExample.createCriteria();
				criteria2.andCompanyidEqualTo(id);
				List<ZyhCompanyTrain> list2 = companyTrainService.selectCompanyTrainByExample(zyhCompanyTrainExample);
				if (null!=list2&&list2.size()>0) {
					log.error("删除失败：公司提供培训不为空" );
					responeToWeb.setMsg(UserCom.ERROR_TRAINNOTNULL);
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				companyService.delCompanyById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("删除失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/addPosition.act")
	public ResponeToWeb addPosition(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompanyPosition zyhCompanyPosition = om.readValue(json, ZyhCompanyPosition.class);
			Date date = new Date();
			zyhCompanyPosition.setOptime(date);
			companyPositionService.addCompanyPosition(zyhCompanyPosition);
			responeToWeb.setMsg("添加成功");
			responeToWeb.setSuccess(true);
		} catch (Exception e) {
			log.error("添加失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/updatePosition.act")
	public ResponeToWeb updatePosition(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompanyPosition zyhCompanyPosition = om.readValue(json, ZyhCompanyPosition.class);
			if (null != zyhCompanyPosition.getId() && !"".equals(zyhCompanyPosition.getId())) {
				companyPositionService.updateCompanyPositionById(zyhCompanyPosition);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("修改失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/delPosition.act")
	public ResponeToWeb delPosition(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			String id = om.readTree(json).get("id").asText();
			if (null != id && !"".equals(id)) {
				companyPositionService.delCompanyPositionById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("删除失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/queryPosition.act")
	public ResponeToWeb queryPositionByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		List<ZyhCompanyPosition> zyhCompanyPositions = new ArrayList<ZyhCompanyPosition>();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PositionQueryVO positionQueryVO = om.readValue(json, PositionQueryVO.class);
			ZyhCompanyPositionExample zyhCompanyPositionExample = new ZyhCompanyPositionExample();
			Criteria criteria = zyhCompanyPositionExample.createCriteria();
			if (null != positionQueryVO.getId() && !"".equals(positionQueryVO.getId())) {
				criteria.andIdEqualTo(positionQueryVO.getId());
			} else {
				if (null != positionQueryVO.getCompanyid() && !"".equals(positionQueryVO.getCompanyid())) {
					criteria.andCompanyidEqualTo(positionQueryVO.getCompanyid());
				}
				if (null != positionQueryVO.getCompanyName() && !"".equals(positionQueryVO.getCompanyName())) {
					criteria.andCompnaynameLike("%" + positionQueryVO.getCompanyName() + "%");
				}
				if (null != positionQueryVO.getWorkcity() && !"".equals(positionQueryVO.getWorkcity())) {
					criteria.andWorkcityEqualTo(positionQueryVO.getWorkcity());
				}
				if (0 != positionQueryVO.getMinmoney()) {
					criteria.andMinmoneyGreaterThanOrEqualTo(positionQueryVO.getMinmoney());
				}
				if (0 != positionQueryVO.getMaxmoney()) {
					criteria.andMaxmoneyLessThanOrEqualTo(positionQueryVO.getMaxmoney());
				}
				if (null != positionQueryVO.getPostionName() && !"".equals(positionQueryVO.getPostionName())) {
					criteria.andPositionnameLike("%" + positionQueryVO.getPostionName() + "%");
				}
			}

			map = companyPositionService.selectCompanyPositionByPage(zyhCompanyPositionExample,
					positionQueryVO.getPageNum(), positionQueryVO.getPageSize());
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/addTrain.act")
	public ResponeToWeb addTrain(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompanyTrain zyhCompanyTrain = om.readValue(json, ZyhCompanyTrain.class);
			Date date = new Date();
			zyhCompanyTrain.setCreatetime(date);
			companyTrainService.addCompanyTrain(zyhCompanyTrain);
			responeToWeb.setMsg("添加成功");
			responeToWeb.setSuccess(true);
		} catch (Exception e) {
			log.error("添加失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/updateTrain.act")
	public ResponeToWeb updateTrain(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhCompanyTrain zyhCompanyTrain = om.readValue(json, ZyhCompanyTrain.class);
			if (null != zyhCompanyTrain.getId() && !"".equals(zyhCompanyTrain.getId())) {
				companyTrainService.updateCompanyTrainById(zyhCompanyTrain);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("修改失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/delTrain.act")
	public ResponeToWeb delTrain(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			String id = om.readTree(json).get("id").asText();
			if (null != id && !"".equals(id)) {
				companyTrainService.delCompanyTrainById(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("删除失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/queryCompany.act")
	public ResponeToWeb queryCompany(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			ZyhCompany zyhCompany = om.readValue(json, ZyhCompany.class);
			ZyhCompanyExample zyhCompanyExample = new ZyhCompanyExample();
			com.zyh.entity.company.ZyhCompanyExample.Criteria criteria = zyhCompanyExample.createCriteria();
			if (null != zyhCompany.getId() && !"".equals(zyhCompany.getId())) {
				criteria.andIdEqualTo(zyhCompany.getId());
			}
			if (null != zyhCompany.getName() && !"".equals(zyhCompany.getName())) {
				criteria.andNameLike("%" + zyhCompany.getName() + "%");
			}
			if (null !=zyhCompany.getType()&&!"".equals(zyhCompany.getType())) {
				if ("0".equals(zyhCompany.getType())) {
					//招聘企业
					criteria.andLabelIsNotNull();
					criteria.andLabelNotEqualTo("");
				}else if ("1".equals(zyhCompany.getType())) {
					//培训企业
					criteria.andTrainlabelIsNotNull();
					criteria.andTrainlabelNotEqualTo("");
				}
			}
			List<ZyhCompany> list = companyService.selectCompanyByExample(zyhCompanyExample);
			map.put("result", list);
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

	@RequestMapping("/queryCompanyByPage.act")
	public ResponeToWeb queryCompanyByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			CompanyQueryVO zyhCompany = om.readValue(json, CompanyQueryVO.class);
			ZyhCompanyExample zyhCompanyExample = new ZyhCompanyExample();
			com.zyh.entity.company.ZyhCompanyExample.Criteria criteria = zyhCompanyExample.createCriteria();
			if (null != zyhCompany.getId() && !"".equals(zyhCompany.getId())) {
				criteria.andIdEqualTo(zyhCompany.getId());
			}
			if (null != zyhCompany.getName() && !"".equals(zyhCompany.getName())) {
				criteria.andNameLike("%" + zyhCompany.getName() + "%");
			}
			if (null !=zyhCompany.getType()&&!"".equals(zyhCompany.getType())) {
				if ("0".equals(zyhCompany.getType())) {
					//招聘企业
					criteria.andLabelIsNotNull();
					criteria.andLabelNotEqualTo("");
				}else if ("1".equals(zyhCompany.getType())) {
					//培训企业
					criteria.andTrainlabelIsNotNull();
					criteria.andTrainlabelNotEqualTo("");
				}
			}
			map = companyService.selectCompanyByExamPage(zyhCompanyExample, zyhCompany.getPageNum(),
					zyhCompany.getPages());
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

	@RequestMapping("/queryTrainByPage.act")
	public ResponeToWeb queryCompanyTrainByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			TrainQueryVO zyhCompanyTrain = om.readValue(json, TrainQueryVO.class);
			ZyhCompanyTrainExample zyhCompanyTrainExample = new ZyhCompanyTrainExample();
			com.zyh.entity.company.ZyhCompanyTrainExample.Criteria criteria = zyhCompanyTrainExample.createCriteria();
			if (null!=zyhCompanyTrain.getId()&&!"".equals(zyhCompanyTrain.getId())) {
				criteria.andIdEqualTo(zyhCompanyTrain.getId());
			}
			if (null!=zyhCompanyTrain.getName()&&!"".equals(zyhCompanyTrain.getName())) {
				criteria.andNameLike("%"+zyhCompanyTrain.getName()+"%");
			}
			if (null!=zyhCompanyTrain.getState()&&!"".equals(zyhCompanyTrain.getState())) {
				criteria.andStateEqualTo(zyhCompanyTrain.getState());
			}
			if (null!=zyhCompanyTrain.getCompanyid()&&!"".equals(zyhCompanyTrain.getCompanyid())) {
				criteria.andCompanyidEqualTo(zyhCompanyTrain.getCompanyid());
			}
			map = companyTrainService.selectCompanyTrainByPage(zyhCompanyTrainExample, zyhCompanyTrain.getPageNum(), zyhCompanyTrain.getPageSize());
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
	
	@RequestMapping("/queryPositionInfo.act")
	public ResponeToWeb queryPositionInfoById(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		String userid =null ;
		try {
			String positionid = om.readTree(json).get("id").asText();
			if (null!=om.readTree(json).get("userid")) {
				 userid = om.readTree(json).get("userid").asText();
			}
			if (null!=positionid&&!"".equals(positionid)) {
				CompanyPositionVO companyPositionVO = companyPositionService.selectCompanyPositionInfo(positionid);
				if (null!=userid&&!"".equals(userid)) {
				//查询该用户是否投递了职位
					ZyhUserPositionExample zyhUserPositionExample = new ZyhUserPositionExample();
					com.zyh.entity.user.ZyhUserPositionExample.Criteria criteria =zyhUserPositionExample.createCriteria();
					criteria.andUseridEqualTo(userid);
					criteria.andPositionidEqualTo(positionid);
					List<ZyhUserPosition> list = userPostServiceImpl.queryPostByExm(zyhUserPositionExample);
					if (null!=list&&list.size()>0) {
						companyPositionVO.setIfpost("1");
					}else{
						companyPositionVO.setIfpost("0");
					}
				}
				responeToWeb.setSuccess(true);
				map.put("result", companyPositionVO);
				responeToWeb.setValue(map);
			}else{
				responeToWeb.setMsg(UserCom.ERROR_IDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("查询失败"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/findCompanyById.act")
	public ResponeToWeb findCompanyById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CompanyQueryVO queryvo = om.readValue(json, CompanyQueryVO.class);
			if (null != queryvo.getId() && !"".equals(queryvo.getId())) {
				ZyhCompany company = companyService.selectByPrimaryKey(queryvo.getId());
				if(null == company ){
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
				}else{
					map.put("result", company);
					if(null != queryvo.getUserid() && !"".equals(queryvo.getUserid())){
						ZyhUserCollectExample example = new ZyhUserCollectExample();
						com.zyh.entity.usercollect.ZyhUserCollectExample.Criteria criteria = example.createCriteria();
						criteria.andArticleidEqualTo(queryvo.getId());
						criteria.andUseridEqualTo(queryvo.getUserid());
						List<ZyhUserCollect> collected = userCollectService.findUserCollectList(example);
						if(null!=collected && collected.size()>0){
							map.put("ifcollect", "1");
						}else{
							map.put("ifcollect", "0");
						}
					}
					responeToWeb.setMsg("查询成功");
					responeToWeb.setSuccess(true);
					responeToWeb.setValue(map);
				}
			} else {
				responeToWeb.setMsg("查询失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/firstPageQuery.act")
	public ResponeToWeb firstPageQuery(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		List<FirstQueryVO> list = new ArrayList<>();
		try {
			String content = om.readTree(json).get("content").asText();
			if (null!=content&&!"".equals(content)) {
				list = companyService.selectFirstQuery(content);
				map.put("result", list);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			}else{
				log.error("查询失败：" +UserCom.ERROR_CONTENTNULL);
				responeToWeb.setMsg(UserCom.ERROR_CONTENTNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}