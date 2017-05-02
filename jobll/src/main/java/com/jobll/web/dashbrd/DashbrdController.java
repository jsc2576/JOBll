package com.jobll.web.dashbrd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashbrdController {
	
	@Autowired
	private DashbrdService dashbrdService;
	
	@RequestMapping("/dashboard")
	public String DashbrdGo(){
		return "dashboard/dashboardView";
	}
	
	@RequestMapping("/cuntPrjt/check/read")
	@ResponseBody
	public List<Dashbrd> findCuntPrjtSbjt(@ModelAttribute Dashbrd entity){
 		return dashbrdService.findCuntPrjtSbjt(entity);
	}
	
	@RequestMapping("/cnetPrjt/check/read")
	@ResponseBody
	public List<Dashbrd> findCnetPrjtSbjt(@ModelAttribute Dashbrd entity){
		return dashbrdService.findCentPrjtSbjt(entity);
	}
	
	@RequestMapping("/tot_atcl")
	@ResponseBody
	public Integer TotAtcl(@ModelAttribute Dashbrd entity){
		return dashbrdService.AtclTotCnt(entity);
	}
	
	@RequestMapping("/rmn_atcl")
	@ResponseBody
	public Integer RmnAtcl(@ModelAttribute Dashbrd entity){
		return dashbrdService.AtclRmnCnt(entity);
	}
	
	@RequestMapping("/end_atcl")
	@ResponseBody
	public Integer EndAtcl(@ModelAttribute Dashbrd entity){
		return dashbrdService.AtclEndCnt(entity);
	}
}

