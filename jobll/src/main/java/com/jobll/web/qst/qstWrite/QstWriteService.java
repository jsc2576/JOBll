package com.jobll.web.qst.qstWrite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.SessionUtil;

@Service
public class QstWriteService {

	@Autowired
	QstWriteRepository qstWriteRepository;
	@Autowired
	SessionUtil sessionUtil;
	
	public int create(QstWrite entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setReg_date((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date(System.currentTimeMillis())));
		return qstWriteRepository.create(entity);
	}
}
