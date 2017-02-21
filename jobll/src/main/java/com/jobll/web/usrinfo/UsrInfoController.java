package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jobll.web.attchfile.AttchFile;



@Controller
@RequestMapping(value="/usr")
public class UsrInfoController {
	
	@Autowired
	private UsrInfoService usrInfoService;
	
	@RequestMapping(value = "/myUsrInfo")
	public String goAttchFileUpload() throws Exception {
		return "usrInfo/MyUsrInfo";
	}
	

	
	
	
	//basic instruction :
	
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public List<HashMap<String, Object>> select() {
		List<HashMap<String, Object>> List;
		List= usrInfoService.select();
		
		return List;
		}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<HashMap<String, Object>> read(@ModelAttribute UsrInfo entity, Model model) {
		List<HashMap<String, Object>> List = usrInfoService.read(entity);
		return List;
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(@ModelAttribute UsrInfo entity, Model model) {
		//usrInfoService.create(entity);
		return "usrInfo/usrInfoJoin";
		}
	@RequestMapping(value = "/make", method = RequestMethod.POST)
	public String createUsrInfo (HttpServletRequest request, @ModelAttribute("model_entity") 
		@Validated UsrInfo entity, BindingResult errors) throws Exception {
		usrInfoService.create(entity);
		return "home";
		}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public void edit(@ModelAttribute UsrInfo entity, Model model) {
		usrInfoService.edit(entity);
		return ;
		}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@ModelAttribute UsrInfo entity, Model model) {
		usrInfoService.delete(entity);
		return ;
		}
}
