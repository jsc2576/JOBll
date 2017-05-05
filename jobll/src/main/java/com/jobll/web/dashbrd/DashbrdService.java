package com.jobll.web.dashbrd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashbrdService {

	@Autowired
	private DashbrdRepository dashbrdRepository;
	
	public List<String> findCuntPrjtSbjt(Dashbrd entity){
		List<String> prjt_sbjt = dashbrdRepository.findCuntPrjtSbjt(entity);
		return prjt_sbjt;
	}
	
	public List<String> findCentPrjtSbjt(Dashbrd entity){
		List<String> prjt_sbjt = dashbrdRepository.findCentPrjtSbjt(entity);
		return prjt_sbjt;
	}
}
