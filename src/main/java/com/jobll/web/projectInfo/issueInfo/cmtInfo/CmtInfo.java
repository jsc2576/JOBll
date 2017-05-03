package com.jobll.web.projectInfo.issueInfo.cmtInfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("CmtInfo")
public class CmtInfo implements Serializable{


	private static final long serialVersionUID = -1638273159722849211L;


	private Integer cmt_idx;
	private String usr_id;
	private String cmt_conts;
	private String reg_date;
	private String cmt_stus;
	private Integer atcl_idx;

	public Integer getCmt_idx() {
		return cmt_idx;
	}
	public void setCmt_idx(Integer cmt_idx) {
		this.cmt_idx = cmt_idx;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getCmt_conts() {
		return cmt_conts;
	}
	public void setCmt_conts(String cmt_conts) {
		this.cmt_conts = cmt_conts;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getCmt_stus() {
		return cmt_stus;
	}
	public void setCmt_stus(String cmt_stus) {
		this.cmt_stus = cmt_stus;
	}
	public Integer getAtcl_idx() {
		return atcl_idx;
	}
	public void setAtcl_idx(Integer atcl_idx) {
		this.atcl_idx = atcl_idx;
	}


}