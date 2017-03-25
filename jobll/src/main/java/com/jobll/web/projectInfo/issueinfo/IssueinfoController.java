package com.jobll.web.projectInfo.issueinfo;

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
import com.jobll.web.projectInfo.ProjectInfo;



@Controller
@RequestMapping(value="/issue")
public class IssueinfoController {

	@Autowired
	private IssueinfoService issueInfoService;
	@Autowired
	private AttchFileService attchFileService;
	
	
	/**
	 * 이슈페이지 이동 통신입니다.
	 * @param entity IssueInfo객체 리스트로 값을 받아옵니다.
	 * @return
	 */
	@RequestMapping(value = "/view", method= RequestMethod.POST)
	public ModelAndView issueView (@ModelAttribute IssueInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/atclInfo/atclInfoList/atclInfoListView");
		mav.addObject("entity", entity);
		
		return mav;
	}
		
	/**
	 * 게시판(이슈) 검색 통신 입니다.
	 * @param entity IssueInfo객체로 프로젝트 인댁스를 받습니다.
	 * @return entity IssueInfo객체 리스트로 보내줍니다.
	**/
	@RequestMapping(value = "/search/read", method = RequestMethod.POST)
	@ResponseBody
	public List<IssueInfo> isssueView(@ModelAttribute IssueInfo entity, BindingResult errors) throws Exception {
		
		List<IssueInfo> issue_list = issueInfoService.findList(entity);
		
		return issue_list;
	}
	
	/**
	 * 게시판(이슈) 조회 통신입니다.
	 * @param entity IssueInfo객체로 프로젝트 인댁스를 받습니다.
	 * @return IssueInfo객체로 보내줍니다.
	 */
	@RequestMapping(value = "/check/read")
	public ModelAndView IssueInfoInforead (@ModelAttribute IssueInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("projectInfo/atclInfo/atclInfoView");
		
		entity = issueInfoService.findOne(entity);
		
		AttchFile find_idx = new AttchFile();
		
		find_idx.setAtcl_idx(entity.getAtcl_idx());
		
		List<AttchFile> list = new ArrayList<AttchFile>();
		
		list = attchFileService.readByIdx(find_idx);
		
		mav.addObject("entity", entity);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * 게시판(이슈) 쓰기 페이지로 맵핑해 줍니다.
	**/
	@RequestMapping("/reg")
	public String atclInfoWriteGo(Locale locale, Model model) {

		return "projectInfo/atclInfo/atclInfoWrite/atclInfoWriteView";
	}
}
