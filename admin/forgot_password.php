<?php
session_start();
include("Common.php");
$email=mysqli_query($con,"select * from users where email='".$_POST['email']."'");
$main_array=array();
if(mysqli_num_rows($email)>0){

	$e=mysqli_fetch_array($email);
    
        $link=$base_url."reset_password.php?id=".encode($e['id']);
		$to=$e['email'];
		$subject="Reset your password.";
        $msg="Hi,<br><br> we heard you're having trouble with your password. If you want to recover your password, click the link below to create a new one. Or, if the page doesn't open directly copy/paste it into your browser.<br><br>".$link."<br><br>If you didn't try to reset your password, then ignore this email. <br><br>Thank You!<br><br>Suppot Team";
		$headers  = 'MIME-Version: 1.0' . "\r\n";
		$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
		$headers .= 'From:  WMS<info@layerslogic.com>' . "\r\n";
		mail($to, $subject, $msg, $headers);
		$_SESSION['msg']="Email sent with password reset instructions, please check your inbox.";
       
	}else{
		$_SESSION['err']="Your email is not registered with, please contact support.";
        //echo "not found;";      
	}
header("location:index.php");
mysqli_close($con);
?>