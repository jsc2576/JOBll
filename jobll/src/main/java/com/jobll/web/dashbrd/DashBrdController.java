package com.jobll.web.dashbrd;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBrdController {

	DashBrdService dashBrdService;
	
	@RequestMapping("/dashboard")
	public String viewDashboard(){
		return null;
	}
	@RequestMapping("/joinPrjt/check/read")
	public List<String> findPrjtSbjt(@ModelAttribute DashBrd entity){
		
		return dashBrdService.findPrjtSbjt(entity);
	}
}
