<?php
include("chksession.php");

include("Common.php");
$tt = date("Ymdhis");
$sql = "update diseases set title='" . mysqli_real_escape_string($con, $_POST['title']) . "',
            description='" . mysqli_real_escape_string($con, $_POST['description']) . "',
            verse='" . mysqli_real_escape_string($con, $_POST['verse']) . "',
            translation='" . mysqli_real_escape_string($con, $_POST['translation']) . "',
			updated_date=NOW() where id=" . $_GET['id'] . "";


mysqli_query($con, $sql);
mysqli_close($con);

$_SESSION['msg'] = "Disease has been updated.";
header('location:diseases.php');


?>