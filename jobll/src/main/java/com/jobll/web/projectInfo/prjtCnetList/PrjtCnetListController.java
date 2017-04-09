package com.jobll.web.projectInfo.prjtCnetList;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.projectInfo.ProjectInfoService;
import com.jobll.web.usrinfo.UsrInfo;



@Controller
public class PrjtCnetListController {
	Logger log=Logger.getLogger(this.getClass());
 
	@Autowired
	private PrjtCnetListService prjtCnetListService;
	@Autowired
	private ProjectInfoService projectInfoService;
	
	//팀원 리스트를 읽어와 반환
	@RequestMapping(value = "/prjtCnetList/run", method = RequestMethod.POST)
	@ResponseBody
	public List<PrjtCnetList> prjtCnetInfo(@ModelAttribute PrjtCnetList entity, BindingResult errors) throws Exception {
		
		List<PrjtCnetList> list = prjtCnetListService.selectPrjtCnetList(entity);

		return list;
	}
	

	//팀원 초대를 위한 회원 리스트 목록 반환
	@RequestMapping(value = "/prjtCnetList/CnetList.json", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> CnetList (){
		
		List<UsrInfo> list = prjtCnetListService.selectCnetList();
		return list;
	}
	
	//팀원  초대 제외 사항 저장
	@RequestMapping(value = "/teamPerson/inv.json", method = RequestMethod.POST)
	@ResponseBody
	public List<PrjtCnetList>  prjtCnetInfoInv (@RequestParam(value="prjtCnetInvList[]") List<String> prjtCnetInvList,
			@RequestParam(value="prjt_idx") Integer prjt_idx){
		//전체 삭제
		prjtCnetListService.deletePrjtCnetList(prjt_idx);
		
		//usr_id로 usr_cmpny의 값을 불러와서 list에 usr_id와 usr_cmpny 저장
		List<UsrInfo> list= prjtCnetListService.findCmpnyIdx(prjtCnetInvList);
		
		//prjt_idx값과 list의 usr_id, usr_cmpny 값을 사용하여 insert
		List<PrjtCnetList> prjt_list = prjtCnetListService.createPrjtCnetList(list, prjt_idx);
		
		return prjt_list;
	}
	
	//팀원 리스트 화면 출력
		@RequestMapping(value="/teamPerson/check")
	public ModelAndView PrjtCnetListGo (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/prjtCnetList/prjtCnetList/prjtCnetListView");
		entity = projectInfoService.findOne(entity);
		mav.addObject("entity", entity);
		
		return mav;
	}
	
	//팀원 초대 및 제외 화면 출력
	@RequestMapping("/teamPerson/inv")
	public ModelAndView prjtCnetListModifyGo (@ModelAttribute ProjectInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/prjtCnetList/prjtCnetListModify/prjtCnetListModifyView");
		entity = projectInfoService.findOne(entity);
		mav.addObject("entity", entity);
		
		return mav;
	}

	
	
}