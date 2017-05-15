
package com.jobll.web.projectInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.hstyInfo.*;
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
	

	public int create(ProjectInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setPrjt_stus("1");
		entity.setReg_date(commonUtil.getCurrentDtime());
		if(entity.getHigh_prjt_idx() == null)
			entity.setPrjt_lv(1);
		else
		{
			ProjectInfo high_project = projectInfoRepository.findChildren(entity);
			entity.setPrjt_lv(high_project.getPrjt_lv()+1);
		}
				
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		result = hstyInfoService.create(hsty);
		
		int qry = projectInfoRepository.create(entity);
		
		return qry;
	}
	
	public List<ProjectInfo> findList(ProjectInfo entity) throws Exception{
		
		List<ProjectInfo> project_list = projectInfoRepository.findList(entity);
		return project_list;
	}
	
	public ProjectInfo findOne(ProjectInfo entity) throws Exception{
		
		entity = projectInfoRepository.findOne(entity);
		return entity;
	}
	
	public List<ProjectInfo> findToUsr() throws Exception{
		UsrInfo entity = new UsrInfo();
		entity.setUsr_cmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		List<ProjectInfo> project_list = projectInfoRepository.findToUsr(entity);
		
		return project_list;
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

