package com.jobll.web.hstyInfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("HstyInfo")
public class HstyInfo implements Serializable{


	private static final long serialVersionUID = -1638273159722849211L;


	private Integer hsty_idx;
	private String usr_id;
	private Integer cmpny_idx;
	private Integer prjt_idx;
	private Integer atcl_idx;
	private Integer cmt_idx;
	private String hsty_date;
	private String hsty_conts;
	private Integer hsty_typ;
	
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
	
	public Integer getCmpny_idx() {
		return cmpny_idx;
	}
	public void setCmpny_idx(Integer cmpny_idx) {
		this.cmpny_idx = cmpny_idx;
	}
	public Integer getHsty_idx() {
		return hsty_idx;
	}
	public void setHsty_idx(Integer hsty_idx) {
		this.hsty_idx = hsty_idx;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public Integer getPrjt_idx() {
		return prjt_idx;
	}
	public void setPrjt_idx(Integer prjt_idx) {
		this.prjt_idx = prjt_idx;
	}
	public Integer getAtcl_idx() {
		return atcl_idx;
	}
	public void setAtcl_idx(Integer atcl_idx) {
		this.atcl_idx = atcl_idx;
	}
	public Integer getCmt_idx() {
		return cmt_idx;
	}
	public void setCmt_idx(Integer cmt_idx) {
		this.cmt_idx = cmt_idx;
	}
	public String getHsty_date() {
		return hsty_date;
	}
	public void setHsty_date(String hsty_date) {
		this.hsty_date = hsty_date;
	}
	public String getHsty_conts() {
		return hsty_conts;
	}
	public void setHsty_conts(String hsty_conts) {
		this.hsty_conts = hsty_conts;
	}
	public Integer getHsty_typ() {
		return hsty_typ;
	}
	public void setHsty_typ(Integer hsty_typ) {
		this.hsty_typ = hsty_typ;
	}


}