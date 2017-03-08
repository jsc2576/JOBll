package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoRepository;

import com.jobll.web.CommonUtil;
//38 line 수정필요

@Service
public class UsrInfoService{

	@Autowired
	private UsrInfoRepository usrInfoRepository;
	
	@Autowired
	private CommonUtil commonUtil;


	public List<HashMap<String, Object>> select(){
		return usrInfoRepository.select();
	}
	
	public List<HashMap<String, Object>> read(UsrInfo entity){
		
		return usrInfoRepository.read(entity);
	}
	
	public int create(UsrInfo entity){
		
		entity.setAct_stus(1);
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setUsr_lv(1);
		entity.setUsr_cmpny_nm(1);//임시, 반드시  수정 필요
		int test = usrInfoRepository.create(entity);
		
		return test;
	}
	
	public int edit(UsrInfo entity){
		int test = usrInfoRepository.edit(entity);
		return test;
	}
	
	public int delete(UsrInfo entity){
		int test = usrInfoRepository.delete(entity);
		return test;
	}
}
