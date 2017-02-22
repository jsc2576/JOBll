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

import com.jobll.web.attchfile.AttchFile;



@Controller
@RequestMapping(value="/usrInfo")
public class UsrInfoController {
	
	@Autowired
	private UsrInfoService usrInfoService;
	
	/**
	 * 로그인 사용자의 개인정보를 볼 수 있습니다.
	**/
	@RequestMapping(value = "/MyUsrInfo/go")
	public String myUsrInfoGo() throws Exception {
		return "usrInfo/myUsrInfo/myUsrInfoView";
	}
	
	/**
	 * 회원목록 리스트 페이지로 이동합니다.(추후 사이트 관리자 계정에서만 보이게 할 것)
	**/
	@RequestMapping("/usrInfoList/go")
	public String usrInfoListGo(){
		return "usrInfo/usrInfoList/usrInfoListView";
	}
	/**
	 * 회원 가입 페이지로 이동합니다.
	**/
	@RequestMapping("/usrInfoJoin/go")
	public String usrInfoJoinGo(){
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
