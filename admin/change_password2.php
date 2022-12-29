<?php

include("chksession.php");

include("Common.php");

		
		mysqli_query($con,"update users set password='".mysqli_real_escape_string($con,$_POST['password'])."' where id=".$_SESSION['login_id']);
			
	

			$_SESSION['msg']="Password has been changed.";



			mysqli_close($con);		

			header('location:change_password.php');



?>