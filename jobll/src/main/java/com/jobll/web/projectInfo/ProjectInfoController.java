package com.jobll.web.projectInfo;

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
@RequestMapping(value="/projectInfo")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoService projectInfoService;
	
	/**
	 * 프로젝트 리스트로 이동합니다.
	 */
	@RequestMapping("/projectInfoList/go")
	public String ProjectInfoListGo(){
		return "projectInfo/projectInfoList/projectInfoListView";
	}
	/**
	 * 프로젝트 생성 페이지로 이동합니다.
	 */
	@RequestMapping("/projectInfoCreate/go")
	public String ProjectInfoCreateGo(){
		return "projectInfo/projectInfoCreate/projectInfoCreateView";
	}
	/**
	 * 프로젝트를 생성하는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 받아옵니다.
	 * @return
	 */
	@RequestMapping(value = "/projectInfoCreate", method= RequestMethod.POST)
	public ModelAndView ProjectInfoCreate (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/projectInfoList/projectInfoListView");
		
		projectInfoService.create(entity);
		
		return mav;
	}
	
	/**
	 * 프로젝트 리스트를 불러오는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 불러옵니다.
	 * @return
	 */
	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> ProjectInfolistRun(@ModelAttribute ProjectInfo entity) throws Exception{
		List<ProjectInfo> project_list = projectInfoService.findList(entity);
		
		return project_list;
	}
	///
	/**
	 * 프로젝트 정보 불러오는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 불러옵니다.
	 * @return
	 */
	@RequestMapping(value = "/prjt/check/read", method= RequestMethod.POST)
	public ModelAndView ProjectInfoView (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/projectInfoView");
		
		entity = projectInfoService.findOne(entity);
		
		mav.addObject("entity", entity);
		
		return mav;
	}
}
