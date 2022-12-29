
function team() {

	this.Items = [];
  
	this.addItem = function(item) {
		//alert(item);
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


	this.renderCart = function(){
		var html = '';
		console.log(this.Items.length);
  		for (var i = 0; i < this.Items.length; i++){ 

   			html += this.templateItem(this.Items[i]);
 		}
 
		$('#job_item_list').html(html);

		//this.afterAdditionJob(employees);
	}
	
	/*this.getSelectedItem = function(employee,number){
  		if(employee != 0){
    		return '<select name="select_item_'+number+'" class="select-2-basic inline-select labour_tech_selected disabled" data-width="80%" >'+
    		'<option value="'+employee.id+'" selected="selected">'+employee.name+'</option>'+
    		'</select>';
  		}else{
   			return '<select name="select_item_'+number+'" class="select-2-basic inline-select labour_tech_unselected" data-width="80%" required></select>';
 		}
	}*/
	
	this.templateItem = function(item){
  		html = '<li class="labout_list_item" data-uid="'+item.uid+'">'+
  			'<input type="hidden" name="employee_uids[]" value="'+item.uid+'" >'+
			'<input type="hidden" name="employee_ids[]" value="'+item.e_id+'" >'+
  			'<div class="row">'+
  				'<div class="col-md-1">'+
  					'<h4 class="left"><a href="#" class="deleteEmployee"><i class="fa fa-trash"></i></a></h4>'+
  
  				'</div>'+
    			/*'<div class="col-md-3">'+
					this.getSelectedItem(item.employee,item.uid)+
  				'</div>'+*/
  				

				'<div class="col-md-3">'+
  					'<input type="text"  name="employee_name[]" class="form-control small-input p_rate" value="'+item.e_name+'">'+
  				'</div>'+
				
  				'<div class="col-md-3">'+
  					'<input type="text"  name="employee_email[]" class="form-control small-input p_rate" value="'+item.e_email+'">'+
  				'</div>'+
    			'<div class="col-md-3">'+
					'<input type="text"  name="employee_phone[]" class="form-control small-input p_qty" value="'+item.e_phone+'">'+
  				'</div>'+
				'<div class="col-md-2">'+
					'<input type="text"  name="employee_role[]" class="form-control small-input p_qty" value="'+item.e_type+'">'+
  				'</div>'+

  			'</div></li>';
  		//console.log(html);
  		return html;

	};
//////////expense tab date


	/*this.changeProp = function(uid,property,value,render = true){
	
  		for(var i = this.Items.length - 1; i >= 0; i--) {
    		if(this.Items[i].uid == uid) {
				//alert(JSON.stringify(value));
				if(property=="employee"){
					this.Items[i][property] = value;
					this.Items[i]['e_id'] = value['id'];
					this.Items[i]['e_name'] = value['name'];
					this.Items[i]['e_email'] = value['email'];
					this.Items[i]['e_phone'] = value['phone'];
					this.Items[i]['emp_id'] = value['emp_id'];
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
	}*/




	/*this.afterAdditionJob = function(employees){
  		$('.select-2-basic').select2();
  		$('.datepicker').datepicker({
        	format: 'yyyy-mm-dd'
      	});
  		for(var k in employees) {
	  		var str='<option value="'+employees[k].id+'_'+employees[k].phone+'_'+employees[k].designation+'">'+employees[k].name+'/'+employees[k].emp_id+'</option>';
	  		$('.labour_tech_unselected').append(str);
  		}
	}*/

}

/************************* OUR JOB CART ****************************/
teamcart = new team();


$(document).ready(function(){


	$('body').on('click','.deleteEmployee',function(e){
  		e.preventDefault();
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		teamcart.removeItem(uid);
	});
	
	
	$('body').on('change','.tech_unselected',function(e){
		element = $(e.currentTarget).find("option:selected");
    	var id = element.val();
		if(id!=""){
			var data = {id: id };
		  	url = "ajax/load_employees.php";
		  	$.get(url, data,function(data) {
				var rs=JSON.parse(data);
				//alert(JSON.stringify(rs["employees"]));
				var employee=rs["employees"];
				
				
				//e.preventDefault();

				var item = {
					uid : Math.round(Date.now() + Math.random()),
					e_id:employee.id,
					e_name:employee.name,
					e_email:employee.email,
					e_phone:employee.phone,
					e_type:employee.designation,
		
				};
    			teamcart.addItem(item);
		  	});
		}
	});

});




var employees=[];




$(document).ready(function(){
	 var data = {};
	 url = "ajax/load_employees.php";
	 $.get(url, data,function(data) {
		 var rs=JSON.parse(data);
		 if(rs["Success"]==1){
			employees=rs["employees"];
			for(var k in employees) {
				
	  		var str='<option value="'+employees[k].id+'">'+employees[k].name+'('+employees[k].designation+')</option>';
	  		$('.tech_unselected').append(str);
  		}
		 }
	
	});
	$('.select-2-basic').select2();

});



//////////////////////////////////////////////////// equipment resource code start   ///////////////////////////////



function equipment() {

	this.Items = [];
	var total = 0;
  
	this.addItem = function(item) {
		//alert(item);
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


	this.renderCart = function(){
		var html = '';
		console.log(this.Items.length);
  		for (var i = 0; i < this.Items.length; i++){ 
			this.Items[i].p_total = parseFloat(this.Items[i].p_qty * this.Items[i].p_rate);
	  		total = total+this.Items[i].p_total;

   			html += this.templateItem(this.Items[i]);
 		}
 
		$('#products_list').html(html);

		//this.afterAdditionJob(employees);
	}
	

	
	this.templateItem = function(item){
  		html = '<li class="labout_list_item" data-uid="'+item.uid+'">'+
  			'<input type="hidden" name="product_uids[]" value="'+item.uid+'" >'+
			'<input type="hidden" name="product_id[]" value="'+item.p_id+'" >'+
  			'<div class="row">'+
  				'<div class="col-md-1">'+
  					'<h4 class="left"><a href="#" class="deleteProduct"><i class="fa fa-trash"></i></a></h4>'+
  
  				'</div>'+
  				

				'<div class="col-md-3">'+
  					'<input type="text"  name="product_name[]" class="form-control small-input p_name" value="'+item.p_name+'" disabled>'+
  				'</div>'+
				'<div class="col-md-3">'+
  					'<input type="text"  name="product_code[]" class="form-control small-input p_code" value="'+item.p_code+'" disabled>'+
  				'</div>'+
				'<div class="col-md-3">'+
  					'<input type="text"  name="product_category[]" class="form-control small-input p_code" value="'+item.p_category+'" disabled>'+
  				'</div>'+
				
    			'<div class="col-md-2">'+
					'<input type="text"  name="product_qty[]" class="form-control small-input p_qty" value="'+item.p_qty+'">'+
  				'</div>'+

  			'</div></li>';
  		//console.log(html);
  		return html;

	};
	
	

}

/************************* OUR JOB CART ****************************/
equipmentcart = new equipment();


$(document).ready(function(){
	
	$('body').on('click','.deleteProduct',function(e){
  		e.preventDefault();
  		element = $(e.target);
  		var parentLI = $(element).closest('li');
  		var uid = parentLI.attr('data-uid');
  		equipmentcart.removeItem(uid);
	});
	
	
	$('body').on('change','.products_unselected',function(e){
		element = $(e.currentTarget).find("option:selected");
    	var id = element.val();
		if(id!=""){
			var data = {id: id };
		  	url = "ajax/load_products.php";
		  	$.get(url, data,function(data) {
				var rs=JSON.parse(data);
				//alert(JSON.stringify(rs["products"]));
				var product=rs["products"][0];
				
				
				//e.preventDefault();

				var item = {
					uid : Math.round(Date.now() + Math.random()),
					p_id:product.id,
					p_name:product.name,
					p_code:product.p_code,
					p_category:product.category,
					p_qty:1,
		
				};
    			equipmentcart.addItem(item);
		  	});
		}
	});


});




var products=[];




$(document).ready(function(){
	 var data = {};
	 url = "ajax/load_products.php";
	 $.get(url, data,function(data) {
		 var rs=JSON.parse(data);
		 if(rs["Success"]==1){
			products=rs["products"];
			for(var k in products) {
	  			var str='<option value="'+products[k].id+'">'+products[k].name+'('+products[k].s_no+')</option>';
	  			$('.products_unselected').append(str);
  			}
		 }
	});
	$('.select-2-basic').select2();

});
