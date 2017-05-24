<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<h3 class = "project-subject">${ entity.prjt_sbjt }</h3>
<h4>팀원 초대 제외</h4>


	<!-- data table -->
 	<div id="list"></div>
 	<p></p>

<button onclick = "viewTeamInv()">돌아가기 </button>


<form id = "dataSender" method="post">
	<input type = "hidden" class = "prjt_idx" id = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
	<input type = "hidden" class = "cmpny_idx" id = "cmpny_idx" name = "cmpny_idx" value = ${ entity.cmpny_idx }>
</form>
	

 
 

