package com.jobll.web.projectInfo.issueinfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("Issueinfo")
public class IssueInfo implements Serializable{

	private static final long serialVersionUID = 6160024646312100989L;
	
	private int atcl_idx; 			//게시물 인덱스 
	private int high_atcl_idx;		//상위이슈 인덱스
	private String atcl_sbjt;		//이슈제목	
	private String atcl_conts;		//이슈내용
	private String reg_date;		//등록날짜
	private String usr_id;			//담당자	
	private String strt_date;		//시작시간	
	private String comp_date;		//완료기간	
	private String estn_time;		//추정시간	
	private int atcl_prog_rate;		//이슈진행정도
	private String atcl_stus;		//이슈 상태 1: 활성 2: 비활성
	private int prjt_idx;			//프로젝트인덱스
	private String atcl_typ;		//1: 이슈 2: Q/A
	
	private Integer atcl_offset;
	private Integer atcl_limit;
	private Integer write_type;		//게시글을 쓸때 수정인경우 1 아닌 경우 0
	
	public int getAtcl_idx() {
		return atcl_idx;
	}
	public void setAtcl_idx(int atcl_idx) {
		this.atcl_idx = atcl_idx;
	}
	public int getHigh_atcl_idx() {
		return high_atcl_idx;
	}
	public void setHigh_atcl_idx(int high_atcl_idx) {
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
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getStrt_date() {
		return strt_date;
	}
	public void setStrt_date(String strt_date) {
		this.strt_date = strt_date;
	}
	public String getComp_date() {
		return comp_date;
	}
	public void setComp_date(String comp_date) {
		this.comp_date = comp_date;
	}
	public String getEstn_time() {
		return estn_time;
	}
	public void setEstn_time(String estn_time) {
		this.estn_time = estn_time;
	}
	public int getAtcl_prog_rate() {
		return atcl_prog_rate;
	}
	public void setAtcl_prog_rate(int atcl_prog_rate) {
		this.atcl_prog_rate = atcl_prog_rate;
	}
	public String getAtcl_stus() {
		return atcl_stus;
	}
	public void setAtcl_stus(String atcl_stus) {
		this.atcl_stus = atcl_stus;
	}
	public int getPrjt_idx() {
		return prjt_idx;
	}
	public void setPrjt_idx(int prjt_idx) {
		this.prjt_idx = prjt_idx;
	}
	public String getAtcl_typ() {
		return atcl_typ;
	}
	public void setAtcl_typ(String atcl_typ) {
		this.atcl_typ = atcl_typ;
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
	public Integer getWrite_type() {
		return write_type;
	}
	public void setWrite_type(Integer write_type) {
		this.write_type = write_type;
	}
	
	
}
