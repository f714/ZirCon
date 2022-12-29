<?php
include("dbcon.php");

$title = mysqli_escape_string($con, $_POST['title']);
$description = mysqli_escape_string($con, $_POST['description']);
$start_time = $_POST['start_time'];
$end_time = $_POST['end_time'];
$type = $_POST['type'];
$number_of_participants = $_POST['number_of_participants'];
$duration = $_POST['duration'];
$start_date = $_POST['start_date'];
$end_date = $_POST['end_date'];
$recitation_target = $_POST['recitation_target'];
$status = $_POST['status'];
$owner_id = $_GET['id'];

$main_array = array();
$output = array();
if ($status == "individual") {
    $sql = "INSERT INTO individual_rooms set owner_id = '" . $owner_id . "',
                        title = '" . $title . "',
                        description = '" . $description . "',
                        start_time = '" . $start_time . "',
                        end_time = '" . $end_time . "',
                        pr_type = '" . $type . "',
                        number_of_participants = '" . $number_of_participants . "',
                        duration = '" . $duration . "',
                        start_date = '" . $start_date . "',
                        end_date = '" . $end_date . "',
                        recitation_target = '" . $recitation_target . "',
                        status = '" . $status . "',
                        created_date = NOW()";
} elseif ($status == "community") {
    $sql = "INSERT INTO commuity_rooms set owner_id = '" . $owner_id . "',
                        title = '" . $title . "',
                        description = '" . $description . "',
                        start_time = '" . $start_time . "',
                        end_time = '" . $end_time . "',
                        pr_type = '" . $type . "',
                        number_of_participants = '" . $number_of_participants . "',
                        duration = '" . $duration . "',
                        start_date = '" . $start_date . "',
                        end_date = '" . $end_date . "',
                        status = '" . $status . "',
                        created_date = NOW()";
}
mysqli_query($con, $sql);
//echo $sql;
$inserted_id = $con->insert_id;
if ($inserted_id > 0) {
    if ($status == "individual") {
        /*data inserted successfully*/  /*room id and status should be get and sent to the next APIs*/
        $output = array("response" => 'data saved for individual', "room_id" => $inserted_id, "status" => $status);
    } elseif ($status == "community") {
        $output = array("response" => 'data saved for community', "room_id" => $inserted_id, "status" => $status);
    }
} else {
    /*data insertion failed*/
    $output = array("id" => '0');
}

array_push($main_array, $output);
echo json_encode($main_array);
?>