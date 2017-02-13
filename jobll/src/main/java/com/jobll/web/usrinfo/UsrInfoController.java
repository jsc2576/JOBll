package com.jobll.web.usrinfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jobll.web.attchfile.AttchFile;



@Controller

public class UsrInfoController {

//	protected static final Logger LOGGER = Logger.getLogger(UsrInfoController.class);

	
	@Autowired
	private UsrInfoService usrinfoservice;
	
	@RequestMapping("/JoinProcessing")
	@ResponseBody
	public UsrInfo Join (@ModelAttribute UsrInfo entity, HttpServletRequest request, BindingResult errors) throws Exception {
		
		//test용 출력//////////////////////
		System.out.println("usrid: " + entity);
		//////////////////////////////
		
		usrinfoservice.CreateUsrInfo(entity);
		return entity;
	}

	/*
	
	@ResponseBody
	public UsrInfo JoinProcessing (@ModelAttribute UsrInfo entity, HttpServletRequest request, BindingResult errors) throws Exception {
			
		
		else{
			LOGGER.debug(errors.toString());
		}
	}

*/
}
