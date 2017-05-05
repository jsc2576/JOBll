package com.jobll.web.qst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QstService {

	@Autowired
	QstRepository qstRepository;
	
	public List<Qst> findQstList(Qst entity){
		return qstRepository.findQstList(entity);
	}
	
	public Integer findQstListCnt(Qst entity){
		return qstRepository.findQstListCnt(entity);
	}
}
