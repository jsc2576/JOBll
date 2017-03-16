package com.jobll.web.prjtCnetList;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.usrinfo.UsrInfo;


@Service
public class PrjtCnetListService{

	@Autowired
	private PrjtCnetListRepository prjtCnetListRepository;
		
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private SessionUtil sessionUtil;
		

	//팀원 리스트 출력
	public List<PrjtCnetList> selectPrjtCnetList(){
		return prjtCnetListRepository.selectPrjtCnetList();
	}
	
	
	
	//팀원 리스트 출력
	public List<UsrInfo> selectCnetList(){
		return prjtCnetListRepository.selectCnetList();
	}
	//
	public int createPrjtCnetList(PrjtCnetList entity){
		
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
	      //entity.setCmpny_nm(sessionUtil.getSessionBean().getUsr_cmpny());
	      entity.setPrjt_idx(1);
		
		int qry = prjtCnetListRepository.createPrjtCnetList(entity);
		return qry;
	}
	
	//
	 // 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 // @param entity
	 // @return
	 //
	public List<PrjtCnetList> findList(PrjtCnetList entity) throws Exception{
		List<PrjtCnetList> prjtCnetList_list = prjtCnetListRepository.findList(entity);
		return prjtCnetList_list;
	}
	//
	 // 하나의 데이터 출력 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색)
	 // @param entity
	 // @return
	 ///
	public PrjtCnetList findOne(PrjtCnetList entity) throws Exception{
		entity = prjtCnetListRepository.findOne(entity);
		return entity;
	}
	

	public List<HashMap<String, Object>> select(){
		return prjtCnetListRepository.select();
	}
		
	public List<HashMap<String, Object>> read(PrjtCnetList entity){
			
		return prjtCnetListRepository.read(entity);	
	}

		
	public int create(PrjtCnetList entity){
			
		entity.setPrjt_cnet_list_idx(1);
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());//수정필요
		entity.setPrjt_idx(1);
		entity.setCmpny_idx(1);//임시, 반드시  수정 필요
		entity.setPrjt_cnet_list_idx_stus(1);
		int test = prjtCnetListRepository.create(entity);
		
		return test;
	}
		
	public int edit(PrjtCnetList entity){
		int test = prjtCnetListRepository.edit(entity);
		return test;
	}
		
	public int delete(PrjtCnetList entity){
		int test = prjtCnetListRepository.delete(entity);
		return test;
	}
}
