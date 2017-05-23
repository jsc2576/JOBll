$(document).ready (function (){
	cmpnyList();
	
});



function cmpnyList() {
		$.ajax ({
			method	: "post",
			url		: "/usrInfo/cmpnyList.json",
			success	: function (list) {
				str_html ="<label for=\"cmpny_idx\">기업명</label>";
				str_html +="<select name=\"usr_cmpny_idx\" class=\"form-control\" id=\"usr_cmpny_idx\" >";
				str_html +="<option value=\"\">기업선택</option>";
				
				var i=0;
				for(i=0; i<list.length; i++){
					str_html +="<option value=\"";
					str_html +=list[i].cmpny_idx;
					str_html +="\">";
					str_html +=list[i].cmpny_nm;
					str_html +="</option>";
				}
				str_html +="</select>";
			
				
				
				$("#list").html (str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});
}


$(document).ready(function(){
  $("#usr_make").validate({
   rules: {
    usr_id: {
     required: true,
     minlength: 4,
     maxlength: 15
    },
    usr_pwd: {
     required: true,
    },
    chk_pwd: {
     required: true,
     equalTo: "#usr_pwd"
    },
    usr_nm: {
        required: true
    },
    tel_num: {
        required: true,
        minlength: 8,
        maxlength: 13
    },
    mobile_num: {
        required: true,
        minlength: 8,
        maxlength: 13
    },
    usr_email: {
        required: true
    },
    usr_cmpny: {
        required: true
    },
    usr_gdr: {
        required: true
    },
    zip_cd: {
        required: true
    },
    norm_addr: {
        required: true
    },
    dtl_addr: {
        required: true
    },
    usr_birth: {
        required: true
    },
    usr_cmpny_idx:{
    	required: true
    },
   },
   messages: {
    usr_id: {
     required: "이름을 입력하세요.",
     minlength: "{0}글자 이상으로 입력하세요.",
     maxlength: "{0}글자 이하로 입력하세요."
    },
    usr_pwd: {
     required: "비밀 번호를 입력하세요.",
     minlength: "{0}글자 이상으로 입력하세요.",
     maxlength: "{0}글자 이하로 입력하세요."
    },
     chk_pwd: {
     required: "비밀 번호를 입력하세요.",
     minlength: "{0}글자 이상으로 입력하세요.",
     maxlength: "{0}글자 이하로 입력하세요.",
     equalTo: "비밀 번호가 서로 일치하지 않습니다."
    },
    usr_nm: {
        required: "이름을 입력하세요."
    },
    tel_num: {
        required: "전화번호를 입력하세요.",
        minlength: "너무 짧습니다",
        maxlength: "너무 깁니다"
    },
    mobile_num: {
        required: "핸드폰 번호를 입력하세요.",
            minlength: "너무 짧습니다",
            maxlength: "너무 깁니다"
    },
    usr_email: {
        required: "이메일을 입력하세요."
    },
    usr_cmpny: {
        required: "회사명을 입력하세요."
    },
    usr_gdr: {
        required: "성별을 선택하세요."
    },
    zip_cd: {
        required: "우편번호를 입력하세요."
    },
    norm_addr: {
        required: "주소를 입력하세요."
    },
    dtl_addr: {
        required: "상제 주소를 입력하세요."
    },
    usr_birth: {
        required: "생년월일을 입력하세요."
    },
    usr_cmpny_idx: {
    	required: "기업명을 선택하세요."
    },
   }
  });
 });