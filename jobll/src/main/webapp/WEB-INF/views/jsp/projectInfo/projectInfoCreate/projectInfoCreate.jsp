<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

프로젝트 생성
<form action = "/projectInfo/projectInfoCreate" method="post">
	<div class = "CreateProject">
		상위 프로젝트
		<div class = "High-Project-List"></div>
		<div>
			제목
			<input type = "text" class = "prjt_sbjt" name = "prjt_sbjt">
		</div>
		<div>
			설명
			<textarea class = "prjt_conts" name = "prjt_conts" ></textarea>
		</div>
	</div>
	<button type = "submit">생성하기</button>
</form>
