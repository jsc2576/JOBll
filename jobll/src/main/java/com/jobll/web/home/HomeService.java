package com.jobll.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobll.web.attchfile.AttchFile;
import com.jobll.web.attchfile.AttchFileService;
import com.jobll.web.home.HomeRepository;
import com.jobll.web.home.Home;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HomeService {

	@Autowired
	HomeRepository homeRepository;
	
	@Autowired
	private AttchFileService attchFileService;

	public int create(Home entity, List<MultipartFile> files) throws Exception {
		Random random = new Random();
		entity.setTest_idx(random.nextInt(1000) + 1);
		
		//첨부파일 등록
		//List<AttchFile> attchFile = new ArrayList<AttchFile>();
		//리스트 객체에서 객채로 형변환 
		
		
		return homeRepository.create(entity);

	}

}
