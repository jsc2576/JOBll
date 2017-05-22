package com.jobll.web.cmpnyinfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

public class CmpnyInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1638273159722849341L;
	
	
	
	private Integer cmpny_idx;
	private String cmpny_nm;
	private Integer cmpny_stus;
	
	private Integer select_typ;
	
	
	
	public Integer getSelect_typ() {
		return select_typ;
	}

	public void setSelect_typ(Integer select_typ) {
		this.select_typ = select_typ;
	}

	public Integer getCmpny_idx() {
		return cmpny_idx;
	}

	public void setCmpny_idx(Integer cmpny_idx) {
		this.cmpny_idx = cmpny_idx;
	}

	public String getCmpny_nm() {
		return cmpny_nm;
	}

	public void setCmpny_nm(String cmpny_nm) {
		this.cmpny_nm = cmpny_nm;
	}

	public Integer getCmpny_stus() {
		return cmpny_stus;
	}

	public void setCmpny_stus(Integer cmpny_stus) {
		this.cmpny_stus = cmpny_stus;
	}

		public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
