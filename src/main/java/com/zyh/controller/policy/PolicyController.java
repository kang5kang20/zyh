package com.zyh.controller.policy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;
import com.zyh.entity.policy.ZyhPolicyExample.Criteria;
import com.zyh.service.policy.IPolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IPolicyService policyService;  
	
	@RequestMapping("/findPolicyById.act")
	public ResponeToWeb findPolicyById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String policyid =  node.get("policyid").asText();
			if (null != policyid && !"".equals(policyid)) {
				ZyhPolicy policy = policyService.queryPolicyById(policyid);
				if(null == policy ){
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
				}else{
					map.put("result", policy);
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
	
	
	@RequestMapping("/findPolicyList.act")
	public ResponeToWeb findPolicyList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			String title ="";
			if(null!=json && !"".equals(json)){
				JsonNode node = om.readTree(json);
				if(null!=node.get("title") && !"".equals(node.get("title"))){
					title =  node.get("title").asText();
				}
			}
			ZyhPolicyExample zyhPolicyExample = new ZyhPolicyExample();
			zyhPolicyExample.setOrderByClause("pubtime desc");
			Criteria criteria = zyhPolicyExample.createCriteria();
			criteria.andIfgroundEqualTo("1");
			if(null!=title || "" !=title){
				criteria.andTitleLike("%"+title+"%");
			}
			List<ZyhPolicy> policylist = policyService.findPolicyList(zyhPolicyExample);
			map.put("result", policylist);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addPolicy.do")
	public ResponeToWeb addPolicy(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhPolicy policy = om.readValue(json, ZyhPolicy.class);
			if (null != policy) {
				policy.setPubtime(new Date());
				policyService.addPolicy(policy);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("新增失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("新增失败：" + e.getMessage());
			responeToWeb.setMsg("新增失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updatePolicy.do")
	public ResponeToWeb updatePolicy(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhPolicy policy = om.readValue(json, ZyhPolicy.class);
			if (null != policy && null!=policy.getId() && !"".equals(policy.getId())) {
				policyService.updatePolicy(policy);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("修改失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("修改失败：" + e.getMessage());
			responeToWeb.setMsg("修改失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	
	@RequestMapping("/deletePolicy.do")
	public ResponeToWeb deletePolicy(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				policyService.deletePolicy(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("删除失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("删除失败：" + e.getMessage());
			responeToWeb.setMsg("删除失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
}
