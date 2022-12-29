<?php
include("dbcon.php");

$name = mysqli_escape_string($con, $_POST['name']);
$email = mysqli_escape_string($con, $_POST['email']);
$password = mysqli_escape_string($con, md5($_POST['password']));

$main_array = array();
$output = array();
$sql = "INSERT INTO app_users set name = '" . $name . "',
                        email = '" . $email . "',
                        password = '" . $password . "',
                        
                        created_date = NOW()";
mysqli_query($con, $sql);
//echo $sql;
$inserted_id = $con->insert_id;
if ($inserted_id > 0) {
    /*data inserted successfully*/
    $output = array("id" => $inserted_id, "name" => $name, "email" => $email);
} else {
    /*data insertion failed*/
    $output = array("id" => '0');
}

array_push($main_array, $output);
echo json_encode($main_array);
?>