<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
<nav id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
        <li class="sidebar-brand">
            <a href="#top" onclick=$("#menu-close").click();>Start Bootstrap</a>
        </li>
        <li>
            <A href="/" class="active">
          		<span>Home</span>
        	</a>
        </li>
        <li>
            <a href="/usrInfo/MyUsrInfo" >
	          <span>회원정보</span>
	        </a>
        </li>
        <li>
            <A href="/projectInfo/projectInfoList/go" >
	          <span>프로젝트</span>
	        </a>
        </li>
        <li>
            <A href="/dashboard" >
	          <span>대시보드</span>
	        </a>
        </li>
        <li>
            <A href="/usrInfo/usrInfoList" >
	          <span>회원목록</span>
	        </a>
        </li>
        <li>
            <A href="/usrInfo/join" >
	          <span>회원가입</span>
	        </a>
        </li>
        <li>
            <A href="/atclInfo/atclInfoList/go" >
	          <span>게시판</span>
	        </a>
        </li>
        <li>
            <A href="/hstyInfo/hstyInfoList/go" >
	          <span>히스토리</span>
	        </a>
        </li>
        <li>
        	<A href="/logout.do" >
	          <span>로그아웃</span>
	        </a>
        </li>
        <li>
            <A href="/admin/home" >
          		<span>관리자 페이지</span>
        	</a>
        </li>
    </ul>
</nav>
