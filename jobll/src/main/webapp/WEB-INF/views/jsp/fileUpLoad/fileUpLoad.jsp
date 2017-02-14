<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>JOBll - Project</title>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" Content="text/html; charset=utf-8" />
    <!--Fav-->
    <link href="images/favicon.ico" rel="shortcut icon">
    
    <!--styles-->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/owl.carousel.css" rel="stylesheet">
    <link href="/resources/css/owl.theme.css" rel="stylesheet">
    <link href="/resources/css/magnific-popup.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/responsive.css" rel="stylesheet">
    
    <!--fonts google-->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700' rel='stylesheet' type='text/css'>
    
    <!--[if lt IE 9]>
       <script type="text/javascript" src="/resources/js/html5shiv.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!--PRELOADER
     <div id="preloader">
      <div id="status">
        <img alt="logo" src="/resources/images/logo-big.png">
      </div>
    </div> 
    PRELOADER END-->

    <!--HEADER -->
    <div class="header">
      <div class="for-sticky">
        <!--LOGO-->
        <div class="col-md-2 col-xs-6 logo">
          <a href="/"><img alt="logo" class="logo-nav" src="/resources/images/logo.png"></a>
        </div>
        <!--/.LOGO END-->
      </div>
      <div class="menu-wrap">
        <nav class="menu">
          <div class="menu-list">
             <A href="/" class="active">
              <span>Home</span>
            </a>
            <A href="/myUsrInfo" >
              <span>회원정보</span>
            </a>
            <A href="/usr" >
              <span>회원목록</span>
            </a>
            <A href="usrInfoJoin" >
              <span>회원가입</span>
            </a>
            <A href="/atcl" >
              <span>게시판</span>
            </a>
             <A href="/fileUpLoad" >
              <span>파일업로드</span>
            </a>
          </div>
        </nav>
        <button class="close-button" id="close-button">Close Menu</button>
      </div>
      <button class="menu-button" id="open-button">
        <span></span>
        <span></span>
        <span></span>
      </button><!--/.for-sticky-->
    </div>
    <!--/.HEADER END-->
    
    <!--CONTENT WRAP-->
    <div class="content-wrap">
      <!--CONTENT-->
      <div class="content">
        <!--HOME-->
        <section id="home">
          <div class="container">
            <div class="row">
              <div class="wrap-hero-content">
                  <div class="hero-content">
                    <a href = "/testmember">파일업로드</a>
                    <br>
                    <span class="typed"></span>
                  </div>
              </div>
              <div class="mouse-icon margin-20">
                <div class="scroll"></div>
              </div>
            </div>
          </div>
        </section>
      
        <!--/.HOME END-->

        <!--FILE UP LOAD -->
        <section id="file-upload-tag">
          <div class="col-md-12 col-xs-12 no-pad">
          <form id="commonForm" name="commonForm"></form>
          <form id ="fileUpLoadForm"  method="post" enctype="multipart/form-data">
        	<input type="button" value="추가" onclick="addUpload()"/>
			<input type="button" value="제거" onclick="delUpload()"/>
			<div id="uploads">
			<p><input type="file" id="file-upload"  name="uploadFile" /></p>
			</div>
        	<p><button onclick ="fileUpload()">등록</button></p>
		</form>
		<button onclick = "fileUploadView()">파일리스트 보기</button>
		<div id = "list"></div>
          </div>
        </section>
        <!--/.FILE UP LOAD END-->
      </div>
     </div>

    <script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.form.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.appear.js" type="text/javascript"></script>
    <script src="/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/resources/js/classie.js" type="text/javascript"></script>
    <script src="/resources/js/owl.carousel.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.magnific-popup.min.js" type="text/javascript"></script>
    <script src="/resources/js/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="/resources/js/masonry.js" type="text/javascript"></script>
    <script src="/resources/js/smooth-scroll.min.js" type="text/javascript"></script>
    <script src="/resources/js/typed.js" type="text/javascript"></script>
    <script src="/resources/js/main.js" type="text/javascript"></script>
    <script src="/resources/js/fileUpLoad/fileUpLoad.js" type="text/javascript"></script>
  </body>
</html>
