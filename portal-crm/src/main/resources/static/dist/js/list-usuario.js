function modalRemoverUsuario(teste){
	alert(teste);
	/*$.confirm({
	    title: 'Confirmar a Exclusão ?',
	    content: 'Tem certeza que quer excluir o registro ?',
	    buttons: {
	        confirmar: function () {
	        	 $.ajax({
	                 url: '/cliente/delete',
	                 data: id,
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
	});  */
}

function editarUsuario(id){
	window.location.href = "/cliente/update/"+id;
}