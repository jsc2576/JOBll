package com.jobll.web.attchfile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(AttchFileService.class);

	@Autowired
	private AwsS3Config awsS3Config;
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private AttchFileRepository attchFileRepository;
	
	/**
	 * 업로드 파일 체크 설정 입니다.
	 */
	public List<AttchFile> uploadFiles(List<MultipartFile> list, AttchFile entity) throws Exception{
		List<AttchFile> mlist = new ArrayList<AttchFile>();
		AttchFile uploadFile ;
		
		for(int i=0;i<list.size();i++){
			uploadFile = this.uploadPathSetting(list.get(i),entity);
			
			//업로드 체크
			if(uploadFile==null){
				LOGGER.debug("Upload error, File name : "+list.get(i).getOriginalFilename());
			}else {
				mlist.add(uploadFile);
			}
		}
		return mlist;
	}
	/**
	 * 업로드 파일 경로 설정 입니다.
	 */
	public AttchFile uploadPathSetting(MultipartFile file , AttchFile entity) throws Exception {
		AttchFile result= entity;
		String y = commonUtil.getCurrentDtime().substring(0, 4);
		String md = commonUtil.getCurrentDtime().substring(4, 8);
		int i = 0;
		
		StringTokenizer file_type  = new StringTokenizer(file.getOriginalFilename());
		String find_file_type = null;
		
		//확장자 분류 조건
		String[] images = {"bmp","rle","jpg","gif","png","psd","pdd","tif","pdf","raw","ai","eps",
				"svg","iff","fpx","frm","pcx","pct","pic","pxr","sct","tga","vda","icb","vst",""};
		String[] videos = {"avi","mp4","mpg","mpeg","mpe","wmv","asf","asx","flv","rm","mov","dat",""};
		String[] audios = {"mp3","ogg","wma","wav","au","rm","mid","flac",""};
		//확장자 추출
		while(file_type.hasMoreTokens()) {  
			find_file_type = file_type.nextToken(".");
        }  
		
		//파일 형식과 년도 월,일에 따른 폴더 경로를 구성합니다.
		while(images[i] != "")
		{
			if(images[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "image/"+y+"/"+md+"/",entity);
				return result;
			}
			i++;
		}
		i = 0;
		while(videos[i] != "")
		{
			if(videos[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "video/"+y+"/"+md+"/",entity);
				return result;
			}
			i++;
		}
		i = 0;
		while(audios[i] != "")
		{
			if(audios[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "audio/"+y+"/"+md+"/",entity);
				return result;
			}
			i++;
		}
		
		result = upload(file, "others/"+y+"/"+md+"/",entity);
		return result;
	}
	/**
	 * 업로드 파일 경로 설정 입니다.
	 */
	public AttchFile upload(MultipartFile file, String S3path, AttchFile entity) throws Exception{
		//aws 스토리지 연결
		//파일 업로드 후 path 저장
		String path = "false";
		
		//파일 형식이 없는 경우
		if(file.getContentType()== null)
			return null;
		
		//파일 업로드 할때 밀리초_파일명 형식으로 저장합니다.
		S3path+=(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date(System.currentTimeMillis()))+"_";
		
		//이것은 실제 업로드 되는 로직부분입니다.
		path = awsS3Config.multipartFileUpload(file, S3path);
		
		//업로드가 실패되면 경로가 아닌 false가 반환됩니다.
		if(path.equals("false")){
			return null;
		}
		
		/*
		 * 업로드 완료후 
		 * Attach 정보를 객체에 담습니다.
		 * 파일명, 사이즈, 경로, 타입, 사용자 아이디, 업로드 시간
		 * 그리고 정보를 DB에 넣습니다. 그리고 객체를 반환합니다.
		 */
		entity.setAttch_file_nm(file.getOriginalFilename());
		entity.setAttch_file_vol((int)file.getSize());
		entity.setFile_path(path);
		if(file.getContentType().split("/")[0].equals("image")){
			entity.setFile_typ(1);
		}
		else if(file.getContentType().split("/")[0].equals("audio")){
			entity.setFile_typ(2);
		}
		else if(file.getContentType().split("/")[0].equals("vedio")){
			entity.setFile_typ(3);
		}
		else
			entity.setFile_typ(4);

		entity.setReg_date(commonUtil.getCurrentDtime());

		//DB에 정보 저장
		this.create(entity);
		
		
		//DB에 저장된 객체 반환
		return entity;
	}
	
	public int create(AttchFile entity) throws Exception {
		int success = attchFileRepository.create(entity);
		return success;
	}
	
	public List<AttchFile> findAll(AttchFile entity) throws Exception {
		List<AttchFile> list = attchFileRepository.findAll(entity);
		return list;
	}
	
	public List<AttchFile> findByUsr(AttchFile entity) throws Exception {
		List<AttchFile> list = attchFileRepository.findByUsr(entity);
		return list;
	}

	public int updateByIdx(AttchFile entity) throws Exception {
		return attchFileRepository.updateByIdx(entity);
	}
}
