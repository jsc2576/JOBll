package com.jobll.web.cmpnyinfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CmpnyInfoRepository {
	@Autowired
    SqlSession sqlSession;

	public String createCmpnyInfo(String cmpny_nm){
		sqlSession.insert("com.jobll.web.cmpnyinfo.create", cmpny_nm);
		return cmpny_nm;
	}
	
	public List<String> deleteCmpnyInfo(List<String> deleteCmpnyName) {
		sqlSession.selectList("com.jobll.web.cmpnyinfo.delete", deleteCmpnyName);
		return deleteCmpnyName ;
	}
	
	
}
