$(document).on("click", ".btn-modal", (function(){
			$("#name").val("");
			$("#price").val("");
			$("#date").val("");
			$("#saleModal").modal();
	    }));
	
	  $(function() {
		  $("#date").datepicker({
			    dateFormat: 'dd/mm/yy',
			    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
			    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
			    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
			    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
			    nextText: 'Próximo',
			    prevText: 'Anterior'
			});
		});
	  
	  $("#btn-save").click(function(event) {

			var name = $('#name').val();
			var price = $('#price').val();
			var date = $('#date').val();
			var id = $('input[name=customerId]').val();
			console.log("id= "+id);
			
			var host = "http://localhost:8080";

			/*$.post(host + "/sale", {
				name : name,
				desc : desc,
				tags : tags,
			}, function(data) {

				var json = JSON.parse(data);
				//...

			}).done(function() {
			}).fail(function(xhr, textStatus, errorThrown) {
			}).complete(function() {
				$("#btn-save").prop("disabled", false);

			});*/

		});