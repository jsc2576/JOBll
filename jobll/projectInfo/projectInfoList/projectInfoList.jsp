<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "panel-primary view">
	<div class="panel-heading project-menu">
		프로젝트 리스트
	</div>
</div>
<form id = "projectInfo" action = "/projectInfo/prjt/check/read" method="post">
	<div class = "list"></div>
</form>