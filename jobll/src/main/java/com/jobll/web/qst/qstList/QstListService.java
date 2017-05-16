package com.jobll.web.qst.qstList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QstListService {

	@Autowired
	QstListRepository qstListRepository;
	
	public List<QstList> findQstList(QstList entity){
		return qstListRepository.findQstList(entity);
	}
	
	public Integer findQstListCnt(QstList entity){
		return qstListRepository.findQstListCnt(entity);
	}
	
	public List<QstList> findAnsQstList(QstList entity){
		List<QstList> data = qstListRepository.findAnsQstList(entity);
		return data;
	}
}
