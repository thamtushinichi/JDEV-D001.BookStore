var BookManagement = {
		initOnClickAddBook : function(){
			$('#btnAddBook').on('click',function(){
				window.location.href = url + "bookmanagement/addbook";
			});
		},
		
		initOnClickEditBook : function(){
			$('.btnEditBook').on('click',function(){
				window.location.href = url + "bookmanagement/editbook";
			});
		},
		
		initOnClickDeleteBook : function(elementId){
			$('.btnDelete').on('click',function(){
				swal({
					  title: "Are you sure?",
					  text: "You will not be able to recover this file!",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "Yes",
					  closeOnConfirm: false
					},
					function(isConfirm){
						if(isConfirm){
							window.location.href = url + "bookmanagement/delete/" + elementId;
						}
				});
			});
		},
		initValidate : function(){
			$('#formSearch').validate({
				rules : {
					'year_of_publishing' : {
						minlength : 4,
					},
				},
				messages : {
					'year_of_publishing' : {
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
}