// JavaScript Document
$(document).ready(function(){
		$('body').on('change','.payment-type',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
		if(val=='Project'){
			$('.project-fields').css('display','block');
		}else{
			$('.project-fields').css('display','none');
		}
 
 		//jobcart.changeAmount('discount',val);
	});
	
	
	$('body').on('change','#project_id',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
		if(val!=''){
			var data = {id:val};
			url = "ajax/load_project_invoices.php";
			$.get(url, data,function(data) {
				 var rs=JSON.parse(data);
				 if(rs["Success"]==1){
					result=rs["invoices"];
					for(var k in result) {
						
						var str='<option value="'+result[k].id+'_'+result[k].total_price+'_'+result[k].paid_Amount+'">'+result[k].id+' - ( $ '+result[k].total_price+' )</option>';
						$('#invoice_options').append(str);
					}
				 }
			});
		}
 
 		//jobcart.changeAmount('discount',val);
	});
	
	$('body').on('change','#invoice_options',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
		//var full_val = element.val();
  		var val_arr = val.split("_");
  		var id=val_arr[0];
 		var total=val_arr[1];
		var paid=val_arr[2];
		var remaining=total-paid;
		$('#invoice_id').val(id);
		$('#amount').val(remaining);
		
 
	});
	
	$('body').on('change','#method',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
		//var full_val = element.val();
		//alert(val);
  		if(val=="Cash"){
			$('.reference').css('display','none');
			
		}else{
			$('.reference').css('display','block');
			$('.reference-label').html(val+' #');
		}
		if(val=="Online Transaction" || val==""){
			$('.received-by').css('display','none');
			
		}else{
			$('.received-by').css('display','block');
		} 
	});
	 
	$('.select-2-basic').select2();

});



