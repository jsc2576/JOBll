<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="hstyInfoMenu.jsp" flush="false" />

<!-- data table -->
 	<div id="data_list"></div>
 		
<form id = "hstyInfo" action = "/hstyInfo/readOne" method="post">
	<div class = "list"></div>
</form>
