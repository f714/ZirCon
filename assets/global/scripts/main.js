// JavaScript Document

function validate(){
 var cpass=$('#Current').val();
 var npass=$('#New').val();
 var rpass=$('#Confirm').val();
 if(npass==rpass){
		$.post("ajax/change_password.php",{cp:cpass,np:npass},function(data){
		$('#err').html(data);
		});
 }else{
	$('#err').html("New & Re-enter passwords doesn't match.");	
	return false;	
 }
}
function show_project(){
	var id=$('#project_id').val();
	window.location='welcome.php?id='+id;
}
function show_issue(){
	var id=$('#issue_id').val();
	window.location='issues_map.php?id='+id;
}
/*function edit_company(id){
	$('#edit_place').html("<img src='images/loader.gif' width='30px' />");
	$.get("ajax/load_edit_company.php?id="+id,{},function(data){
			$('#edit_place').html(data);
		});	
}

function edit_poc(id,p){
	$('#edit_place').html("<img src='images/loader.gif' width='30px' />");
	$.get("ajax/load_edit_poc.php?id="+id+"&p="+p,{},function(data){
			$('#edit_place').html(data);
		});	
}

function check_duplicate(field,table){
	var value=$('#'+field).val();
	$.get('ajax/check_duplicate.php',{f:field,v:value,t:table},function(data){
		$('#'+field+'-err').html(data);
		if(data=="Already exists."){
			$('#'+field).focus();
			$('#dup_err').html("Already exists.");
		}
	})
}
function cnic_check(e){
	var patt = /[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()+=";:><]/;
	var value=$('#'+e).val();
	var lastChar = value.substr(value.length - 1);
	if(patt.test(lastChar)){
		value=value.replace(lastChar,'');
		$('#'+e+'-err').html("Only numbers with - allowed.");
		$('#'+e).val(value);
	}else{
		$('#'+e+'-err').html("");
	}	
}
function cell_check(e){
	var patt = /[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`-~!@#$%^&*()+=";:><]/;
	var value=$('#'+e).val();
	var lastChar = value.substr(value.length - 1);
	if(patt.test(lastChar)){
		value=value.replace(lastChar,'');
		$('#'+e+'-err').html("Only numbers allowed.");
		$('#'+e).val(value);
	}else{
		$('#'+e+'-err').html("");
	}	
}
function load_reporting(){
	var depart=$("#department").val();
	$.get("ajax/load_reporting.php",{d:depart},function(data){
		$('#depart').html(data);
	});
}
function disbale_item(element){
	var id=$('#customer_type').val();
	if(id=="20"){
		$('#'+element).prop("disabled",false);
	}else{
		$('#'+element).prop("disabled",true);
	}	
	
}
function show_vehicle(){
	var reg_no=$('#reg_no').val();
	window.location='live_tracking.php?reg_no='+reg_no;
}
function disable_insurance(val){
	if(val=="Yes"){
			$('#users2').prop("disabled",false);
			$('#users3').prop("disabled",false);
	}else{
			$('#users2').prop("disabled",true);
			$('#users3').prop("disabled",true);
	}
}

function load_customer(){
	var value=$('#customer').val();
	
	$.get("ajax/load_customer.php",{val:value},function(data){
		$d=$.parseJSON(data);
		if($d=="0"){
				$('#'+itemid+'-err').html("Profile not found, please try again.");
		}else{
				$('#c_cnic').html("CNIC");
				$('#c_email').html("Email");
				$('#c_phone').html("Phone");

				$('#cnic').html($d['cnic']);
				$('#phone').html($d['phone']);
				$('#email').html($d['email']);
		}
	});
}
function load_complaint(){
	var ctype=$('#c_type').val();
	$.get("ajax/load_complaint.php",{ct:ctype},function(data){
		$d=$.parseJSON(data);
				$('#critical').val($d['priority']);
				$('#response_time').val($d['r_time']+"hrs");
	});
}




function load_riders(id){
	$.get("ajax/load_riders.php?id="+id,{},function(data){
		$('#riders').html(data);
		$('#rider_detail').html('');	
	});
}
function load_rider_detail(id){
	var id=$('#rider').val();
	$.get("ajax/load_rider_detail.php?id="+id,{},function(data){
		$('#rider_detail').html(data);	
	});
}
function show_price_button(){
	src=$('#src').val();
	dst=$('#dst').val();
	if(src!='' & dst!=''){
	$.get("ajax/load_price.php?src="+src+"&dst="+dst,{},function(data){
		//$('#show_price').html('Rs: <strong>'+data+'</strong>');
		$('#show_price').val(data);
	});
	}else{
	}
}

function load_events(){
	id=$('#cat').val();
	$.get("ajax/load_events.php?id="+id,{},function(data){
		$('#show_price').html('Rs: <strong>'+data+'</strong>');
		$('#price').val(data);
	});
}

function model(id){
	$.get("ajax/load_video.php?id="+id,{},function(data){
		$('#video_place').html(data);
	});
    $("#myModal").on("show", function() {    // wire up the OK button to dismiss the modal when shown
        $("#myModal a.btn").on("click", function(e) {
            console.log("button pressed");   // just as an example...
            $("#myModal").modal('hide');     // dismiss the dialog
        });
    });

    $("#myModal").on("hide", function() {    // remove the event listeners when the dialog is dismissed
        $("#myModal a.btn").off("click");
    });
    
    $("#myModal").on("hidden", function() {  // remove the actual elements from the DOM when fully hidden
        $("#myModal").remove();
    });
    
    $("#myModal").modal({                    // wire up the actual modal functionality and show the dialog
      "backdrop"  : "static",
      "keyboard"  : true,
      "show"      : true                     // ensure the modal is shown immediately
    });
	}*/