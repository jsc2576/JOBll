var atcl_conts;

function submitdata() {
	Editor.save(); // 이 함수를 호출하여 글을 등록하면 된다.	
}

	/**
	 * Editor.save()를 호출한 경우 데이터가 유효한지 검사하기 위해 부르는 콜백함수
	 * 데이터가 유효할 경우 서버로 데이터를 보냄
	 */
function validForm(editor) {
	// Place your validation logic here

	// sample : validate that content exists
	var validator = new Trex.Validator();
	
	var subject = $(".subject").val();
	var contents = editor.getContent();
	
	
	if(!subject)
	{
		alert('제목을 입력하세요');
		return false;
	}
	
	if (!validator.exists(contents)) {
		alert('내용을 입력하세요');
		return false;
	}
	
	$.ajax ({
		method	: "post",
		url		: "/atcl/testAtclRun",
		data	: { atcl_sbjt : subject , atcl_conts : contents},
		success : function () {
			var url = "/";    
			$(location).attr('href',url);
		},
		error		: function (a) {
			console.log(a);
		}
	});
	
	//$("#tx_editor_form").append("<input type = 'hidden' id = 'atcl_sbjt' name = 'atcl_sbjt' value = '"+atcl_sbjt+"'>");
	//$("#tx_editor_form").append("<input type = 'hidden' id = 'atcl_conts' name = 'atcl_conts' value = '"+atcl_conts+"'>");
	
	//document.tx_editor_form.submit();
	
	
	return false;
}

/**
 * Editor.save()를 호출한 경우 validForm callback 이 수행된 이후
 * 실제 form submit을 위해 form 필드를 생성, 변경하기 위해 부르는 콜백함수로
 * 각자 상황에 맞게 적절히 응용하여 사용한다.
 * @function
 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
 * @returns {Boolean} 정상적인 경우에 true
 */
function setForm(editor) {
    var i, input;
    var form = editor.getForm();
    var content = editor.getContent();

    // 본문 내용을 필드를 생성하여 값을 할당하는 부분
    var textarea = document.createElement('textarea');
    textarea.name = 'content';
    textarea.value = content;
    form.createField(textarea);

    /* 아래의 코드는 첨부된 데이터를 필드를 생성하여 값을 할당하는 부분으로 상황에 맞게 수정하여 사용한다.
     첨부된 데이터 중에 주어진 종류(image,file..)에 해당하는 것만 배열로 넘겨준다. */
    var images = editor.getAttachments('image');
    for (i = 0; i < images.length; i++) {
        // existStage는 현재 본문에 존재하는지 여부
        if (images[i].existStage) {
            // data는 팝업에서 execAttach 등을 통해 넘긴 데이터
            alert('attachment information - image[' + i + '] \r\n' + JSON.stringify(images[i].data));
            input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'attach_image';
            input.value = images[i].data.imageurl;  // 예에서는 이미지경로만 받아서 사용
            form.createField(input);
        }
    }

    var files = editor.getAttachments('file');
    for (i = 0; i < files.length; i++) {
        input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'attach_file';
        input.value = files[i].data.attachurl;
        form.createField(input);
    }
    return true;
}

function loadContent() {
	var attachments = {};
	attachments['image'] = [];
	attachments['image'].push({
		'attacher': 'image',
		'data': {
			'imageurl': 'http://cfile273.uf.daum.net/image/2064CD374EE1ACCB0F15C8',
			'filename': 'github.gif',
			'filesize': 59501,
			'originalurl': 'http://cfile273.uf.daum.net/original/2064CD374EE1ACCB0F15C8',
			'thumburl': 'http://cfile273.uf.daum.net/P150x100/2064CD374EE1ACCB0F15C8'
		}
	});
	attachments['file'] = [];
	attachments['file'].push({
		'attacher': 'file',
		'data': {
			'attachurl': 'http://cfile297.uf.daum.net/attach/207C8C1B4AA4F5DC01A644',
			'filemime': 'image/gif',
			'filename': 'editor_bi.gif',
			'filesize': 640
		}
	});
	/* 저장된 컨텐츠를 불러오기 위한 함수 호출 */
	Editor.modify({
		"attachments": function () { /* 저장된 첨부가 있을 경우 배열로 넘김, 위의 부분을 수정하고 아래 부분은 수정없이 사용 */
			var allattachments = [];
			for (var i in attachments) {
				allattachments = allattachments.concat(attachments[i]);
			}
			return allattachments;
		}(),
		"content": document.getElementById("sample_contents_source") /* 내용 문자열, 주어진 필드(textarea) 엘리먼트 */
	});
}