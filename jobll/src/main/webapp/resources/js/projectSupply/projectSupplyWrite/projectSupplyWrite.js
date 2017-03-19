$(document).ready(function() {

		$("#editor_box").focus();
		onoffswitch("tx-btn-bg");
		selectwitch("tx-slt-70bg","tx_fontfamily_menu");
		selectwitch("tx-slt-42bg","tx_fontsize_menu");
		
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

function onoffswitch(name) {
	var class_name = "."+name;
	var pushed_name = name+"-pushed";
	var pushed_class_name = class_name+"-pushed";


	$(document).on("click", class_name, function() {
			$(this).removeClass(name).addClass(pushed_name);
 		});
	$(document).on("click", pushed_class_name, function() {
			$(this).removeClass(pushed_name).addClass(name);
 		});
}

function selectwitch(name,submenu_name) {

	var class_name = "."+name;
	var pushed_name = name+"-pushed";
	var pushed_class_name = class_name+"-pushed";
	var id_submenu_name = "#"+submenu_name;

	$(document).on("click", class_name, function() {
			$(this).removeClass(name).addClass(pushed_name);
			$(id_submenu_name).css("display","block");

 		});
	$(document).on("click", pushed_class_name, function() {
			$(this).removeClass(pushed_name).addClass(name);
			$(id_submenu_name).css("display","none");
 		});
	$(document).on("click", id_submenu_name, function() {
			$(this).css("display","none");
			$(pushed_class_name).removeClass(pushed_name).addClass(name);
 		});
}



function callFormatting(aCommandName, aShowDefaultUI, aValueArgument) {
	document.execCommand(aCommandName, aShowDefaultUI, aValueArgument);

	switch(aValueArgument) {
		case '굴림' :
		{
			$("#tx_fontfamily").html('<a href="javascript:;" title="글꼴" style="font-family:Gulim,굴림,AppleGothic,sans-serif;">굴림</a>');
			break;
		}
		case '바탕' :
		{
			$("#tx_fontfamily").html('<a href="javascript:;" title="글꼴" style="font-family:Batang,바탕,serif;">바탕</a>');
			break;
		}
		case '돋움' :
		{
			$("#tx_fontfamily").html('<a href="javascript:;" title="글꼴" style="font-family:Dotum,돋움,sans-serif;">돋움</a>');
			break;
		}
		case '궁서' :
		{
			$("#tx_fontfamily").html('<a href="javascript:;" title="글꼴" style="font-family:Gungsuh,궁서,serif;">궁서</a>');
			break;
		}
		case 1 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">8pt</a>');
			break;
		}
		case 2 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">10pt</a>');
			break;
		}
		case 3 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">11pt</a>');
			break;
		}
		case 4 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">12pt</a>');
			break;
		}
		case 5 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">14pt</a>');
			break;
		}
		case 6 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">18pt</a>');
			break;
		}
		case 7 :
		{
			$("#tx_fontsize").html('<a href="javascript:;" title="글자크기">24pt</a>');
			break;
		}
	}
		$("#editor_box").focus();
}


function editorwrite() {
	
	var context = $("#editor_box").html();
	
	
			
	$("#editorcreateform").ajaxForm ({
		method   : "post",
		url: "/projectSupply/write",
		enctype: "multipart/form-data",
		data	: { sup_conts : context},
		success: function(result)	{
			location.href = "/projectSupply/projectSupplyList/go";
		}
	});
	$("#fileUpLoadForm").submit();
}



