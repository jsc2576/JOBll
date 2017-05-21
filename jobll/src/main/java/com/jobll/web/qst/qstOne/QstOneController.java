package com.jobll.web.qst.qstOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qstOne")
public class QstOneController {

	@Autowired
	QstOneService qstOneService;
	
	@RequestMapping(value="")
	public ModelAndView QstOneView(@ModelAttribute QstOne entity){
		ModelAndView mav = new ModelAndView("qst/qstOne/qstView");
		
		QstOne qst = qstOneService.findQstOne(entity);
		mav.addObject("qst", qst);
		
		return mav;
	}
}
