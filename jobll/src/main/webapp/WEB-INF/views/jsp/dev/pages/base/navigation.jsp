<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/dev">반응형 웹 기반 서비스데스크</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="/usrInfo/MyUsrInfo"><i
						class="fa fa-user fa-fw"></i> 내 프로필</a></li>
				<li><a href="/usrInfo/usrMdf"><i class="fa fa-medium fa-fw"></i>
						프로필 수정</a></li>
				<li><a href="/usrInfo/usrDel"><i class="fa fa-frown-o fa-fw"></i>
						회원 탈퇴</a></li>
				<li class="divider"></li>
				<li><a href="/logout.do"><i class="fa fa-sign-out fa-fw"></i>
						Logout</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

 <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="/dev"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        
                        <li>
                            <a href="/projectInfo/projectInfoList/go"><i class="fa fa-th-list fa-fw"></i> 프로젝트</a>
                        </li>
                        <li class = "AdminLv">
                            <a href="/admin/home"><i class="fa fa-lock fa-fw"></i> 관리자 페이지</a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/admin/cmpnyInfo/cnfg">고객사 관리</a>
                                </li>
                                <li>
                                    <a href="/qstList/go">문의 관리</a>
                                </li>
                                <li>
                                    <a href="/usrInfo/usrInfoList">사용자 관리</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="/qstList/write"><i class="fa fa-question-circle fa-fw"></i> Q & A</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>

	<!-- /.navbar-static-side -->

</nav>

           