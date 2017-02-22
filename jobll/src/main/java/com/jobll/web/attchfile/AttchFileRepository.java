package com.jobll.web.attchfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("cmnAttchFileRepository")
public class AttchFileRepository {
	protected static final Logger LOGGER = Logger.getLogger(AttchFileRepository.class);
	
	@Autowired
    SqlSession sqlSession;
	
	//파일 업로드
	public int create(AttchFile entity) throws Exception {
		int result =sqlSession.insert("com.jobll.web.attchfile.AttchFile.create", entity); 
		return result;
	}
	//파일 리스트 뽑기
	public List<AttchFile> findAll(AttchFile entity) throws Exception {
		List<AttchFile> list = sqlSession.selectList("com.jobll.web.attchfile.AttchFile.findAll",entity);
		return list;
	}
	//usr_id를 통한 파일 리스트 뽑기
	public List<AttchFile> findByUsr(AttchFile entity) throws Exception {
		List<AttchFile> list = sqlSession.selectList("com.jobll.web.attchfile.AttchFile.findByUsr",entity);
		return list;
	}
	//ref_idx를 통한 파일 리스트 뽑기
	public List<AttchFile> readByIdx(AttchFile entity) throws Exception {
		List<AttchFile> list = sqlSession.selectList("com.jobll.web.attchfile.AttchFile.readByIdx",entity);
		return list;
	}
	//파일 정보 업데이트
	public int updateByIdx(AttchFile entity) throws Exception {
		int result = sqlSession.update("com.jobll.web.attchfile.AttchFile.updateByIdx",entity);
		// TODO Auto-generated method stub
		return result;
	}
}
