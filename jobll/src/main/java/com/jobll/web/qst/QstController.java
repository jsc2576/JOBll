package com.jobll.web.qst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QstController {

	@Autowired
	QstService qstService;
	
	@RequestMapping(value="/qst")
	public String QnAgo(@ModelAttribute Qst entity){
		return "qna/qnaView";
	}
	
	@RequestMapping(value="/qst/read", method=RequestMethod.POST)
	@ResponseBody
	public List<Qst> QstList(@ModelAttribute Qst entity){
		return qstService.findQstList(entity);
	}
}
