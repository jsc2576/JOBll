package com.jobll.web.projectInfo.projectSupply;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.admin.AdminService;
import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.attchfile.AttchFileService;
import com.jobll.web.cmpnyinfo.CmpnyInfoService;
import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.projectInfo.ProjectInfoService;
import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoService;

@Controller
@RequestMapping(value="/projectSupply")
public class ProjectSupplyController {

	@Autowired
	private ProjectSupplyService projectSupplyService;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CmpnyInfoService cmpnyInfoService;
	@Autowired
	private UsrInfoService usrInfoService;
	@Autowired
	private ProjectInfoService projectInfoService;

	@RequestMapping("/projectSupplyList/go")
	public ModelAndView projectSupplyListGo (@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/projectInfo/projectSupply/projectSupplyList/projectSupplyListView");
		
		mav.addObject("entity", entity);
		
		return mav;
	}
	
	@RequestMapping("/projectSupplyWrite/go")
	public ModelAndView projectSupplyWriteGo(@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/projectInfo/projectSupply/projectSupplyWrite/projectSupplyWriteView");
		
		mav.addObject("entity", entity);
		
		return mav;
	}
	
	@RequestMapping(value = "/projectSupplyWrite", method = RequestMethod.POST)
	public ModelAndView projectSupplyServiceWrite (@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/projectInfo/projectSupply/projectSupplyList/projectSupplyListView");
		
		projectSupplyService.create(entity);
		mav.addObject("entity", entity);
		
		return mav;
	}
	@RequestMapping(value = "/prjt/read", method = RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> ProjectInfolistRun(@ModelAttribute ProjectInfo entity) throws Exception{
		List<ProjectInfo> List = projectSupplyService.readPrjtSbjtByUsrId(entity);
		
		return List;
	}
	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<ProjectSupply> projectSupplylistRun(@ModelAttribute ProjectSupply entity) throws Exception{
		List<ProjectSupply> list = projectSupplyService.findAll(entity);
		return list;
	}
	
	@RequestMapping(value = "/readOne", method= RequestMethod.POST)
	public ModelAndView projectSupplyView (@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/projectInfo/projectSupply/projectSupplyView");
		entity = projectSupplyService.findOne(entity);		
		mav.addObject("entity", entity);
		return mav;
	}
}
