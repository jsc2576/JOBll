package com.jobll.web.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	@RequestMapping("/usrinfoJoin")
	public String usr(){
		return "usrinfo/usrinfoJoin";
	}
	
}
