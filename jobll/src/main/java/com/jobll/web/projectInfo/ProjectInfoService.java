
package com.jobll.web.projectInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.hstyInfo.*;
import com.jobll.web.cmpnyinfo.*;

@Service
public class ProjectInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private ProjectInfoRepository projectInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	@Autowired
	private HstyInfoService hstyInfoService;
	@Autowired
	private CmpnyInfoService cmpnyInfoService;
	

	public int create(ProjectInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setPrjt_stus(1);
		entity.setReg_date(commonUtil.getCurrentDtime());
		
		result = projectInfoRepository.create(entity);
				
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setCmpny_idx(entity.getCmpny_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		cmpny_nm.setCmpny_idx(entity.getCmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + entity.getPrjt_sbjt() + " 프로젝트를 생성함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		
		
		return result;
	}
	
	public int delete (ProjectInfo entity) throws Exception{
		
		int result;
		
		entity = projectInfoRepository.findOne(entity);
		
		result = projectInfoRepository.delete(entity);
		
		HstyInfo hsty = new HstyInfo();
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setCmpny_idx(entity.getCmpny_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		cmpny_nm.setCmpny_idx(entity.getCmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + entity.getPrjt_sbjt() + " 프로젝트를 삭제(비활성화)함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		
		return result;
	}
	public int modify (ProjectInfo entity) throws Exception{
		
		int result;
		
		ProjectInfo temp = new ProjectInfo();
		
		temp = projectInfoRepository.findOne(entity);
		
		commonUtil.getDividedTime(temp.getReg_date());
		
		result = projectInfoRepository.modify(entity);
		
		HstyInfo hsty = new HstyInfo();
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(temp.getPrjt_idx());
		hsty.setCmpny_idx(temp.getCmpny_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		
		CmpnyInfo cmpny_nm = new CmpnyInfo();
		cmpny_nm.setCmpny_idx(temp.getCmpny_idx());
		
		cmpny_nm = cmpnyInfoService.findOne(cmpny_nm);
		
		
		String conts_val = sessionUtil.getSessionBean().getUsr_nm() + "(" + sessionUtil.getSessionBean().getUsr_id() +
							") 가 "+ cmpny_nm.getCmpny_nm() + " 고객사의 " + temp.getPrjt_sbjt() + " 프로젝트를 " + 
							entity.getPrjt_sbjt() +"프로젝트로 수정함";
		
		hsty.setHsty_conts(conts_val);
		result = hstyInfoService.create(hsty);
		
		
		return result;
	}
	
	public List<ProjectInfo> findList(ProjectInfo entity) throws Exception{
		
		if(entity.getSelect_typ() > 2)
		entity.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		
		List<ProjectInfo> project_list = projectInfoRepository.findList(entity);
		for(int i = 0; i < project_list.size(); i++)
		{
			project_list.get(i).setReg_date(commonUtil.getDividedTime(project_list.get(i).getReg_date()));
		}
		return project_list;
	}
	
	
	
	public ProjectInfo findOne(ProjectInfo entity) throws Exception{
		
		entity = projectInfoRepository.findOne(entity);
		return entity;
	}
	
	public List<ProjectInfo> find(ProjectInfo entity) throws Exception{
		if(entity.getSelect_typ() > 2)
		entity.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		else
		{
		}
		List<ProjectInfo> list = projectInfoRepository.find(entity);
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setReg_date(commonUtil.getDividedTime(list.get(i).getReg_date()));
		}
		return list;
	}
	
	public int checkAuth() throws Exception{
		return sessionUtil.getSessionBean().getUsr_lv();
	}
	public UsrInfo getUsrIdAndLv() throws Exception{
		UsrInfo entity = new UsrInfo();
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setUsr_lv(sessionUtil.getSessionBean().getUsr_lv());
		
		return entity;
	}
}

