<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	${ entity.atcl_conts }
</div>
<div id = file-list></div>
