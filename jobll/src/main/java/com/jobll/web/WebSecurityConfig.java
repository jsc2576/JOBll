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
    
    /**
     * Configure
     * 프로그램이 가동되기 전 밑의 옵션을 우선으로 설정한다
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf() //csrf 보안 
        		.disable().anonymous()	
        		.and()
            .formLogin()//로그인 옵션
                .loginPage("/login.do")
                .loginProcessingUrl("/authLogin.do")
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
            .logout()//로그아웃 옵션
                .logoutUrl("/logout.do")
                .logoutSuccessUrl("/login.do?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
           .authorizeRequests()//권한요청
            	.antMatchers("/").permitAll()
            	.antMatchers("/signin/facebook").permitAll()
                .antMatchers("/resources/**").permitAll()
            	.antMatchers("/usrInfo/usrInfoJoin/go").permitAll()
            	.antMatchers("/usrInfo/join").permitAll()
            	//.antMatchers("/**").permitAll()
                .anyRequest().authenticated()//위 설정 외에 전 url에서 세션 검사
                .and()
           .apply(new SpringSocialConfigurer());//소셜 로그인 폼 사용 설정
        		
		
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //http.exceptionHandling().accessDeniedPage("/login.do?error");
        //http.sessionManagement().invalidSessionUrl("/login.do");
    }
  
    /**
     * 로그인 프로세스
     */
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