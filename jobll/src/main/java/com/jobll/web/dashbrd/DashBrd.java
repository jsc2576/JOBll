package com.jobll.web.dashbrd;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("DashBrd")
public class DashBrd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9063855158932773225L;

	private Integer usr_id; // 유저 아이디
	private List<String> prjt_sjbt; // 프로젝트 이름 리스트
	
	
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public List<String> getPrjt_sjbt() {
		return prjt_sjbt;
	}
	public void setPrjt_sjbt(List<String> prjt_sjbt) {
		this.prjt_sjbt = prjt_sjbt;
	}
	
}
