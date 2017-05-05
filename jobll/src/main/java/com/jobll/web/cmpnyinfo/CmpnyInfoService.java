package com.jobll.web.cmpnyinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList;
import com.jobll.web.projectInfo.prjtCnetList.PrjtCnetListRepository;
import com.jobll.web.usrinfo.UsrInfo;

@Service
public class CmpnyInfoService {
	
	@Autowired
	private CmpnyInfoRepository cmpnyInfoRepository;
	
	//회사 입력
	public String createCmpnyInfo(String cmpny_nm){
		String temp;
		temp=cmpnyInfoRepository.createCmpnyInfo(cmpny_nm);
		return temp;
	}
	
	//회사 삭제
	public List<String> deleteCmpnyInfo(List<String> deleteCmpnyName){
		List<String> temp= cmpnyInfoRepository.deleteCmpnyInfo(deleteCmpnyName);
		return temp;
	}
	
	public List<CmpnyInfo> findAll(CmpnyInfo entity) {
		return cmpnyInfoRepository.findAll(entity);
	}

}
