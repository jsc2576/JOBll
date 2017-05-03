
package com.jobll.web.atclInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class AtclInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private AtclInfoRepository atclInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 */
	
	public int createAtcl(AtclInfo entity){
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	      entity.setReg_date(commonUtil.getCurrentDtime());
	      entity.setAtcl_stus(1);
	      //entity.setCmpny_nm(sessionUtil.getSessionBean().);
	      entity.setPrcs_stus(1);
		
		int qry = atclInfoRepository.createAtcl(entity);
		return qry;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<AtclInfo> findList(AtclInfo entity) throws Exception{
		List<AtclInfo> atcl_list = atclInfoRepository.findList(entity);
		return atcl_list;
	}
	/**
	 * 하나의 데이터 출력 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public AtclInfo findOne(AtclInfo entity) throws Exception{
		entity = atclInfoRepository.findOne(entity);
		return entity;
	}
	
	public Integer pageCnt(AtclInfo entity) throws Exception{
		Integer data = atclInfoRepository.PageCnt(entity);
		return data;
	}

}

