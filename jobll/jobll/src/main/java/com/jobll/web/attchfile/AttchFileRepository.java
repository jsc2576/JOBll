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
		int result =sqlSession.insert("com.youanmy.web.attchfile.AttchFile.create", entity); 
		return result;
	}
	//파일 리스트 뽑기
	public List<AttchFile> findAll(AttchFile entity) throws Exception {
		List<AttchFile> list = sqlSession.selectList("com.youanmy.web.attchfile.AttchFile.findAll",entity);
		return list;
	}
	//파일 정보 객체 하나 뽑기
	public AttchFile readByIdx(AttchFile entity) throws Exception {
		AttchFile result = sqlSession.selectOne("com.youanmy.web.attchfile.AttchFile.readByIdx",entity);
		return result;
	}
	//파일 정보 업데이트
	public int updateByIdx(AttchFile entity) throws Exception {
		int result = sqlSession.update("com.youanmy.web.attchfile.AttchFile.updateByIdx",entity);
		// TODO Auto-generated method stub
		return result;
	}
	//path정보로 path를 업데이트 합니다.
	//map형태로 보냅니다.
	public int updateByPath(AttchFile data, AttchFile finder) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data",data);
		map.put("finder",finder);
		int result = sqlSession.update("com.youanmy.web.attchfile.AttchFile.updateByPath",map);
		return result;
	}
	public AttchFile readByPath(AttchFile entity) throws Exception {
		AttchFile result = sqlSession.selectOne("com.youanmy.web.attchfile.AttchFile.readByPath",entity);
		return result;
	}
}
