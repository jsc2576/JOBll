package com.jobll.web.atclInfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("AtclInfo")
public class AtclInfo implements Serializable{

	private static final long serialVersionUID = 6160024646312100989L;
	
	private int atcl_idx; //게시물 인덱스 
	private String usr_id; // 유저 아이디 
	private Integer high_atcl_idx; //상위 게시물 인덱스 
	private String atcl_sbjt; //게시물 제목 
	private String atcl_conts; //게시물 내용 
	private String reg_date; //작성 날짜 
	private Integer atcl_stus; //1: 활성, 2: 비활성 (default: 1) 
	private String cmpny_nm; //회사 이름 
	private Integer prcs_stus; //1: 대기중, 2: 접수완료, 3: 처리중, 4: 처리완료(default: 1)
	
	private Integer atcl_offset;
	private Integer atcl_limit;
	public int getAtcl_idx() {
		return atcl_idx;
	}
	public void setAtcl_idx(int atcl_idx) {
		this.atcl_idx = atcl_idx;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public Integer getHigh_atcl_idx() {
		return high_atcl_idx;
	}
	public void setHigh_atcl_idx(Integer high_atcl_idx) {
		this.high_atcl_idx = high_atcl_idx;
	}
	public String getAtcl_sbjt() {
		return atcl_sbjt;
	}
	public void setAtcl_sbjt(String atcl_sbjt) {
		this.atcl_sbjt = atcl_sbjt;
	}
	public String getAtcl_conts() {
		return atcl_conts;
	}
	public void setAtcl_conts(String atcl_conts) {
		this.atcl_conts = atcl_conts;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Integer getAtcl_stus() {
		return atcl_stus;
	}
	public void setAtcl_stus(Integer atcl_stus) {
		this.atcl_stus = atcl_stus;
	}
	public String getCmpny_nm() {
		return cmpny_nm;
	}
	public void setCmpny_nm(String cmpny_nm) {
		this.cmpny_nm = cmpny_nm;
	}
	public Integer getPrcs_stus() {
		return prcs_stus;
	}
	public void setPrcs_stus(Integer prcs_stus) {
		this.prcs_stus = prcs_stus;
	}
	public Integer getAtcl_offset() {
		return atcl_offset;
	}
	public void setAtcl_offset(Integer atcl_offset) {
		this.atcl_offset = atcl_offset;
	}
	public Integer getAtcl_limit() {
		return atcl_limit;
	}
	public void setAtcl_limit(Integer atcl_limit) {
		this.atcl_limit = atcl_limit;
	}
	
	
	
}
