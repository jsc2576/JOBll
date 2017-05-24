<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<h3 class = "project-subject">Project Name : ${ entity.prjt_sbjt }</h3>
<!-- data table -->
 	<div id="list"></div>
 		
 <div class="jb-center">
  	<ul class="pagination" id="page_nm">
	</ul>
</div>
<form id="prjtCnetListModify" class = "ManagerLv" action = "/teamPerson/inv" method="post">
	<input type = "hidden" name = "prjt_idx" id = "prjt_idx" value = ${ entity.prjt_idx }>
	<input type = "hidden" class = "prjt_sbjt" name = "prjt_sbjt" value = ${ entity.prjt_sbjt }>
	<input type = "hidden" class = "prjt_cmpny" name = "prjt_cmpny" value = ${ entity.prjt_cmpny }>
	<button onclick = "submit()">팀원 초대/제외</button>
</form>