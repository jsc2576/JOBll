package com.jobll.web.prjtCnetList;



import java.util.HashMap;
import java.util.List;
import java.util.Locale;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobll.web.prjtCnetList.PrjtCnetList;
import com.jobll.web.usrinfo.UsrInfo;


@Controller
public class PrjtCnetListController {
	Logger log=Logger.getLogger(this.getClass());
 
	@Autowired
	private PrjtCnetListService prjtCnetListService;
	
	
	//팀원 리스트를 읽어와 반환
	@RequestMapping(value = "/prjtCnetList/run", method = RequestMethod.POST)
	@ResponseBody
	public List<PrjtCnetList> prjtCnetInfo (){
		
		List<PrjtCnetList> list = prjtCnetListService.selectPrjtCnetList();
		return list;
	}
	
	//팀원 초대를 위한 회원 리스트 목록 반환
	@RequestMapping(value = "/prjtCnetList/CnetList.json", method = RequestMethod.POST)
	@ResponseBody
	public List<UsrInfo> CnetList (){
		
		List<UsrInfo> list = prjtCnetListService.selectCnetList();
		return list;
	}
	
	//팀원 리스트 화면 출력
	@RequestMapping(value="/teamPerson/check")
	public String PrjtCnetListGo(){
		return "prjtCnetList/prjtCnetList/prjtCnetListView";
	}
	
	//팀원 초대 및 제외 화면 출력
	@RequestMapping("/teamPerson/inv")
	public String prjtCnetListModifyGo() {
		return "prjtCnetList/prjtCnetListModify/prjtCnetListModifyView";
	}
	

	
	
	
	//basic instruction :
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public List<HashMap<String, Object>> select() {
		List<HashMap<String, Object>> List;
		List= prjtCnetListService.select();
		
		return List;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<HashMap<String, Object>> read(@ModelAttribute PrjtCnetList entity, Model model) {
		List<HashMap<String, Object>> List = prjtCnetListService.read(entity);
		return List;
	}
	
		
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public void edit(@ModelAttribute PrjtCnetList entity, Model model) {
		prjtCnetListService.edit(entity);
		return ;
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public void delete(@ModelAttribute PrjtCnetList entity, Model model) {
		prjtCnetListService.delete(entity);
		return ;
	}
	
}
