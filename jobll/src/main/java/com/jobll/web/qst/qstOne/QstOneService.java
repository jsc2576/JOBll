package com.jobll.web.qst.qstOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QstOneService {

	@Autowired
	QstOneRepository qstOneRepository;
	
	public QstOne findQstOne(QstOne entity){
		return qstOneRepository.findQstOne(entity);
	}
}
