package com.jobll.web.atclInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import com.jobll.web.attchfile.AttchFileService;



@Controller
public class AtclInfoController {

	@Autowired
	private AtclInfoService atclInfoService;
	
	@Autowired
	private AttchFileService attchFileService;
	
	@RequestMapping(value = "/editor")
	@ResponseBody
	public ModelAndView AtclView (@ModelAttribute AtclInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("editor/editor");
		
		return mav;
	}
	
	@RequestMapping(value = "/atcl/AtclCreate", method = RequestMethod.POST)
	@ResponseBody
	public AtclInfo AtclCreate (@ModelAttribute AtclInfo entity, BindingResult errors) throws Exception {
		
		atclInfoService.createAtcl(entity);
				
		return entity;
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
