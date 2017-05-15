<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<!-- data table -->
 	<div id="data_list"></div>

<h3 class = "project-subject">Project Number : ${ entity.prjt_idx }</h3>  
프로젝트 지원요청
<form action = "/projectSupply/projectSupplyWrite" method="post">
		<div>
			<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
		</div>
		<div>
			인원
			<input type = "text" class = "sup_person" name = "sup_person">
		</div>
		<div>
			지원시작날짜
			<input type = "text" class = "sup_strt_date" name = "sup_strt_date">
		</div>
		<div>
			지원종료날짜
			<input type = "text" class = "sup_end_date" name = "sup_end_date">
		</div>
		<div>
			설명
			<textarea class = "sup_conts" name = "sup_conts" ></textarea>
		</div>
	</div>
  <button type = "submit">요청하기</button> 	
</form>
