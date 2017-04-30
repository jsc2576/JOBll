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
@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;


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
}