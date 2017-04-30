$(document).ready (function (){
	permissionDenied();

});

function permissionDenied() {
		alert("권한이 없습니다.");
		
		var url = "/"; 
		$(location).attr('href',url);
}