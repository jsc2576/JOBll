$(document).ready(function(){
	Cunt_Prjt();
	Cnet_Prjt();
	Tot_Prcs();
});

var crnt_prjt;


function Cunt_Prjt(){
	
	$.ajax({
		method: "POST",
		url: "/cuntPrjt/check/read",
		success:function(list){
			var str_html = "<table class = 'cunt_prjt'>";
			str_html += "<thead><tr>";
			str_html += "<th>최근 프로젝트</th>";
			str_html += "</tr></thead>";
		
			str_html += "<tbody>";
			$.each(list, function(index, data){
				str_html += "<td>";
				str_html += data;
				str_html += "</td>";
			});
			
			
			str_html += "</tbody> </table>";
			$("#cunt_list").html(str_html);
		},
		error: function(){
			var str_html = "<table class = 'cunt_prjt'>";
			str_html += "<thead><tr>";
			str_html += "<th>최근 프로젝트</th>";
			str_html += "</tr></thead>";		
			str_html += "<tbody>";
			str_html += "</tbody> </table>";
			$("#cunt_list").html(str_html);
		}
	});
}

function Cnet_Prjt(){
	
	$.ajax({
		method: "POST",
		url: "/centPrjt/check/read",
		success: function(list){
			var str_html = "";
			
			$.each(list, function(index, data){
				str_html += "<option>";
				str_html += data;
				str_html += "</option>";
			});
			
			$("#cnet_prjt").html(str_html);
		},
		error: function(){alert("ERROR")}
	});
}

function Tot_Prcs(){
	
	var end=0, rmn=0, tot=0;
	
	$.ajax({
		method: "POST",
		url: "/dashbrd/tot_atcl",
		success: function(data){
			tot = data;
		}
	});
	
	$.ajax({
		method: "POST",
		url: "/dashbrd/rmn_atcl",
		success: function(data){
			rmn = data;
		}
	});
	
	$.ajax({
		method: "POST",
		url: "/dashbrd/end_atcl",
		success: function(data){
			end = data;
		}
	});
	
	Circle_chart(end, rmn, tot);	
}

function Circle_chart(end, rmn, remain){
	var options = {
			'dataset':{
				title: 'Web accessibility status',
				values:[1, 2, 3],
				colorset: ['#2EB400', '#2BC8C9', "#666666"],
				fields: ['종료 이슈', '진행 이슈',  '남은 이슈'],
			},
			'donut_width' : 35,
			'core_circle_radius':50,
			'chartDiv': 'Nwagon',
			'chartType': 'donut',
			'chartSize': {width:700, height:400}
		};
	Nwagon.chart(options);	
}