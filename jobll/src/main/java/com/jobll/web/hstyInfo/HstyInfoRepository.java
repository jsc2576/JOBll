package com.jobll.web.hstyInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HstyInfoRepository {

	@Autowired
	private SqlSession sqlSession;


	public int create(HstyInfo entity) throws Exception{
		int qry = sqlSession.insert("com.jobll.web.hstyInfo.HstyInfo.create", entity);
		return qry;
	}

	public List<HstyInfo> findAll(HstyInfo entity)  throws Exception{
		List<HstyInfo> list = sqlSession.selectList("com.jobll.web.hstyInfo.HstyInfo.findAll", entity);
		return list;
	}

	public HstyInfo findOne(HstyInfo entity)  throws Exception{
		HstyInfo data = sqlSession.selectOne("com.jobll.web.hstyInfo.HstyInfo.findOne", entity);
		return data;
	}

}