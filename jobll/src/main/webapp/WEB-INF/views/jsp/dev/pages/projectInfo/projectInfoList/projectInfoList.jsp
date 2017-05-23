<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">프로젝트</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class ="row">
	<form id = "projectInfo" action = "/projectInfo/prjt/check/read" method="post">
		<div class = "prjt_list"></div>
	</form>
</div>