<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원탈퇴</title>
  <link href="/resources/css/usrInfo/usrInfoJoin.css" rel="stylesheet">
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>


</head>
<body>

      <div class="container">
        <div class="HeadLine">
          <h1>회원탈퇴 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form id="usr_del" action = "/usrInfo/usrDel/send" method="post">
			
			<div class="form-group">
  				<span class="FB666666">&nbsp;&nbsp;&nbsp; ${ usr_id }님 회원탈퇴를 원하실 경우, 본인확인을 위해 비밀번호를 한번 더 입력해 주세요.</span>
            </div>
			<div class="form-group">
              <input type="hidden" id="usr_id" name="usr_id" value = ${ usr_id }>
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
           <div class="form-group text-center">
              <button type="submit" id="usr_del" class="btn btn-info">회원탈퇴<i class="fa fa-check spaceLeft"></i></button>
              <A href="/"  class="btn btn-warning">회원탈퇴 취소<i class="fa fa-times spaceLeft"></i></A>
            </div>
           
        </form>
        </div>
      </div>


  </body></html>