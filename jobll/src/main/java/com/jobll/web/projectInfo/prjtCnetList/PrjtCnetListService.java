package com.jobll.web.projectInfo.prjtCnetList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<PrjtCnetList> selectPrjtCnetList(PrjtCnetList entity) throws Exception{
		List<PrjtCnetList> list = prjtCnetListRepository.selectPrjtCnetList(entity);
		return list;
	}
	
	//팀원 리스트 삭제
		public List<PrjtCnetList> deletePrjtCnetList(Integer prjt_idx){
			return prjtCnetListRepository.deletePrjtCnetList(prjt_idx);
		}
	
	//팀원 리스트 입력
	public List<PrjtCnetList> createPrjtCnetList(List<UsrInfo> list, Integer prjt_idx){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<PrjtCnetList> sample = new ArrayList<PrjtCnetList>();
		
		int i =0;
		
		
		for(i=0 ; i<list.size() ; i++){
			PrjtCnetList prjtcnetlist = new PrjtCnetList();
			prjtcnetlist.setPrjt_cnet_list_idx(i+1);
			prjtcnetlist.setUsr_id(list.get(i).getUsr_id());
			prjtcnetlist.setCmpny_idx(list.get(i).getUsr_cmpny_idx());
			prjtcnetlist.setPrjt_idx(prjt_idx);
			sample.add(prjtcnetlist);
		}
		
		if(i!=0){
			map.put("sample", sample);
			prjtCnetListRepository.createPrjtCnetList(map);
		}
		
		return sample;
	}
	

	
	
	
	//유저 리스트 출력
	public List<UsrInfo> selectCnetList(){
		return prjtCnetListRepository.selectCnetList();
	}
	//

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
	
		
	
	public List<UsrInfo> findCmpnyIdx(List<String> prjtCnetInvList){
		return prjtCnetListRepository.findCmpnyIdx(prjtCnetInvList);
	}
	
}
