package com.jobll.web.usrinfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("UsrInfo")
public class UsrInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1638273159722849211L;
	
	
	private String usr_id;						// 사용자아이디
	private String usr_nm;					// 사용자이름
	private Integer usr_lv;					// 사용자 등급
	private Integer tel_num;				// 전화번호
	private Integer mobile_num;				// 휴대폰번호
	private String usr_email;				// 이메일
	private String usr_cmpny;				// 회사명
	private String usr_gdr;					// 유저성별 M:남자 F:여자 (Default:M)
	private String usr_pwd;					// 사용자비밀번호
	private String join_date;				// 가입일자
	private Integer act_stus;				// 1:활성 2: 비활성(Default:1)
	private String zip_cd;					// 우편번호
	private String norm_addr;				// 기본주소
	private String dtl_addr;				// 상세주소
	private Integer usr_brth;				// 생년월일
	
	
	
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_nm() {
		return usr_nm;
	}
	public void setUsr_nm(String usr_nm) {
		this.usr_nm = usr_nm;
	}
	public Integer getUsr_lv() {
		return usr_lv;
	}
	public void setUsr_lv(Integer usr_lv) {
		this.usr_lv = usr_lv;
	}
	public Integer getTel_num() {
		return tel_num;
	}
	public void setTel_num(Integer tel_num) {
		this.tel_num = tel_num;
	}
	public Integer getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(Integer mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_cmpny() {
		return usr_cmpny;
	}
	public void setUsr_cmpny(String usr_cmpny) {
		this.usr_cmpny = usr_cmpny;
	}
	public String getUsr_gdr() {
		return usr_gdr;
	}
	public void setUsr_gdr(String usr_gdr) {
		this.usr_gdr = usr_gdr;
	}
	public String getUsr_pwd() {
		return usr_pwd;
	}
	public void setUsr_pwd(String usr_pwd) {
		this.usr_pwd = usr_pwd;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public Integer getAct_stus() {
		return act_stus;
	}
	public void setAct_stus(Integer act_stus) {
		this.act_stus = act_stus;
	}
	public String getZip_cd() {
		return zip_cd;
	}
	public void setZip_cd(String zip_cd) {
		this.zip_cd = zip_cd;
	}
	public String getNorm_addr() {
		return norm_addr;
	}
	public void setNorm_addr(String norm_addr) {
		this.norm_addr = norm_addr;
	}
	public String getDtl_addr() {
		return dtl_addr;
	}
	public void setDtl_addr(String dtl_addr) {
		this.dtl_addr = dtl_addr;
	}
	public Integer getUsr_brth() {
		return usr_brth;
	}
	public void setUsr_brth(Integer usr_brth) {
		this.usr_brth = usr_brth;
	}
	
	
}
