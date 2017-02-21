package com.jobll.web.atclInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.attchfile.AttchFileService;



@Controller
public class AtclInfoController {

	@Autowired
	private AtclInfoService atclInfoService;
	@Autowired
	private AttchFileService attchFileService;
	
	
	/**
	 * 게시판(이슈) 쓰기 페이지로 맵핑해 줍니다.
	**/
	@RequestMapping("/editor")
	public String editor(Locale locale, Model model) {

		return "editor/editorView";
	}
	
	/**
	 * 게시판(이슈) 쓰기 통신 입니다.
	 * @param request HttpServletRequest형식으로 업로드된 파일 정보를 가지고 있습니다.
	 * @param entity AtclInfo객체 형식으로 이슈(게시글)의 제목과 내용을 가지고 있습니다.
	 * @return 현재는 성공 값인 1만 보내주며 추후 통신 실패에 따른 0또는 error메시지를 보낼 계획입니다.
	**/
	@RequestMapping(value = "/atcl/AtclCreate", method = RequestMethod.POST)
	@ResponseBody
	public int AtclCreate (@ModelAttribute AtclInfo entity, HttpServletRequest request, BindingResult errors) throws Exception {
		//HttpServletRequest 형식의 데이터를 MultipartFile형식으로 캐스팅 해 줍니다.
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		List<MultipartFile> multipartFile = multipartRequest.getFiles("uploadFile");
		
		//게시글 정보를 우선적으로 db로 전송합니다. 쿼리  전송후 atcl_idx값이 entity에 저장됩니다.
		atclInfoService.createAtcl(entity);
		
		//파일 업로드용 객체인 AttchFile를 생성합니다.
		AttchFile uploaddata = new AttchFile();
		
		//AtclInfo객체에서 atcl_idx와  usr_id를 전달 받습니다.
		uploaddata.setRef_idx(entity.getAtcl_idx());
		uploaddata.setUsr_id(entity.getUsr_id());
		
		//업로드 를 수행합니다.
		attchFileService.uploadFiles(multipartFile,uploaddata);
		
		return 1;
	}
	
	

	
	/**
	 * 모든 데이터를 검색 
	 * @return
	 */
	@RequestMapping("/atcl")
	public String atcl(){
		return "atclInfo/atclList";
	}
	
	
	/**
	 * find atcl data list
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/atcl/find.json", method= RequestMethod.POST)
	@ResponseBody
	public List<AtclInfo> AtclList(@ModelAttribute AtclInfo entity) throws Exception{
		List<AtclInfo> atcl_list = atclInfoService.findList(entity);
		
		return atcl_list;
	}
}
