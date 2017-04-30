
package com.jobll.web.projectInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.atclInfo.AtclInfo;

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
	

	public int create(ProjectInfo entity) throws Exception{
		
		entity.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		entity.setPrjt_stus("1");
		entity.setReg_date(commonUtil.getCurrentDtime());
		if(entity.getHigh_prjt_idx() == null)
			entity.setPrjt_lv(1);
		else
		{
			ProjectInfo high_project = projectInfoRepository.findChildren(entity);
			entity.setPrjt_lv(high_project.getPrjt_lv()+1);
		}
		
		int qry = projectInfoRepository.create(entity);
		return qry;
	}
	
	public List<ProjectInfo> findList(ProjectInfo entity) throws Exception{
		
		entity.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		List<ProjectInfo> project_list = projectInfoRepository.findList(entity);
		return project_list;
	}
public ProjectInfo findOne(ProjectInfo entity) throws Exception{
		
		entity = projectInfoRepository.findOne(entity);
		return entity;
	}
}

