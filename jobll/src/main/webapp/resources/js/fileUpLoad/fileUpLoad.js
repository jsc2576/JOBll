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