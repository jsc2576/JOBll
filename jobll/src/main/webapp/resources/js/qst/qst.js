$(document).ready(function(){
	pagination_mv(page_nm, list_nm*5);
	findData(page_nm, list_nm);
});

var page_nm = 0; // 현재 보이는 페이지네이션의 페이지 
var list_nm = 10; // 리스트 한번에 보여지는 개수

//페이네이션의 페이지가 이동할 때마다 호출하는 함수
function pagination_mv(offset, limit){ // limit은 5페이지 전체를 체크하기 위한 것  = list_nm * 5를 해줘야 함
	var str_html = "";
	if(page_nm<=0){
		str_html += "<li class='disabled'>";
	}
	else{
		str_html += "<li>";
	}
	
	str_html += "<a onclick='pagination_prev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
	$.ajax({
		method: "POST",
		url: "/qst/read/cnt",
		data: {offset:offset, limit:limit},
		success: function(cnt){
			alert(cnt/5);
			var i;
			for(i=0; i<cnt/5; i++){
				str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + i) + ")'>" + (page_nm * list_nm + i+1) + "</a></li>";				
			}
			
			if(cnt > 20){
				str_html += "<li><a onclick='pagination_next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
			}
			else{
				str_html += "<li class='disabled'><span class='glyphicon glyphicon-chevron-right'></span></li>";
			}
			$("#page_nm").html(str_html);
			
		},
		error: function(){
			alert("error");
		}
	});
	
}

function pagination_next(){
	page_nm++;
	pagination_mv(page_nm, list_nm);
}

function findpage(offset){
	findData(offset, list_nm);
}


//데이터를 찾는 함수
function findData(offset, limit){
	$.ajax({
		method : "POST", 
		url : "/qst/read",
		data : {offset : offset, limit : limit},
		success : function(list){
			var str_html = "<thead>";
			str_html += "<tr>";
			str_html += "<td>인덱스</td>";
			str_html += "<td>제목</td>";
			str_html += "<td>내용</td>";
			str_html += "<td>날짜</td>";
			str_html += "<td>등록자</td>";
			str_html += "</tr>";
			str_html += "</thead>";
			str_html += "<tbody>";
			
			$.each(list, function(index, data){
				str_html += "<tr>";
				str_html += "<td>"+data.qst_idx+"</td>";
				str_html += "<td>"+data.qst_sbjt+"</td>";
				str_html += "<td>"+data.qst_conts+"</td>";
				str_html += "<td>"+data.reg_date+"</td>";
				str_html += "<td>"+data.usr_id+"</td>";
				str_html += "</tr>";
			});
			
			str_html += "</tbody>";
			
			$("#qst_table").html(str_html);
		},
		error : function(){
			alert("fail");
		}
	});
}
