var customerId;
//var host = "http://localhost:8080";

function getSaleId(id){
	$("#confirmationModal").modal();
	customerId = id;
}

function addCsrfToken(xhr){
	var header = $('input[name=_csrf_header]').val();
	var token = $('input[name=_csrf]').val();
	xhr.setRequestHeader(header, token);
}

$("#btn-delete").click(function(){
	$("#btn-delete").prop("disabled", true);
	
	$.ajax({
	    url: "/sale/" + customerId,
	    type: 'DELETE',
	    beforeSend: addCsrfToken,
	    success: function (result) {
	    	$("#btn-delete").prop("disabled", false);
	    	$("#confirmationModal").modal('toggle');
	    	$("#confirmationModal").on("hidden.bs.modal", function () {
				location.reload();
   	    	});
	   	}
	})
});