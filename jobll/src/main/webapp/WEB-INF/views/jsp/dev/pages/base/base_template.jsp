<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String content = request.getParameter("CONTENT");
	String css = request.getParameter("CSS");
	String script = request.getParameter("SCRIPT");
%>
<html lang="ko">
	<head>
		<jsp:include page="head.jsp" flush="false" />
		<jsp:include page="<%= css %>" flush="false" />
	</head>
	<body>
		<div id="wrapper" class="row">
		<div class="col-md-3 col-xs-12">
			<jsp:include page="navigation.jsp" flush="false" />
		</div>
			<div id="page-wrapper" class="col-md-9 col-xs-12">
				<jsp:include page="<%= content %>" flush="false" />
        	</div>
        	<!-- /#page-wrapper -->
		</div>
	</body>
	<jsp:include page="script.jsp" flush="false" />
	<jsp:include page="<%= script %>" flush="false" />
</html>