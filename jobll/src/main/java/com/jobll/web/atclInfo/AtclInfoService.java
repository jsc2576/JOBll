package com.jobll.web.atclInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;

@Service
public class AtclInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private AtclInfoRepository atclInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 */
	
	public int createAtcl(AtclInfo entity){
		
		entity.setUsr_id("bbk");
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setAtcl_stus(1);
		entity.setCmpny_nm("미정");
		entity.setPrcs_stus(1);
		
		int qry = atclInfoRepository.createAtcl(entity);
		return qry;
	}
	
	public List<AtclInfo> findAll(AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoRepository.findAll(entity);
		return atcl_list;
	}
	
	public List<AtclInfo> findRcvWait(AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoRepository.findRcvWait(entity);
		return atcl_list;
	}
	
	public List<AtclInfo> findRcvCmpt(AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoRepository.findRcvCmpt(entity);
		return atcl_list;
	}
	
	public List<AtclInfo> findPrcsWait(AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoRepository.findPrcsWait(entity);
		return atcl_list;
	}
	
	public List<AtclInfo> findPrcsCmpt(AtclInfo entity){
		List<AtclInfo> atcl_list = atclInfoRepository.findPrcsCmpt(entity);
		return atcl_list;
	}
}
