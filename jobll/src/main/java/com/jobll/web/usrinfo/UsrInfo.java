package com.jobll.web.usrinfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("UsrInfo")
public class UsrInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1638273159722849211L;
	
	
	private String usr_id;					// 사용자아이디
	private String usr_nm;					// 사용자이름
	private Integer usr_lv;					// 사용자 등급
	private Integer tel_num;				// 전화번호
	private Integer mobile_num;				// 휴대폰번호
	private String usr_email;				// 이메일
	private String usr_pwd;					// 사용자비밀번호
	private String reg_date;				// 가입일자
	private Integer act_stus;				// 1:활성 2: 비활성(Default:1)
	private Integer usr_cmpny_idx;			// 기관명 인덱스 
	
	private Integer select_typ;
	
	private int lim=10;
	private int off=0;
	
	
	public int getLim() {
		return lim;
	}
	public void setLim(int lim) {
		this.lim = lim;
	}
	public int getOff() {
		return off;
	}
	public void setOff(int off) {
		this.off = off;
	}
	
	
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




	public String getUsr_pwd() {
		return usr_pwd;
	}




	public void setUsr_pwd(String usr_pwd) {
		this.usr_pwd = usr_pwd;
	}




	public String getReg_date() {
		return reg_date;
	}




	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}




	public Integer getAct_stus() {
		return act_stus;
	}




	public void setAct_stus(Integer act_stus) {
		this.act_stus = act_stus;
	}




	public Integer getUsr_cmpny_idx() {
		return usr_cmpny_idx;
	}




	public void setUsr_cmpny_idx(Integer usr_cmpny_idx) {
		this.usr_cmpny_idx = usr_cmpny_idx;
	}




	public Integer getSelect_typ() {
		return select_typ;
	}




	public void setSelect_typ(Integer select_typ) {
		this.select_typ = select_typ;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
