function viewIssue() {
	$("#dataSender").attr('action', "/issue/view");
	$("#dataSender").submit();
}

function viewProject() {
	$("#dataSender").attr('action', "/projectInfo/prjt/check/read");
	$("#dataSender").submit();
}

function viewProjectSupply() {
	$("#dataSender").attr('action', "/projectSupply/readOne");
	$("#dataSender").submit();
}

function viewTeamInv() {
	$("#dataSender").attr('action', "/teamPerson/check");
	$("#dataSender").submit();
}