
package com.jobll.web.projectInfo.issueinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class IssueinfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private IssueinfoRepository issueInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 */
	
	public int create(IssueInfo entity){
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	    entity.setReg_date(commonUtil.getCurrentDtime());
	    entity.setAtcl_stus("1");
	    entity.setStrt_date("20120102030405");
		entity.setAtcl_typ("1");
	    
		int qry = issueInfoRepository.create(entity);
		return qry;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<IssueInfo> findList(IssueInfo entity) throws Exception{
		List<IssueInfo> atcl_list = issueInfoRepository.findList(entity);
		return atcl_list;
	}
	/**
	 * 하나의 데이터 출력 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public IssueInfo findOne(IssueInfo entity) throws Exception{
		entity = issueInfoRepository.findOne(entity);
		return entity;
	}
	
	public int delete(IssueInfo entity) throws Exception{
		
		entity.setAtcl_stus("0");
	   
		int qry = issueInfoRepository.delete(entity);
		return qry;
	}
	
	public int update(IssueInfo entity) throws Exception{
		
		IssueInfo update_data = this.findOne(entity);
		
		update_data.setReg_date(commonUtil.getCurrentDtime());
		update_data.setAtcl_sbjt(entity.getAtcl_sbjt());
		update_data.setAtcl_conts(entity.getAtcl_conts());
	    
	   
		int qry = issueInfoRepository.update(update_data);
		return qry;
	}
}

