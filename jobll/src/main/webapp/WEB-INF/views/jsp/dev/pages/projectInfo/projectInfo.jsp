<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="projectInfoMenu.jsp" flush="false" />

<div class="panel panel-default">
  <h3 class = "project-subject">${ entity.prjt_sbjt }</h3>
  <div class="panel-heading">세부 정보</div>
  <pre class="panel-body">${ entity.prjt_conts }</pre>
</div>
	