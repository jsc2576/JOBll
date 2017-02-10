package com.jobll.web.attchfile;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("attchFile")
public class AttchFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1638273159722849211L;
	
	private int attch_file_idx;					// 첨부파일인덱스
	private String file_path;					// 파일경로
	private String attch_file_nm;				// 첨부파일이
	private int attch_file_vol;					// 첨부파일크기
	private String reg_date;					// 등록날짜
	private int file_typ;						// 파일종류(1:그림, 2:파일, 3:동영상 등등, default:1)
	private String reg_usr_id;					// 등록한사용자아이디
	
	public int getAttch_file_idx() {
		return attch_file_idx;
	}
	public void setAttch_file_idx(int attch_file_idx) {
		this.attch_file_idx = attch_file_idx;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getAttch_file_nm() {
		return attch_file_nm;
	}
	public void setAttch_file_nm(String attch_file_nm) {
		this.attch_file_nm = attch_file_nm;
	}
	public int getAttch_file_vol() {
		return attch_file_vol;
	}
	public void setAttch_file_vol(int attch_file_vol) {
		this.attch_file_vol = attch_file_vol;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getFile_typ() {
		return file_typ;
	}
	public void setFile_typ(int file_typ) {
		this.file_typ = file_typ;
	}
	public String getReg_usr_id() {
		return reg_usr_id;
	}
	public void setReg_usr_id(String reg_usr_id) {
		this.reg_usr_id = reg_usr_id;
	}
	
}
