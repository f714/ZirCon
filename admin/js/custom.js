// JavaScript Document

	Webcam.set({
			// live preview size
			width: 240,
			height: 240,
			
			// device capture size
			dest_width: 240,
			dest_height: 240,
			
			// final cropped size
			crop_width: 240,
			crop_height: 240,
			
			// format and quality
			image_format: 'png',
			jpeg_quality: 90
		});
		
		//Webcam.attach( '#my_camera' );
		function take_snapshot() {
			document.getElementById("photo-btn").style.display = "none";
			document.getElementById("camera-btn").style.display = "block";
				//$("#photo-btn").hide();
				//$("#camera-btn").show();
			// take snapshot and get image data
			Webcam.snap( function(data_uri) {
				// display results in page
				document.getElementById('my_camera').innerHTML = '<img src="'+data_uri+'"/>';
					document.getElementById('photo').value = data_uri;
			} );
		}
		function attach_webcam() {
			document.getElementById("camera-btn").style.display = "none";
			document.getElementById("photo-btn").style.display = "block";
			//$("#photo-btn").show();
			// take snapshot and get image data
			Webcam.attach( '#my_camera' );
		}
		
		
		function load_parent_accounts(){
				
				var category=$("#category").val();
				$.get('ajax/load_accounts.php',{category:category},function(data){
					console.log(data);
					$("#parent_account").html(data);
					$("#sub_account").html('<option value="">Select Sub Account</option>');
					//var rs=JSON.parse(data);
					
				});
			}
			
			function load_sub_accounts(){
				
				var parent_account=$("#parent_account").val();
				$.get('ajax/load_accounts.php',{parent_account:parent_account},function(data){
					console.log(data);
					$("#sub_account").html(data);
					//var rs=JSON.parse(data);
					
				});
			}
			
$(document).ready(function(){
	 
	$('.select-2-basic').select2();

});



