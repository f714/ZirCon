<?php
include("dbcon.php");

$title = mysqli_escape_string($con, $_POST['title']);
$description = mysqli_escape_string($con, $_POST['description']);
$narrator = $_POST['narrator'];
$language = $_POST['language'];
$number_of_ayat = $_POST['number_of_ayat'];
$counting = $_POST['counting'];

$room_id = $_POST['room_id'];
$status = $_POST['status'];

$main_array = array();
$output = array();

if ($status == "individual") {
    $sql = "update individual_rooms set zikr_title = '" . $title . "',
                        zikr_description = '" . $description . "',
                        zikr_narrator = '" . $narrator . "',
                        zikr_number_of_ayat = '" . $number_of_ayat . "',
                        zikr_counting = '" . $counting . "'
                        where id=" . $room_id;
}elseif($status == "community"){
    $sql = "update community_rooms set zikr_title = '" . $title . "',
                        zikr_description = '" . $description . "',
                        zikr_narrator = '" . $narrator . "',
                        zikr_number_of_ayat = '" . $number_of_ayat . "',
                        zikr_counting = '" . $counting . "'
                        where id=" . $room_id;
}
mysqli_query($con, $sql);
//echo $sql;
$inserted_id = $con->insert_id;
if ($inserted_id > 0) {
    /*data inserted successfully*/
    $output = array("response" => 'data saved successfully');
} else {
    /*data insertion failed*/
    $output = array("response" => 'data saving failed');
}

array_push($main_array, $output);
echo json_encode($main_array);
?>