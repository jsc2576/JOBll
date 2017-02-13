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
    
    <!-- 이세연 add start-->
    <script type="text/javascript">
	function popupOpen(){
		var popUrl = "/login.do";	//팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);
	}
	</script>
	<link rel="stylesheet" type="text/css" href="/resources/css/usr/usr.css">
    <!-- 이세연 add end-->
    
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
      <div class="login-button">
      	<div class="col-md-2 col-xs-6 logo">
            <A href="javascript:popupOpen();">로그인</A>
        </div>
      </div>
      <div class="usrin-button">
      	<div class="col-md-2 col-xs-6 logo">
            <A href="/usrin">회원가입</A>
        </div>
      </div>
      <div class="usrout-button">
      	<div class="col-md-2 col-xs-6 logo">
            <A href="/usrout">회원탈퇴</A>
        </div>
      </div>
      <div class="menu-wrap">
        <nav class="menu">
          <div class="menu-list">
            <A href="/" class="active">
              <span>Home</span>
            </a>
            <A href="/usr" >
              <span>회원정보</span>
            </a>
            <A href="/atcl" >
              <span>게시판</span>
            </a>
             <A href="/fileUpLoad" >
              <span>파일첨부</span>
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
                    <a href = "/testmember">JOBll</a>
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

        <!--ABOUT-->
        <section id="about">
          <div class="col-md-6 col-xs-12 no-pad">
            <div class="bg-about">
            	
            </div>
          </div>
          <div class="col-md-6 col-sm-12 col-xs-12 white-col">
            <div class="row">
              <!--OWL CAROUSEL2-->
              <div class="owl-carousel2">
                <div class="col-md-12">
                  <div class="wrap-about">
                    <div class="w-content">
                      <p class="head-about">
                        we are
                      </p>
                      
                      <h5 class="name">
                        jobll
                      </h5>
                    </div>
                  </div>
                </div>
              
                <div class="col-md-12 col-sm-12 col-xs-12 white-col">
                  <div class="row">
                    <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12">
                      <div class="wrap-about">
                        <table class="w-content">
                          <tr>
                            <td class="title">Name </td>
                            <td class="break">:</td>
                            <td> jobll</td>
                          </tr>
                         
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--/.OWL CAROUSEL2 END-->
            </div>
          </div>
        </section>
        <!--/.ABOUT END-->

        
      </div>
    <!--/.CONTENT-WRAP END-->
    </div>
    

    <script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
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
  </body>
</html>
