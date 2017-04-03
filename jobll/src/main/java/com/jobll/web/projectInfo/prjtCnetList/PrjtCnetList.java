package com.jobll.web.projectInfo.prjtCnetList;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobll.web.usrinfo.UsrInfo;

@Repository("PrjtCnetList")

public class PrjtCnetList implements Serializable{

		/**
		 * 
		 */
	private static final long serialVersionUID = -1638273159722849341L;
		
	private Integer prjt_cnet_list_idx;
	private String usr_id;
	private Integer prjt_idx;
	private Integer cmpny_idx;
	private Integer prjt_cnet_list_stus;
	

	

	public Integer getPrjt_cnet_list_idx() {
		return prjt_cnet_list_idx;
	}
	public void setPrjt_cnet_list_idx(Integer prjt_cnet_list_idx) {
		this.prjt_cnet_list_idx = prjt_cnet_list_idx;
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
	public Integer getCmpny_idx() {
		return cmpny_idx;
	}
	public void setCmpny_idx(Integer cmpny_idx) {
		this.cmpny_idx = cmpny_idx;
	}
	public Integer getPrjt_cnet_list_stus() {
		return prjt_cnet_list_stus;
	}
	public void setPrjt_cnet_list_stus(Integer prjt_cnet_list_stus) {
		this.prjt_cnet_list_stus = prjt_cnet_list_stus;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
