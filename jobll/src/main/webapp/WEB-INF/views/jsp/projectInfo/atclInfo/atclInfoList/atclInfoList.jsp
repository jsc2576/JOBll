<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<!-- data table -->
 	<div id="list"></div>
 		
 <div class="jb-center">
  	<ul class="pagination" id="page_nm">
	</ul>
</div>
<form id="atclInfoWrite" action = "/issue/reg" method="post">
	<button onclick = "submit()">글쓰기</button>
</form>

<input type = "hidden" id = "prjt_idx" value = ${ entity.prjt_idx }>