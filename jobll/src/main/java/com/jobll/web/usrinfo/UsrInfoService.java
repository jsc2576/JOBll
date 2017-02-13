package com.jobll.web.usrinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobll.web.usrinfo.UsrInfo;

@Service
public class UsrInfoService{

	@Autowired
	private UsrInfoRepository usrInfoRepository;
	

	public List<HashMap<String, Object>> select(){
		return usrInfoRepository.select();
	}
	
	public List<HashMap<String, Object>> read(UsrInfo entity){
		
		return usrInfoRepository.read(entity);
	}
	
	public int create(UsrInfo entity){
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
