<?php
include("dbcon.php");
$main_array = array();
$output = array();

$type = $_POST['type'];
$owner_id = $_POST['owner_id'];

/*for recent book list*/
$sql = "select id, title, recitation_target, recitation_completed from individual_rooms where owner_id=" . $owner_id . " and status='In-Progress' and created_date = NOW()";
$rooms = mysqli_query($con, $sql);
if (mysqli_num_rows($rooms) > 0) {
    /*data login successfully*/
    while ($r = mysqli_fetch_array($rooms)) {
        $output = array("id" => $r['id'], "title" => $r['title'], "recitation_target" => $r['recitation_target'], "recitation_completed" => $r['recitation_completed']);
        array_push($main_array, $output);
    }
} else {
    /*data login failed*/
    $output = array("id" => '0');
    array_push($main_array, $output);
}

/*for recent book list*/
/*$sql = "select id, title, recitation_target, recitation_completed from community_rooms where owner_id=" . $owner_id . " and status='In-Progress'";;
$rooms = mysqli_query($con, $sql);
if (mysqli_num_rows($rooms) > 0) {*/
/*data login successfully*/
/*while ($r = mysqli_fetch_array($rooms)) {
    $output = array("id" => $r['id'], "title" => $r['title'], "recitation_target" => $r['recitation_target'], "recitation_completed" => $r['recitation_completed']);
    array_push($main_array, $output);
}
} else {*/
/*data login failed*/
/*$output = array("id" => '0');
array_push($main_array, $output);
}*/


echo json_encode($main_array);
?>