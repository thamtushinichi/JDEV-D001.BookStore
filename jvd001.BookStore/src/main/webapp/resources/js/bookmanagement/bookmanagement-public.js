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
		
		initOnClickDeleteBook : function(){
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
							var id = $('#book_Id').val();
							window.location.href = url + "bookmanagement/delete/" + id;
						}
				});
			});
		}
}