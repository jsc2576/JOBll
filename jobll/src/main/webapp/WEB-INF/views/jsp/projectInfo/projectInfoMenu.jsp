<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="view collapse navbar-collapse project_menu" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li><a class = "menu-a-tag" href="/projectInfo/projectInfoList/go">프로젝트 리스트</a></li>
        <li><a class = "menu-a-tag" onclick="viewProject()">프로젝트 정보</a></li>
        <li><a class = "menu-a-tag" onclick="viewIssue()">게시판(이슈)</a></li>
        <li><a class = "menu-a-tag" onclick="viewTeamInv()">팀원 조회</a></li>
        <li><a class = "menu-a-tag" onclick="viewProjectSupply()">프로젝트 지원</a></li>
        <li class="dropdown">
          <a class = "menu-a-tag" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown  Example<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
</div>

<form id = "dataSender" method="post">
	<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
</form>
	