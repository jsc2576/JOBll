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
		int qry = hstyInfoRepository.create(entity);
		return qry;
	}

	public List<HstyInfo> findAll(HstyInfo entity)  throws Exception{
		List<HstyInfo> list = hstyInfoRepository.findAll(entity);
		return list;
	}
	
	public List<HstyInfo> findByPrjt(HstyInfo entity)  throws Exception{
		List<HstyInfo> list = hstyInfoRepository.findByPrjt(entity);
		
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setHsty_date(commonUtil.getDividedTime(list.get(i).getHsty_date()));
		}
		return list;
	}

	public HstyInfo findOne(HstyInfo entity)  throws Exception{
		entity = hstyInfoRepository.findOne(entity);
		return entity;
	}

}