function usrList() {
		$.ajax ({
			method	: "post",
			url		: "/usrList",
			data	: {usr_id : "bbk"},
			success	: function (list) {
				str_html = "<table class='type01' class = 'table table-striped' border ='1'>";
				str_html += "<thead><tr>";
				str_html += "<th scope='cols'></th>";
				str_html += "<th scope='cols'>번호</th>";
				str_html += "<th scope='cols'>등급</th>";
				str_html += "<th scope='cols'>회사</th>";
				str_html += "<th scope='cols'>이름</th>";
				str_html += "<th scope='cols'>가입날짜</th>";
				str_html += "<th scope='cols'>수정</th>";
				str_html += "</tr></thead><tbody>";
				for (var i = 0; i < list.length; i++) {
					if( i%2==1){
						str_html += "<tr>";
						str_html += "<td scope='row'><input type='checkbox' name='check' value='i+1'></td>";
						str_html += "<td scope='row'>번호('i'th)</td>";
						str_html += "<td scope='row'>등급('i'th)</td>";
						str_html += "<td scope='row'>회사('i'th)</td>";
						str_html += "<td scope='row'>이름('i'th)</td>";
						str_html += "<td scope='row'>가입날짜('i'th)</td>";
						str_html += "<td scope='row'><a href='modify.jsp'>수정</a></td>";
						str_html += "</tr>";
					}
					else{
						str_html += "<tr>";
						str_html += "<td scope='row' class='even'><input type='checkbox' name='check' value='i+1'></td>";
						str_html += "<td scope='row' class='even'>번호('i'th)</td>";
						str_html += "<td scope='row' class='even'>등급('i'th)</td>";
						str_html += "<td scope='row' class='even'>회사('i'th)</td>";
						str_html += "<td scope='row' class='even'>이름('i'th)</td>";
						str_html += "<td scope='row' class='even'>가입날짜('i'th)</td>";
						str_html += "<td scope='row' class='even'><a href='modify.jsp'>수정</a></td>";
						str_html += "</tr>";
					}
				}  //end of for
				str_html += "</tbody></table>";
				$("#list").html (str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});
}
