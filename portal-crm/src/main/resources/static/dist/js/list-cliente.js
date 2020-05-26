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
	                     console.log(data)
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

function converterInscrito(id, estado){
	
	/* 1 = Inscrito  
	 * 2 = Pré - Vestibular
	 * 3 = Vestibular
	 * 4 = Pré-Matricula
	 * 5 = Matriculado
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
	                     console.log(data)
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