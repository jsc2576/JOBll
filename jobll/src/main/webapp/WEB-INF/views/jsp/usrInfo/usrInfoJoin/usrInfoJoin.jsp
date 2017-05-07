<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원가입</title>
  <link href="/resources/css/usrInfo/usrInfoJoin.css" rel="stylesheet">
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
  <script src="/resources/js/usrInfo/usrInfoJoin.js" type="text/javascript"></script>

</head>
<body>

      <div class="container">
        <div class="HeadLine">
          <h1>회원가입 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form id="usr_make" action = "/usrInfo/join" method="post">
           <div class="form-group">
              <label for="usr_id">아이디</label>
              <input type="text" class="form-control" id="usr_id" name="usr_id" placeholder="아이디">
            </div>
            <div class="form-group">
              <label for="usr_pwd">비밀번호</label>
              <input type="password" class="form-control" id="usr_pwd" name="usr_pwd" placeholder="비밀번호">
            </div>
            <div class="form-group">
              <label for="usr_pwd1">비밀번호 확인</label>
              <input type="password" class="form-control" id="chk_pwd" name="chk_pwd" placeholder="비밀번호 확인">
               <div>
               <font name="err_pwd" size="2" color="red"></font>
               <font name="cor_pwd" size="2" color="green"></font>
               </div> <br>
            </div>
           
            <div class="form-group">
              <label for="usr_nm">이름</label>
              <input type="text" class="form-control" id="usr_nm" name="usr_nm" placeholder="이름">
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
               <input type="text" class="form-control" id="mobile_num"  name="mobile_num" placeholder="- 없이 입력해 주세요">
            </div>
          
 
            
			<div class="form-group" id="list">  
 		    </div>
           

            <div class="form-group text-center">
              <button type="submit" id="usr_make" class="btn btn-info">회원가입<i class="fa fa-check spaceLeft"></i></button>
              <button type="submit" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i></button>
            </div>
          </form>
        </div>
      </div>


  </body></html>