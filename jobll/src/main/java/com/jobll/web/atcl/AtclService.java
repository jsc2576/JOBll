package com.jobll.web.atcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtclService {
	
	/*
	 * repository 객체 
	 */
	@Autowired
	private AtclRepository atclRepository;
	
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<Atcl> findList(Atcl entity, Integer find_nm){
		List<Atcl> atcl_list = atclRepository.findList(entity, find_nm);
		return atcl_list;
	}
	

}
