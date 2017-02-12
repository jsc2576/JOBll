package com.jobll.web.usrinfo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("attchFile")
public class UsrInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1638273159722849211L;
	
	private int usr_gdr;					// 유저인덱스
	private String usr_id;					// 사용자 이름
	private String usr_lv;					// 사용자 등급
	private int tel_num;					// 전화번호
	private String mobile_num;				// 휴대폰번호
	private int usr_email;					// 이메일
	private String usr_cmpny;				// 회사명
	private int usr_age;					// 나이
	private String usr_nm;					// 사용자이름
	private String usr_pwd;					// 사용자비밀번호
	private String join_date;				// 가입일자
	private String act_stus;				// 
	private String zip_cd;					// 등록한사용자아이디(유저 프로필 사진 등)
	private String norm_addr;				// 등록한사용자아이디(유저 프로필 사진 등)
	private String dtl_addr;				// 등록한사용자아이디(유저 프로필 사진 등)
	private String usr_birth;				// 등록한사용자아이디(유저 프로필 사진 등)
}
