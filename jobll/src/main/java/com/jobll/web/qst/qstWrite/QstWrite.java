package com.jobll.web.qst.qstWrite;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("QstWrite")
public class QstWrite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4499707894648272905L;

	private Integer qst_idx;
	private Integer high_qst_idx;
	private String usr_id;
	private String reg_date;
	private String qst_sbjt;
	private String qst_conts;
	private String qst_stus;
	
	
	public Integer getQst_idx() {
		return qst_idx;
	}
	public void setQst_idx(Integer qst_idx) {
		this.qst_idx = qst_idx;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getQst_conts() {
		return qst_conts;
	}
	public void setQst_conts(String qst_conts) {
		this.qst_conts = qst_conts;
	}
	public Integer getHigh_qst_idx() {
		return high_qst_idx;
	}
	public void setHigh_qst_idx(Integer high_qst_idx) {
		this.high_qst_idx = high_qst_idx;
	}
	public String getQst_sbjt() {
		return qst_sbjt;
	}
	public void setQst_sbjt(String qst_sbjt) {
		this.qst_sbjt = qst_sbjt;
	}
	public String getQst_stus() {
		return qst_stus;
	}
	public void setQst_stus(String qst_stus) {
		this.qst_stus = qst_stus;
	}
}
