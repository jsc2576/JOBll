package com.jobll.web.hstyInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.projectSupply.ProjectSupply;
@Controller
@RequestMapping(value="/hstyInfo")
public class HstyInfoController {

	@Autowired
	private HstyInfoService hstyInfoService;
	
	@RequestMapping("/hstyInfoList/go")
	public String hstyInfoListGo(){
		return "hstyInfo/hstyInfoView";
	}

	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<HstyInfo> hstyInfolistRun(@ModelAttribute HstyInfo entity) throws Exception{
		List<HstyInfo> list = hstyInfoService.findAll(entity);
		return list;
	}

	@RequestMapping(value = "/readOne", method= RequestMethod.POST)
	public ModelAndView hstyInfoView (@ModelAttribute HstyInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("hstyInfo/hstyInfoView");
		entity = hstyInfoService.findOne(entity);		
		mav.addObject("entity", entity);
		return mav;
	}	
}