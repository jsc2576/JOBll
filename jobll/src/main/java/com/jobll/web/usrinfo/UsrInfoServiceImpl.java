package com.jobll.web.usrinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobll.web.usrinfo.UsrInfo;

@Service
public class UsrInfoServiceImpl {

	private UsrInfoRepository usrInfoRepository;
	public void setusrInfoRepository(UsrInfoRepository usrInfoRepository){
		this.usrInfoRepository = usrInfoRepository;
	}
	
	public List<HashMap<String, Object>> select(UsrInfo entity){
		return usrInfoRepository.select(entity);
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
