function modalRemoverUsuario(nomeDeUsuario){
	$.confirm({
	    title: 'Confirmar a Exclusão ?',
	    content: 'Tem certeza que quer excluir o registro ?',
	    buttons: {
	        confirmar: function () {
	        	 $.ajax({
	                 url: '/usuario/delete',
	                 data: nomeDeUsuario,
	                 type: 'POST',

	                 processData: false,
	                 cache: false,
	                 contentType: "application/json; charset=utf-8",

	                 success: function (data) {
	                	 $.alert({
	                		    title: 'Sucesso!',
	                		    content: 'Lead Removido com Sucesso!',
	                		});
	                	 
	                     window.location.reload();
	                 },                 
	                 error: function (xhr, status, error) {
	                	 var err = eval("(" + xhr.responseText + ")");
	                	 console.log(err.Message);
	                 }
	             });
	        },
	        
	        cancelar: function () {
	            $.alert('Cancelado!');
	        },
	    }
	});
}

function editarUsuario(nomeDeUsuario){
	window.location.href = "/usuario/update/"+nomeDeUsuario;
}