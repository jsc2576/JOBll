
package com.jobll.web.projectInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class ProjectInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private ProjectInfoRepository atclInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	

	public int create(ProjectInfo entity){
		
		int qry = atclInfoRepository.create(entity);
		return qry;
	}
}

