package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.cmpnyinfo.CmpnyInfo;
import com.jobll.web.projectInfo.ProjectInfo;



@Controller
@RequestMapping(value="/usrInfo")
public class UsrInfoController {
	
	@Autowired
	private UsrInfoService usrInfoService;
	
	@RequestMapping(value = "/usrMdf/send", method = RequestMethod.POST)
	public ModelAndView usrMdfSend(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("homeView");
	
		usrInfoService.edit(entity);
		return mav;
	}
	
	@RequestMapping(value = "/usrMdf")
	public ModelAndView usrMdf() throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/usrMdf/usrMdf");
		//mav.addObject("usr_id", entity.getUsr_id());
		
		UsrInfo entity = new UsrInfo();
		
		entity = usrInfoService.readOne(entity);
		mav.addObject("entity",entity);
		return mav;
	}
	/**
	 * 개인정보 열람
	**/
	@RequestMapping(value = "/MyUsrInfo")
	public ModelAndView myUsrInfoGo(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/myUsrInfo/myUsrInfoView");
		
		mav.addObject("usr_id", entity.getUsr_id());
		//일반적으로 Null이나, 관리자의 특정 유저정보 접근시 열람할 유저의 아이디가 존재
		
		return mav;
	}
	
	/**
	 * 회원목록 리스트 페이지로 이동합니다.(추후 사이트 관리자 계정에서만 보이게 할 것)
	**/
	@RequestMapping("/usrInfoList")
	public String usrInfoListGo(){
		return "usrInfo/usrInfoList/usrInfoListView";
	}
	/**
	 * 회원 가입 페이지로 이동합니다.
	**/
	@RequestMapping("/join")
	public String  usrInfoJoinGo(){
		
		return "usrInfo/usrInfoJoin/usrInfoJoin";
	}
	/**
	 * 회원 가입 통신입니다.
	 * @param entity UsrInfo객체 형식으로 회원 가입 정보를 가지고 있습니다.
	 * @param request 추후 프로필 사진을 업로드 파일로 전송받을 예정입니다.
	 * @return 현재는 홈화면으로 이동합니다.
	**/
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String createUsrInfo (HttpServletRequest request, @ModelAttribute("model_entity") 
		@Validated UsrInfo entity, BindingResult errors) throws Exception {
		usrInfoService.create(entity);
		return "homeView";
	}
	
	/**
	 * 기업 리스트를 읽어와 반환
	 * @return
	 */
	@RequestMapping(value = "/cmpnyList.json", method = RequestMethod.POST)
	@ResponseBody
	public List<CmpnyInfo> CmpnyList (){
		List<CmpnyInfo> list = usrInfoService.selectCmpny();
		return list;
	}
	
	/**
	 * 기업 인덱스를 참조해 특정 기업 하나를 읽어와 반환
	 * @return
	 */
	@RequestMapping(value = "/cmpnyOne", method = RequestMethod.POST)
	@ResponseBody
	public CmpnyInfo CmpnyOne (UsrInfo entity){
		CmpnyInfo list = usrInfoService.selectCmpnyOne(entity);
		return list;
	}
	/**
	 * 유저 아이디를 사용해 유저 정보를 반환
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/myUsrInfo/read", method = RequestMethod.POST)
	@ResponseBody
	public UsrInfo UsrInfo (UsrInfo entity){
		UsrInfo sel = usrInfoService.selectOne(entity);
		CmpnyInfo list = usrInfoService.selectCmpnyOne(entity);
		sel.setUsr_pwd(list.getCmpny_nm());
		return sel;
	}
	
	/**
	 * 모든 유저 정보를 리스트 형식으로 반환
	 * @return
	 */
	@RequestMapping(value = "/allPersonInfo/check/read", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> UsrInfoList() {
		List<UsrInfo> List;
		List= usrInfoService.selectAllUser();
		return List;
		}
	
	@RequestMapping(value = "/prjt/read", method = RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> PrjtInfoList() {
		UsrInfo entity=new UsrInfo();
		List<ProjectInfo> List;
		List= usrInfoService.readPrjtSbjtByUsrId(entity);
		return List;
		}
	//basic instruction :
	
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public List<HashMap<String, Object>> select() {
		List<HashMap<String, Object>> List;
		List= usrInfoService.select();
		
		return List;
		}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<HashMap<String, Object>> read(@ModelAttribute UsrInfo entity, Model model) {
		List<HashMap<String, Object>> List = usrInfoService.read(entity);
		return List;
		}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public void edit(@ModelAttribute UsrInfo entity, Model model) {
		usrInfoService.edit(entity);
		return ;
		}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@ModelAttribute UsrInfo entity, Model model) {
		usrInfoService.delete(entity);
		return ;
		}
}
