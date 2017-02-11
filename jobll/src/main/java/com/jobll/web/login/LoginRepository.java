package com.jobll.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.domain.UserVo;
import com.jobll.web.home.Home;

@Repository
public class LoginRepository {

	@Autowired
	SqlSession sqlSession;
	
	public UserVo getUser(String userId)throws Exception {
		UserVo result = sqlSession.selectOne("com.jobll.web.login.select",userId);
		return result;
	}
	
	
	

}