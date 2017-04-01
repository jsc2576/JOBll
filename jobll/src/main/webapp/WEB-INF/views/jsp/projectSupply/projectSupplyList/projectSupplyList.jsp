<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

프로젝트지원 리스트
<h3 class = "project-subject">Project Name : ${ entity.prjt_sbjt }</h3>
 <div class ="process" style="margin-top: 100px">
	<a onclick="findPrcs(0)" style="margin-right: 2px">전체목록</a>|
	<a onclick="findPrcs(1)" style="margin-right: 2px">수신목록</a>|
	<a onclick="findPrcs(2)" style="margin-right: 2px">발신목록</a>|
	<a onclick="findPrcs(3)" style="margin-right: 2px">수신처리완료</a>|
	<a onclick="findPrcs(4)" style="margin-right: 2px">발신접수완료</a>
</div> 

<!-- data table -->
 	<div id="data_list"></div>
 		
<form id = "projectSupply" action = "/projectSupply/readOne" method="post">
	<div class = "list"></div>
</form>


<form id="projectSupplyWrite" action = "/projectSupply/projectSupplyWrite/go" method="post">
	<button onclick = "submit()">글쓰기</button>
</form>
