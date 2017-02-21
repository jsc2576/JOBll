package com.jobll.web.atclInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.session.SessionUtil;

@Service
public class AtclInfoService {
	
	@Autowired
	private AtclInfoRepository atclInfoRepository;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
    private SessionUtil sessionUtil;
	
	/**
	 * session을 통한 usr_id, 현재시간, 게시글 상태, 회사정보(추후 구현)을 입력 후 db로 통신합니다.
	 * @param entity
	 * @return integer
	 */
	public int createAtcl(AtclInfo entity){
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setAtcl_stus(1);
		entity.setCmpny_nm(sessionUtil.getSessionBean().getUsr_cmpny());
		entity.setPrcs_stus(1);
		
		int qry = atclInfoRepository.createAtcl(entity);
		return qry;
	}
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 * @param entity
	 * @return
	 */
	public List<AtclInfo> findList(AtclInfo entity) throws Exception{
		List<AtclInfo> atcl_list = atclInfoRepository.findList(entity);
		return atcl_list;
	}
}
