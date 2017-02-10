package com.jobll.web.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public interface UserRepository {

	public List<HashMap<String, Object>> select(User entity) throws Exception;;
	public List<HashMap<String, Object>> read(User entity);
	public int create(User entity);
	public int edit(User entity);
	public int delete(User entity);

}