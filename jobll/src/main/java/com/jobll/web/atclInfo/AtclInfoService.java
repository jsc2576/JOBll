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
		
		entity.set_usr_id("bbk");
		entity.set_reg_date(commonUtil.getCurrentDtime());
		entity.set_atcl_stus(1);
		entity.set_cmpny_nm("미정");
		entity.set_prcs_stus(1);
		
		int qry = atclInfoRepository.createAtcl(entity);
		return qry;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<AtclInfo> findList(AtclInfo entity, Integer find_nm){
		List<AtclInfo> atcl_list = atclInfoRepository.findList(entity, find_nm);
		return atcl_list;
	}
	

}
