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

$(document).ready(function() {
	$('#table-sales').DataTable({
		"searching": false,
		"bJQueryUI": false,
	     "oLanguage": {
	          "sProcessing":   "Processando...",
	          "sLengthMenu":   "Mostrar _MENU_ registros",
	          "sZeroRecords":  "Não foram encontrados resultados",
	          "sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registros",
	          "sInfoEmpty":    "Mostrando de 0 até 0 de 0 registros",
	          "sInfoFiltered": "",
	          "sInfoPostFix":  "",
	          "sSearch":       "Buscar:",
	          "sUrl":          "",
	          "oPaginate": {
	              "sFirst":    "Primeiro",
	              "sPrevious": "Anterior",
	              "sNext":     "Seguinte",
	              "sLast":     "Último"
	          }
	    },
	});
});

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