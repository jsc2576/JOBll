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
     minlength: 6,
     maxlength: 12
    },
    chk_pwd: {
     required: true,
     minlength: 6,
     maxlength: 12,
     equalTo: "#usr_pwd"
    },
    usr_nm: {
        required: true
    },
    tel_num: {
        required: true
    },
    mobile_num: {
        required: true
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
    }
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
        required: "전화번호를 입력하세요."
    },
    mobile_num: {
        required: "핸드폰 번호를 입력하세요."
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
    }
   }
  });
 });