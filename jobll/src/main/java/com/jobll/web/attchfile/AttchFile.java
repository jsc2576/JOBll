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
	private String attch_file_nm;				// 첨부파일이름
	private int attch_file_vol;					// 첨부파일크기
	private String reg_date;					// 등록날짜
	private int file_typ;						// 파일종류(1:이미지, 2:오디오, 3:동영상 4:기타 등등(DEFAULT:1))
	private String signed_url;					// CloudFront에서 받아올 URL
	private String usr_id;						// 등록한사용자아이디(유저 프로필 사진 등)
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
	public String getSigned_url() {
		return signed_url;
	}
	public void setSigned_url(String signed_url) {
		this.signed_url = signed_url;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	
	
	
}
