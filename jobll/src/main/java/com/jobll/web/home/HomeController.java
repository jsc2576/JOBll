package com.jobll.web.home;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 *home url 맵핑입니다.
	 */
	@RequestMapping("/")
	public String home(Locale locale, Model model) {

		return "homeView";
	}
	
	@RequestMapping("/dev")
	public String dev(Locale locale, Model model) {

		return "dev/pages/homeView";
	}

}
