package com.jobll.web.cmpnyinfo;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList;
import com.jobll.web.usrinfo.UsrInfo;


@Controller
@RequestMapping(value="/cmpny")
public class CmpnyInfoController {
	
	@Autowired
	private CmpnyInfoService cmpnyInfoService;

	
	//회사 입출력 화면 출력
	@RequestMapping("/add")
	public String CmpnyInfoGo(){
		return "usrInfo/cmpnyInfo/cmpnyInfoView";
	}
	
	
	
	//회사 입력
	@RequestMapping(value = "/add/create", method = RequestMethod.POST)
	@ResponseBody
	public String  createCmpnyInfo (@RequestParam(value="cmpny_nm") String cmpny_nm){
		
		String temp;
		//prjt_idx값과 list의 usr_id, usr_cmpny 값을 사용하여 insert
		temp=cmpnyInfoService.createCmpnyInfo(cmpny_nm);
		
		return temp;
	}
	
	//회사 삭제
	@RequestMapping(value = "/add/delete", method = RequestMethod.POST)
	@ResponseBody
	public List<String> deleteCmpnyInfo (@RequestParam(value="checkedItems[]") List<String> checkedItems){
		
		//prjt_idx값과 list의 usr_id, usr_cmpny 값을 사용하여 insert
		List<String> temp=cmpnyInfoService.deleteCmpnyInfo(checkedItems);
		
		return temp;
	}
	/**
	 * @param
	 * @return
	**/
	@RequestMapping(value = "/GetCmpnyList", method = RequestMethod.POST)
	@ResponseBody
	public List<CmpnyInfo> GetCmpnyList (@ModelAttribute CmpnyInfo entity) throws Exception{
		
		//prjt_idx값과 list의 usr_id, usr_cmpny 값을 사용하여 insert
		List<CmpnyInfo> list = cmpnyInfoService.findAll(entity);
		
		return list;
	}
	
	


}

