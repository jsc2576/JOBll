$(document).ready (function (){
	GetProjectList(4);
	graphRefresh(0,0,0,0,0);
});
function graphRefresh (val1, val2, val3, val4, val5){
	$("#morris-donut-chart").html("");
	if(!(val1 == 0 && val2 == 0 && val3 == 0 && val4 == 0 && val5 == 0))
	{
		Morris.Donut({
	        element: 'morris-donut-chart',
	        data: [{
	            label: "진행중",
	            value: val1,
	        }, {
	            label: "진행 완료",
	            value: val2,
	        }, {
	            label: "진행 중단",
	            value: val3,
	        }, {
	            label: "진행 초과",
	            value: val4,
	        }, {
	            label: "협의중",
	            value: val5,
	        }],
	        resize: true
	    }); 
	}
		
	 
	
}
