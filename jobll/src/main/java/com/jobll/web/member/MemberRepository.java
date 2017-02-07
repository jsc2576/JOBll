package com.jobll.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public class MemberRepository {

	//@Autowired
	//SqlSession sqlSession;

	public int create(Member entity) throws Exception {
		return 1;
		
	}

}