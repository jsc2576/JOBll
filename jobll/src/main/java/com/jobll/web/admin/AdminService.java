package com.jobll.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	
	public int AuthCheck (){
		int usr_lv = sessionUtil.getSessionBean().getUsr_lv();
		
		if(usr_lv > 2)
			return 1;
		else
			return 0;
	}


}