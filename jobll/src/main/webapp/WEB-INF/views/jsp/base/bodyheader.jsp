<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <A href="/usrInfo/MyUsrInfo/go" >
          <span>회원정보</span>
        </a>
        <A href="/usrInfo/usrInfoList/go" >
          <span>회원목록</span>
        </a>
        <A href="/usrInfo/usrInfoJoin/go" >
          <span>회원가입</span>
        </a>
        <A href="/atclInfo/atclInfoList/go" >
          <span>게시판</span>
        </a>
         <A href="/logout.do" >
          <span>로그아웃</span>
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