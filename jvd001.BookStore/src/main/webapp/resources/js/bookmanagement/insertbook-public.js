var AddBookPublic = {
		// button save
		eventOnClickButtonSave : function(){
			$('#btnSave').on('click',function(){
				var form = $("#frmAddBook");
				var action = url + "/bookmanagement/addbook/save";
				var method = "POST";
				form.attr("action",action);
				form.attr("method",method);
				form.attr("commandName","book");
				form.submit();
			});
		},
		
}