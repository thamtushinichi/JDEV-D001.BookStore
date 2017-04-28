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
		}
}