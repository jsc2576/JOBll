<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="view collapse navbar-collapse project_menu" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li><a class = "menu-a-tag" href="/projectInfo/projectInfoList/go">회원정보 리스트</a></li>
      </ul>
</div>

<form id = "dataSender" method="post">
	<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
</form>
	