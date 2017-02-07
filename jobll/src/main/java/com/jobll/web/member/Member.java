package com.jobll.web.member;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("memInfo")
public class Member implements Serializable {

	private Integer mem_idx;
	private String mem_id;
	private String mem_pw;
	private String mem_nm;
	private String mem_adress;
	private String mem_phone;
	private String mem_type;
	private String mem_grade;
	private String mem_company;
	private Integer mem_valid;
	//10EA Column
	public Integer getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(Integer mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getMem_adress() {
		return mem_adress;
	}
	public void setMem_adress(String mem_adress) {
		this.mem_adress = mem_adress;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_type() {
		return mem_type;
	}
	public void setMem_type(String mem_type) {
		this.mem_type = mem_type;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	public String getMem_company() {
		return mem_company;
	}
	public void setMem_company(String mem_company) {
		this.mem_company = mem_company;
	}
	public Integer getMem_valid() {
		return mem_valid;
	}
	public void setMem_valid(Integer mem_valid) {
		this.mem_valid = mem_valid;
	}
	

	

}