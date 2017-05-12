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
				},
				messages : {
					'title' : {
						required : "Please input data" 
					},
					'year_Of_Publishing' : {
						minlength : "Please input 4 number" 
					},
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
		
//		initNotifyMessageBox : function(){
//			var message = $("#message").val();
//			//if message=1 then save successfully
//			if(message == 1){
//				swal({
//					   title: "Notify",
//				       text:  "Save successfully",
//				       type:  "success",
//				       confirmButtonText: "OK"
//				 });
//				$('body').css('overflow','auto');
//			}
//			//if message=2 then save failed
//			else if(message == 2){
//				swal({
//					   title: "Notify",
//				       text:  "Save failed ",
//				       type:  "error",
//				       confirmButtonText: "OK"
//				 });
//				$('body').css('overflow','auto');
//			}
//			$("#message").val(0);
//		},
}