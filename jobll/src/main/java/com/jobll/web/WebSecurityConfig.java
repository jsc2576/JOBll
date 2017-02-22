package com.jobll.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import com.jobll.web.login.LoginService;
import com.jobll.web.social.FacebookConnectionSignup;
import com.jobll.web.social.FacebookSignInAdapter;
import com.jobll.web.social.SimpleSocialUsersDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginService loginService;
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring();
                 //   .antMatchers("/css/**").antMatchers("/js/**").antMatchers("/images/**");
        	
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable().anonymous()
        .and()
                .formLogin()
                .loginPage("/login.do")
                .loginProcessingUrl("/authLogin.do")
                //.defaultSuccessUrl("/web/index.do",true)
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout.do")
                .logoutSuccessUrl("/login.do?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
           .authorizeRequests()
            	.antMatchers("/facebook").permitAll()
            	.antMatchers("/login.do").permitAll()
            	.antMatchers("/").permitAll()
                .antMatchers("/connect/**").permitAll()
                .antMatchers("/signin/**").permitAll()
            	.antMatchers("/resources/**").permitAll()
            	.antMatchers("/login*","/signin/**","/signup/**").permitAll()
            	.antMatchers("/usrInfo/usrInfoJoin/go").permitAll()
            	//.antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
           .apply(new SpringSocialConfigurer());
        		
		
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //http.exceptionHandling().accessDeniedPage("/login.do?error");
        //http.sessionManagement().invalidSessionUrl("/login.do");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("1").password("1").roles("USER");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(loginService);
    }   
    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;
 
    @Autowired
    private UsersConnectionRepository usersConnectionRepository;
 
    @Autowired
    private FacebookConnectionSignup facebookConnectionSignup;
	@Bean
	public SocialUserDetailsService socialUsersDetailService() {
		return new SimpleSocialUsersDetailService(userDetailsService());
	}
	 @Bean
	    public ProviderSignInController providerSignInController() {
	        ((InMemoryUsersConnectionRepository) usersConnectionRepository)
	          .setConnectionSignUp(facebookConnectionSignup);
	         	
	        return new ProviderSignInController(
	          connectionFactoryLocator, 	
	          usersConnectionRepository, 
	          new FacebookSignInAdapter());
	    }
}