<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<!-- data table -->
 	<div id="list"></div>
	<div id="pagination"></div>

<form id="atclInfoWrite" action = "/issue/reg" method="post">
	<input type = "hidden" name = "prjt_idx" id = "prjt_idx" value = ${ entity.prjt_idx }>
	<button onclick = "submit()">글쓰기</button>
</form>

