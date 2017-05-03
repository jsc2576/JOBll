package com.jobll.web.hstyInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class HstyInfoService {

	@Autowired
	private HstyInfoRepository hstyInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;


	public int create(HstyInfo entity)  throws Exception{
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		int qry = hstyInfoRepository.create(entity);
		return qry;
	}

	public List<HstyInfo> findAll(HstyInfo entity)  throws Exception{
		List<HstyInfo> list = hstyInfoRepository.findAll(entity);
		return list;
	}

	public HstyInfo findOne(HstyInfo entity)  throws Exception{
		entity = hstyInfoRepository.findOne(entity);
		return entity;
	}

}