package com.jobll.web.member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.member.MemberRepository;
import com.jobll.web.member.Member;

@Service
public class MemberServiceImpl {

	@Autowired
	private MemberRepository memberRepository;
	
	
	public List<HashMap<String, Object>> select(Member entity)throws Exception{
		memberRepository.select(entity);
		return null;
	}
	public List<HashMap<String, Object>> read(Member entity){
		memberRepository.read(entity);
		return null;
	};
	public int create(Member entity){
		memberRepository.create(entity);
		return 0;
	}
	public int edit(Member entity){
		memberRepository.edit(entity);
		return 0;
	};
	public int delete(Member entity){
		memberRepository.delete(entity);
		return 0;
	};
	

}
