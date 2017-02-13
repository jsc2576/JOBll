package com.jobll.web.usrinfo;

import java.util.HashMap;
import java.util.List;

import com.jobll.web.usrinfo.UsrInfo;


public interface UsrInfoService {
	public List<HashMap<String, Object>> select(UsrInfo entity);
	public List<HashMap<String, Object>> read(UsrInfo entity);
	public int create(UsrInfo entity);
	public int edit(UsrInfo entity);
	public int delete(UsrInfo entity);
}
