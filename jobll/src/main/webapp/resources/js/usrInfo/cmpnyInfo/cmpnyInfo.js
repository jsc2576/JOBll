$(document).ready (function (){
	cmpnyList();
	
});



function cmpnyList() {

	$.ajax ({
		method	: "post",
		url		: "/usrInfo/cmpnyList.json",
		success	: function (list) {
			
			str_html ="<div class=\"col-xs-12\">";
			str_html +="<div class=\"well\" style=\"overflow: auto;\">";
			str_html +="<ul id=\"check-list-box\" class=\"list-group checked-list-box\">";
			
			//list company
			var i=0;
			for(i=0; i<list.length; i++){
				str_html +="<li class=\"list-group-item\">";
				str_html +=list[i].cmpny_nm;
				str_html += "</li>";
			}
			str_html+="</ul>";
			
			//search company
			str_html+="<div class=\"input-group col-xs-12\">";
			str_html+="<input id=\"cmpnySearch\" type=\"text\" class=\"form-control input-lg\" placeholder=\"회사 검색\">";
			str_html+="<span class=\"input-group-btn\">";
			str_html+="<i class=\"glyphicon glyphicon-search\"></i>";
			str_html+="</span></div>";
			
			//delete company
			str_html +="<button class=\"btn btn-primary col-xs-12\" id=\"deleteCheckedCmpny\">선택한 회사(들) 삭제</button>";
			
			//add company
			str_html+="<div class=\"input-group col-md-12\">";
			str_html+="<input id=\"cmpnyName\" type=\"text\" class=\"form-control input-lg\" placeholder=\"회사 추가\">";
			str_html+="<span class=\"input-group-btn\">";
			str_html+="<button id=\"addCmpny\" class=\"btn btn-info btn-lg\" type=\"button\">";
			str_html+="추가";
			str_html+="</button></span></div></div></div>";
			$("#cmpnyList").html (str_html);
			
		},
		complete	: function () {
			listSearch();
			listbox();
			
		},
		error		: function (a) {
			console.log(a);
		}
	});
}

function listSearch(){
	$('#cmpnySearch').keyup(function(){	
		var current_query = $('#cmpnySearch').val().toLowerCase();
		if (current_query !== "") {
			$(".list-group li").hide();
			$(".list-group li").each(function(){
				var current_keyword = $(this).text().toLowerCase();
				if (current_keyword.indexOf(current_query) >=0) {
					$(this).show();    	 	
				};
			});    	
		} else {
			$(".list-group li").show();
		};
	});
}

function listbox() {
	 $('.list-group.checked-list-box .list-group-item').each(function () {
	        
	        // Settings
	        var $widget = $(this),
	            $checkbox = $('<input type="checkbox" class="hidden" />'),
	            color = ($widget.data('color') ? $widget.data('color') : "primary"),
	            style = ($widget.data('style') == "button" ? "btn-" : "list-group-item-"),
	            settings = {
	                on: {
	                    icon: 'glyphicon glyphicon-check'
	                },
	                off: {
	                    icon: 'glyphicon glyphicon-unchecked'
	                }
	            };
	            
	        $widget.css('cursor', 'pointer')
	        $widget.append($checkbox);

	        // Event Handlers
	        $widget.on('click', function () {
	            $checkbox.prop('checked', !$checkbox.is(':checked'));
	            $checkbox.triggerHandler('change');
	            updateDisplay();
	        });
	        $checkbox.on('change', function () {
	            updateDisplay();
	        });
	          

	        // Actions
	        function updateDisplay() {
	            var isChecked = $checkbox.is(':checked');

	            // Set the button's state
	            $widget.data('state', (isChecked) ? "on" : "off");

	            // Set the button's icon
	            $widget.find('.state-icon')
	                .removeClass()
	                .addClass('state-icon ' + settings[$widget.data('state')].icon);

	            // Update the button's color
	            if (isChecked) {
	                $widget.addClass(style + color + ' active');
	            } else {
	                $widget.removeClass(style + color + ' active');
	            }
	        }

	        // Initialization
	        function init() {
	            
	            if ($widget.data('checked') == true) {
	                $checkbox.prop('checked', !$checkbox.is(':checked'));
	            }
	            
	            updateDisplay();

	            // Inject the icon if applicable
	            if ($widget.find('.state-icon').length == 0) {
	                $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span>');
	            }
	        }
	        init();
	    });
	    
	    $('#deleteCheckedCmpny').on('click', function(event) {
	        event.preventDefault(); 
	        var checkedItems=new Array();
	        var checked_num=0;//check 된 item 갯수

	        $("#check-list-box li.active").each(function(idx, li) {
	            checkedItems.push($(li).text());
	            checked_num++;
	        });	  
	        
	        if(checked_num==0){//선택된 회사가 없는 경우
	        	alert("선택된 회사가 없습니다.");
	        }
	        else{//선택 된 회사가 있는 경우 ->선택된 회사 삭제
		        //삭제 확인 메시지 출력
		        if (confirm("정말로 삭제하시겠습니까?\n회사목록: "+ checkedItems) == true) {
			        $.ajax({
			    		method	: "post",
			    		url		: "/cmpny/add/delete",
			    		data : {"checkedItems" : checkedItems},
			    		success: function(result){
			    			alert("삭제되었습니다");
			    			location.href="/cmpny/add";
			    			
			    			
			    		},
			    		complete	: function () {
			    			
			    		},
			    		error		: function (a) {
			    			alert("deletecmpny failed");
			    			console.log(a);
			    		}
			    	});
		        }
		        else{
		    		alert("삭제 취소되었습니다");
		    		location.href="/cmpny/add";
		    	}
	        }
	    });
	    
	    $('#addCmpny').on('click', function(event) {
	    	
	    	var cmpny_nm = $('#cmpnyName').val();
	    	if(cmpny_nm=="")
	    		alert("회사명을 입력해주십시오.");
	    	else{
		    	$.ajax({
		    		method	: "post",
		    		url		: "/cmpny/add/create",
		    		data : {"cmpny_nm" : cmpny_nm},
		    		success: function(result){
		    			location.href="/cmpny/add";
		    			
		    			
		    		},
		    		complete	: function () {
		    		},
		    		error		: function (a) {
		    			alert("addcmpny failed");
		    			console.log(a);
		    		}
		    	});
	    	}
	    });
	    
	    
	    
}