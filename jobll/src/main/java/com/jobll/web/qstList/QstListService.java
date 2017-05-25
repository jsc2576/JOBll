package com.jobll.web.qstList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.projectInfo.projectSupply.ProjectSupply;

@Service
public class QstListService {

	@Autowired
	private QstListRepository qstListRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	
	public int create(QstList entity)  throws Exception{
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setQst_stus(1);
		entity.setQst_idx(qstListRepository.findAll(entity).size()+1);
		int qry = qstListRepository.create(entity);
		return qry;
	}

	public List<QstList> findAll(QstList entity)throws Exception{
		List<QstList> list = qstListRepository.findAll(entity);
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setReg_date(commonUtil.getDividedTime(list.get(i).getReg_date()));
		}
		return list;
	}
	
	public List<QstList> findMyQst(QstList entity)throws Exception{
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		
		List<QstList> list = qstListRepository.findMyQst(entity);
		
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setReg_date(commonUtil.getDividedTime(list.get(i).getReg_date()));
		}
		return list;
	}

	public QstList findOne(QstList entity) throws Exception{
		entity = qstListRepository.findOne(entity);
		
		entity.setReg_date(commonUtil.getDividedTime(entity.getReg_date()));
		return entity;
	}
	
	public int update(QstList entity) throws Exception{
		entity.setQst_stus(2);
		int result = qstListRepository.update(entity);
		
		return result;
	}
}
