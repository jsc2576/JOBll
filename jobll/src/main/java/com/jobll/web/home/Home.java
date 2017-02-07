package com.jobll.web.home;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository("product")
public class Home implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1499476260178885152L;
	/**
	 * 
	 */
	
	private Integer test_idx;
	public Integer getTest_idx() {
		return test_idx;
	}
	public void setTest_idx(Integer test_idx) {
		this.test_idx = test_idx;
	}
	
}