package com.jobll.web.home;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository("home")
public class Home implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1499476260178885152L;
	/**
	 * 
	 */
	
	private Integer test_idx;
	private String test;
	private boolean test2;
	
	
	public boolean isTest2() {
		return test2;
	}
	public void setTest2(boolean test2) {
		this.test2 = test2;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public Integer getTest_idx() {
		return test_idx;
	}
	public void setTest_idx(Integer test_idx) {
		this.test_idx = test_idx;
	}
	
}