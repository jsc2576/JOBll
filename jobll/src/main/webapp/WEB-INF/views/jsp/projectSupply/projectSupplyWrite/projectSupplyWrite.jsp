<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

프로젝트 지원요청
<form action = "/projectSupply/projectSupplyWrite" method="post">
	<div class = "WriteProject">
		지원할 프로젝트
		<div class = "SupplyList"></div>
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
