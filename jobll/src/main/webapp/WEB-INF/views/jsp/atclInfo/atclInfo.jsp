<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class ='type01'>
	<thead>
		<tr>
			<th>제목</th>
			<th>${ entity.atcl_sbjt }</th>
			<th>작성자</th>
			<th>${ entity.usr_id }</th>
			<th>작성시간</th>
			<th>${ entity.reg_date }</th>
		</tr>
	</thead>
</table>
<div id = 'content-box'>
</div>
<table id = file-list class ='type01'>
	<thead>
		<tr>
			<th>첨부 파일 리스트</th>
		</tr>
	</thead>
	<tbody>
			 <c:forEach begin="1" end="${fn:length(list)}" step="1" var="x">
			 	<tr>
				 	<th>
				  		<a href = 'https://s3.ap-northeast-2.amazonaws.com/elasticbeanstalk-ap-northeast-2-190235634467/${ list[x].file_path }'>${ list[x-1].attch_file_nm }</a><br>
				 	</th>
			 	</tr>
			 </c:forEach>
	</tbody>
</table>
