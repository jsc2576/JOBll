

function viewIssue() {
	$("#dataSender").attr('action', "/issue/view");
	$("#dataSender").submit();
}

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
function viewSupplyReq() {
	$("#dataSender").attr('action', "/projectSupply/projectSupplyReq/go");
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