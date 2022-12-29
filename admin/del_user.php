<?php
include("chksession.php");
include("Common.php");
if(is_numeric($_GET['id'])){
	
	$result=mysqli_query($con,"select name from users where id=".$_GET['id']);
	$rs=mysqli_fetch_array($result);
	
	
	//action log entry
	mysqli_query($con,"insert into action_log set section='Users',action='Deleted User (".$rs['name'].")',action_by='".$_SESSION['login_name']."',action_dt=NOW();");
	//================
	
	mysqli_query($con,"delete from users where id='".mysqli_real_escape_string($con,$_GET['id'])."'");
	$_SESSION['msg']="User has been deleted.";
}
mysqli_close($con);	
if(isset($_GET['g'])){
	header("location:guest_trainers.php");
}else{
	header("location:users.php");
}
?>