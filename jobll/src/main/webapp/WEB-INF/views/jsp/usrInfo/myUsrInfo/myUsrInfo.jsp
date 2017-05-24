<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--MYINFO-->
<div id="myUsrInfo"></div>

<input type="hidden" id="usr_id" value = ${ usr_id }>
<!--/.MYINFO END-->
<div class ="row">
	<form id = "projectInfo" action = "/projectInfo/prjt/check/read" method="post">
		<div id="myPrjtInfo"></div> 
		<div id="hidden"></div>
	</form>
</div>