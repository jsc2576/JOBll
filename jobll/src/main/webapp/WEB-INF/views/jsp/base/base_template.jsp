<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String content = request.getParameter("CONTENT");
	String css = request.getParameter("CSS");
	String script = request.getParameter("SCRIPT");
%>
<html lang="ko">
	<head>
		<jsp:include page="header.jsp" flush="false" />
		<jsp:include page="<%= css %>" flush="false" />
	</head>
	<body>
		<jsp:include page="bodyheader.jsp" flush="false" />
		<jsp:include page="contentwrap.jsp" flush="false" />
		<jsp:include page="<%= content %>" flush="false" />
	</body>
	<jsp:include page="script.jsp" flush="false" />
	<jsp:include page="<%= script %>" flush="false" />
</html>