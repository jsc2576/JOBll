package com.jobll.web.atclInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AtclInfoController {

	@Autowired
	private AtclInfoService atclInfoService;
	
	
	/**
	 * 이슈 등록
	**/
	@RequestMapping("/editor")
	public String editor(Locale locale, Model model) {

		return "editor/editor";
	}
	@RequestMapping(value = "/atcl/testAtclRun", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView AtclCreate (@ModelAttribute AtclInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("home");
		
		atclInfoService.createAtcl(entity);
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/atcl/all")
	@ResponseBody
	public List<AtclInfo> AtclAll(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findAll(entity);
		return atcl_list;
	}
	
	@RequestMapping("/atcl/rcv/wait")
	public String AtclRcvWait(){
		return "AtclRcvWait";
	}
	
	@RequestMapping("/atcl/rcv/cmpt")
	public String AtclRcvCmpt(){
		return "AtclRcvWait";
	}
	
	@RequestMapping("/atcl/prcs/wait")
	public String AtclPrcsWait(){
		return "AtclPrcsWait";
	}
	
	@RequestMapping("/atcl/prcs/cmpt")
	public String AtclPrcsCmpt(){
		return "AtclPrcsCmpt";
	}
}
