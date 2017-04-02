package com.jobll.web.dashbrd;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("Dashbrd")
public class Dashbrd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7640555179543136473L;
	
	
	private Integer usr_id;
	private List<String> prjt_sbjt;
	private List<String> cnet_prjt_sbjt;
	
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public List<String> getPrjt_sbjt() {
		return prjt_sbjt;
	}
	public void setPrjt_sbjt(List<String> prjt_sbjt) {
		this.prjt_sbjt = prjt_sbjt;
	}
	public List<String> getCnet_prjt_sbjt() {
		return cnet_prjt_sbjt;
	}
	public void setCnet_prjt_sbjt(List<String> cnet_prjt_sbjt) {
		this.cnet_prjt_sbjt = cnet_prjt_sbjt;
	}
}
