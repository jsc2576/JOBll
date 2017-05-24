package com.jobll.web.hstyInfo;

import java.util.ArrayList;
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
@RequestMapping(value="/allPersonInfo")
public class HstyInfoController {

	@Autowired
	private HstyInfoService hstyInfoService;


	@RequestMapping(value = "/defaultHstyInfoResponseBody", method= RequestMethod.POST)
	@ResponseBody
	public HstyInfo DefaultHstyInfoResponseBody(@ModelAttribute HstyInfo entity) throws Exception{
		return entity;
	}
	@RequestMapping(value = "/defaultHstyInfoModelAndView", method= RequestMethod.POST)
	@ResponseBody
	public ModelAndView DefaultHstyInfoModelAndView(@ModelAttribute HstyInfo entity) throws Exception{
		ModelAndView mav = new ModelAndView("default");
		return mav;
	}
	@RequestMapping(value = "/GetHstyLog", method= RequestMethod.POST)
	@ResponseBody
	public List<HstyInfo> GetHstyLog(@ModelAttribute HstyInfo entity) throws Exception{
		
		List<HstyInfo> list = new ArrayList<HstyInfo>();
		
		list = hstyInfoService.findByPrjt(entity);
		return list;
	}
}