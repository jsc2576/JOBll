package com.jobll.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.jobll.web.home.Home;
import com.jobll.web.member.MemberRepository;
import com.jobll.web.member.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public interface MemberService {

	
	public List<HashMap<String, Object>> select(Member entity) throws Exception;
	public List<HashMap<String, Object>> read(Member entity);
	public int create(Member entity);
	public int edit(Member entity);
	public int delete(Member entity);

}
