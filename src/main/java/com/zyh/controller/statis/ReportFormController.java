package com.zyh.controller.statis;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyh.controller.statis.util.ExcelUtil;
import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeBaseExample;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.service.resume.IResumeBaseService;
import com.zyh.service.resume.impl.ResumeBaseServiceImpl;
import com.zyh.service.user.IUserService;
import com.zyh.utils.DateUtil;

@Controller
@RequestMapping(value = "/report")
public class ReportFormController {

	private Logger log = Logger.getLogger("error");

	@Autowired
	private IUserService userService;

	@Autowired
	private IResumeBaseService resumeBaseService;

	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ZyhResumeBaseExample zyhResumeBase = new ZyhResumeBaseExample();
		List<ZyhResumeBase> list = new ArrayList<>();
		try {
			list = resumeBaseService.selectResumeBaseByExample(zyhResumeBase);
			if (null != list && list.size() > 0) {
				// excel标题
				String[] title = { "姓名", "性别", "年龄", "联系方式", "求职状态", "当兵时间", "部队专业", "部队职位", "政治面貌", "籍贯", "退伍证号",
						"退伍证认证", "身份证号", "身份证认证" };
				// excel文件名
				String fileName = "用户统计" + System.currentTimeMillis() + ".xls";

				String[][] content = null;
				// sheet名
				String sheetName = "用户统计";
				for (int i = 0; i < list.size(); i++) {
					content[i] = new String[title.length];
					ZyhResumeBase resumeBase = list.get(i);
					content[i][0] = resumeBase.getName();
					content[i][1] = resumeBase.getSex();
					if (null != resumeBase.getBirthday()) {
						content[i][2] = DateUtil.getAge(resumeBase.getBirthday())+"";
					}
					content[i][3] = resumeBase.getPhone();
					String workstate = "";
					if ("0".equals(resumeBase.getWorkstate())) {
						workstate = "在职";
					}else if ("1".equals(resumeBase.getWorkstate())) {
						workstate = "离职";
					}else if ("3".equals(resumeBase.getWorkstate())) {
						workstate = "考虑换工作";
					}else {
						workstate = "未知";
					}
					content[i][4] = workstate;
					content[i][5] = resumeBase.getSoldierdate();
					content[i][6] = resumeBase.getBdzy();
					content[i][7] = resumeBase.getBdzw();
					content[i][8] = resumeBase.getZzmm();
					content[i][9] = resumeBase.getBirthcity();
					content[i][10] = resumeBase.getSoldierno();
					String scheckstate = "";
					if ("0".equals(resumeBase.getSoldiercheckstate())) {
						scheckstate = "未认证";
					}else if ("1".equals(resumeBase.getSoldiercheckstate())) {
						scheckstate = "认证通过";
					}else if ("2".equals(resumeBase.getSoldiercheckstate())) {
						scheckstate = "认证失败";
					}else if ("3".equals(resumeBase.getSoldiercheckstate())) {
						scheckstate = "申请认证";
					}else {
						scheckstate = "未认证";
					}
					content[i][11] = scheckstate;
					content[i][12] = resumeBase.getIdno();
					String icheckstate = "";
					if ("0".equals(resumeBase.getIdcheckstate())) {
						icheckstate = "未认证";
					}else if ("1".equals(resumeBase.getIdcheckstate())) {
						icheckstate = "认证通过";
					}else if ("2".equals(resumeBase.getIdcheckstate())) {
						icheckstate = "认证失败";
					}else if ("3".equals(resumeBase.getIdcheckstate())) {
						icheckstate = "申请认证";
					}else {
						icheckstate = "未认证";
					}
					content[i][13] = icheckstate;
				}
				// 创建HSSFWorkbook
				HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
				// 响应到客户端
				this.setResponseHeader(response, fileName);
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
