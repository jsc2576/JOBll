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
            <A href="/admin/usrInfo/cnfg" >
          		<span>회원 관리</span>
        	</a>
        </li>
        <li>
            <A href="/admin/cmpnyInfo/cnfg" >
          		<span>기관 관리</span>
        	</a>
        </li>
        <li>
            <A href="/admin/usrAuth/cnfg" >
          		<span>권한 관리</span>
        	</a>
        </li>
        <li>
            <A href="/qstList" >
          		<span>Q/A 게시판</span>
        	</a>
        </li>
        <li>
        	<A href="/logout.do" >
	          <span>로그아웃</span>
	        </a>
        </li>
    </ul>
</nav>
