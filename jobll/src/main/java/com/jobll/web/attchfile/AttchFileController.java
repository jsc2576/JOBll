package com.jobll.web.attchfile;

import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
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
	@RequestMapping(value = "/attchFile/testFileUpLoadRun" , method = {RequestMethod.POST})
	@ResponseBody
	public AttchFile FileUpLoadRun (@ModelAttribute AttchFile entity, HttpServletRequest request, BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			LOGGER.debug(errors.toString());
		}	
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		List<MultipartFile> multipartFile = multipartRequest.getFiles("uploadFile");
		
		attchFileService.uploadFiles(multipartFile);
		return entity;
	}
	
	@RequestMapping(value = "/attchFile/testFileDownLoadList" , method = {RequestMethod.POST})
	@ResponseBody
	public List<AttchFile> FileDownLoadList (@ModelAttribute AttchFile entity, BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			LOGGER.debug(errors.toString());
		}	
		
		List<AttchFile> list = new ArrayList<AttchFile>();
		
		list = attchFileService.findByUsr(entity);
		

		return list;
	}
	
	@RequestMapping(value="/attchFile/testFileDownLoadRun")
	public void FileDownLoadRun(@ModelAttribute AttchFile entity, HttpServletResponse response) throws Exception{

		File file = attchFileService.getDownLoadResponse(entity);
		
	    byte fileByte[] = FileUtils.readFileToByteArray(file);
	    	    
	     
	    response.setContentType("application/download;charset=utf-8");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(entity.getAttch_file_nm(),"UTF-8")+"\";");
	    response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Connection", "close");
	    response.getOutputStream().write(fileByte);
	    
	    

        
        
        //FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
	     
	    response.flushBuffer();
	    response.getOutputStream().close();
	    
	    file.delete();
	}
}
