$(document).ready(function(){
	Cunt_Prjt(); // 프로젝트 리스트 부르기
	Tot_Prcs(); //초기에 그래프 그리기 용
	Cnet_Prjt_Change(); // 셀렉트 박스 동작
});

function Cunt_Prjt(){ // 프로젝트 리스트 부르기 함수
	
	$("#cnet_list_name").html("프로젝트 리스트");
	$.ajax({
		method: "POST",
		url: "/cuntPrjt/check/read",
		success:function(list){
			var str_html = "<option value=''>----최근----</option>";
			$.each(list, function(index, data){
				str_html += "<option value='";
				str_html += data.prjt_idx;
				str_html += "'>";
				str_html += data.prjt_sbjt;
				str_html += "</option>";
			});
			
			Cnet_Prjt(str_html); // 셀렉트 박스의 담당 프로젝트 부분
		},
		error: function(){
			alert("Project List Error");
		}
	});
}

function Cnet_Prjt(str_html){ // 담당 프로젝트
	
	
	$.ajax({
		method: "POST",
		url: "/cnetPrjt/check/read",
		success: function(list){
			str_html += "<option value=''>----담당----</option>";
			$.each(list, function(index, data){
				str_html += "<option value='";
				str_html += data.prjt_idx;
				str_html += "'>";
				str_html += data.prjt_sbjt;
				str_html += "</option>";
			});
			
			$("#cnet_list").html(str_html);
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function Cnet_Prjt_Change(){ // 프로젝트 리스트 셀렉트 박스가 변경될 때의 동작
	$("#cnet_list").change(function(){
		var prjt_idx = $("#cnet_list").val();
		Tot_Prcs(prjt_idx);
	});
	
}

function Tot_Prcs(prjt_idx){ // 통계수치를 수집
	
	$.ajax({
		method: "POST",
		url: "/atcl_chart",
		data: {prjt_idx : prjt_idx},
		success: function(data){
			var tot = data[0];
			var rmn = data[1];
			var end = data[2];
			Circle_chart(tot, rmn, end);
		},
		error: function(){
			alert("chart error");
		}
	});	
}

function Circle_chart(tot, rmn, end){ // 차트 그리는 함수
	var options = {
			'dataset':{
				title: 'Web accessibility status',
				values:[end, tot-end-rmn, rmn],
				colorset: ['#2EB400', '#2BC8C9', "#666666"],
				fields: ['종료 이슈', '진행 이슈',  '남은 이슈'],
			},
			'donut_width' : 100,
			'core_circle_radius':0,
			'chartDiv': 'Nwagon',
			'chartType': 'pie',
			'chartSize': {width:500, height:200}
		};
	$("#Nwagon").html("");
	Nwagon.chart(options);	
}
