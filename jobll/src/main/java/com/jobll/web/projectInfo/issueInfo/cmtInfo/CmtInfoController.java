package com.jobll.web.projectInfo.issueInfo.cmtInfo;

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
@RequestMapping(value="/cmt")
public class CmtInfoController {

	@Autowired
	private CmtInfoService cmtInfoService;


	@RequestMapping(value = "/reg", method= RequestMethod.POST)
	@ResponseBody
	public List<CmtInfo> CommentCreate(@ModelAttribute CmtInfo entity) throws Exception{
		if(entity.getCmt_conts() != "")
		cmtInfoService.create(entity);
		
		List<CmtInfo> cmt_list = cmtInfoService.findAll(entity);
		
		return cmt_list;
	}
	@RequestMapping(value = "/del/send", method= RequestMethod.POST)
	@ResponseBody
	public int CommentDelete(@ModelAttribute CmtInfo entity) throws Exception{

		int result = cmtInfoService.delete(entity);
		
		return result;
	}
	@RequestMapping(value = "/mdf/send", method= RequestMethod.POST)
	@ResponseBody
	public int CommentModify(@ModelAttribute CmtInfo entity) throws Exception{

		int result = cmtInfoService.update(entity);
		
		return result;
	}
	@RequestMapping(value = "/defaultCmtInfoModelAndView", method= RequestMethod.POST)
	@ResponseBody
	public ModelAndView DefaultCmtInfoModelAndView(@ModelAttribute CmtInfo entity) throws Exception{
		ModelAndView mav = new ModelAndView("default");
		return mav;
	}
}