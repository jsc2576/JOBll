package com.jobll.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.member.MemberRepository;
import com.jobll.web.member.Member;
import java.util.Random;

@Service
public class MemberService {

	@Autowired
	MemberRepository merberRepository;

	

}
