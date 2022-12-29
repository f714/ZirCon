<?php
include("chksession.php");

include("Common.php");
$tt = date("Ymdhis");

$target_dir = "admin/inspiration_images/";
$target_file = $tt . $_FILES["image"]["name"];
$file_tmp = $_FILES['image']['tmp_name'];
move_uploaded_file($_FILES['image']['tmp_name'], 'inspiration_images/' . $target_file);

if ($_FILES['image']['error'] > 0) {
    $sql = "update inspirations set title='" . mysqli_real_escape_string($con, $_POST['title']) . "',
			updated_date=NOW() where id=" . $_GET['id'] . "";
}else{
    $sql = "update inspirations set title='" . mysqli_real_escape_string($con, $_POST['title']) . "',
			image='" . $target_file . "',
			updated_date=NOW() where id=" . $_GET['id'] . "";
}

mysqli_query($con, $sql);
mysqli_close($con);

$_SESSION['msg'] = "Inspiration has been updated.";
header('location:inspirations.php');


?>