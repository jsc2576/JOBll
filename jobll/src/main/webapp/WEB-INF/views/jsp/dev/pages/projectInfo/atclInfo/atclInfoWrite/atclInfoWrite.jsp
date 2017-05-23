<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      <jsp:include page="../../projectInfoMenu.jsp" flush="false" />
      
        <!--FILE UP LOAD -->
      <div>
        <form id ="editorcreateform"  method="post" enctype="multipart/form-data">
	        <section id="editor-section">
	        	<div id="subject-tag">
		        	<label for="subject">제목</label>
		  			<input type="text" class="form-control" id="subject" value = "${ entity.atcl_sbjt }">
	        	</div>
		      <div id="editor_box" CONTENTEDITABLE>${ entity.atcl_conts }</div>
	        </section>
	        <div class = "date">
	        	진행 기간
	        	<input type="date" class="start-date" name="userdate"> ~
	        	<input type="date" class="end-date" name="userdate">
	        </div>
	        <div class = "type">
	        	진행 정도
	        	<select class = "atcl_typ" name = "atcl_typ">
	        		<option value = "1">진행중</option>
	        		<option value = "2">진행완료</option>
	        		<option value = "3">진행중단</option>
	        		<option value = "4">진행초과</option>
	        		<option value = "5">협의중</option>
	        	</select>
	        </div>
	        <!--/.EDITOR LOAD END-->
	        <section id="file-upload-section">
		        <div id = "file-upload-tag">
		        	<input type="file" id="file-upload"  name="uploadFile" class = "file" multiple=true/>
		   			<div id="file-list" style="border:2px solid #c9c9c9;min-height:50px"></div> 
	        		<p class = "send-btn-tag"><button onclick ="editorwrite()">글 쓰기</button></p>
	          </div>
	          
	        </section>
        </form>
       </div>
       
<input type = "hidden" class = "write_type" name = "write_type" value = ${ entity.write_type }>
<input type = "hidden" class = "atcl_idx" name = "atcl_idx" value = ${ entity.atcl_idx }>