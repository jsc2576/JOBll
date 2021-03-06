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

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.cmpnyinfo.CmpnyInfo;
import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.projectInfo.issueInfo.IssueInfo;



@Controller
@RequestMapping(value="/usrInfo")
public class UsrInfoController {
	@Autowired
	private CommonUtil commonUtil;
	
	
	@Autowired
	private UsrInfoService usrInfoService;
	
	@Autowired
	private SessionUtil sessionUtil;
	
	@RequestMapping("/pagination")
	public String pagination(){
		
		return "pagination";
	}
	

	
	@RequestMapping(value = "/usrDel/send", method = RequestMethod.POST)
	public ModelAndView usrDelSend(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("login.do");
		
		int result;
		result = usrInfoService.delete(entity);
		if(result==1)
			mav.setViewName("homeView");
		else
			mav.setViewName("fail.do");
		return mav;
	}
	
	@RequestMapping(value = "/usrDel")
	public ModelAndView usrDel() throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/usrDel/usrDelView");
		
		mav.addObject("usr_id",sessionUtil.getSessionBean().getUsr_id());
		return mav;
	}
	
	@RequestMapping(value = "/usrMdf/send", method = RequestMethod.POST)
	public ModelAndView usrMdfSend(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("homeView");
	
		usrInfoService.edit(entity);
		return mav;
	}
	
	@RequestMapping(value = "/usrMdf")
	public ModelAndView usrMdf() throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/usrMdf/usrMdfView");
		//mav.addObject("usr_id", entity.getUsr_id());
		
		UsrInfo entity = new UsrInfo();
		
		entity = usrInfoService.readOne(entity);
		mav.addObject("MdfEntity",entity);
		return mav;
	}
	/**
	 * 개인정보 열람
	**/
	@RequestMapping(value = "/MyUsrInfo")
	public ModelAndView myUsrInfoGo(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/myUsrInfo/myUsrInfoView");
		mav.addObject("usr_id", sessionUtil.getSessionBean().getUsr_id());
		return mav;
	}
	@RequestMapping(value = "/usrInfo")
	public ModelAndView UsrInfoGo(@ModelAttribute UsrInfo entity) throws Exception {
		ModelAndView mav = new ModelAndView("usrInfo/myUsrInfo/myUsrInfoView");
		mav.addObject("usr_id", entity.getUsr_id());
		return mav;
	}
	/**
	 * 회원목록 리스트 페이지로 이동합니다.(추후 사이트 관리자 계정에서만 보이게 할 것)
	**/
	@RequestMapping("/usrInfoList")
	public ModelAndView usrInfoListGo(@ModelAttribute UsrInfo entity){
		ModelAndView mav = new ModelAndView("usrInfo/usrInfoList/usrInfoListView");
		mav.addObject("lim", entity.getLim());
		mav.addObject("off", entity.getOff());
		return mav;
	}
	
	/**
	 * 모든 유저 정보를 리스트 형식으로 반환
	 * @return
	 */
	@RequestMapping(value = "/allPersonInfo/check/read", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> UsrInfoList(UsrInfo entity) {
		entity.setOff(entity.getLim()*entity.getOff());
		List<UsrInfo> List;
		List= usrInfoService.selectAllUser(entity);
		return List;
	}
	@RequestMapping(value = "/readUserInfoByCmpny", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> UsrInfoListByCmpny(@ModelAttribute UsrInfo entity) {
		
		List<UsrInfo> List;
		entity.setOff(entity.getLim()*entity.getOff());
		if(entity.getUsr_cmpny_idx()==-1){
			List= usrInfoService.selectAllUser(entity);	
		}
		else{
			List=usrInfoService.selectUserByCmpny(entity);
		}
		return List;
	}
	/**
	 * 회원 가입 페이지로 이동합니다.
	**/
	@RequestMapping("/join")
	public String  usrInfoJoinGo(){
		
		return "usrInfo/usrInfoJoin/usrInfoJoinView";
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
	
	
	
	@RequestMapping(value = "/prjt/read", method = RequestMethod.POST)
	@ResponseBody
	public List<ProjectInfo> PrjtInfoList(UsrInfo entity) {
		List<ProjectInfo> List;
		List= usrInfoService.readPrjtSbjtByUsrId(entity);
		for(int i = 0; i < List.size(); i++)
		{
			List.get(i).setReg_date(commonUtil.getDividedTime(List.get(i).getReg_date()));
		}
		
		return List;
		}
	//basic instruction :
	@RequestMapping(value = "/GetUsrList", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> GetUsrList(UsrInfo entity) {
		List<UsrInfo> List;
		List = usrInfoService.find(entity);
		return List;
		}
	
	
	
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
	@RequestMapping(value = "/changeUsrLv", method = RequestMethod.POST)
	@ResponseBody
	public int changeUsrLv(UsrInfo entity) {
		int result = usrInfoService.changeUsrLv(entity);
		return result;
	}
}
