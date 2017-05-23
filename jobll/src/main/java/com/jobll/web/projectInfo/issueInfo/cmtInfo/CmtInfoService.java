package com.jobll.web.projectInfo.issueInfo.cmtInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.cmpnyinfo.CmpnyInfo;
import com.jobll.web.cmpnyinfo.CmpnyInfoService;
import com.jobll.web.hstyInfo.*;
import com.jobll.web.projectInfo.*;
import com.jobll.web.projectInfo.issueInfo.*;

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
	@Autowired
	private CmpnyInfoService cmpnyInfoService;
	@Autowired
	private ProjectInfoService projectInfoService;
	@Autowired
	private IssueInfoService issueInfoService;
	

	public int create(CmtInfo entity)  throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		IssueInfo atcl_sbjt = new IssueInfo();
		
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setCmt_stus(1);
		
		result = cmtInfoRepository.create(entity);
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(3);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		atcl_sbjt.setAtcl_idx(entity.getAtcl_idx());
		atcl_sbjt = issueInfoService.findOne(atcl_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의 " +
							atcl_sbjt.getAtcl_sbjt() + " 이슈의 댓글을 등록함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		return result;
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
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		IssueInfo atcl_sbjt = new IssueInfo();
		CmtInfo prev_data = new CmtInfo();
		
		prev_data = cmtInfoRepository.findOne(entity);
		
		entity.setCmt_stus(0);
		
		result = cmtInfoRepository.delete(entity);
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(prev_data.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(3);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		atcl_sbjt.setAtcl_idx(prev_data.getAtcl_idx());
		atcl_sbjt = issueInfoService.findOne(atcl_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의 " +
							atcl_sbjt.getAtcl_sbjt() + " 이슈의 댓글을 삭제함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		return result;
	}
	public int update(CmtInfo entity)  throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		IssueInfo atcl_sbjt = new IssueInfo();
		CmtInfo prev_data = new CmtInfo();
		
		prev_data = cmtInfoRepository.findOne(entity);
		
		entity.setReg_date(commonUtil.getCurrentDtime());
		
		result = cmtInfoRepository.update(entity);
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(prev_data.getAtcl_idx());
		hsty.setCmt_idx(entity.getCmt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(3);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		atcl_sbjt.setAtcl_idx(prev_data.getAtcl_idx());
		atcl_sbjt = issueInfoService.findOne(atcl_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의 " +
							atcl_sbjt.getAtcl_sbjt() + " 이슈의 댓글을 수정함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		return result;
	}
}