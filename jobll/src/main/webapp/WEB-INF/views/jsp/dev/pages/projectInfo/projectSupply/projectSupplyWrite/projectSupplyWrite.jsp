<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />
	
		
<!-- data table -->
 	<div id="data_list"></div>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">프로젝트 지원요청</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
 <div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->
            <div class="panel-body">
<form action = "/projectSupply/projectSupplyWrite" method="post">
		<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>	
		<table width="80%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					       <colgroup>
					  			<col style="width:13%">
		                        <col style="width:37%">
		                        <col style="width:12%">
		                        <col style="width:38%">
		                    </colgroup>
		                    <tbody>
		                    <input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>	

		                    <tr>
			<th scope="row">지원대상</th>
		                            <td colspan="3">
			<div class = "list">
			</div>
		</td></tr>
		
		<tr>
			<th scope="row">인원</th>
		                            <td colspan="3">
			<select style="width:631px" class = "sup_person" name = "sup_person">
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
				<option value = "7">7</option>
				<option value = "8">8</option>
				<option value = "9">9</option>
				<option value = "10">10</option>
				<option value = "11">11</option>
				<option value = "12">12</option>
				<option value = "13">13</option>
				<option value = "14">14</option>
				<option value = "15">15</option>
				<option value = "16">16</option>
				<option value = "17">17</option>
				<option value = "18">18</option>
				<option value = "19">19</option>
				<option value = "20">20</option>
				<option value = "21">21</option>
				<option value = "22">22</option>
				<option value = "23">23</option>
				<option value = "24">24</option>
				<option value = "25">25</option>
				<option value = "26">26</option>
				<option value = "27">27</option>
				<option value = "28">28</option>
				<option value = "29">29</option>
				<option value = "30">30</option>
			</select>
		</td></tr>
		<tr>
			<th scope="row">지원시작날짜</th>
		                            <td colspan="3">
			<input style="width:631px" type = "date" class = "sup_strt_date" name = "sup_strt_date">
		</td></tr>
		<tr>
			<th scope="row">지원종료날짜</th>
		                            <td colspan="3">
			<input style="width:631px" type = "date" class = "sup_end_date" name = "sup_end_date">
		</td></tr>
		<tr>
			<th scope="row">설명</th>
		                            <td colspan="3">
			<textarea style="height:200px; width:631px" class = "sup_conts" name = "sup_conts" ></textarea>
		</td></tr>
		</tbody>
		                </table>
		<button onclick = "sendRequest()">요청하기</button>
</form>
</div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<!-- /.row -->