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
@RequestMapping("/atcl")
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
	
	

	
	/**
	 * 모든 데이터를 검색 
	 * @return
	 */
	@RequestMapping("/")
	public String atcl(){
		return "atcl/atcl";
	}
	
	
	/**
	 * find all
	 * @param entity
	 * @return
	 */
	@RequestMapping("/all")
	@ResponseBody
	public List<AtclInfo> AtclAll(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findList(entity, 0);
		return atcl_list;
	}
	
	
	/**
	 * find receive wait
	 * @param entity
	 * @return
	 */
	@RequestMapping("/rcv/wait")
	@ResponseBody
	public List<AtclInfo> AtclRcvWait(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findList(entity, 1);
		return atcl_list;
	}
	
	
	/**
	 * find receive complete
	 * @param entity
	 * @return
	 */
	@RequestMapping("/rcv/cmpt")
	@ResponseBody
	public List<AtclInfo> AtclRcvCmpt(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findList(entity, 2);
		return atcl_list;
	}
	
	
	/**
	 * find process wait
	 * @param entity
	 * @return
	 */
	@RequestMapping("/prcs/wait")
	@ResponseBody
	public List<AtclInfo> AtclPrcsWait(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findList(entity, 3);
		return atcl_list;
	}
	
	
	/**
	 * find process complete
	 * @param entity
	 * @return
	 */
	@RequestMapping("/prcs/cmpt")
	@ResponseBody
	public List<AtclInfo> AtclPrcsCmpt(@ModelAttribute AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoService.findList(entity, 4);
		return atcl_list;
	}
}
