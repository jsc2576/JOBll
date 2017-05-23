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

import com.jobll.web.usrinfo.*;

@Controller
@RequestMapping(value="/projectInfo")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoService projectInfoService;
	
	@Autowired
	private UsrInfoService usrInfoService;
	/**
	 * 프로젝트 리스트로 이동합니다.
	 */
	@RequestMapping("/projectInfoList/go")
	public String ProjectInfoListGo(){
		return "dev/pages/projectInfo/projectInfoList/projectInfoListView";
	}
	/**
	 * 프로젝트 생성 페이지로 이동합니다.
	 */
	@RequestMapping("/projectInfoCreate/go")
	public String ProjectInfoCreateGo(){
		return "dev/pages/projectInfo/projectInfoCreate/projectInfoCreateView";
	}
	/**
	 * 프로젝트를 생성하는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 받아옵니다.
	 * @return
	 */
	@RequestMapping(value = "/projectInfoCreate", method= RequestMethod.POST)
	public ModelAndView ProjectInfoCreate (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/admin/cmpnyCnfg/cmpnyCnfgView");
		
		projectInfoService.create(entity);
		
		return mav;
	}
	@RequestMapping(value = "/projectInfoDelete", method= RequestMethod.POST)
	public ModelAndView ProjectInfoDelete (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/admin/cmpnyCnfg/cmpnyCnfgView");
		
		projectInfoService.delete(entity);
		
		return mav;
	}
	@RequestMapping(value = "/projectInfoModifyPop", method= RequestMethod.GET)
	public ModelAndView projectInfoModifyPop (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/admin/cmpnyCnfg/projectModifyPop");
		
		entity = projectInfoService.findOne(entity);
		
		UsrInfo usr_nm = new UsrInfo();
		
		usr_nm.setUsr_id(entity.getUsr_id());
		
		usr_nm = usrInfoService.findOne(usr_nm);
		
		mav.addObject("entity", entity);
		mav.addObject("usr_nm", usr_nm);
		
		return mav;
	}
	@RequestMapping(value = "/projectInfoModify", method= RequestMethod.POST)
	public ModelAndView projectInfoModify (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("/popClose");
		
		projectInfoService.modify(entity);
		
		return mav;
	}
	/**
	 * 프로젝트 리스트를 불러오는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 불러옵니다.
	 * @return
	 */
	@RequestMapping(value = "/GetProjectList", method= RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> GetProjectList(@ModelAttribute ProjectInfo entity) throws Exception{
		List<ProjectInfo> list = projectInfoService.findList(entity);
		
		return list;
	}
	///
	/**
	 * 프로젝트 정보 불러오는 통신입니다.
	 * @param entity ProjectInfo객체 리스트로 값을 불러옵니다.
	 * @return
	 */
	@RequestMapping(value = "/prjt/check/read", method= RequestMethod.POST)
	public ModelAndView ProjectInfoView (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("dev/pages/projectInfo/projectInfoView");
		
		entity = projectInfoService.findOne(entity);
		
		mav.addObject("entity", entity);
		
		return mav;
	}
	
	@RequestMapping(value = "/checkAuth", method= RequestMethod.POST)
	@ResponseBody
	public int checkAuth(@ModelAttribute ProjectInfo entity) throws Exception{
		return projectInfoService.checkAuth();
	}
	@RequestMapping(value = "/getUsrIdAndLv", method= RequestMethod.POST)
	@ResponseBody
	public UsrInfo getUsrIdAndLv() throws Exception{
		return projectInfoService.getUsrIdAndLv();
	}
}
