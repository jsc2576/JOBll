package com.jobll.web.qst.qstWrite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qstWrite")
public class QstWriteController {

	@Autowired
	QstWriteService qstWriteService;
	
	@RequestMapping(value="")
	public ModelAndView qstWriteView(@ModelAttribute QstWrite entity){
		ModelAndView mav = new ModelAndView("qst/qstWrite/qstWriteView");
		
		if(entity.getHigh_qst_idx() == 0){
			mav.addObject("high_qst_idx", entity.getQst_idx());	
		}
		else{
			mav.addObject("high_qst_idx", entity.getHigh_qst_idx());
		}
		
		return mav;
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	@ResponseBody
	public int create(@ModelAttribute QstWrite entity){
		return qstWriteService.create(entity);
	}
}
