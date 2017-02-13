package com.jobll.web.usr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrController {
	
	@RequestMapping("/usr")
	public String usr(){
		return "usr/usr";
	}
	@RequestMapping("/usrin")
	public String usrin(){
		return "usr/usrin";
	}
	@RequestMapping("/usrout")
	public String usrout(){
		return "usr/usrout";
	}
}
