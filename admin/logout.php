<?php
@session_start();
@ob_start();
unset($_SESSION['login_id']);
unset($_SESSION['user_name']);
unset($_SESSION['user_role']);
$_SESSION = array();
session_destroy();
header("location:index.php");
?>