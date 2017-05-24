$(document).ready (function (){
	GetCmpnyList(2);
});

function PjrtCreateTagController(){
	$('.prjt_create-tag').toggle(500);
	//GetUsrList(3);
}

function createPorject() {
	
	var usr_id = "<input type = 'hidden' name = 'usr_id' value = "+$(".usr_value").val()+">";
	var cmpny_idx = "<input type = 'hidden' name = 'cmpny_idx' value = "+$(".cmpny_value").val()+">";
	if($(".usr_value").val() == "선택")
	{
		alert("관리자를 선택해주새요.");
		return 0;
	}
	if($(".prjt-sbjt").val() == "")
	{
		alert("사업명를 선택해주새요.");
		return 0;
	}
	$(".project-create-form").append(usr_id);
	$(".project-create-form").append(cmpny_idx);
	
	$(".project-create-form").attr('action', "/projectInfo/projectInfoCreate");
	$("project-create-form").submit();
}
function mofidyProjectPop(prjt_idx) {
	var popupOption = 'directories=no, toolbar=no, location=no, menubar=no, status=no, scrollbars=no, resizable=no, left=400, top=200, width=440, height=550';
    window.open("/projectInfo/projectInfoModifyPop?prjt_idx="+prjt_idx, name, popupOption);
}
function mofidyProject() {
//
	
	var usr_id = "<input type = 'hidden' name = 'usr_id' value = "+$(".usr_value").val()+">";
	$(".project-modify-form").append(usr_id);
	$(".project-modify-form").append(cmpny_idx);
	
	$("project-modify-form").submit();
	
	
}

function deleteProject(prjt_idx) {
	var result = confirm('삭제하시겠습니까?'); 
	if(result) 
	{
		var prjt_idx_tag = "<input type = 'hidden' name = 'prjt_idx' value = "+prjt_idx+">";
		$(".project-form").append(prjt_idx_tag);
		
		$(".project-form").attr('action', "/projectInfo/projectInfoDelete");
		$(".project-form").submit();
		
	}
	else
	{
		return 0;
	}
	
}