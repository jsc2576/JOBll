<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
 <body>
      <div class="container">
        <div class="HeadLine">
          <h1>ȸ������ </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form role="form" action = "/usr/make" method="post">
           <div class="form-group">
              <label for="usr_id">���̵�</label>
              <input type="text" class="form-control" name="usr_id" placeholder="���̵�">
            </div>
            <div class="form-group">
              <label for="usr_pwd">��й�ȣ</label>
              <input type="password" class="form-control" name="usr_pwd" placeholder="��й�ȣ">
            </div>
            <div class="form-group">
              <label for="usr_pwd1">��й�ȣ Ȯ��</label>
              <input type="password" class="form-control" name="usr_pwd" placeholder="��й�ȣ Ȯ��">
              <p class="help-block">��й�ȣ Ȯ���� ���� �ٽ��ѹ� �Է� �� �ּ���</p>
            </div>
           
            <div class="form-group">
              <label for="usr_nm">�̸�</label>
              <input type="text" class="form-control" name="usr_nm" placeholder="�̸�">
            </div>
            <div class="form-group">
              <label for="usr_birth">�������</label>
              <input type="text" class="form-control" name="usr_birth" placeholder="�������">
            </div>
           	<div class="form-group">
           	<label for="usr_gdr">����</label><br>
            <input type="radio" id="man" name="usr_gdr" value="1" onclick="checkGdr()">
            <label id="manLb" for="man" class="on">���� </label>
            <input type="radio" id="woman" name="usr_gdr" value="0" onclick="checkGdr()">
            <label id="manLb" for="woman" class="on">���� </label>
            </div>
             <div class="form-group">
              <label for="usr_gdr">ȸ���</label>
              <input type="text" class="form-control" id="usr_cmpny" name="usr_cmpny" placeholder="ȸ���">
            </div>
            <div class="form-group">
              <label for="usr_email">�̸��� �ּ�</label>
              <input type="email" class="form-control" id="usr_email"  name="usr_email" placeholder="�̸��� �ּ�">
            </div>
            <div class="form-group">
              <label for="tel_num">��ȭ��ȣ</label>
               <input type="tel" class="form-control" id="tel_num" name="tel_num" placeholder="- ���� �Է��� �ּ���">
            </div>
            <div class="form-group">
              <label for="mobile_num">�ڵ��� ��ȣ</label>
               <input type="tel" class="form-control" id="mobile_num"  name="mobile_num" placeholder="- ���� �Է��� �ּ���">
            </div>
            <div class="form-group">
              <label for="zip_cd">�����ȣ</label>
               <input type="text" class="form-control" id="zip_cd" name="zip_cd" placeholder="�����ȣ">
            </div>
            <div class="form-group">
              <label for="norm_addr">�ּ�</label>
               <input type="text" class="form-control" id="norm_addr" name="norm_addr" placeholder="�ּ�">
               <label for="dtl_addr"></label>
               <input type="text" class="form-control" id="dtl_addr"  name="dtl_addr" placeholder="���ּ�">
            </div>
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">ȸ������<i class="fa fa-check spaceLeft"></i></button>
              <button type="submit" class="btn btn-warning">�������<i class="fa fa-times spaceLeft"></i></button>
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