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
		}
}