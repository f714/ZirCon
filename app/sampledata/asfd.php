<?php
include("dbcon.php");

$name = mysqli_escape_string($con, $_POST['name']);
$email = mysqli_escape_string($con, $_POST['email']);


$main_array = array();
$output = array();
$sql = "UPDATE app_users set name = '" . $name . "',
                        email = '" . $email . "',
                        
                        updated_date = NOW() where email='".$email."'";
mysqli_query($con, $sql);
//echo $sql;
if ($stmt->rowCount() >= 0) {
    /*data inserted successfully*/
    $output = array("id" => $inserted_id, "name" => $name, "email" => $email);
} else {
    /*data insertion failed*/
    $output = array("id" => '0');
}

array_push($main_array, $output);
echo json_encode($main_array);
?>