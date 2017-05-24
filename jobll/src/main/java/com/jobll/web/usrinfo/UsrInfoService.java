package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.cmpnyinfo.CmpnyInfo;
import com.jobll.web.projectInfo.ProjectInfo;
import com.jobll.web.usrinfo.UsrInfo;
import com.jobll.web.usrinfo.UsrInfoRepository;
import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;

@Service
public class UsrInfoService{
	
	@Autowired
	private SessionUtil sessionUtil;
	
	@Autowired
	private UsrInfoRepository usrInfoRepository;
	
	@Autowired
	private CommonUtil commonUtil;
	
	public List<UsrInfo> selectUserByCmpny(UsrInfo entity) {
		return usrInfoRepository.selectUserByCmpny(entity);
	}
	
	public List<UsrInfo> selectAllUser(UsrInfo entity) {
		return usrInfoRepository.selectAllUser(entity);
	}
	public List<CmpnyInfo> selectCmpny(){
		return usrInfoRepository.selectCmpny();
	}
	public CmpnyInfo selectCmpnyOne(UsrInfo entity){
		//if(entity.getUsr_id().isEmpty())
			entity.setUsr_cmpny_idx(sessionUtil.getSessionBean().getUsr_cmpny_idx());
		return usrInfoRepository.selectCmpnyOne(entity);
	}
	public List<HashMap<String, Object>> select(){
		return usrInfoRepository.select();
	}
	public List<ProjectInfo> readPrjtSbjtByUsrId(UsrInfo entity){
		if(entity.getUsr_id().isEmpty())
			entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return usrInfoRepository.readPrjtSbjtByUsrId(entity);
		
	};
	public UsrInfo selectOne(UsrInfo entity){
		if(entity.getUsr_id().isEmpty())
			entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return usrInfoRepository.selectOne(entity);
	}
	public UsrInfo readOne(UsrInfo entity){
		entity.setUsr_id(sessionUtil.getSessionBean().getUsr_id());
		return usrInfoRepository.selectOne(entity);
	}
	public UsrInfo findOne(UsrInfo entity){
		return usrInfoRepository.selectOne(entity);
	}
	public List<HashMap<String, Object>> read(UsrInfo entity){
		
		return usrInfoRepository.read(entity);
	}
	
	public int create(UsrInfo entity){
		
		entity.setAct_stus(1);
		entity.setReg_date(commonUtil.getCurrentDtime());
		entity.setUsr_lv(1);
		//entity.setUsr_cmpny_idx(1);
		//entity.setUsr_cmpny_nm(1);//임시, 반드시  수정 필요
		int test = usrInfoRepository.create(entity);
		
		return test;
	}
	
	public int edit(UsrInfo entity){
		int test = usrInfoRepository.edit(entity);
		return test;
	}
	
	public int delete(UsrInfo entity){
		int test = usrInfoRepository.delete(entity);
		return test;
	}
	
	public List<UsrInfo> selectUserToCmpny(UsrInfo entity){
			return usrInfoRepository.selectUserToCmpny(entity);	
		};
		public int updateToLv(UsrInfo entity){
			int result = usrInfoRepository.updateToLv(entity);
			return result;
		}//
	public List<UsrInfo> find(UsrInfo entity){
		return usrInfoRepository.find(entity);	
	};
}
