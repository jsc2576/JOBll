
package com.jobll.web.projectInfo.issueInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.hstyInfo.*;

@Service
public class IssueInfoService {
	
	/*
	 * repository 객
	 */
	@Autowired
	private IssueInfoRepository issueInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SessionUtil sessionUtil;
	@Autowired
	private HstyInfoService hstyInfoService;
	
	/**
	 * 모든 데이터 검색 
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	
	public int create(IssueInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	    entity.setReg_date(commonUtil.getCurrentDtime());
	    entity.setAtcl_stus("1");
	    entity.setStrt_date("20120102030405");
		entity.setAtcl_typ("1");
	    
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		result = hstyInfoService.create(hsty);
		
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
		int result;
		HstyInfo hsty = new HstyInfo();
		
		entity.setAtcl_stus("0");
		
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		result = hstyInfoService.create(hsty);
		
		int qry = issueInfoRepository.delete(entity);
		return qry;
	}
	
	public int update(IssueInfo entity) throws Exception{
		int result;
		HstyInfo hsty = new HstyInfo();
		
		IssueInfo update_data = this.findOne(entity);
		
		update_data.setReg_date(commonUtil.getCurrentDtime());
		update_data.setAtcl_sbjt(entity.getAtcl_sbjt());
		update_data.setAtcl_conts(entity.getAtcl_conts());
	    
		hsty.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		hsty.setPrjt_idx(entity.getPrjt_idx());
		hsty.setHsty_date(commonUtil.getCurrentDtime());
		hsty.setHsty_typ(1);
		hsty.setAtcl_idx(entity.getAtcl_idx());
		result = hstyInfoService.create(hsty);
		
	   
		int qry = issueInfoRepository.update(update_data);
		return qry;
	}
}

