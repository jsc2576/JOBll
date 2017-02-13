package com.jobll.web.usrinfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cmnUsrInfoRepository")
public class UsrInfoRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	//회원 등록
	public int create(UsrInfo entity) throws Exception{
		int result= sqlSession.insert("com.jobll.usrinfo.UsrInfo.create", entity);
		return result;
	}
}
