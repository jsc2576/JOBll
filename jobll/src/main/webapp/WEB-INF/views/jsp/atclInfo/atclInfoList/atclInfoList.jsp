<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--atcl START -->
 <div class ="process" style="margin-top: 100px">
	<a onclick="findPrcs(0)" style="margin-right: 2px">전체목록</a>|
	<a onclick="findPrcs(1)" style="margin-right: 2px">접수대기</a>|
	<a onclick="findPrcs(2)" style="margin-right: 2px">접수완료</a>|
	<a onclick="findPrcs(3)" style="margin-right: 2px">처리중</a>|
	<a onclick="findPrcs(4)" style="margin-right: 2px">처리완료</a>
</div> 

<!-- data table -->
 	<div id="data_list"></div>
 		
 <div class="jb-center">
  	<ul class="pagination" id="page_nm">
	</ul>
</div>
<form id="atclInfoWrite" action = "/atclInfo//atclInfoWrite/go" method="post">
	<button onclick = "submit()">글쓰기</button>
</form>
