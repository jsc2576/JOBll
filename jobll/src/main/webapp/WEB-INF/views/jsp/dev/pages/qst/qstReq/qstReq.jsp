<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">문의 내용</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<form class = 'qst-form' action = "/qstList/req" method = "POST">
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->
            <div class="panel-body">
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
		                                <div type="text" class="qst_sbjt" name="qst_sbjt" style="width:100%;">
		                                ${ entity.qst_sbjt }
		                                </div>
		                            </td>
		                        </tr>
		                        <tr>
		                            <th scope="row">내용</th>
		                            <td colspan="3">
		                            	<div style="height:200px; width:100%;" class = "qst_conts" name = "qst_conts" >
		                            	${ entity.qst_conts }
		                            	</div>
		                            </td>
		                        </tr>
		                        <tr>
		                            <th scope="row">등록 날짜</th>
		                            <td colspan="3">
		                            	<div style="width:100%;" class = "qst_conts" name = "qst_conts" >
		                            	${ entity.reg_date }
		                            	</div>
		                            </td>
		                        </tr>
								<tr>
								
		                            <th scope="row">답변</th>
		                            
		                            <td colspan="3">
		                            	<textarea style="height:200px; width:100%;" class = "ans_conts" name = "ans_conts" ></textarea>
		                            </td>
		                        
		                        </tr>
		                    </tbody>
		                </table>
		                <button onclick = "submit()">답변하기</button>
						<div class = "Writeqst"></div>	

</div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<input type = "hidden" name = 'qst_idx' value = '${ entity.qst_idx }'>
</form>
