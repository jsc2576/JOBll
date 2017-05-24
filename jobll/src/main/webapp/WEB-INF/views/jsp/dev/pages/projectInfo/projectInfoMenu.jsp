<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="view collapse navbar-collapse project_menu" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a class = "menu-a-tag" onclick="viewProject()">프로젝트 정보</a></li>
        <li><a class = "menu-a-tag" onclick="viewIssue()">게시판(이슈)</a></li>
        <li><a class = "menu-a-tag" onclick="viewTeamInv()">팀원 조회</a></li>
        <li class = "ManagerLv"><a class = "menu-a-tag" onclick="viewSupplyList()">지원 요청</a></li>
        <li class = "ManagerLv"><a class = "menu-a-tag" onclick="viewSupplyReq()">지원 수신</a></li>
      </ul>
</div>

<form id = "dataSender" method="post">
	<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
</form>
