package com.jobll.web.attchfile;


import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobll.web.AwsS3Config;
import com.jobll.web.CommonUtil;



@Service
public class AttchFileService {
	
	//protected static final Logger LOGGER = LoggerFactory.getLogger(AttchFileService.class);

	@Autowired
	private AwsS3Config awsS3Config;
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private AttchFileRepository attchFileRepository;
	

	public List<AttchFile> uploadFiles(List<MultipartFile> list, String S3path ) throws Exception{
		List<AttchFile> mlist = new ArrayList<AttchFile>();
		AttchFile uploadFile ;
		String path = S3path;
		for(int i=0;i<list.size();i++){
			//업로드 경로가 정해져있는지 없는지 체크 후 없으면 temp로 이동
			if(path.equals("")){
				uploadFile = this.uploadTemp(list.get(i));
			}else{
				uploadFile = this.upload(list.get(i),path);
			}
			//업로드 체크
			if(uploadFile==null){
				//LOGGER.debug("JSH:IT's WORNG FILE TYPE!!! file name : "+list.get(i).getOriginalFilename());
			}else{
				mlist.add(uploadFile);
				//LOGGER.info(mlist.get(i).getReg_date()+":"+mlist.get(i).getAttch_file_nm()+"is uploaded complete");
			}
		}
		return mlist;
	}

	public AttchFile uploadTemp(MultipartFile file) throws Exception {
		AttchFile result=null ;
		String y = commonUtil.getCurrentDtime().substring(0, 4);
		String md = commonUtil.getCurrentDtime().substring(4, 8);
		result = upload(file, "temp/"+y+"/"+md+"/");
		return result;
	}
	public AttchFile upload(MultipartFile file, String S3path) throws Exception{

		
		
		//aws 스토리지 연결
		//파일 업로드 후 path 저장
		String path = "false";
		if(file.getContentType()==null){
			//LOGGER.debug("파일 형식이 없네요//정수찬이 넘겨주는 request때 생긴 예외처리");
			return null;
		}
		//파일 업로드 할때 밀리초_파일명 형식으로 저장합니다.
		S3path+=(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date(System.currentTimeMillis()))+"_";
		//이것은 실제 업로드 되는 로직부분입니다. type이 이미지나 영상일때만 업로드합니다.
		path = awsS3Config.multipartFileUpload(file, S3path);
		//업로드가 실패되면 경로가 아닌 false가 반환됩니다.
		if(path.equals("false")){
			return null;
		}
		
		AttchFile attchFile = new AttchFile();

		/*
		 * 업로드 완료후 
		 * Attach 정보를 객체에 담습니다.
		 * 파일명, 사이즈, 경로, 타입, 사용자 아이디, 업로드 시간
		 * 그리고 정보를 DB에 넣습니다. 그리고 객체를 반환합니다.
		 */
		attchFile.setAttch_file_nm(file.getOriginalFilename());
		attchFile.setAttch_file_vol((int)file.getSize());
		attchFile.setFile_path(path);
		if(file.getContentType().split("/")[0].equals("video")){
			attchFile.setFile_typ(3);
		}else if(file.getContentType().split("/")[0].equals("image")){
			attchFile.setFile_typ(1);
		}
		attchFile.setReg_date(commonUtil.getCurrentDtime());

		//DB에 정보 저장
		//this.create(attchFile);
		
		
		//DB에 저장된 객체 반환
		return attchFile;
	}
	
	public int create(AttchFile entity) throws Exception {
		int id = attchFileRepository.create(entity);
		return id;
	}

	public List<AttchFile> findAll(AttchFile entity) throws Exception {
		List<AttchFile> list = attchFileRepository.findAll(entity);
		return list;
	}

	public int tempToReal(AttchFile entity, String To) throws Exception {
		/**
		 * entity의 경로를 To로 수정한 후 업데이트 합니다.
		 */
		String [] arr = entity.getFile_path().split("/");
		To+=arr[arr.length-1];
		awsS3Config.copyFileToFrom(To, entity.getFile_path());
		AttchFile finder = entity;
		AttchFile data = new AttchFile();
		data.setFile_path(To);
		int result = this.updateByPath(data, finder);
		
		return result;
	}

	public AttchFile readByIdx(AttchFile entity) throws Exception {
		return attchFileRepository.readByIdx(entity);
	}

	public int updateByIdx(AttchFile entity) throws Exception {
		return attchFileRepository.updateByIdx(entity);
	}

	public int updateByPath(AttchFile data, AttchFile finder) throws Exception {
		return attchFileRepository.updateByPath(data, finder);
	}

	public ResponseEntity<byte[]> getImageResponse(int idx) throws Exception {

		AttchFile finder = new AttchFile();
		finder.setAttch_file_idx(idx);
		InputStream in = awsS3Config.getObjectInputStream(this.readByIdx(finder).getFile_path());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}

	public AttchFile readByPath(AttchFile entity) throws Exception {
		AttchFile result = attchFileRepository.readByPath(entity);
		return result;
	}

}
