package com.jobll.web.projectSupply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.atclInfo.AtclInfo;

@Service
public class ProjectSupplyService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private ProjectSupplyRepository projectSupplyRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 */
	
	public int create(ProjectSupply entity) throws Exception{
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	    entity.setAppr_yn("2");  
		
		int qry = projectSupplyRepository.create(entity);
		return qry;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<ProjectSupply> findList(ProjectSupply entity) throws Exception{
		List<ProjectSupply> projectSupply_list = projectSupplyRepository.findList(entity);
		return projectSupply_list;
	}
	/**
	 * 하나의 데이터 출력 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public ProjectSupply findOne(ProjectSupply entity) throws Exception{
		entity = projectSupplyRepository.findOne(entity);
		return entity;
	}

}

