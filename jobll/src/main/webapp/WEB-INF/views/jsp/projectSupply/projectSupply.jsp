<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="projectSupplyMenu.jsp" flush="false" />

<div class="panel panel-default">
  <h3 class = "project-subject">Project Name : ${ entity.prjt_sbjt }</h3>
  <div class="panel-heading">Project Comment</div>
  <div class="panel-body">${ entity.prjt_conts }</div>
</div>
	