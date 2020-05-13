function modalRemover(id){
	  $("#modal-deletar-cliente-id").val(id);
	  $("#deleteModal").modal(options);	
	  //alert('oi')
};

/*$(document.this).ready(function () {
	$('#deleteCliente').on("click", function(e){
	      e.preventDefault();						
	    
	      var Id = parseInt($("#modal-deletar-cliente-id").val());
									
	      $.ajax({
	          type:"GET",
	          url:"/deleteClient",
	          data:{id:Id},
                  success:function (data) {
	            	   $("#clientes"+id).closest("td#"+data).parent("tr").remove();
		          }
            });				        	
	 });
});*/