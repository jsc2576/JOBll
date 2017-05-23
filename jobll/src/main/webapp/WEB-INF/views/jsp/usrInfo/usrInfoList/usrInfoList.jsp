<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- data table -->
<div class ="row">
	<div class = "col-lg-12 cmpny_list-tag">
		<h3>고객사 검색</h3>
	</div>
	<div class = "col-lg-12 cmpny_list">
		<button onclick = "getUserByCmpny(2)">검색</button>
	</div>
</div>
 	<div id="list"></div>
<div class="container">
	<ul class="pagination">
		<li class="previous"><a href="#">First</a></li>
		<li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li class="active"><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
    	<li class="next"><a href="#">Last</a></li>
  	</ul>
</div>
 <div class="jb-center">
  	<ul class="pagination" id="page_nm">
	</ul>
</div>


