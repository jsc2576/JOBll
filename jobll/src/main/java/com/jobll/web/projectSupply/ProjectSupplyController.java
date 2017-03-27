package com.jobll.web.projectSupply;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.attchfile.AttchFileService;

@Controller
@RequestMapping(value="/projectSupply")
public class ProjectSupplyController {

	@Autowired
	private ProjectSupplyService projectSupplyService;
	
	@RequestMapping("/projectSupplyList/go")
	public String projectSupplyListGo(){
		return "projectSupply/projectSupplyList/projectSupplyListView";
	}
	
	@RequestMapping("/projectSupplyWrite/go")
	public String projectSupplyWriteGo() {

		return "projectSupply/projectSupplyWrite/projectSupplyWriteView";
	}
	
	@RequestMapping(value = "/projectSupplyWrite", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView projectSupplyServiceWrite (@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("projectSupply/projectSupplyList/projectSupplyListView");
		
		projectSupplyService.create(entity);
		
		return mav;
	}
	
	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<ProjectSupply> projectSupplylistRun(@ModelAttribute ProjectSupply entity) throws Exception{
		List<ProjectSupply> list = projectSupplyService.findAll(entity);
		return list;
	}
	
	@RequestMapping(value = "/readOne", method= RequestMethod.POST)
	public ModelAndView projectSupplyView (@ModelAttribute ProjectSupply entity) throws Exception {
		ModelAndView mav = new ModelAndView("projectSupply/projectSupplyView");
		entity = projectSupplyService.findOne(entity);		
		mav.addObject("entity", entity);
		return mav;
	}
}
