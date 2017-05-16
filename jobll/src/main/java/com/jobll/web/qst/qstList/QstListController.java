package com.jobll.web.qst.qstList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qstList")
public class QstListController {

	@Autowired
	QstListService qstListService;
	
	@RequestMapping("")
	public String QstListgo(@ModelAttribute QstList entity){
		return "qst/qstList/qstView";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.POST)
	@ResponseBody
	public List<QstList> QstList(@ModelAttribute QstList entity){
		return qstListService.findQstList(entity);
	}
	
	@RequestMapping(value="/read/cnt", method=RequestMethod.POST)
	@ResponseBody
	public Integer QstListCnt(@ModelAttribute QstList entity){
		return qstListService.findQstListCnt(entity);
	}
	
	@RequestMapping(value="/read/ans", method=RequestMethod.POST)
	@ResponseBody
	public List<QstList> AnsQstList(@ModelAttribute QstList entity){
		List<QstList> data = qstListService.findAnsQstList(entity); 
		return data;
	}
}
