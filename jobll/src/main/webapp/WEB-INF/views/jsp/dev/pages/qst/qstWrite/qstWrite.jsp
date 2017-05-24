<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">문의 작성</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->
            <div class="panel-body">
            
			<form action = "/qstList/qstListWrite" method="post">
		                  <table width="80%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					       <colgroup>
					  			<col style="width:13%">
		                        <col style="width:37%">
		                        <col style="width:12%">
		                        <col style="width:38%">
		                    </colgroup>
		                    <tbody>
		                        <tr>
		                            <th scope="row">제목</th>
		                            <td colspan="3">
		                                <input type="text" class="qst_sbjt" name="qst_sbjt" style="width:100%;">
		                            </td>
		                        </tr>
		                        <tr>
		                            <th scope="row">내용</th>
		                            <td colspan="3">
		                            	<textarea style="height:200px; width:100%;" class = "qst_conts" name = "qst_conts" ></textarea>
		                            </td>
		                        </tr>
		
		                    </tbody>
		                </table>
						<div class = "Writeqst"></div>
				  <button type = "submit">요청하기</button> 	
				</form>

</div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">나의 문의 내역</h3>
    </div>
    <div class = 'myQstList'></div>
    <!-- /.col-lg-12 -->
</div>

<form class = 'qst-form' method = 'POST'>
	<div class = 'qst-data'></div>
</form>