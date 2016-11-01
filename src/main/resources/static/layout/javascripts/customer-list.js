var customerId;

function getCustomerId(id){
	customerId = id;
}

function addCsrfToken(xhr){
	var header = $('input[name=_csrf_header]').val();
	var token = $('input[name=_csrf]').val();
	xhr.setRequestHeader(header, token);
}

$(document).ready(function() {
	
	$('#table-customers').DataTable({
		"searching": false,
		//"scrollY": '50vh',
		"scrollCollapse": true,
		"autoWidth": false,
		"DeferRender": true,
		"lengthMenu": [ 5, 10, 15, 25, 50, 100],
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
	    }
	});
});

$("#selectAll").click(function(){
	$('input:checkbox').prop('checked', this.checked);
});

$(document).on("click", ".btn-modal", (function(){
	var id = customerId;
	$.get("/sale/find/" + id, function (result) {
	    	if (result) {
	    		$("#SaleConfirmationModal").modal();
	    	}
	    	else {
	    		window.location.href = "/sale/"+ id;
	    	}
	});
}));

$("#btn-newSale").click(function(){
	var id = customerId;
	$("#btn-newSale").prop("disabled", false);
	$("#SaleConfirmationModal").modal('toggle');
	$("#SaleConfirmationModal").on("hidden.bs.modal", function () {
		window.location.href = "/sale/"+ id;
	});
});


$('#email-form').validate({
	rules: {
		_email: {
			required: true,
			email: true
		}
	},
	messages: {
		_email: {
            required: "Email é obrigatório.",
            email: "Insira um email válido."
        },
	},
	submitHandler: function (form) {
		var ids = [];
		var email = $("#_email").val();
		$('#emailModal').modal('toggle');
		
		$("input[name='checkBox[]']:checked").each(function () {
			ids.push(parseInt($(this).val()));
		});
		
		var data = {
				ids : ids,
				email : email
		};		
		
		var json = JSON.stringify(data);
		
		
		$.ajax({
			url: "/email",
			type: "post",
			contentType: "application/json; charset=utf-8",
			beforeSend:	addCsrfToken,
			data: json,
			success: function(data) {
				$("#emailConfirmationModal").modal();
				$("#emailConfirmationModal").on("hidden.bs.modal", function () {
					location.reload();
				});
			}
		});
	},
	highlight: function(element) {
		$(element).closest('.form-group').addClass('has-error');
	},
	unhighlight: function(element) {
		$(element).closest('.form-group').removeClass('has-error');
	},
	errorElement: 'span',
	errorClass: 'help-block',
	errorPlacement: function(error, element) {
		if(element.parent('.input-group').length) {
			error.insertAfter(element.parent());
		} else {
			error.insertAfter(element);
		}
	}
});

$("#emailModal").on("hidden.bs.modal", function () {
	$("#email-form").validate().resetForm();
	$("#_email").val("");
	$('#_email').closest('.form-group').removeClass('has-error');
});

$("#deleteModal_btn_delete").click(function() {
	var ids = [];
	
	$("input[name='checkBox[]']:checked").each(function () {
		ids.push(parseInt($(this).val()));
	});
	
	var json = JSON.stringify(ids);
	
	$("#deleteModal_btn_delete").prop("disabled", true);
	
	$.ajax({
		url: "/customer",
		type: "DELETE",
		contentType: "application/json; charset=utf-8",
		beforeSend: addCsrfToken,
		data: json,
		success: function(data) {
			$("#deleteModal_btn-delete").prop("disabled", false);
			$("#deleteModal").modal('toggle');
			$("#deleteModal").on("hidden.bs.modal", function () {
				location.reload();
			});
		}
	});
});

