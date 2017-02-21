package com.jobll.web.session;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoService;

import javax.servlet.http.HttpSession;
@Controller
public class SessionController {
	
	@Autowired
	private SessionUtil sessionUtil;
	@RequestMapping(value="/session")
	public String index(Model model, HttpSession session) {
		  

	    
	    	session.setAttribute("id", "admin");
	        //session 객체에 admin이라는 값을 id라는 키로 저장
	        
	        model.addAttribute("className", this.getClass());
	        //model 객체에 현재 클래스이름을 className이라는 키로 저장
	       
	        UsrInfo a = sessionUtil.getSessionBean();
	        if(a==null)System.out.println("Session is null");
	        else System.out.println(a.toString());
		return "/login/session";	
	}
	

	
}
