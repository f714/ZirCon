<?php

include("chksession.php");

include("Common.php");

mysqli_query($con,"delete from verses where id='".mysqli_real_escape_string($con,$_GET['id'])."'");

$_SESSION['msg']="Verses has been deleted.";

mysqli_close($con);

header("location:verses.php");

?>