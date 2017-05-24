$(document).ready(function() {

		
		$("#file-upload").MultiFile({
	        maxfile: 1048576, //각 파일 최대 업로드 크기
	        STRING: { //Multi-lingual support : 메시지 수정 가능
	            remove : "제거", //추가한 파일 제거 문구, 이미태그를 사용하면 이미지사용가능
	            duplicate : "$file 은 이미 선택된 파일입니다.", 
	            denied : "$ext 는(은) 업로드 할수 없는 파일확장자입니다.",
	            selected:'$file 을 선택했습니다.', 
	            toomuch: "업로드할 수 있는 최대크기를 초과하였습니다.($size)", 
	            toomany: "업로드할 수 있는 최대 갯수는 $max개 입니다.",
	            toobig: "$file 은 크기가 매우 큽니다. (max $size)"
	        },
	        list:"#file-list" //파일목록을 출력할 요소 지정가능
	    });

});




function editorwrite() {
	
	var subject = $("#subject").val();
	var context = $("#editor_box").html();
	var prjt_idx = $(".prjt_idx").val();
	var strt_date = $(".start-date").val();
	var comp_date = $(".end-date").val();
	var atcl_type = $(".atcl_typ").val();
	var atcl_idx = $(".atcl_idx").val();
	
	if($(".write_type").val() == 1){
		
		$("#editorcreateform").ajaxForm ({
			method   : "post",
			url: "/issue/mdf/send",
			enctype: "multipart/form-data",
			data	: {atcl_idx : atcl_idx, atcl_sbjt : subject, atcl_conts : context, prjt_idx : prjt_idx, 
				strt_date : strt_date, comp_date : comp_date, atcl_typ : atcl_type},
			success: function(result)	{
				viewIssue();
			}
		});
		
	}
	else {		
		$("#editorcreateform").ajaxForm ({
			method   : "post",
			url: "/issue/reg/send",
			enctype: "multipart/form-data",
			data	: {atcl_sbjt : subject, atcl_conts : context, prjt_idx : prjt_idx,
				strt_date : strt_date, comp_date : comp_date, atcl_typ : atcl_type},
			success: function(result)	{
				viewIssue();
			}
		});
	}
	$("#fileUpLoadForm").submit();
}



