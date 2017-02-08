package com.jobll.web.user;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Repository("user_info")
public class User implements Serializable, UserDetails {

	private Integer user_idx;
	private String user_id;
	private String user_pw;
	private String user_nm;
	private String user_adress;
	private String user_phone;
	private String user_type;
	private String user_grade;
	private String user_company;
	private Integer user_valid;
	
	//10EA Column
	 private Collection<? extends GrantedAuthority> authorities;

	public Integer getuser_idx() {
		return user_idx;
	}
	public void setuser_idx(Integer user_idx) {
		this.user_idx = user_idx;
	}
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getuser_pw() {
		return user_pw;
	}
	public void setuser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getuser_nm() {
		return user_nm;
	}
	public void setuser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getuser_adress() {
		return user_adress;
	}
	public void setuser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	public String getuser_phone() {
		return user_phone;
	}
	public void setuser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getuser_type() {
		return user_type;
	}
	public void setuser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getuser_grade() {
		return user_grade;
	}
	public void setuser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getuser_company() {
		return user_company;
	}
	public void setuser_company(String user_company) {
		this.user_company = user_company;
	}
	public Integer getuser_valid() {
		return user_valid;
	}
	public void setuser_valid(Integer user_valid) {
		this.user_valid = user_valid;
	}
	
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
         this.authorities = authorities;
    }
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	

}