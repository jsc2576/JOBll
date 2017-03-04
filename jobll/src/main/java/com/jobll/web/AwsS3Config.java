package com.jobll.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import org.springframework.core.io.ClassPathResource; 
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Component
public class AwsS3Config {
	
	protected static final Logger logger = Logger.getLogger(AwsS3Config.class);
	
	private String accessKey;
	private String secretKey;
	private String bucketName;
	
	private AmazonS3 conn;
	//AWS S3 접속 모듈 입니다.
	public void connectionAwsS3() {
	
		accessKey = "AKIAJKEQIYAL35KYQORA";
		secretKey = "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";
		bucketName = "elasticbeanstalk-ap-northeast-2-190235634467";

		
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);
		
		this.conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint("s3-ap-northeast-2.amazonaws.com");

	}

		public String multipartFileUpload(MultipartFile multipartFile, String S3path) throws IOException {
			
			/* aws server용 코드
			File file = new File("/var/lib/tomcat8/webapps/ROOT/resources/images/"+multipartFile.getOriginalFilename());
			*/
			//File file = new File(multipartFile.getOriginalFilename());
			File file = new File("/var/lib/tomcat8/webapps/ROOT/resources/images/"+multipartFile.getOriginalFilename());
			file.createNewFile(); 
			
			FileOutputStream fos = new FileOutputStream(file);
		    fos.write(multipartFile.getBytes());
		    fos.close(); 
			    
			    
			if (fileUpload(file, S3path)) {
				//s3업로드 후 서버에 생성된 파일을 삭제 합니다.
				file.delete();
				return (S3path + file.getName());
			} else {
				return "false";
			}
		}

		/**
		 * 파일 업로드입니다. 실제로 업로드 하기 위해서는 이 메소드가 반드시 호출되야합니다.
		 * 
		 * @param file
		 *            파일
		 * @param S3path
		 *            문자열
		 * @return
		 * @throws IOException
		 */
		public boolean fileUpload(File file, String S3path) throws IOException {
			this.connectionAwsS3();
			FileInputStream fis;
			String path = S3path + file.getName();
			if (file == null || (fis = new FileInputStream(file)) == null) {
				return false;
			} else if (conn.putObject(new PutObjectRequest(this.bucketName, path, fis, new ObjectMetadata())) == null) {
				fis.close();
				return false;
			} else {
				fis.close();
				return true;
			}
		}
}