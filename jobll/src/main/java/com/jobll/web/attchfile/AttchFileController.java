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
@RequestMapping(value = "/")
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
	@RequestMapping(value = "/goCmnAttchFileUpload")
	public String goCmnAttchFileUpload() throws Exception {
		return "cmn/attchfile/upload";
	}

	/**
	 * 파일 첨부 사용 예제입니다. 파일 첨부 쓰려면 필독!! 일반 업로드 요청입니다. MultipartHttpServletRequest로
	 * 요청을 받은 후 파일첨부 서비스를 사용합니다.
	 * 
	 * @param request
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tempUpload/upload.json", method = RequestMethod.POST)
	@ResponseBody
	public List<AttchFile> tempAttchFileUpload(HttpServletRequest request, ModelAndView mav) throws Exception {
		/**
		 * MultipartHttpServletRequest multipartRequest =
		 * (MultipartHttpServletRequest)request; Multipart File 요청의 이름입니다. 웹으로
		 * 치면 input태그의 이름입니다. 앱으로 치면 정수찬에게 물어보세요.
		 */
		try{
			// 파일 정보를 담은 객체 리스트를 반환해줍니다.
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			List<MultipartFile> files = multipartRequest.getFiles("uploadFile");
			/**
			 * 스토리지의 실제 경로입니다. 이 부분은 실제 경로 이므로 an, you, my, image, video 나눠줄때 어떻게
			 * 나눌지 따로 생각해보아야 합니다. 스토리지 상 경로 결정 가능
			 */
			List<AttchFile> list = attchFileService.uploadFiles(files, "");
			return list;
		}catch(Exception e){
			return null;
		}
		
	}

	/**
	 * 이 예제는 temp공간에 파일 업로드 후 tempToReal이라는 메소드를 사용해 실제 원하는 스토리지 디렉토리에 저장시킬수 있는
	 * 예제입니다. 유/안/마이 별로 디렉터리를 다르게 저장할 수 있습니다. 대신 temp의 경우 용량이 꽉 찰 경우 자동으로 지워지는 건
	 * 아직 안만들었습니다. 조사중입니다.
	 * 
	 * @param request
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tempUpload/uploadTest.json", method = RequestMethod.POST)
	@ResponseBody
	public List<AttchFile> tempAttchFileUploadTest(HttpServletRequest request, @RequestParam HashMap<String, Object> param, ModelAndView mav) throws Exception {

		LOGGER.debug(param);	
		
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;

			LOGGER.debug(param);	
			List<MultipartFile> files = multipartRequest.getFiles("uploadFile");
			List<AttchFile> list = attchFileService.uploadFiles(files, "");
			
			for (int i = 0; i < list.size(); i++) {
				attchFileService.tempToReal(list.get(i), "test/temp/");
			}	
			// 파일 정보를 담은 객체 리스트를 반환해줍니다.
			return list;
		
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * image소스 사용하기 위한 매핑 url입니다. id값을 바로 넣어서 가져올 수 있습니다.
	 * 나중에 보안을 위해 id값이 아닌 변환값을 암호 복호 방법으로 불러오는 것으로 수정해야합니다.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") int id) throws Exception {
		ResponseEntity<byte[]> result = attchFileService.getImageResponse(id);
		return result;
	}

	/**
	 * image소스 사용하기 위한 매핑 url입니다. id값을 바로 넣어서 가져올 수 있습니다.
	 * 나중에 보안을 위해 id값이 아닌 변환값을 암호 복호 방법으로 불러오는 것으로 수정해야합니다.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public AttchFile getImage(HttpServletRequest request, @RequestParam Map<String, String> param) throws Exception {
		String a = param.get("file_path");
		String b = param.get("file_name");
		AttchFile c = new AttchFile();
		c.setAttch_file_nm(b);
		c.setFile_path(a);
		
		return attchFileService.readByPath(c);
	}

}
