package com.jobll.web.social;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobll.web.CommonUtil;
import com.jobll.web.session.SessionUtil;
import com.jobll.web.usrinfo.UsrInfo;
@Controller
//@Scope( proxyMode = ScopedProxyMode.TARGET_CLASS )
//@RequestMapping("/")
public class SocialController extends Session {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;
	@Autowired
	private SessionUtil sessionUtil;
	@Autowired
	private CommonUtil commonUtil;
	
    public SocialController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/facebook" )
    //@RequestMapping("/facebook" )
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        
   
        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "connect/hello";
    }
  

}