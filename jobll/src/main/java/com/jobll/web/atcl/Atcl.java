package com.jobll.web.atcl;

public class Atcl {

	//==================================================
	//				atcl_info table column 
	//==================================================
	
	private int atcl_idx; //게시물 인덱스 
	private String usr_id; // 유저 아이디 
	private int high_atcl_idx; //상위 게시물 인덱스 
	private String atcl_sbjt; //게시물 제목 
	private String atcl_conts; //게시물 내용 
	private String reg_date; //작성 날짜 
	private int atcl_stus; //1: 활성, 2: 비활성 (default: 1) 
	
	
	
	
	//==================================================
	//					get 메소드 
	//==================================================
	
	/**
	 * 게시물 인덱스
	 * @return
	 */
	public int get_atcl_idx(){
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
	public int get_high_atcl_idx(){
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
	public int get_atcl_stus(){
		return atcl_stus;
	}
	
	
	
	
	
	//==================================================
	//					set 메소드 
	//==================================================
	
	/**
	 * 게시물 인덱스
	 * @return
	 */
	public void set_atcl_idx(int atcl_idx){
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
	public void set_high_atcl_idx(int high_atcl_idx){
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
	public void set_atcl_stus(int atcl_stus){
		this.atcl_stus = atcl_stus;
	}
}
