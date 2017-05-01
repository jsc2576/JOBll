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
@RequestMapping(value="/atclInfo")
public class AtclInfoController {

	@Autowired
	private AtclInfoService atclInfoService;
	@Autowired
	private AttchFileService attchFileService;
	
	
	/**
	 * 게시판 리스트로 이동합니다.
	 */
	@RequestMapping("/atclInfoList/go")
	public String atclInfoListGo(){
		return "atclInfo/atclInfoList/atclInfoListView";
	}
	
	/**
	 * 게시판(이슈) 쓰기 페이지로 맵핑해 줍니다.
	**/
	@RequestMapping("/atclInfoWrite/go")
	public String atclInfoWriteGo(Locale locale, Model model) {

		return "atclInfo/atclInfoWrite/atclInfoWriteView";
	}
	
	/**
	 * 게시판(이슈) 쓰기 통신 입니다.
	 * @param request HttpServletRequest형식으로 업로드된 파일 정보를 가지고 있습니다.
	 * @param entity AtclInfo객체 형식으로 이슈(게시글)의 제목과 내용을 가지고 있습니다.
	 * @return 현재는 성공 값인 1만 보내주며 추후 통신 실패에 따른 0또는 error메시지를 보낼 계획입니다.
	**/
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public int atclInfoWrite (@ModelAttribute AtclInfo entity, HttpServletRequest request, BindingResult errors) throws Exception {
		//HttpServletRequest 형식의 데이터를 MultipartFile형식으로 캐스팅 해 줍니다.
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		List<MultipartFile> multipartFile = multipartRequest.getFiles("uploadFile");
		
		//게시글 정보를 우선적으로 db로 전송합니다. 쿼리  전송후 atcl_idx값이 entity에 저장됩니다.
		atclInfoService.createAtcl(entity);
		
		//파일 업로드용 객체인 AttchFile를 생성합니다.
		AttchFile uploaddata = new AttchFile();
		
		//AtclInfo객체에서 atcl_idx와  usr_id를 전달 받습니다.
		//uploaddata.setRef_idx(entity.getAtcl_idx());
		//uploaddata.setUsr_id(entity.getUsr_id());
		
		//업로드 를 수행합니다.
		attchFileService.uploadFiles(multipartFile,uploaddata);
		
		return 1;
	}
	/**
	 * 게시판 리스트를 불러오는 통신입니다.
	 * @param entity AtclInfo객체 리스트로 값을 불러옵니다.
	 * @return
	 */
	@RequestMapping(value = "/listRun", method= RequestMethod.POST)
	@ResponseBody
	public List<AtclInfo> AtclInfolistRun(@ModelAttribute AtclInfo entity) throws Exception{
		List<AtclInfo> atcl_list = atclInfoService.findList(entity);
		
		return atcl_list;
	}
	
	/**
	 * 플래너 정보 조회 화면 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/readOne")
	public ModelAndView AtclInforeadOne (@ModelAttribute AtclInfo entity, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("atclInfo/atclInfoView");
		
		entity = atclInfoService.findOne(entity);
		
		AttchFile find_idx = new AttchFile();
		
		
		List<AttchFile> list = new ArrayList<AttchFile>();
		
		list = attchFileService.readByIdx(find_idx);
		
		mav.addObject("entity", entity);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/pageCheck")
	public Integer AtclInfoPageCnt(@ModelAttribute AtclInfo entity) throws Exception{
		Integer data = atclInfoService.pageCnt(entity);
		return data;
	}
}
