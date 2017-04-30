package com.jobll.web.projectInfo.issueInfo.cmtInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class CmtInfoService {

	@Autowired
	private CmtInfoRepository cmtInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;


	public int create(CmtInfo entity)  throws Exception{
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setCmt_stus("1");
		
		int qry = cmtInfoRepository.create(entity);
		return qry;
	}

	public List<CmtInfo> findAll(CmtInfo entity)  throws Exception{
		List<CmtInfo> list = cmtInfoRepository.findAll(entity);
		return list;
	}

	public CmtInfo findOne(CmtInfo entity)  throws Exception{
		entity = cmtInfoRepository.findOne(entity);
		return entity;
	}
	public int delete(CmtInfo entity)  throws Exception{
		entity.setCmt_stus("0");
		
		int qry = cmtInfoRepository.delete(entity);
		return qry;
	}
	public int update(CmtInfo entity)  throws Exception{
		entity.setReg_date(commonUtil.getCurrentDtime());
		
		int qry = cmtInfoRepository.update(entity);
		return qry;
	}
}