package com.jobll.web.social;

//import xyz.autumnn.exam.springsocial.config.connection.JpaUsersConnectionRepository;
//import xyz.autumnn.exam.springsocial.config.connection.UserConnectionRepository;
//import xyz.autumnn.exam.springsocial.controller.signin.SimpleSignInAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.inject.Inject;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter implements SocialConfigurer{

	 
	/*
    @Inject
    private UserConnectionRepository userConnectionRepository;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JpaUsersConnectionRepository(Encryptors.noOpText(), connectionFactoryLocator, userConnectionRepository);
    }

    @Bean
    public SignInAdapter signInAdapter() {
        return new SimpleSignInAdapter(new HttpSessionRequestCache());
    }
    */
}
