package com.jobll.web.dashbrd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.SessionUtil;

@Service
public class DashbrdService {

	@Autowired
	private DashbrdRepository dashbrdRepository;
	
	@Autowired
	private SessionUtil sessionUtil;
	
	public List<Dashbrd> findCuntPrjtSbjt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return dashbrdRepository.findCuntPrjtSbjt(entity);
		
	}
	
	public List<Dashbrd> findCentPrjtSbjt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return dashbrdRepository.findCentPrjtSbjt(entity);
	}
	
	public Integer[] AtclCnt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return dashbrdRepository.AtclCnt(entity);
	}
}
