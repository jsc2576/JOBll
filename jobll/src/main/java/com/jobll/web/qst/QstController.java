package com.jobll.web.qst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/qst")
public class QstController {

	@Autowired
	QstService qstService;
	
	@RequestMapping("")
	public String QnAgo(@ModelAttribute Qst entity){
		return "qst/qstView";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.POST)
	@ResponseBody
	public List<Qst> QstList(@ModelAttribute Qst entity){
		return qstService.findQstList(entity);
	}
	
	@RequestMapping(value="/read/cnt", method=RequestMethod.POST)
	@ResponseBody
	public Integer QstListCnt(@ModelAttribute Qst entity){
		return qstService.findQstListCnt(entity);
	}
}
