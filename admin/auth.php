<?php
session_start(); 
ob_start();
include("Common.php");

$loginid = mysqli_real_escape_string($con, $_POST['username']);

$pass = mysqli_real_escape_string($con, $_POST['password']);



$sql="select * from users where username='".$loginid."' and password='".$pass."'";



//echo $sql;



$rs=mysqli_query($con,$sql);

if(mysqli_num_rows($rs)>0){

	$row=mysqli_fetch_array($rs);
	 //echo "ROW id :".$row['id'];

	$_SESSION['login_id']=$row['id'];

	$_SESSION['login_user']=$row['username'];

	$_SESSION['login_name']=$row['name'];

    $_SESSION['login_email']=$row['email'];


	$location="location:welcome.php";
    header($location);
    exit;

	}else{
		$_SESSION['err']="Invalid Login ID/Password, Please try again.";
        $location="location:index.php";
    header($location);
    exit;
			
	}
	
?>