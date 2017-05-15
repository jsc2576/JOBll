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
import com.jobll.web.projectInfo.*;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CmpnyInfoService cmpnyInfoService;
	@Autowired
	private UsrInfoService usrInfoService;
	@Autowired
	private ProjectInfoService projectInfoService;

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
	
	/**
	 * 회원목록 리스트 페이지로 이동합니다.(추후 사이트 관리자 계정에서만 보이게 할 것)
	**/
	@RequestMapping("/usrInfo/cnfg")
	public String AdminusrInfoCnfgGo(){
		return "admin/usrInfoCnfg/usrInfoCnfgView";
	}
	@RequestMapping("/prjt/create/go")
	public String AdminPrjtCreateGo(){
		return "admin/PrjtCreate/PrjtCreateView";
	}
	
	@RequestMapping("/usrAuth/cnfg")
	public String AdminAuthConfigGo(){
			return "admin/authCnfg/authCnfgView";
	}
	
	@RequestMapping("/cmpnyInfo/cnfg")
	public String AdminCmpnyConfigGo(){
			return "admin/cmpnyCnfg/cmpnyCnfgView";
	}
	
	@RequestMapping(value = "/GetCmpnyList", method= RequestMethod.POST)
	@ResponseBody
	public List<CmpnyInfo> GetCmpnyList(@ModelAttribute CmpnyInfo entity) throws Exception{
		List<CmpnyInfo> cmpny_list = cmpnyInfoService.findAll(entity);
		
		return cmpny_list;
	}
	@RequestMapping(value = "/GetCmpnyUsrInfo", method= RequestMethod.POST)
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
	}
	@RequestMapping(value = "/GetCmpnyPrjtList", method= RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> ProjectInfolistRun(@ModelAttribute ProjectInfo entity) throws Exception{
		List<ProjectInfo> project_list = projectInfoService.findList(entity);
		
		return project_list;
	}
}