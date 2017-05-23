<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class='row'>
			<div class='col-lg-12'>
		        	<form role='form' class = 'project-modify-form' method = 'POST' action = "/projectInfo/projectInfoModify">
		            <div class='form-group'>
		                <label>사업명</label>
		                <input class='form-control prjt-sbjt' name = 'prjt_sbjt' value = '${ entity.prjt_sbjt }'>
		            </div>
		            <div class='form-group'>
		            <label>관리자</label>
		                <div class='usr_list'>
		                ${ usr_nm.usr_nm }(${ entity.usr_id })
		                </div>
		            </div>
		            <div class='form-group'>
		                <label>상세 내용</label>
		                <textarea class='form-control' rows='8' name = 'prjt_conts'>
${ entity.prjt_conts }
		                </textarea>
		            </div>
		            <div class='form-group'>
		            	<button onclick = 'mofidyProject()' class = 'btn'>수정</button>
		            	<button onclick = 'window.close()' class = 'btn'>취소</button>
		            </div>
		            <input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = "${ entity.prjt_idx }">
		        </form>
	        </div>
    	</div>
    	
    	<script src="/resources/vendor/jquery/jquery.min.js"></script>
    	<script src="/resources/js/dev/defaultSelectDataFunc.js" type="text/javascript"></script>
    	<script src="/resources/js/dev/admin/cmpnyCnfg/cmpnyCnfg.js" type="text/javascript"></script>
    	<script>
    	$(document).ready (function (){
    		GetUsrList(3);
    	});
    	</script>
    	<input type = "hidden" class = "cmpny_value" name = "cmpny_idx" value = "${ entity.cmpny_idx }">
    	
	</body>
</html>