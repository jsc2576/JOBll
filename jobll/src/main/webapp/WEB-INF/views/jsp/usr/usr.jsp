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
      <div class="menu-wrap">
        <nav class="menu">
          <div class="menu-list">
       		<A href="/" class="active">
              <span>Home</span>
            </a>
            <A href="/usr/myUsrInfo" >
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
            <A href="editor" >
              <span>글쓰기</span>
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
                    <a href = "/testmember">회원정보</a>
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

        <!--user START -->
        <section id="user-info-tag">
        <div class="col-md-12 col-md-offset--1">
        	<p> </p>
			<table class="type01">
				<thead>
            		<tr>
                      	<th scope="cols"></th>
                		<th scope="cols">번호</th>
                		<th scope="cols">등급</th>
                		<th scope="cols">회사</th>
                		<th scope="cols">이름</th>
                		<th scope="cols">가입날짜</th>
                      	<th scope="cols">수정</th>
             		</tr>
             	</thead>
             	<tbody>
            		<tr>
                        <td scope="row"><input type="checkbox" name="check" value="1"></td>
                		<td scope="row">1</td>
                		<td scope="row">ex</td>
                		<td scope="row">ex</td>
                		<td scope="row">ex</td>
                		<td scope="row">2000.xx.xx</td>
                      	<td scope="row"> <a href="modify.jsp">수정</a></td>
             		</tr>
             		<tr>
                        <td scope="row" class="even"> <input type="checkbox" name="check" value="1"></td>
                		<td scope="row" class="even">2</td>
                		<td scope="row" class="even">ex2</td>
                		<td scope="row" class="even">ex2</td>
                		<td scope="row" class="even">ex2</td>
                		<td scope="row" class="even">2000.xx.xx</td>
                      	<td scope="row" class="even"> <a href="modify.jsp">수정</a></td>
             		</tr>
            	</tbody>
            </table>
            <form role="form" action="/usr/make" method="post"> 
            <button onclick = "usrList()">회원리스트</button>
            <div class="form-group">
              <table><tbody><tr>
              <td><button type="submit" class="btn btn-info">글쓰기<i class="fa fa-check spaceLeft"></i></button></td>
              
              
              <td><button type="submit" class="btn btn-info">삭제<i class="fa fa-check spaceLeft"></i></button></td>
              <td><input type="text" class="lsycss" id="atcl_search"></td>
			  <td><button type="submit" class="btn btn-info">검색<i class="fa fa-check spaceLeft"></i></button></td>
              </tr></tbody></table>  
              </div>
            </form>
        </div>
        </section>
        <!--/.user END-->
    

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
    <script src="/resources/js/usr/usr.js" type="text/javascript"></script>
  </body>
</html>
