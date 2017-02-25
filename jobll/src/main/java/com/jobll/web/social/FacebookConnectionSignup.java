package com.jobll.web.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

import com.jobll.web.SessionUtil;
import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UsrInfoRepository userRepository;
 
    //@Autowired
    //private Facebook facebook;
    @Autowired
	private SessionUtil sessionUtil;
	
    
    @SuppressWarnings("deprecation")
	@Override
    public String execute(Connection<?> connection) {
    	
    	
    	
        UsrInfo user = new UsrInfo();
       
        user.setUsr_nm(connection.getDisplayName());
        
		Facebook facebook= (Facebook)connection.getApi();
		/*String [] fields = { "id", "about", "age_range", "birthday", "context", "cover",
				"currency", "devices", "education", "email", "favorite_athletes",
				"favorite_teams", "first_name", "gender", "hometown", "inspirational_people",
				"installed", "install_type", "is_verified", "languages", "last_name", "link",
				"locale", "location", "meeting_for", "middle_name", "name", "name_format",
				"political", "quotes", "payment_pricepoints", "relationship_status", "religion",
				"security_settings", "significant_other", "sports", "test_group", "timezone",
				"third_party_id", "updated_time", "verified", "video_upload_limits",
				"viewer_can_send_gift", "website", "work"};*/
		
		//All element to profile
		
		String[] fields = {"id", "name", "birthday", "email"};
		//element that we need
		
		User userProfile = facebook.fetchObject("me", User.class, fields);
		user.setUsr_id(userProfile.getId());
		user.setUsr_nm(userProfile.getName());
		
		//user.setUsr_brth(userProfile.getBirthday());
		//Integer - Character
		
		user.setUsr_email(userProfile.getEmail());
		
		int check;

		check = userRepository.checkId(user);
		
		
        if(check==0)userRepository.create(user);
        sessionUtil.setNewSession("SessionBean",user);
		
        return user.getUsr_nm();
    }
    
}