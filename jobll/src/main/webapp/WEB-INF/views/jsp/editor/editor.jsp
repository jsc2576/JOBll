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
    
    <!-- editor css -->
    <link rel="stylesheet" href="resources/css/editor.css" type="text/css">
    <link rel="stylesheet" href="resources/css/customeditor.css" type="text/css">
    
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
            <A href="/usr/myUsrInfo" >
              <span>회원정보</span>
            </a>
            <A href="/usr" >
              <span>회원목록</span>
            </a>
            <A href="/usrInfoJoin" >
              <span>회원가입</span>
            </a>
            <A href="/atcl" >
              <span>게시판</span>
            </a>
            <A href="/editor" >
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
                    <a href = "/testmember">글쓰기</a>
                    <br>
                    <span class="typed"></span>
                  </div>
              </div>
            </div>
          </div>
        </section>
      
        <!--/.HOME END-->

        <!--FILE UP LOAD -->
        <section id="editor-section">
        	<form id = "editor-form">
	        	<div id="subject-tag">
		        	<label for="subject">제목</label>
		  			<input type="text" class="form-control" id="subject">
	        	</div>
		        <div id="tx_toolbar_basic" class="tx-toolbar tx-toolbar-basic">
		            <div class="tx-toolbar-boundary">
		                 <ul class="tx-bar tx-bar-left">
		                     <li class="tx-list">
		                         <div id="tx_fontfamily" unselectable="on" class="tx-slt-70bg tx-fontfamily">
		                             <a href="javascript:;" title="글꼴">굴림</a>
		                         </div>
		                         <div id="tx_fontfamily_menu" class="tx-fontfamily-menu tx-menu" unselectable="on">
		                             <ul class="tx-menu-list" unselectable="on">
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-gulim" href="javascript:;" unselectable="on" onclick="callFormatting('fontName',false,'굴림')">
		                                         굴림  (<span class="tx-txt" style="font-family:Gulim,굴림,AppleGothic,sans-serif;">가나다라</span>)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-batang" href="javascript:;" unselectable="on" onclick="callFormatting('fontName',false,'바탕')">
		                                         바탕 (<span class="tx-txt" style="font-family:Batang,바탕,serif;">가나다라</span>)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-dotum" href="javascript:;" unselectable="on" onclick="callFormatting('fontName',false,'돋움')">
		                                         돋움 (<span class="tx-txt" style="font-family:Dotum,돋움,sans-serif;">가나다라</span>)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-gungseo" href="javascript:;" unselectable="on" onclick="callFormatting('fontName',false,'궁서')">
		                                         궁서 (<span class="tx-txt" style="font-family:Gungsuh,궁서,serif;">가나다라</span>)
		                                     </a>
		                                 </li>
		                             </ul>
		                         </div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left">
		                     <li class="tx-list">
		                         <div unselectable="on" class="tx-slt-42bg tx-fontsize" id="tx_fontsize">
		                             <a href="javascript:;" title="글자크기">11pt</a>
		                         </div>
		  
		                         <div id="tx_fontsize_menu" class="tx-fontsize-menu tx-menu" unselectable="on">
		                             <ul class="tx-menu-list" unselectable="on">
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-8pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,1)">
		                                         가나다라마바사 (8pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-9pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,2)">
		                                         가나다라마바사 (10pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-10pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,3)">
		                                         가나다라마바사 (11pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-11pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,4)">
		                                         가나다라마바사 (12pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-12pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,5)">
		                                         가나다라마바사 (14pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-14pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,6)">
		                                         가나다라마바사 (18pt)
		                                     </a>
		                                 </li>
		                                 <li class="tx-menu-list-item">
		                                     <a class="tx-18pt" href="javascript:;" unselectable="on" onclick="callFormatting('fontSize',false,7)">
		                                         가나다라마바사 (24pt)
		                                     </a>
		                                 </li>
		                             </ul>
		                         </div>
		  
		  
		  
		                         <div id="tx_fontsize_menu" class="tx-fontsize-menu tx-menu" unselectable="on"></div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left tx-group-font">
		  
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg     tx-bold" id="tx_bold">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('bold', null, null)">굵게</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-underline" id="tx_underline">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('Underline', null, null)">밑줄</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-italic" id="tx_italic">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('Italic', null, null)">기울임</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-strike" id="tx_strike">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('StrikeThrough', null, null)">취소선</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-slt-tbg     tx-forecolor" id="tx_forecolor">
		                             <a href="javascript:;" class="tx-icon" title="글자색">글자색</a>
		                             <a href="javascript:;" class="tx-arrow" title="글자색 선택">글자색 선택</a>
		                         </div>
		                         <div id="tx_forecolor_menu" class="tx-menu tx-forecolor-menu tx-colorpallete"
		                              unselectable="on">
		  
		                          </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-slt-brbg    tx-backcolor" id="tx_backcolor">
		                             <a href="javascript:;" class="tx-icon" title="글자 배경색">글자 배경색</a>
		                             <a href="javascript:;" class="tx-arrow" title="글자 배경색 선택">글자 배경색 선택</a>
		                         </div>
		                         <div id="tx_backcolor_menu" class="tx-menu tx-backcolor-menu tx-colorpallete"
		                              unselectable="on"></div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left tx-group-align">
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg     tx-alignleft" id="tx_alignleft">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('justifyleft', null, null)">왼쪽정렬</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-aligncenter" id="tx_aligncenter">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('justifycenter', null, null)">가운데정렬</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-alignright" id="tx_alignright">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('justifyright', null, null)">오른쪽정렬</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg     tx-alignfull" id="tx_alignfull">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('justifyfull', null, null)">양쪽정렬</a>
		                         </div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left tx-group-tab">
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg     tx-indent" id="tx_indent">
		                             <a href="javascript:;" onclick="callFormatting('indent', null, null)" class="tx-icon">들여쓰기</a>
		                         </div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg     tx-outdent" id="tx_outdent">
		                             <a href="javascript:;" onclick="callFormatting('outdent', null, null)" class="tx-icon">내어쓰기</a>
		                         </div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left tx-group-list">
		                     <li class="tx-list">
		                         <div unselectable="on" class="tx-slt-31lbg tx-lineheight" id="tx_lineheight">
		                             <a href="javascript:;" class="tx-icon" title="줄간격">줄간격</a>
		                             <a href="javascript:;" class="tx-arrow" title="줄간격">줄간격 선택</a>
		                         </div>
		                         <div id="tx_lineheight_menu" class="tx-lineheight-menu tx-menu" unselectable="on"></div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="tx-slt-31rbg tx-styledlist" id="tx_styledlist">
		                             <a href="javascript:;" class="tx-icon" title="리스트">리스트</a>
		                             <a href="javascript:;" class="tx-arrow" title="리스트">리스트 선택</a>
		                         </div>
		                         <div id="tx_styledlist_menu" class="tx-styledlist-menu tx-menu" unselectable="on"></div>
		                     </li>
		                 </ul>
		                 <ul class="tx-bar tx-bar-left tx-group-etc">
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-link" id="tx_link">
		                             <a href="javascript:;" class="tx-icon" onclick="callFormatting('createLink', null, null)">링크</a>
		                         </div>
		                         <div id="tx_link_menu" class="tx-link-menu tx-menu"></div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-specialchar" id="tx_specialchar">
		                             <a href="javascript:;" class="tx-icon" title="특수문자">특수문자</a>
		                         </div>
		                         <div id="tx_specialchar_menu" class="tx-specialchar-menu tx-menu"></div>
		                     </li>
		                     <li class="tx-list">
		                         <div unselectable="on" class="       tx-btn-bg  tx-table" id="tx_table">
		                             <a href="javascript:;" class="tx-icon" title="표만들기">표만들기</a>
		                         </div>
		                         <div id="tx_table_menu" class="tx-table-menu tx-menu" unselectable="on">
		                             <div class="tx-menu-inner">
		                                 <div class="tx-menu-preview"></div>
		                                 <div class="tx-menu-rowcol"></div>
		                                 <div class="tx-menu-deco"></div>
		                                 <div class="tx-menu-enter"></div>
		                             </div>
		                         </div>
		                     </li>
		                 </ul>
		        	</div>
		      </div>
		      <div id="editor_box" CONTENTEDITABLE></div>
			</form>
        </section>
        <!--/.EDITOR LOAD END-->
        <section id="file-upload-section">
	        <div id = "file-upload-tag">
		        <form id="commonForm" name="commonForm"></form>
		        <form id ="fileUpLoadForm"  method="post" enctype="multipart/form-data">
		        	<input type="file" id="file-upload"  name="uploadFile" />
		   			<div id="file-list" style="border:2px solid #c9c9c9;min-height:50px"></div> 
	        		<p><button onclick ="editorwrite()">글 쓰기</button></p>
				</form>
          </div>
        </section>
        <!--/.FILE UPLOAD LOAD END-->
      </div>
     </div>

    <script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.form.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.multifile.min.js" type="text/javascript"></script>
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
    <script src="resources/js/customeditor.js" type="text/javascript"></script>
  </body>
</html>
