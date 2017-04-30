package com.jobll.web.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminRepository {

	@Autowired
	private SqlSession sqlSession;

}