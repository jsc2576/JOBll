$(document).ready(function() {
	
	var prjt_idx = $(".prjt_idx").val();

	//GetHstyTable(prjt_idx); : 본래 코드, 페이징을 위해 변경 - OSC
	GetHstyTable(prjt_idx,0,0);
});
function viewIssue() {
	$("#dataSender").attr('action', "/issue/view");
	$("#dataSender").submit();
}//GetHstyTable(prjt_idx,0,0)

function viewProject() {
	$("#dataSender").attr('action', "/projectInfo/prjt/check/read");
	$("#dataSender").submit();
}

function viewTeamInv() {
	$("#dataSender").attr('action', "/teamPerson/check");
	$("#dataSender").submit();
}

function viewSupplyList() {
	$("#dataSender").attr('action', "/projectSupply/projectSupplyList/go");
	$("#dataSender").submit();
}

function viewSupplyWrite() {
	$("#dataSender").attr('action', "/projectSupply/projectSupplyWrite/go");
	$("#dataSender").submit();
}

function viewSupply(){
	$("#dataSender").attr('action', "/projectSupply/readOne");
	$("#dataSender").submit();
}