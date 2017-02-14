<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
 <body>
      <div class="container">
        <div class="HeadLine">
          <h1>회원가입 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form role="form" action = "/usr/make" method="post">
           <div class="form-group">
              <label for="usr_id">아이디</label>
              <input type="text" class="form-control" name="usr_id" placeholder="아이디">
            </div>
            <div class="form-group">
              <label for="usr_pwd">비밀번호</label>
              <input type="password" class="form-control" name="usr_pwd" placeholder="비밀번호">
            </div>
            <div class="form-group">
              <label for="usr_pwd1">비밀번호 확인</label>
              <input type="password" class="form-control" name="usr_pwd" placeholder="비밀번호 확인">
              <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
            </div>
           
            <div class="form-group">
              <label for="usr_nm">이름</label>
              <input type="text" class="form-control" name="usr_nm" placeholder="이름">
            </div>
            <div class="form-group">
              <label for="usr_birth">생년월일</label>
              <input type="text" class="form-control" name="usr_birth" placeholder="생년월일">
            </div>
           	<div class="form-group">
           	<label for="usr_gdr">성별</label><br>
            <input type="radio" id="man" name="usr_gdr" value="1" onclick="checkGdr()">
            <label id="manLb" for="man" class="on">남자 </label>
            <input type="radio" id="woman" name="usr_gdr" value="0" onclick="checkGdr()">
            <label id="manLb" for="woman" class="on">여자 </label>
            </div>
             <div class="form-group">
              <label for="usr_gdr">회사명</label>
              <input type="text" class="form-control" id="usr_cmpny" name="usr_cmpny" placeholder="회사명">
            </div>
            <div class="form-group">
              <label for="usr_email">이메일 주소</label>
              <input type="email" class="form-control" id="usr_email"  name="usr_email" placeholder="이메일 주소">
            </div>
            <div class="form-group">
              <label for="tel_num">전화번호</label>
               <input type="tel" class="form-control" id="tel_num" name="tel_num" placeholder="- 없이 입력해 주세요">
            </div>
            <div class="form-group">
              <label for="mobile_num">핸드폰 번호</label>
               <input type="tel" class="form-control" id="mobile_num"  name="mobile_num" placeholder="- 없이 입력해 주세요">
            </div>
            <div class="form-group">
              <label for="zip_cd">우편번호</label>
               <input type="text" class="form-control" id="zip_cd" name="zip_cd" placeholder="우편번호">
            </div>
            <div class="form-group">
              <label for="norm_addr">주소</label>
               <input type="text" class="form-control" id="norm_addr" name="norm_addr" placeholder="주소">
               <label for="dtl_addr"></label>
               <input type="text" class="form-control" id="dtl_addr"  name="dtl_addr" placeholder="상세주소">
            </div>
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">회원가입<i class="fa fa-check spaceLeft"></i></button>
              <button type="submit" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i></button>
            </div>
          </form>
        </div>
      </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  </body>
</html>