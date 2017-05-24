package com.jobll.web.qstList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.projectInfo.projectSupply.ProjectSupply;

@Controller
@RequestMapping(value="/qstList")
public class QstListController {

	@Autowired
	private QstListService qstListService;
	
	@RequestMapping("/go")
	public ModelAndView qstListGo (@ModelAttribute QstList entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstList/qstListView");
		
		return mav;
	}
	
	@RequestMapping("/write")
	public ModelAndView qstListWriteGo(@ModelAttribute QstList entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstWrite/qstWriteView");
		
		return mav;
	}
	
	@RequestMapping(value = "/qstListWrite", method = RequestMethod.POST)
	public ModelAndView qstListServiceWrite (@ModelAttribute QstList entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstWrite/qstWriteView");
		
		qstListService.create(entity);
		
		return mav;
	}
	@RequestMapping(value = "/readOne", method = RequestMethod.POST)
	public ModelAndView readOne (@ModelAttribute QstList entity) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstView");
		
		entity  = qstListService.findOne(entity);
		
		mav.addObject("entity", entity);
		
		return mav;
	}
	
	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<QstList> QstListgo(@ModelAttribute QstList entity)throws Exception{
		List<QstList> list = qstListService.findAll(entity);
		return list;
	}
	
	@RequestMapping(value = "/GetMyQstList", method= RequestMethod.POST)
	@ResponseBody
	public List<QstList> GetMyQstList(@ModelAttribute QstList entity)throws Exception{
		List<QstList> list = qstListService.findMyQst(entity);
		return list;
	}
	
	@RequestMapping(value="/read", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView qstListView(@ModelAttribute QstList entity)throws Exception{
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstReq/qstReqView");
		entity = qstListService.findOne(entity);
		mav.addObject("entity", entity);
		return mav;
	}
	@RequestMapping(value="/req", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView qstListReq(@ModelAttribute QstList entity)throws Exception{
		ModelAndView mav = new ModelAndView("dev/pages/qst/qstList/qstListView");
		int result = qstListService.update(entity);
		return mav;
	}
}
