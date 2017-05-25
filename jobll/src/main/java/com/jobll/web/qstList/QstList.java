package com.jobll.web.qstList;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("QstList")
public class QstList implements Serializable{


	private static final long serialVersionUID = -1638273159722849211L;


	private Integer qst_idx;
	private String qst_sbjt;
	private String qst_conts;
	private String reg_date;
	private String usr_id;
	private Integer qst_stus;
	private String ans_conts;
	
	private int lim=10;
	private int off=0;
	// for pagination
	
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
	public Integer getQst_idx() {
		return qst_idx;
	}
	public void setQst_idx(Integer qst_idx) {
		this.qst_idx = qst_idx;
	}
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
	public Integer getQst_stus() {
		return qst_stus;
	}
	public void setQst_stus(Integer qst_stus) {
		this.qst_stus = qst_stus;
	}
	public String getAns_conts() {
		return ans_conts;
	}
	public void setAns_conts(String ans_conts) {
		this.ans_conts = ans_conts;
	}
}