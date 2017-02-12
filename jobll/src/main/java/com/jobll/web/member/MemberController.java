package com.jobll.web.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/meminfo")
	public String meminfo(){
		return "meminfo/meminfo";
	}
	
	
}
