package com.jobll.web.qst;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("Qst")
public class Qst implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6174235347010023028L;

	private String qst_sbjt;
	private String qst_conts;
	private String reg_date;
	private String usr_id;
	private Integer offset;
	private Integer limit;
	
	public String getQst_sbjt() {
		return qst_sbjt;
	}
	public void setQst_sbjt(String qst_sbjt) {
		this.qst_sbjt = qst_sbjt;
	}
	public String getQst_conts() {
		return qst_conts;
	}
	public void setQst_conts(String qst_conts) {
		this.qst_conts = qst_conts;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}	
}
