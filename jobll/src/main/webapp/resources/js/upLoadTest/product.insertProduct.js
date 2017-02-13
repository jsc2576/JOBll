var img_num = 0;

		$(document).ready (function (){
			
		});
function delUpload(){
	img_num--;
	 $("#file-upload").remove();
	 $("#file-upload-radio").remove();
}
function addUpload(){
	img_num++;
	$("#uploads").append('<p/><input type="file" id="file-upload"  name="uploadFile" /></p> ');
	$("#uploads").append('<p/><input type="radio" id="file-upload-radio" value ="'+img_num+'" name="repre_img"></p>');
}