package com.jobll.web.projectInfo.projectSupply;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("ProjectSupply")
public class ProjectSupply implements Serializable{

	private static final long serialVersionUID = 6160024646312100989L;
	
	private Integer prjt_sup_list_idx; 	// 프로젝트지원리스트 인덱스 
	private Integer prjt_idx; 			// 프로젝트 인덱스 
	private String sup_conts; 			// 지원내용 
	private String sup_person;			// 지원인원
	private String sup_strt_date;		// 지원시작날짜
	private String sup_end_date;		// 지원종료날짜
	private Integer appr_yn;				// 승인여부
	private String usr_id;				// 사용자아이디
	
	public Integer getPrjt_sup_list_idx() {
		return prjt_sup_list_idx;
	}
	public void setPrjt_sup_list_idx(Integer prjt_sup_list_idx) {
		this.prjt_sup_list_idx = prjt_sup_list_idx;
	}
	public Integer getPrjt_idx() {
		return prjt_idx;
	}
	public void setPrjt_idx(Integer prjt_idx) {
		this.prjt_idx = prjt_idx;
	}
	public String getSup_conts() {
		return sup_conts;
	}
	public void setSup_conts(String sup_conts) {
		this.sup_conts = sup_conts;
	}
	public String getSup_person() {
		return sup_person;
	}
	public void setSup_person(String sup_person) {
		this.sup_person = sup_person;
	}
	public String getSup_strt_date() {
		return sup_strt_date;
	}
	public void setSup_strt_date(String sup_strt_date) {
		this.sup_strt_date = sup_strt_date;
	}
	public String getSup_end_date() {
		return sup_end_date;
	}
	public void setSup_end_date(String sup_end_date) {
		this.sup_end_date = sup_end_date;
	}
	public Integer getAppr_yn() {
		return appr_yn;
	}
	public void setAppr_yn(Integer appr_yn) {
		this.appr_yn = appr_yn;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
}
