<?php
session_start(); 
ob_start();
 
if($_SESSION['login_id']>0){}else{

$_SESSION['err']="Session Expired, Please login again.";

header("location:index.php");

}
?>