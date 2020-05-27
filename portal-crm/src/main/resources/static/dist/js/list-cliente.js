function modalRemover(id){
	$.confirm({
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
	});  
}

function editarCliente(id){
	window.location.href = "/cliente/update/"+id;
}

function converterLead(id, estado){
	
	/* 
	 * 1 = Lead
	 * 2 = Pre-Vestibular
	 * 3 = Pre-Matricula
	 * 4 = Matriculado
	 * 5 = Pendente
	 * */
	
	$.confirm({
	    title: 'Confirmar Conversão ?',
	    content: 'Quer converter o Lead para Inscrito ?',
	    buttons: {
	        confirmar: function () {
	        	 $.ajax({
	                 url: '/cliente/updateEstado/' + id,
	                 data: estado,
	                 type: 'POST',

	                 processData: false,
	                 cache: false,
	                 contentType: "application/json; charset=utf-8",

	                 success: function (data) {
	                	 $.alert({
	                		    title: 'Sucesso',
	                		    content: 'Lead Convertido com Sucesso!',
	                		});
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