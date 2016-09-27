var host = "http://localhost:8080";
var customerId;

function getSaleId(id){
	customerId = id;
	$("#confirmationModal").modal();
}

function addCsrfToken(xhr){
	var header = $('input[name=_csrf_header]').val();
	var token = $('input[name=_csrf]').val();
	xhr.setRequestHeader(header, token);
}

$("#btn-delete").click(function(){
	$("#btn-delete").prop("disabled", true);
	$.ajax({
	    url: host + "/sale/" + customerId,
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