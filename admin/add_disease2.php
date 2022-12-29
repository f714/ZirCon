<?php
include("chksession.php");

include("Common.php");

$q = "insert into diseases set title='" . mysqli_real_escape_string($con, $_POST['title']) . "',
			description='" . mysqli_real_escape_string($con, $_POST['description']) . "',
			verse='" . mysqli_real_escape_string($con, $_POST['verse']) . "',
			translation='" . mysqli_real_escape_string($con, $_POST['translation']) . "',
			created_date=NOW()";

$result = mysqli_query($con, $q);
$_SESSION['msg'] = "Disease has been created.";
mysqli_close($con);

header('location:diseases.php');


?>