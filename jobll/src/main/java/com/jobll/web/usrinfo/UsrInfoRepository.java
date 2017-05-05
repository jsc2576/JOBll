package com.jobll.web.usrinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.jobll.web.cmpnyinfo.CmpnyInfo;
import com.jobll.web.projectInfo.ProjectInfo;
@Repository("usr_info")
public class UsrInfoRepository {
	
	@Autowired
    SqlSession sqlSession;
	
	public List<UsrInfo> selectAllUser() {
		List<UsrInfo> selectList = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.selectAllUser");	
		return selectList ;
	}
	public List<CmpnyInfo> selectCmpny() {
		List<CmpnyInfo> selectList = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.selectCmpny");	
		return selectList ;
	}
	public CmpnyInfo selectCmpnyOne(UsrInfo entity){
	
		CmpnyInfo sel = sqlSession.selectOne("com.jobll.web.usrinfo.UsrInfo.selectCmpnyOne", entity);
		return sel;
	}
	public UsrInfo selectOne(UsrInfo entity) {
		UsrInfo sel = sqlSession.selectOne("com.jobll.web.usrinfo.UsrInfo.selectOne", entity);
		return sel;
	}
	
	public List<ProjectInfo> readPrjtSbjtByUsrId(UsrInfo entity) {
		
		List<ProjectInfo> selectList = new ArrayList<ProjectInfo>();
		selectList  = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.readPrjtSbjt",entity);
		return selectList ;
	}
	public List<HashMap<String, Object>> select() {
		
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.select");
		return selectList ;
	}
	
	public List<HashMap<String, Object>> read(UsrInfo entity){
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.read",entity);
		return selectList ;
	};
	
	public int create(UsrInfo entity){
		
		int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.create",entity);
		return test;
	}
	
	public int edit(UsrInfo entity){
		
		int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.edit",entity);
		return test;
	}

	public int delete(UsrInfo entity){
	
	int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.delete",entity);
	return test;
}
	public int checkId(UsrInfo entity){
		int test = sqlSession.selectOne("com.jobll.web.usrinfo.UsrInfo.checkId",entity.getUsr_id());
		return test;
	}
	public List<UsrInfo> selectUserToCmpny(UsrInfo entity){
		return sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.selectUserToCmpny",entity);	
	};
	public int updateToLv(UsrInfo entity){
		int test = sqlSession.update("com.jobll.web.usrinfo.UsrInfo.updateToLv",entity);
		return test;
	}
}
