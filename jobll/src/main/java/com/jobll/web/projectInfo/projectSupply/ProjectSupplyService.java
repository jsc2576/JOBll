package com.jobll.web.projectInfo.projectSupply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.atclInfo.AtclInfo;
import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.usrinfo.UsrInfo;

@Service
public class ProjectSupplyService {
	
	@Autowired
	private ProjectSupplyRepository projectSupplyRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
		
	public int create(ProjectSupply entity) throws Exception{	
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	    entity.setAppr_yn(2);
	    entity.setPrjt_sup_list_idx(projectSupplyRepository.findEnty(entity).size()+1);
	    int qry = projectSupplyRepository.create(entity);
		return qry;
	}
	public List<ProjectInfo> readPrjtSbjtByUsrId(ProjectInfo entity){
		
		entity.setCmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		entity.setPrjt_stus(1);
		
		List<ProjectInfo> list = projectSupplyRepository.readPrjtSbjtByUsrId(entity);
		
		
		return list;
		
	};
	public List<ProjectSupply> findAll(ProjectSupply entity) throws Exception{
		List<ProjectSupply> list = projectSupplyRepository.findAll(entity);
		return list;
	}
	
	public ProjectSupply findOne(ProjectSupply entity) throws Exception{
		entity = projectSupplyRepository.findOne(entity);
		return entity;
	}

}

