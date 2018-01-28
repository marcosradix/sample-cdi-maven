$(document).ready(function($){
	
	$('.myid').keyup(function() {
		  $(this).val(this.value.replace(/\D/g, ''));
		});
	$('.cpf').keyup(function() {
		  $(this).val(this.value.replace(/\D/g, ''));
		});
	$('.myid').prop('readonly', true);
});