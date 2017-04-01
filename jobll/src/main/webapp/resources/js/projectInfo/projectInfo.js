function viewIssue() {
	$("#dataSender").attr('action', "/issue/view");
	$("#dataSender").submit();
}

function viewProject() {
	$("#dataSender").attr('action', "/projectInfo/prjt/check/read");
	$("#dataSender").submit();
}