<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

프로젝트 리스트
<form id = "projectInfo" action = "/projectInfo/prjt/check/read" method="post">
	<div class = "list"></div>
</form>



<form action = "/projectInfo/projectInfoCreate/go" method="post">
	<button onclick = "submit()">프로젝트생성</button>
</form>
