var img_num = 0;

		$(document).ready (function (){
			
		});
function delUpload(){
	img_num--;
	 $("#file-upload").remove();
}
function addUpload(){
	img_num++;
	$("#uploads").append('<p/><input type="file" id="file-upload"  name="uploadFile" /></p> ');
}

function fileUpload() {
	$('#fileUpLoadForm').ajaxForm	({
		url: "/testFileUpLoadRun",
		enctype: "multipart/form-data",
		success: function(result)	{
			alert("success!");
		}
	});
	$("#fileForm").submit();
}

/*function fileUploadView() {
		$.ajax ({
			method	: "post",
			url		: "/my/product/goEditProduct.json",
			data	: {prdt_idx : val},
			success	: function (data) {
				str_html = "<form action = '/my/product/editProduct.json' method='post'>";
				str_html += "상품이름: <input type='text' name='prdt_nm' value ="+data.prdt_nm+"><br>";
				str_html += "상품가격: <input type='text' name='sell_prce' value ="+data.sell_prce+"><br>";
				str_html += "구성: <input type='text' name='prdt_cmpt' value ="+data.prdt_cmpt+"><br>";
				str_html += "상품소개글: <input type='text' name='prdt_intr' value ="+data.prdt_intr+"><br>";
				str_html += "판매자 추천점수: <input type='text' name='selr_rcmd_scr' value ="+data.selr_rcmd_scr+"><br>";
				str_html += "<input type='hidden' name='prdt_idx' value ="+val+"><br>";
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});

}*/
