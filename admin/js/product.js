
function Job() {

	this.Items = [];
	var tax_rate=0;
	var discount=0;
  
	this.addItem = function(item) {
		this.Items.push(item);
		this.renderCart();
	}
	this.replaceItems = function(items) {
		this.Items=items;
		this.renderCart();
	}
	
	this.removeItem = function(item_number) {
		for(var i = this.Items.length - 1; i >= 0; i--) {
			if(this.Items[i].uid == item_number) {
				this.Items.splice(i, 1);
				this.renderCart();
				return true;
			}
		}
		return false;
	}
	
	this.applyTax = function(item) {
		//alert(item);
		tax_rate=item;
		//alert(tax_rate);
		this.renderCart();
	}

	this.calculateTotal = function(quantity,rate){
		return  (quantity * rate).toFixed(2);
	}

	this.renderCart = function(){
		var html = '';
		var total = 0;
		var rem_amount=0;

  		for (var i = 0; i < this.Items.length; i++){ 
			//alert(this.labor[i].p_total+'='+this.labor[i].p_qty+'+'+this.labor[i].p_rate);
	  		this.Items[i].p_total = parseFloat(this.calculateTotal(this.Items[i].p_qty , this.Items[i].p_rate));
	  		total = total+this.Items[i].p_total;

   			html += this.templateItem(this.Items[i]);
 		}
 		
		discount=parseFloat(discount);
		if(tax_rate > 0){
			var tax=total*tax_rate/100;
		}else{
			var tax=0;
		}
 		tax=parseFloat(tax);
 		remaining = parseFloat(total+tax);
		remaining = parseFloat(remaining-discount);
		
		$('#job_item_list').html(html);
		$('#total_price').val(total.toFixed(2));
		$('#total_tax').val(tax.toFixed(2));
		$('#total_discount').val(discount.toFixed(2));
		$('#remaining').val(remaining.toFixed(2));


		this.afterAdditionJob(products);
	}
	
	this.getSelectedItem = function(product,number){
  		if(product != 0){
    		return '<select name="select_item_'+number+'" class="select-2-basic inline-select product_unselected" data-width="80%" >'+
    		'<option value="'+product.id+'" selected="selected">'+product.name+'</option>'+
    		'</select>';
  		}else{
   			return '<select name="select_item_'+number+'" class="select-2-basic inline-select product_unselected" data-width="80%" required></select>';
 		}
	}
	
	this.templateItem = function(item){
  		html = '<li class="labout_list_item" data-uid="'+item.uid+'">'+
  			'<input type="hidden" name="products_uids[]" value="'+item.uid+'" >'+
			'<input type="hidden" name="products_ids[]" value="'+item.p_id+'" >'+
  			'<div class="row">'+
  				'<div class="col-md-1">'+
  					'<h4 class="left"><a href="#" class="deleteProduct"><i class="fa fa-trash"></i></a></h4>'+
  
  				'</div>'+
    			'<div class="col-md-3">'+
					this.getSelectedItem(item.product,item.uid)+
  				'</div>'+
  				'<div class="col-md-3">'+
					'<input type="text"  name="products_name[]" class="form-control small-input p_name" value="'+item.p_name+'">'+
  				'</div>'+


  				'<div class="col-md-2">'+
  					'<input type="text"  name="products_rate[]" class="form-control small-input p_rate" value="'+item.p_rate+'">'+
  				'</div>'+
    			'<div class="col-md-1">'+
					'<input type="text"  name="products_qty[]" class="form-control small-input p_qty" value="'+item.p_qty+'">'+
  				'</div>'+

  				'<div class="col-md-2">'+
  					'<input type="text" name="products_total[]" class="form-control small-input p_total" value="'+item.p_total.toFixed(2)+'" readonly="">'+
  				'</div>'+
  			'</div></li>';
  		//console.log(html);
  		return html;

	};
//////////expense tab date


	this.changeProp = function(uid,property,value,render = true){
	
  		for(var i = this.Items.length - 1; i >= 0; i--) {
    		if(this.Items[i].uid == uid) {
				if(property=="product"){
					//this.Items[i][property] = value;
					this.Items[i]['p_id'] = value['id'];
					this.Items[i]['p_name'] = value['name'];
					this.Items[i]['p_rate'] = value['rate'];
				}else{
					this.Items[i][property] = value;
				}
     
     			if(render)
     			{
      				this.renderCart();
    			}
  			}
		}

		return false;
	}


	this.changeAmount = function(property,value,render = true){
		/*if(property=='tax'){
			tax=value;
		}else */if(property=='paid'){
			paid=value;
		}else if(property=='discount'){
			discount=value;
		}
		
     	if(render)
     	{
      		this.renderCart();
    	}
		return false;
	}


	this.afterAdditionJob = function(products){
  		$('.select-2-basic').select2();
  		$('.datepicker').datepicker({
        	format: 'yyyy-mm-dd'
      	});
  		for(var k in products) {
	  		var str='<option value="'+products[k].id+'_'+products[k].rate+'">'+products[k].p_code+'/'+products[k].name+'</option>';
	  		$('.product_unselected').append(str);
  		}
	}

}

/************************* OUR JOB CART ****************************/
jobcart = new Job();


$(document).ready(function(){

	$('body').on('click','.addProductToProject',function(e){

    	e.preventDefault();

    	var item = {
      		uid : Math.round(Date.now() + Math.random()),
	  		p_id:0,
	  		p_name:'',
	  		p_rate:0.00,
	  		p_qty:0,
	  		p_total:0.00,
	  		product:0,

    	};
    	jobcart.addItem(item);
  	});

 


	$('body').on("change",'.product_unselected',function(e){
  		var element = $(e.target);
  		var full_val = element.val();
  		var val_arr = full_val.split("_");
  		var id=val_arr[0];
 		var rate=val_arr[1];
  		var full_name = $(element).find('option:selected').text();
  		var name_arr = full_name.split("/");
  		var name = name_arr[1];
  		var uid = element.closest('li').attr('data-uid');

  		var product = {id: id, rate:rate, name: name};
  		//element.attr('disabled', 'disabled');
  		//element.removeClass('product_unselected');
  		//element.addClass('product_unselected');
  		//alert(uid+' '+JSON.stringify(product));
  		jobcart.changeProp(uid,'product',product);

	});
	
	$('body').on("change",'.tax_unselected',function(e){
  		var element = $(e.target);
  		var full_val = element.val();
  		var val_arr = full_val.split("_");
  		var id=val_arr[0];
 		var tax_rate=val_arr[1];
		//alert(tax_rate);
		//return false;
  		
  		jobcart.applyTax(tax_rate);

	});


	$('body').on('change','.p_name',function(e){
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		var val = $(element).val();
  		val = val.trim();
  		if(typeof(val) == "NAN"){
   			return;
 		}
 		jobcart.changeProp(uid,'p_name',val);
	});

	$('body').on('change','.p_rate',function(e){
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		var val = $(element).val();
  		val = val.trim();
  		if(typeof(val) == "NAN"){
   			return;
 		}
 		jobcart.changeProp(uid,'p_rate',val);
	});

	$('body').on('change','.p_qty',function(e){
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		var val = $(element).val();
  		val = val.trim();
  		if(typeof(val) == "NAN"){
   			return;
 		}
 		jobcart.changeProp(uid,'p_qty',val);
	});


	$('body').on('click','.deleteProduct',function(e){
  		e.preventDefault();
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		jobcart.removeItem(uid);
	});


	$('body').on('change','#total_discount',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
 
 		jobcart.changeAmount('discount',val);
	});
	
	/*$('body').on('change','#total_tax',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
 
 		jobcart.changeAmount('tax',val);
	});*/

	/*$('body').on('change','#total_paid',function(e){
		e.preventDefault();
  		element = $(e.target);
		val=$(element).val();
 
 		jobcart.changeAmount('paid',val);
	});*/

});




var products=[];


$(document).ready(function(){
	 var data = {};
	 url = "ajax/load_products.php";
	 $.get(url, data,function(data) {
		 var rs=JSON.parse(data);
		 if(rs["Success"]==1){
			products=rs["products"];
		 }
	
	});

});

$(document).ready(function(){
	 var data = {};
	 url = "ajax/load_taxes.php";
	 $.get(url, data,function(data) {
		 //alert(data);
		 var rs=JSON.parse(data);
		 if(rs["Success"]==1){
			result=rs["taxes"];
			for(var k in result) {
	  			var str='<option value="'+result[k].id+'_'+result[k].percentage+'">'+result[k].title+' ( '+result[k].percentage+' %)</option>';
	  			$('.tax_unselected').append(str);
  			}
		 }
	});
	$('.select-2-basic').select2();

});



