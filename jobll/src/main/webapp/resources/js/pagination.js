function getPage(page){

	$.ajax({
		//method : "POST",
		//url : "/cmpny/GetCmpnyList",
		data : {page : page},
		success: function(){
			var str_html = "<div class=\"container\">"+
				"<ul class=\"pagination\">"+
					"<li class=\"previous\"><a href=\"#\">First</a></li>"+
					"<li class=\"disabled\"><a href=\"#\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>"+
					"<li><a href=\"\#\">1</a></li>"+
					"<li><a href=\"#\">2</a></li>"+
					"<li class=\"active\"><a href=\"#\">3</a></li>";
					if(page==0)str_html+="<li><a href=\"#\">12</a></li>";
					
					str_html+="<li><a href=\"#\">4</a></li>"+
					"<li><a href=\"#\">5</a></li>"+
					"<li><a href=\"#\"><span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
			    	"<li class=\"next\"><a href=\"#\">Last</a></li>"+
			  	"</ul>"+
			"</div>";
			$("#pagination").html(str_html);

		},
		error: function(){alert("ERROR");}
	});
}
