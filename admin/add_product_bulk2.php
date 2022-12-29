<?php
include("chksession.php");
include("Common.php");

$product_image_query="";
if($_FILES['product_image']['error']<=0){
$tt=date('Ymdhis');
$target_dir = "admin/img/";
$target_file=$tt.$_FILES["product_image"]["name"];
$file_tmp=$_FILES['product_image']['tmp_name'];
move_uploaded_file($_FILES['product_image']['tmp_name'], 'img/'.$target_file);

$product_image_query=",product_image='".$target_file."'";
}

if(isset($_POST['qty']) and $_POST['qty']>0){
    $qty=$_POST['qty'];
    for($i=1;$i<=$qty;$i++){
			$q="insert into products set id_category='".mysqli_real_escape_string($con,$_POST['id_category'])."',
			bar_code='".date("YmdHi").$i."',
            sku='".mysqli_real_escape_string($con,$_POST['sku'])."',
            wave='".mysqli_real_escape_string($con,$_POST['wave'])."',
            product_type='".mysqli_real_escape_string($con,$_POST['product_type'])."',
			name='".mysqli_real_escape_string($con,$_POST['name'])."',
			description='".mysqli_real_escape_string($con,$_POST['description'])."',
			parchase_price=0,
			selling_price=0,
			reg_dt=NOW(),
			status='".mysqli_real_escape_string($con,$_POST['status'])."',
            received_dt='".mysqli_real_escape_string($con,$_POST['received_dt'])."',
			warehouse_id='".mysqli_real_escape_string($con,$_POST['warehouse'])."',
			vendor_id='".mysqli_real_escape_string($con,$_POST['vendor_id'])."',
			id_user='".$_SESSION['login_id']."'".$product_image_query;
			$result=mysqli_query($con,$q);
    }
    $_SESSION['msg']="(".$qty.") Products has been added.";
}else{
    $_SESSION['err']="Error, Products are not added.";
}

mysqli_close($con);		
header('location:products.php');
?>