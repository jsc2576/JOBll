<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id = "cmpny_list">
</div>

<div id = "prjtInfo_list">
</div>

<form action = "/admin/prjt/create/go" method = "POST">
	<div id = "createPorject">
		<button class = "btn" onclick = "submit()">프로잭트 생성</button>
	</div>
</form>