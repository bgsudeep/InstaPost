var contextRoot = "/" + window.location.pathname.split('/')[1];

function deleteCategory(id) {
	
	if (confirm('Are you sure want to delete')) {
		
		$.ajax({
			type : 'DELETE',
			url : contextRoot + '/category/delete/' + id,
			dataType : "json",
			
			success : function(result) {
				$("#" + id).remove();

			},

			error : function(error) {
				alert("Could not delete.");
			}
		});

	}

}

function categorySubmit() {

	var dataToSend = JSON.stringify(serializeObject($('#categoryForm')));
	$
			.ajax({
				type : 'POST',
				url : contextRoot + '/category/add',
				dataType : "json",
				data : dataToSend,
				contentType : 'application/json',
				success : function(category) {
					console.log(category);
					$('#errors').html("");
					$("#success").html("");
					$("#result-header").html('<H3 align="center"> OKAY!! <H3>');
					var edit = contextRoot+"/category/edit/"+category.id;
					var del = contextRoot+"/category/delete/"+category.id;
					$('#categoryTable').append("<tr id="+category.id+"><td>"+category.id+"</td><td >"+category.title+"</td> <td id='edit_"+category.id+"'></td><td id='delete_"+category.id+"'></td> </tr>")
					$('#result').show();
					createRefElement("#edit_"+category.id, edit, "Edit", category.id);
					createRefElement("#delete_"+category.id, del, "Delete", category.id);
					
				},

				error : function(error) {
					$("#success").html("");
					$('#errors').html("");
					if (error.responseJSON.errorType == "ValidationError") {
						$('#success').html("");

						$("#result-header").html(
								'<H3 align="center"> Error(s)!! <H3>');
						$("#result-header").append('<p>');

						var errorList = error.responseJSON.errors;

						$.each(errorList, function(i, err) {
							$("#errors").append(err.message + '<br>');
						});
						$("#result-header").append('</p>');
						$('#result').show();
					} else {
						alert(error.responseJSON.errors(0)); // "non" Validation Error
					}
				}
			});
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();

}

make_hidden = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'none';
}

make_visible = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'block';
}

function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

function createRefElement(val, ref, txt, id){
	//create new li element
	var a = document.createElement("a");

	a.textContent = txt;
	a.setAttribute('href', "#");
	a.setAttribute('onclick', "deleteCategory("+id+")");	
	$(val).append(a);
	console.log(a);
	console.log(a);
}

