package com.jobll.web.dashbrd;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DashBrdService {

	DashBrdRepository dashBrdRepository;
	
	public List<String> findPrjtSbjt(DashBrd entity){
		
		return dashBrdRepository.findPrjtSbjt(entity);
	}
}
