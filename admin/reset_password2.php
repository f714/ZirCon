<?php
@session_start(); 
@ob_start();
include("Common.php");
$id=$_POST['id'];
	$sql="UPDATE users SET `password`='".mysqli_real_escape_string($con,$_POST['password'])."' WHERE id=".$id;
       
        mysqli_query($con,$sql);
        $_SESSION['msg']="Your password has been changed. Please login now.";
header("location:index.php");
mysqli_close($con);
?>