package com.jobll.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

@Component
public class AwsS3Config {
	
	protected static final Logger logger = Logger.getLogger(AwsS3Config.class);
	
	private String accessKey;
	private String secretKey;
	private String bucketName;
	
	private AmazonS3 conn;
	
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
	
	// Bucket List
		public List<Bucket> getBucketList() {
			return conn.listBuckets();
		}

		// Bucket 생성
		public Bucket createBucket(String bucketName) {
			return conn.createBucket(bucketName);
		}

		// 파일 삭제
		public void fileDelete(String bucketName, String fileName) {
			conn.deleteObject(bucketName, fileName);
		}

		// 파일 URL
		public String getFileURL(String fileName) {
			return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(this.bucketName, fileName)).toString();

		}

		public String upload(MultipartFile multipartFile, String S3path) {

			return "";
		}
		
		public String multipartFileUpload(MultipartFile multipartFile, String S3path) throws IOException {
			
			String path = "D:/test"+"/"+multipartFile.getOriginalFilename();
			File file = new File(path);
			multipartFile.transferTo(file);
			if (fileUpload(file, S3path)) {
				// return getMPFileURL(multipartFile,S3path);
				// 미리 서명 받은 url을 반환받아야 할때 사용되는데
				// 현재는 쓰이지 않고 경로와 파일명만 반환됩니다.
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
			} else if (conn.putObject(this.bucketName, path, fis, new ObjectMetadata()) == null) {
				fis.close();
				return false;
			} else {
				fis.close();
				return true;
			}
		}

		/**
		 * 여러개의 멀티파일을 업로드 하기 위해 만든 메소드입니다. 반드시 사용하지 않아도 되는 메소드입니다.
		 * 
		 * @param fileList
		 * @param S3path
		 * @return
		 * @throws IOException
		 */
		public boolean fileListUpload(List<MultipartFile> fileList, String S3path) throws IOException {

			List<MultipartFile> list = fileList;
			boolean result = false;

			if (fileList == null || fileList.size() == 0) {
				return result;
			}

			for (int i = 0; i < list.size(); i++) {
				if ((result = multipartFileUpload(list.get(i), S3path).equals("true"))) {
					continue;
				} else {
					break;
				}
			}
			return result;
		}

		/**
		 * 다운받을 수 있는 미리 서명받은 메소드입니다. 인증된 기간은 현재 10년이며 소스에서 수정가능합니다.
		 * 
		 * @param multipartFile
		 * @param S3path
		 * @return
		 */
		public String getMPFileURL(MultipartFile multipartFile, String S3path) {
			this.connectionAwsS3();
			java.util.Date expiration = new java.util.Date();
			long msec = expiration.getTime();
			msec += 1000 * 60 * 60 * 24 * 365 * 10; // 10년
			expiration.setTime(msec);

			GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(this.bucketName, S3path + multipartFile.getOriginalFilename());
			generatePresignedUrlRequest.setExpiration(expiration);

			String url = conn.generatePresignedUrl(generatePresignedUrlRequest).toString();

			return url;

		}

		/**
		 * 실제 데이터 위치를 기반으로 복사를 합니다.
		 * 
		 * @param To
		 * @param From
		 * @return
		 */
		public String copyFileToFrom(String To, String From) {
			this.connectionAwsS3();
			try {
				CopyObjectRequest copyObjRequest = new CopyObjectRequest(this.bucketName, From, this.bucketName, To);
				System.out.println("Copying object.");
				if (conn.copyObject(copyObjRequest) == null) {
					return "false";
				} else {
					return To;
				}

			} catch (AmazonServiceException ase) {
				System.out.println("Caught an AmazonServiceException, " + "which means your request made it " + "to Amazon S3, but was rejected with an error " + "response for some reason.");
				System.out.println("Error Message:    " + ase.getMessage());
				System.out.println("HTTP Status Code: " + ase.getStatusCode());
				System.out.println("AWS Error Code:   " + ase.getErrorCode());
				System.out.println("Error Type:       " + ase.getErrorType());
				System.out.println("Request ID:       " + ase.getRequestId());
			} catch (AmazonClientException ace) {
				System.out.println("Caught an AmazonClientException, " + "which means the client encountered " + "an internal error while trying to " + " communicate with S3, "
						+ "such as not being able to access the network.");
				System.out.println("Error Message: " + ace.getMessage());
			}
			return "false";

		}

		public InputStream getObjectInputStream(String path) {
			this.connectionAwsS3();
			S3Object s3object = conn.getObject(new GetObjectRequest(this.bucketName, path));
			return s3object.getObjectContent();

			/*
			 * GetObjectRequest rangeObjectRequest = new GetObjectRequest(
			 * bucketName, key); rangeObjectRequest.setRange(0, 10); S3Object
			 * objectPortion = s3Client.getObject(rangeObjectRequest);
			 * 
			 * displayTextInputStream(objectPortion.getObjectContent());
			 */

		}
		
		
	
}