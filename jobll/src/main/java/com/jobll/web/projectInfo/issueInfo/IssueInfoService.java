
package com.jobll.web.projectInfo.issueInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.cmpnyinfo.*;
import com.jobll.web.hstyInfo.*;
import com.jobll.web.projectInfo.*;

@Service
public class IssueInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private IssueInfoRepository issueInfoRepository;
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
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	
	public int create(IssueInfo entity) throws Exception{
		
		int result;
		HstyInfo hsty = new HstyInfo();
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	    entity.setReg_date(commonUtil.getCurrentDtime());
	    entity.setAtcl_stus(1);
	    
	    result = issueInfoRepository.create(entity);
	    
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(2);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의" +
							entity.getAtcl_sbjt() + "이슈를 등록함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		
		
		return result;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<IssueInfo> findList(IssueInfo entity) throws Exception{
		List<IssueInfo> list = issueInfoRepository.findList(entity);
		
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setReg_date(commonUtil.getDividedTime(list.get(i).getReg_date()));
		}
		
		return list;
	}
	/**
	 * 하나의 데이터 출력 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public IssueInfo findOne(IssueInfo entity) throws Exception{
		entity = issueInfoRepository.findOne(entity);
		
		entity.setReg_date(commonUtil.getDividedTime(entity.getReg_date()));
		
		return entity;
	}
	
	public int delete(IssueInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		
		entity.setAtcl_stus(0);
		
		result = issueInfoRepository.delete(entity);

		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(2);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의" +
							entity.getAtcl_sbjt() + "이슈를 삭제함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		return result;
	}
	
	public int update(IssueInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		ProjectInfo prjt_sbjt = new ProjectInfo();
		
		IssueInfo prev_data = new IssueInfo();
		
		prev_data = issueInfoRepository.findOne(entity);
		
		result = issueInfoRepository.update(entity);

		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setAtcl_idx(entity.getAtcl_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(2);
		
		
		cmpny_nm.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		prjt_sbjt.setPrjt_idx(entity.getPrjt_idx());
		prjt_sbjt = projectInfoService.findOne(prjt_sbjt);
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + prjt_sbjt.getPrjt_sbjt() + " 프로젝트의" +
							prev_data.getAtcl_sbjt() + "이슈를"+entity.getAtcl_sbjt()+"로(으로) 수정함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
	   
		
		return result;
	}
}

