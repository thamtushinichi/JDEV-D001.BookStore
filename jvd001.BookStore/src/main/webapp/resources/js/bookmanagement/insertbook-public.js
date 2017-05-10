var AddBookPublic = {
		// button save
		eventOnClickButtonSave : function(){
			$('#btnSave').on('click',function(){
				var form = $("#frmAddBook");
				var action = url + "/bookmanagement/addbook/save";
				var method = "POST";
				var modelattribute = "bookVO";
				form.attr("action",action);
				form.attr("method",method);
				form.attr("modelattribute",modelattribute);
//				form.attr("enctype","multipart/form-data");
				form.submit();
			});
		},
		
}