package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public interface UsrInfoRepository {
	public List<HashMap<String, Object>> select(UsrInfo entity);
	public List<HashMap<String, Object>> read(UsrInfo entity);
	public int create(UsrInfo entity);
	public int edit(UsrInfo entity);
	public int delete(UsrInfo entity);
}
