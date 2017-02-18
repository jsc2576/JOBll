package com.jobll.web.atcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/atcl")
public class AtclController {

	@Autowired
	private AtclService atclService;
	
	
	/**
	 * 모든 데이터를 검색 
	 * @return
	 */
	@RequestMapping("/")
	public String atcl(){
		return "atcl/atcl";
	}
	
	
	/**
	 * find all
	 * @param entity
	 * @return
	 */
	@RequestMapping("/all")
	@ResponseBody
	public List<Atcl> AtclAll(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findList(entity, 0);
		return atcl_list;
	}
	
	
	/**
	 * find receive wait
	 * @param entity
	 * @return
	 */
	@RequestMapping("/rcv/wait")
	@ResponseBody
	public List<Atcl> AtclRcvWait(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findList(entity, 1);
		return atcl_list;
	}
	
	
	/**
	 * find receive complete
	 * @param entity
	 * @return
	 */
	@RequestMapping("/rcv/cmpt")
	@ResponseBody
	public List<Atcl> AtclRcvCmpt(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findList(entity, 2);
		return atcl_list;
	}
	
	
	/**
	 * find process wait
	 * @param entity
	 * @return
	 */
	@RequestMapping("/prcs/wait")
	@ResponseBody
	public List<Atcl> AtclPrcsWait(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findList(entity, 3);
		return atcl_list;
	}
	
	
	/**
	 * find process complete
	 * @param entity
	 * @return
	 */
	@RequestMapping("/prcs/cmpt")
	@ResponseBody
	public List<Atcl> AtclPrcsCmpt(@ModelAttribute Atcl entity){
		List<Atcl> atcl_list = atclService.findList(entity, 4);
		return atcl_list;
	}
}
