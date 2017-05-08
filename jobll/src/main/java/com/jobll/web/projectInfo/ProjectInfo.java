package com.jobll.web.projectInfo;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("ProjectInfo")
public class ProjectInfo implements Serializable{

	private static final long serialVersionUID = 6160024646312100989L;
	
	private Integer prjt_idx;				//프로젝트 인덱스
	private Integer cmpny_idx;				//회사명
	private Integer high_prjt_idx;			//상위 프로젝트 인덱스
	private String prjt_sbjt;				//프로젝트 제목
	private String prjt_conts;				//프로젝트 내용
	private String reg_date;				//등록날짜
	private String prjt_stus;				//프로젝트 상태
	private Integer prjt_lv;				//프로젝트 레벨
	
	public Integer getPrjt_idx() {
		return prjt_idx;
	}
	public void setPrjt_idx(Integer prjt_idx) {
		this.prjt_idx = prjt_idx;
	}
	public Integer getCmpny_idx() {
		return cmpny_idx;
	}
	public void setCmpny_idx(Integer cmpny_idx) {
		this.cmpny_idx = cmpny_idx;
	}
	public Integer getHigh_prjt_idx() {
		return high_prjt_idx;
	}
	public void setHigh_prjt_idx(Integer high_prjt_idx) {
		this.high_prjt_idx = high_prjt_idx;
	}
	public String getPrjt_sbjt() {
		return prjt_sbjt;
	}
	public void setPrjt_sbjt(String prjt_sbjt) {
		this.prjt_sbjt = prjt_sbjt;
	}
	public String getPrjt_conts() {
		return prjt_conts;
	}
	public void setPrjt_conts(String prjt_conts) {
		this.prjt_conts = prjt_conts;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPrjt_stus() {
		return prjt_stus;
	}
	public void setPrjt_stus(String prjt_stus) {
		this.prjt_stus = prjt_stus;
	}
	public Integer getPrjt_lv() {
		return prjt_lv;
	}
	public void setPrjt_lv(Integer prjt_lv) {
		this.prjt_lv = prjt_lv;
	}
}
