package com.jobll.web.atcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtclService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private AtclRepository atclRepository;
	
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 */
	public List<Atcl> findAll(Atcl entity){
		List<Atcl> atcl_list = atclRepository.findAll(entity);
		return atcl_list;
	}
	
	public List<Atcl> findRcvWait(Atcl entity){
		List<Atcl> atcl_list = atclRepository.findRcvWait(entity);
		return atcl_list;
	}
	
	public List<Atcl> findRcvCmpt(Atcl entity){
		List<Atcl> atcl_list = atclRepository.findRcvCmpt(entity);
		return atcl_list;
	}
	
	public List<Atcl> findPrcsWait(Atcl entity){
		List<Atcl> atcl_list = atclRepository.findPrcsWait(entity);
		return atcl_list;
	}
	
	public List<Atcl> findPrcsCmpt(Atcl entity){
		List<Atcl> atcl_list = atclRepository.findPrcsCmpt(entity);
		return atcl_list;
	}
}
