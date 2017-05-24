$(document).ready (function (){
	GetProjectList(4);
	graphRefresh(1,2,3,4,5);
});
function graphRefresh (val1, val2, val3, val4, val5){
	
	$("#morris-donut-chart").html("");
	Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "진행중",
            value: val1
        }, {
            label: "진행 완료",
            value: val2
        }, {
            label: "진행 중단",
            value: val3
        }, {
            label: "진행 초과",
            value: val4
        }, {
            label: "협의중",
            value: val5
        }],
        resize: true
    });  
	
}
