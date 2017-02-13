<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쇼핑상품업로드페이지</title>
	</head>
	<body>
		<form action="/testFileUpLoadRun" method="post" enctype="multipart/form-data">
        	<input type="button" value="추가" onclick="addUpload()"/>
			<input type="button" value="제거" onclick="delUpload()"/>
			<div id="uploads">
			<p/><input type="file" id="file-upload"  name="uploadFile" /></p>
			<p/><input type="radio" id="file-upload-radio" value ="0" name="repre_img"></p>
			</div>
        	<p><button type="submit">등록</button></p>
		</form>
		<p><a href="/">메인홈페이지가기</a></p>
	</body>
	<script src="/resources/js/jquery-1.9.1.min.js"></script>
	<script src="/resources/js/upLoadTest/product.insertProduct.js"></script>
</html>