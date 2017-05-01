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
		List<Dashbrd> prjt_sbjt = dashbrdRepository.findCuntPrjtSbjt(entity);
		return prjt_sbjt;
	}
	
	public List<Dashbrd> findCentPrjtSbjt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		List<Dashbrd> prjt_sbjt = dashbrdRepository.findCentPrjtSbjt(entity);
		return prjt_sbjt;
	}
	
	public Integer AtclTotCnt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		Integer tot_cnt = dashbrdRepository.AtclTotCnt(entity);
		return tot_cnt;
	}
	
	public Integer AtclRmnCnt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		Integer rmn_cnt = dashbrdRepository.AtclRmnCnt(entity);
		return rmn_cnt;
	}
	
	public Integer AtclEndCnt(Dashbrd entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		Integer end_cnt = dashbrdRepository.AtclEndCnt(entity);
		return end_cnt;
	}
}
