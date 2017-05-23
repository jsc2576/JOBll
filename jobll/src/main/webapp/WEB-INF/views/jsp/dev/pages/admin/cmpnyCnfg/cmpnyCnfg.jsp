<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">고객사 관리</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class ="row">
	<div class = "col-lg-12 cmpny_list-tag">
		<h3>고객사 선택</h3>
	</div>
	<div class = "col-lg-12 cmpny_list">
		<button onclick = "GetProjectTable(2)">선택</button>
	</div>
</div>
<div class ="row">
	<form id = "projectInfo" action = "/projectInfo/prjt/check/read" method="post">
		<div class = "col-lg-12 prjt_list">
		</div>
	</form>
</div>

<div class = "row">
	<form class = "project-form" method = "POST">
	</form>
</div>
