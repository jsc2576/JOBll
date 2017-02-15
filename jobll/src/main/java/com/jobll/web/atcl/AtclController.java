package com.jobll.web.atcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AtclController {

	@Autowired
	private AtclService atclService;
	
	
	/**
	 * 모든 데이터를 검색 
	 * @return
	 */
	@RequestMapping("/atcl/all")
	@ResponseBody
	public List<Atcl> AtclAll(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findAll(entity);
		return atcl_list;
	}
	
	@RequestMapping("/atcl/rcv/wait")
	public String AtclRcvWait(){
		return "AtclRcvWait";
	}
	
	@RequestMapping("/atcl/rcv/cmpt")
	public String AtclRcvCmpt(){
		return "AtclRcvWait";
	}
	
	@RequestMapping("/atcl/prcs/wait")
	public String AtclPrcsWait(){
		return "AtclPrcsWait";
	}
	
	@RequestMapping("/atcl/prcs/cmpt")
	public String AtclPrcsCmpt(){
		return "AtclPrcsCmpt";
	}
}
