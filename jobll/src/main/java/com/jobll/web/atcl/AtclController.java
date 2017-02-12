package com.jobll.web.atcl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtclController {

	@RequestMapping("/atcl")
	public String atcl(){
		return "atcl/atcl";
	}
	
	@RequestMapping("/atcl/all")
	public String AtclAll(){
		return "AtclAll";
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
