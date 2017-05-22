var AddBookPublic = {
		// button save
		eventOnClickButtonSave : function(){
			$('#btnSave').on('click',function(){
				var form = $("#frmAddBook");
				var action = url + "bookmanagement/addbook/save";
				var method = "POST";
				var modelattribute = "bookVO";
				$(form).attr("action",action);
				$(form).attr("method",method);
				$(form).attr("modelattribute",modelattribute);
				form.attr("enctype","multipart/form-data");
				form.submit();
			});
		},
		
		initValidate : function(){
			$('#frmAddBook').validate({
				rules : {
					'title' : {
						required : true,
					},
					'year_Of_Publishing' : {
						minlength : 4,
					},
					'category_Ids' : {
						required : true,
					},
					'file' : {
						required : true,
					},
					'book' : {
						required : true,
					},
				},
				messages : {
					'title' : {
						required : "Please input data" 
					},
					'year_Of_Publishing' : {
						minlength : "Please input 4 number" 
					},
					'category_Ids' : {
						required : "Please choose category" 
					},
					'file' : {
						required : "Please choose image" 
					},
					'book' : {
						required : "Please choose book" 
					},
				},
				errorPlacement: function(error, element) {
					if(element.attr("name") == "category_Ids") {
						let divError = element.parent().parent().append('<div></div>');
						error.appendTo( divError );
					} else {
						if(element.hasClass("tooltipError")){
							element.tooltip("destroy") // Destroy any pre-existing tooltip so we can repopulate with new tooltip content
			                    .data("title",$(error).text())
			                    .addClass("error")
			                    .tooltip();
						}else{
							error.insertAfter(element);
						}
					}
				},
			});
		},
		
		initOnlyNumber : function(){
			//allow input number
			$('.onlynumber').on('keypress',function(evt){
				 var self = $(this);
				 if ((evt.which < 48 || evt.which > 57)) 
				 {
				    evt.preventDefault();
				 }
			});
		},
		initValidateFile : function(){
			$('input[name="book"]').change(function () {
				if ($(this).val() != '') {      
				   if(!(/\.(doc|docx|pdf|txt|html)$/i).test($(this).val())){
						swal({
						   title: "Notify",
					       text:  "Please choose document file",
					       type:  "warning",
					       confirmButtonText: "OK"
						});
					   $(this).val("");
					   return false;
				   }
				}
				
			});
		},
		initValidateFileImage : function(){
			$('input[name="file"]').change(function () {
				if ($(this).val() != '') {      
					if(!(/\.(jpg|jpeg|jpe|bmp)$/i).test($(this).val())){
						swal({
							title: "Notify",
							text:  "Please choose image file",
							type:  "warning",
							confirmButtonText: "OK"
						});
						$(this).val("");
						return false;
					}
				}
				
			});
		},
		
		initNotifyMessageBox : function(){
			var message = $("#message").val();
			//if message=1 then save successfully
			if(message == 1){
				swal({
					   title: "Notify",
				       text:  "Save successfully",
				       type:  "success",
				       confirmButtonText: "OK"
				 });
				$('body').css('overflow','auto');
			}
			//if message=2 then save failed
			else if(message == 2){
				swal({
					   title: "Notify",
				       text:  "Save failed ",
				       type:  "error",
				       confirmButtonText: "OK"
				 });
				$('body').css('overflow','auto');
			}
			$("#message").val(0);
		},
}