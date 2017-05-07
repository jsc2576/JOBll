package com.jobll.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.cmpnyinfo.*;
import com.jobll.web.usrinfo.*;
@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CmpnyInfoService cmpnyInfoService;
	@Autowired
	private UsrInfoService usrInfoService;

	/**
	 * 프로젝트 생성 페이지로 이동합니다.
	 */
	@RequestMapping("/home")
	public String AdminHomeGo(){
		
		int auth_check = adminService.AuthCheck();
		
		if(auth_check == 1)
			return "admin/adminHomeView";
		else
			return "error/permissionDenied";
	
	}
	
	@RequestMapping("/usrAuth/cnfg")
	public String AdminAuthConfigGo(){
			return "admin/authCnfg/authCnfgView";
	}
	
	@RequestMapping(value = "/GetCmpnyList", method= RequestMethod.POST)
	@ResponseBody
	public List<CmpnyInfo> GetCmpnyList(@ModelAttribute CmpnyInfo entity) throws Exception{
		List<CmpnyInfo> cmpny_list = cmpnyInfoService.findAll(entity);
		
		return cmpny_list;
	}
	/*@RequestMapping(value = "/GetCmpnyUsrInfo", method= RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> GetCmpnyUsrInfo(@ModelAttribute UsrInfo entity) throws Exception{
		List<UsrInfo> user_list = usrInfoService.selectUserToCmpny(entity);
		
		return user_list;
	}
	@RequestMapping(value = "/GetChangeUsrAuth", method= RequestMethod.POST)
	@ResponseBody
	public int GetChangeUsrAuth(@ModelAttribute UsrInfo entity) throws Exception{
		int result = usrInfoService.updateToLv(entity);
		
		return result;
	}*/
}