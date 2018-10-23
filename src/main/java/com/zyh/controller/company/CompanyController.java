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
import com.zyh.controller.company.vo.CompanyQueryVO;
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
import com.zyh.service.company.ICompanyPositionService;
import com.zyh.service.company.ICompanyService;
import com.zyh.service.company.ICompanyTrainService;

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
			String id = om.readTree("id").asText();
			if (null != id && !"".equals(id)) {
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
			String id = om.readTree("id").asText();
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
				if (null != positionQueryVO.getCompanyId() && !"".equals(positionQueryVO.getCompanyId())) {
					criteria.andCompanyidEqualTo(positionQueryVO.getCompanyId());
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
			String id = om.readTree("id").asText();
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
	public ResponeToWeb queryCompanyTrain(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			TrainQueryVO zyhCompanyTrain = om.readValue(json, TrainQueryVO.class);
			ZyhCompanyTrainExample zyhCompanyTrainExample = new ZyhCompanyTrainExample();
			com.zyh.entity.company.ZyhCompanyTrainExample.Criteria criteria = zyhCompanyTrainExample.createCriteria();
			if (null!=zyhCompanyTrain.getId()&&"".equals(zyhCompanyTrain.getId())) {
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
}