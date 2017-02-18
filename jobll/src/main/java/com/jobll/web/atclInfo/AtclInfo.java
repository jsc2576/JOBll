package com.jobll.web.atclInfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("AtclInfo")
public class AtclInfo implements Serializable{

	//==================================================
	//				atcl_info table column 
	//==================================================
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6160024646312100989L;
	//==================================================
	//				atcl_info table column 
	//==================================================
	
	/**
	 * 
	 */
	
	
	private Integer atcl_idx; //게시물 인덱스 
	private String usr_id; // 유저 아이디 
	private Integer high_atcl_idx; //상위 게시물 인덱스 
	private String atcl_sbjt; //게시물 제목 
	private String atcl_conts; //게시물 내용 
	private String reg_date; //작성 날짜 
	private Integer atcl_stus; //1: 활성, 2: 비활성 (default: 1) 
	private String cmpny_nm; //회사 이름 
	private Integer prcs_stus; //1: 대기중, 2: 접수완료, 3: 처리중, 4: 처리완료(default: 1)
	
	
	
	
	
	//==================================================
	//					get 메소드 
	//==================================================
	
	/**
	 * 게시물 인덱스
	 * @return
	 */
	public Integer get_atcl_idx(){
		return atcl_idx;
	}
	
	
	/**
	 * 작성자 아이디 
	 * @return
	 */
	public String get_usr_id(){
		return usr_id;
	}
	
	/**
	 * 상위 게시물 인덱스 
	 * @return
	 */
	public Integer get_high_atcl_idx(){
		return high_atcl_idx;
	}
	
	/**
	 * 게시물 제목 
	 * @return
	 */
	public String get_atcl_sbjt(){
		return atcl_sbjt;
	}
	
	/**
	 *게시물 내용 
	 * @return
	 */
	public String get_atcl_conts(){
		return atcl_conts;
	}
	
	/**
	 * 작성 날짜  
	 * @return
	 */
	public String get_reg_date(){
		return reg_date;
	}
	
	
	/**
	 * 게시물 상태 
	 * @return
	 */
	public Integer get_atcl_stus(){
		return atcl_stus;
	}
	
		
	/**
	 * 회사 이름 
	 * @return
	 */
	public String get_cmpny_nm(){
		return cmpny_nm;
	}
	
	
	/**
	 * 처리상태 
	 * @return
	 */
	public Integer get_prcs_stus(){
		return prcs_stus;
	}
	
	
	//==================================================
	//					set 메소드 
	//==================================================
	
	/**
	 * 게시물 인덱스
	 * @return
	 */
	public void set_atcl_idx(Integer atcl_idx){
		this.atcl_idx = atcl_idx;
	}
	
	
	/**
	 * 작성자 아이디 
	 * @return
	 */
	public void set_usr_id(String usr_id){
		this.usr_id = usr_id;
	}
	
	/**
	 * 상위 게시물 인덱스 
	 * @return
	 */
	public void set_high_atcl_idx(Integer high_atcl_idx){
		this.high_atcl_idx = high_atcl_idx;
	}
	
	/**
	 * 게시물 제목 
	 * @return
	 */
	public void set_atcl_sbjt(String atcl_sbjt){
		this.atcl_sbjt = atcl_sbjt;
	}
	
	/**
	 * 게시물 내용 
	 * @param atcl_conts
	 */
	public void set_atcl_conts(String atcl_conts){
		this.atcl_conts = atcl_conts;
	}
	
	/**
	 * 작성 날짜 
	 * @return
	 */
	public void set_reg_date(String reg_date){
		this.reg_date = reg_date;
	}
	
	
	/**
	 * 게시물 상태 
	 * @return
	 */
	public void set_atcl_stus(Integer atcl_stus){
		this.atcl_stus = atcl_stus;
	}
	
	
	/**
	 * 회사 이름
	 * @param cmpny_nm
	 */
	public void set_cmpny_nm(String cmpny_nm){
		this.cmpny_nm = cmpny_nm;
	}
	
	
	/**
	 * 처리 상태 
	 * @param prcs_stus
	 */
	public void set_prcs_stus(Integer prcs_stus){
		this.prcs_stus = prcs_stus;
	}
}
