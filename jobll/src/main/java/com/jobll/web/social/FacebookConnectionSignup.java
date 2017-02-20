package com.jobll.web.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;

import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UsrInfoRepository userRepository;
 
    @Override
    public String execute(Connection<?> connection) {
        UsrInfo user = new UsrInfo();
        user.setUsr_id("123");
        user.setUsr_nm(connection.getDisplayName());
        user.setUsr_pwd("1");
       // userRepository.create(user);
        return user.getUsr_nm();
    }
    
}