<?php
include("chksession.php");

include("Common.php");

$image_query = "";
if ($_FILES['image']['error'] <= 0) {
    $tt = date('Ymdhis');
    $target_dir = "admin/inspiration_images/";
    $target_file = $tt . $_FILES["image"]["name"];
    $file_tmp = $_FILES['image']['tmp_name'];
    move_uploaded_file($_FILES['image']['tmp_name'], 'inspiration_images/' . $target_file);
}

$q = "insert into inspirations set title='" . mysqli_real_escape_string($con, $_POST['title']) . "',
			image='" . $target_file . "',
			created_date=NOW()";

$result = mysqli_query($con, $q);
$_SESSION['msg'] = "Inspiration has been created.";
mysqli_close($con);

header('location:inspirations.php');


?>