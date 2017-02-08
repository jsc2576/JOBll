package com.jobll.web.member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public interface MemberRepository {

	public List<HashMap<String, Object>> select(Member entity) throws Exception;;
	public List<HashMap<String, Object>> read(Member entity);
	public int create(Member entity);
	public int edit(Member entity);
	public int delete(Member entity);

}