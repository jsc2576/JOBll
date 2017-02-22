<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--user START -->
<section id="user-info-tag">
	<div class="col-md-12 col-md-offset--1">
		<table class="type01">
			<thead>
         		<tr>
                   	<th scope="cols"></th>
             		<th scope="cols">번호</th>
             		<th scope="cols">등급</th>
             		<th scope="cols">회사</th>
             		<th scope="cols">이름</th>
             		<th scope="cols">가입날짜</th>
                   	<th scope="cols">수정</th>
          		</tr>
          	</thead>
          	<tbody>
         		<tr>
                     <td scope="row"><input type="checkbox" name="check" value="1"></td>
             		<td scope="row">1</td>
             		<td scope="row">ex</td>
             		<td scope="row">ex</td>
             		<td scope="row">ex</td>
             		<td scope="row">2000.xx.xx</td>
                   	<td scope="row"> <a href="modify.jsp">수정</a></td>
          		</tr>
          		<tr>
                     <td scope="row" class="even"> <input type="checkbox" name="check" value="1"></td>
             		<td scope="row" class="even">2</td>
             		<td scope="row" class="even">ex2</td>
             		<td scope="row" class="even">ex2</td>
             		<td scope="row" class="even">ex2</td>
             		<td scope="row" class="even">2000.xx.xx</td>
                   	<td scope="row" class="even"> <a href="modify.jsp">수정</a></td>
          		</tr>
         	</tbody>
         </table>
         <form role="form" action="/usr/make" method="post"> 
         <button onclick = "usrList()">회원리스트</button>
       		<div class="form-group">
         <table><tbody><tr>
         <td><button type="submit" class="btn btn-info">글쓰기<i class="fa fa-check spaceLeft"></i></button></td>
         
         
         <td><button type="submit" class="btn btn-info">삭제<i class="fa fa-check spaceLeft"></i></button></td>
         <td><input type="text" class="lsycss" id="atcl_search"></td>
		<td><button type="submit" class="btn btn-info">검색<i class="fa fa-check spaceLeft"></i></button></td>
         </tr></tbody></table>  
         </div>
       </form>
	</div>
</section>
   <!--/.user END-->
