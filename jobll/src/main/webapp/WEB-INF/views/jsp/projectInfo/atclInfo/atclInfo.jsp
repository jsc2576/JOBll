<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../projectInfoMenu.jsp" flush="false" />

<table class = "table table-bordered conts-table">
	<tr>
		<th>제목</th>
		<th>${ entity.atcl_sbjt }</th>
		<th>작성자</th>
		<th>${ entity.usr_id }</th>
		<th>작성시간</th>
		<th>${ entity.reg_date }</th>
	</tr>
	<tr>
		<td class = "content-box" colspan = "6">
			${ entity.atcl_conts }
		</td>
	
	</tr>
</table>

<table id = file-list class ='table table-bordered'>
	<tr>
		<th>
			첨부 파일 리스트
		</th>
	</tr>
	 <c:forEach begin="1" end="${fn:length(list)}" step="1" var="x">
	 	<tr>
		 	<th>
		  		<a href = 'https://s3.ap-northeast-2.amazonaws.com/elasticbeanstalk-ap-northeast-2-190235634467/${ list[x-1].file_path }'>${ list[x-1].attch_file_nm }</a><br>
		 	</th>
	 	</tr>
	 </c:forEach>
</table>
