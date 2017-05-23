<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../projectInfoMenu.jsp" flush="false" />

<!-- data table -->
 	<div id="data_list"></div>

<h3 class = "project-subject">${ entity.prjt_idx }</h3>  
프로젝트 지원요청
<form action = "/projectSupply/projectSupplyWrite" method="post">
		<div>
			<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
		</div>
		<div>
			인원
			<select class = "sup_person" name = "sup_person">
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
		</div>
		<div>
			지원시작날짜
			<input type = "date" class = "sup_strt_date" name = "sup_strt_date">
		</div>
		<div>
			지원종료날짜
			<input type = "date" class = "sup_end_date" name = "sup_end_date">
		</div>
		<div>
			설명
			<textarea class = "sup_conts" name = "sup_conts" ></textarea>
		</div>
	</div>
  <button type = "submit">요청하기</button> 	
</form>
