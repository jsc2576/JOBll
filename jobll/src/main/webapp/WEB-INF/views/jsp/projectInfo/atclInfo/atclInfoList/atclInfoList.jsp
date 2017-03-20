<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- data table -->
 	<div id="list"></div>
 		
 <div class="jb-center">
  	<ul class="pagination" id="page_nm">
	</ul>
</div>
<form id="atclInfoWrite" action = "/atclInfo/atclInfoWrite/go" method="post">
	<button onclick = "submit()">글쓰기</button>
</form>

<input type = "hidden" id = "prjt_idx" value = ${ entity.prjt_idx }>