package com.jobll.web.attchfile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.AwsS3Config;
import com.jobll.web.home.Home;
import com.jobll.web.home.HomeService;
//import com.jobll.web.user.UserService;

/**
 * 파일 첨부 테스트를 위한 Controller 파일 업로드 웹에서의 사용 예제(클라이언트)와 파일 업로드 서비스(서버) 사용 예제입니다.
 * 쓰기전에 꼭 한번 봐주세요
 * 
 * @author jsh
 *
 */

@Controller
public class AttchFileController {

	protected static final Logger LOGGER = Logger.getLogger(AttchFileController.class);

	@Autowired
	private AwsS3Config awsS3Config;

	@Autowired
	private AttchFileService attchFileService;
	
	@Autowired
	private HomeService memberService;
	
	
	
	

	/**
	 * 웹으로 파일 업로드 테스트 하기 위한 페이지입니다.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "fileUpLoad")
	public String goAttchFileUpload() throws Exception {
		return "fileUpLoad/fileUpLoad";
	}
	/**
	 * 파일 첨부 업로드입니다. MultipartHttpServletRequest로
	 * 요청을 받은 후 파일첨부 서비스를 사용합니다.
	 * 
	 * @param request
	 * @return entity
	 * @throws Exception
	 */
	@RequestMapping(value = "/testFileUpLoadRun" , method = {RequestMethod.POST})
	@ResponseBody
	public AttchFile productList (@ModelAttribute AttchFile entity, HttpServletRequest request, BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			LOGGER.debug(errors.toString());
		}	
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		List<MultipartFile> multipartFile = multipartRequest.getFiles("uploadFile");
		
		attchFileService.uploadFiles(multipartFile);
		return entity;
	}

}
