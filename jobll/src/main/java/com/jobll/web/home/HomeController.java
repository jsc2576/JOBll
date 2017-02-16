package com.jobll.web.home;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jobll.web.AwsS3Config;
import com.jobll.web.attchfile.AttchFileService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private AwsS3Config awsS3Config;
	
	@Autowired
	private AttchFileService attchFileService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Locale locale, Model model) {

		return "home";
	}
	@RequestMapping("/editor")
	public String editor(Locale locale, Model model) {

		return "editor/editor";
	}
	@RequestMapping(value = "/editortest" , method = {RequestMethod.POST})
	public ModelAndView regProduct(@ModelAttribute Home entity, HttpServletRequest request, BindingResult errors) throws Exception {
		ModelAndView mav = new ModelAndView("/editor/editor");		
		
		return mav;
	}
}
