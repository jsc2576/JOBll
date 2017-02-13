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
	 * 업로드 파일 체그 설정 입니다.
	 */
	public List<AttchFile> uploadFiles(List<MultipartFile> list) throws Exception{
		List<AttchFile> mlist = new ArrayList<AttchFile>();
		AttchFile uploadFile ;
		
		for(int i=0;i<list.size();i++){
			uploadFile = this.uploadPathSetting(list.get(i));
			
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
	public AttchFile uploadPathSetting(MultipartFile file) throws Exception {
		AttchFile result= null;
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
		

		while(images[i] != "")
		{
			if(images[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "image/"+y+"/"+md+"/");
				return result;
			}
			i++;
		}
		i = 0;
		while(videos[i] != "")
		{
			if(videos[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "video/"+y+"/"+md+"/");
				return result;
			}
			i++;
		}
		i = 0;
		while(audios[i] != "")
		{
			if(audios[i].equalsIgnoreCase(find_file_type)) {
				result = upload(file, "audio/"+y+"/"+md+"/");
				return result;
			}
			i++;
		}
		
		result = upload(file, "others/"+y+"/"+md+"/");
		return result;
	}
	/**
	 * 업로드 파일 경로 설정 입니다.
	 */
	public AttchFile upload(MultipartFile file, String S3path) throws Exception{
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
		if(file.getContentType().split("/")[0].equals("image")){
			attchFile.setFile_typ(1);
		}
		else if(file.getContentType().split("/")[0].equals("audio")){
			attchFile.setFile_typ(2);
		}
		else if(file.getContentType().split("/")[0].equals("vedio")){
			attchFile.setFile_typ(3);
		}
		else
			attchFile.setFile_typ(4);
		
		//test용 임시 idx 지정
		attchFile.setUsr_id("bbk");
		attchFile.setSigned_url("");
		
		attchFile.setReg_date(commonUtil.getCurrentDtime());

		//DB에 정보 저장
		this.create(attchFile);
		
		
		//DB에 저장된 객체 반환
		return attchFile;
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

	public File getDownLoadResponse(AttchFile entity) throws Exception {

		InputStream in = awsS3Config.getObjectInputStream(entity.getFile_path());
		
		File file = new File("temp");
		
		OutputStream outStream = new FileOutputStream(file);
		
		byte[] buf = new byte[1024];
	      int len = 0;
	      // 끝까지 읽어들이면서 File 객체에 내용들을 쓴다
	      while ((len = in.read(buf)) > 0){
	         outStream.write(buf, 0, len);
	      }
	      // Stream 객체를 모두 닫는다.
	      outStream.close();
	      in.close();

		return file;
	}

	public AttchFile readByPath(AttchFile entity) throws Exception {
		AttchFile result = attchFileRepository.readByPath(entity);
		return result;
	}

}
