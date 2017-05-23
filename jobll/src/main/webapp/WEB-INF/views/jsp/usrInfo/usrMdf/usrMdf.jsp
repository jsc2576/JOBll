<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  <head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>개인정보 변경</title>
  <link href="/resources/css/usrInfo/usrInfoJoin.css" rel="stylesheet">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
  <script src="/resources/js/usrInfo/usrInfoJoin.js" type="text/javascript"></script>

</head>-->
<body>

      <div class="container">
        <div class="HeadLine">
          <h1>개인정보 변경 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form id="usr_make" action = "/usrInfo/usrMdf/send" method="post">
           <div class="form-group">
              <input type="hidden" id="usr_id" name="usr_id" value = ${ MdfEntity.usr_id }>
            </div>
           
           
            <div class="form-group">
              <label for="usr_nm">이름</label>
              <input type="text" class="form-control" id="usr_nm" name="usr_nm" placeholder="이름" value = ${ MdfEntity.usr_nm }>
            </div>
          
           
            
            <div class="form-group">
              <label for="usr_email">이메일 주소</label>
              <input type="email" class="form-control" id="usr_email"  name="usr_email" placeholder="이메일 주소" value = ${ MdfEntity.usr_email }>
            </div>
            <div class="form-group">
              <label for="tel_num">전화번호</label>
               <input type="tel" class="form-control" id="tel_num" name="tel_num" placeholder="- 없이 입력해 주세요" value = ${ MdfEntity.tel_num }>
            </div>
            <div class="form-group">
              <label for="mobile_num">핸드폰 번호</label>
               <input type="text" class="form-control" id="mobile_num"  name="mobile_num" placeholder="- 없이 입력해 주세요" value = ${ MdfEntity.mobile_num }>
            </div>
          
 
            
			<div class="form-group" id="list">  
 		    </div>
           

            <div class="form-group text-center">
              <button type="submit" id="usr_make" class="btn btn-info">변경<i class="fa fa-check spaceLeft"></i></button>
              <A href="/"  class="btn btn-warning">변경취소<i class="fa fa-times spaceLeft"></i></A>
            </div>
          </form>
        </div>
      </div>


  </body></html>