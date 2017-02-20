package com.jobll.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.jobll.web.login.LoginService;

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
            .authorizeRequests()
            	.antMatchers("/facebook").permitAll()
            	.antMatchers("/login.do").permitAll()
            	.antMatchers("/").permitAll()
                .antMatchers("/connect/**").permitAll()
                
            	.antMatchers("/resources/**").permitAll()
                
                .anyRequest().authenticated()
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
                .permitAll();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.exceptionHandling().accessDeniedPage("/login.do?error");
        http.sessionManagement().invalidSessionUrl("/login.do");
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
}