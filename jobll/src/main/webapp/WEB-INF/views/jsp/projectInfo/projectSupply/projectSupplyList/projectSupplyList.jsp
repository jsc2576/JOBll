<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />
 		
<form id = "projectSupply" onclick="viewSupply()" method="post">
	<div class = "list"></div>
</form>

<button onclick = "viewSupplyWrite()">글쓰기</button>
