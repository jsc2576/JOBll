package com.jobll.web.projectInfo.issueInfo.cmtInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.hstyInfo.*;

@Service
public class CmtInfoService {

	@Autowired
	private CmtInfoRepository cmtInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	@Autowired
	private HstyInfoService hstyInfoService;

	public int create(CmtInfo entity)  throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setCmt_stus(1);
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		result = hstyInfoService.create(hsty);
		
		int qry = cmtInfoRepository.create(entity);
		return qry;
	}

	public List<CmtInfo> findAll(CmtInfo entity)  throws Exception{
		List<CmtInfo> list = cmtInfoRepository.findAll(entity);
		
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setReg_date(commonUtil.getDividedTime(list.get(i).getReg_date()));
		}
		
		return list;
	}

	public CmtInfo findOne(CmtInfo entity)  throws Exception{
		entity = cmtInfoRepository.findOne(entity);
		
		entity.setReg_date(commonUtil.getDividedTime(entity.getReg_date()));
		
		return entity;
	}
	public int delete(CmtInfo entity)  throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setCmt_stus(0);
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		result = hstyInfoService.create(hsty);
		
		int qry = cmtInfoRepository.delete(entity);
		return qry;
	}
	public int update(CmtInfo entity)  throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setReg_date(commonUtil.getCurrentDtime());
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		result = hstyInfoService.create(hsty);
		
		int qry = cmtInfoRepository.update(entity);
		return qry;
	}
}