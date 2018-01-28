$(document).ready(function($){
	jQuery(function($){    
		//usando o id do campo necessário usar caracter de escape \\
		$('#idForm\\:myid').keyup(function() {
			  $(this).val(this.value.replace(/\D/g, ''));
			});
		//usando o id do campo
		$('#idForm\\:myid').prop('readonly', true);
		
		//usando o id do campo
		$('#idForm\\:cpf').keyup(function() {
			  $(this).val(this.value.replace(/\D/g, ''));
			});
	});
	
});