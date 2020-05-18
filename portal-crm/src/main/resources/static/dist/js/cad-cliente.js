$(document).ready(
		function() {
			$.getJSON('/dist/js/estados_cidades.json', function(data) {
				var items = [];
				var options = '<option value="">Selecione.</option>';

				$.each(data, function(key, val) {
					options += '<option th:value="' + val.nome + '">'
							+ val.nome + '</option>';
				});

				$("#estados").append(options);

				$("#estados").change(
						function() {
							var options_cidades = '';
							var str = "";

							$("#estados option:selected").each(function() {
								str += $(this).text();
							});

							$.each(data, function(key, val) {
								if (val.nome == str) {
									$.each(val.cidades, function(key_city,
											val_city) {
										options_cidades += '<option th:value="'
												+ val_city + '">' + val_city
												+ '</option>';
									});
								}
							});

							$("#cidades").append(options_cidades);
							$("#naturalidade").append(options_cidades);
						}).change();
			});
		});

$(document).ready(
		function() {
			$.getJSON('/dist/js/paises.json', function(data) {

				var items = [];
				var options = '<option value="">Selecione.</option>';

				$.each(data, function(key, val) {
					options += '<option th:value="' + val.nome + '">'
							+ val.nome + '</option>';

				});

				$("#nacionalidade").append(options);
			});
			
			
			$('#btn-excluir-cliente').click(function(){
				var id = this.getAttribute('data-idCliente')
				 alert(id)
			});
		})
		
  $(document).ready(function () { 
	  $("#CPF").mask('000.000.000-00', {reverse: true});
	  $("#telefone").mask("(00) 0000-00009")
	  $("#telefoneComplementar").mask("(00) 0000-00009")
   });
