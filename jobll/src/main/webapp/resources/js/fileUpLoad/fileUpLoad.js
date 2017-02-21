var img_num = 0;
$(document).ready (function (){
	
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
		url: "/attchFile/testFileUpLoadRun",
		enctype: "multipart/form-data",
		success: function(result)	{
			alert("success!");
		}
	});
	//$("#fileForm").submit();
}

function fileUploadView() {
		$.ajax ({
			method	: "post",
			url		: "/attchFile/testFileDownLoadList",
			data	: {usr_id : "bbk"},
			success	: function (list) {
				str_html = "<table class = 'table table-striped' border ='1'>";
				str_html += "<tr>";
				str_html += "<th>파일명</th>";
				str_html += "<th>파일크기</th>";
				str_html += "<th>파일형식</th>";
				str_html += "</tr>";
				for (var i = 0; i < list.length; i++) {
					str_html += "<tr>";
					str_html += "<td><a href ='https://s3.ap-northeast-2.amazonaws.com/elasticbeanstalk-ap-northeast-2-190235634467/"+list[i].file_path+"'>"+list[i].attch_file_nm+"</a></td>";
					str_html += "<td>"+list[i].attch_file_vol+"</td>";
					switch(list[i].file_typ)
					{
						case 1:
						{
							str_html += "<td>image</td>";
							break;
						}
						case 2:
						{
							str_html += "<td>audio</td>";
							break;
						}
						case 3:
						{
							str_html += "<td>vedio</td>";
							break;
						}
						case 4:
						{
							str_html += "<td>others</td>";
							break;
						}
					}
					
					str_html += "</tr>";
				}
				str_html += "</table>";
				$("#list").html (str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});

}
