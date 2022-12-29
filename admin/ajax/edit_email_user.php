<?php
    include("../Common.php");

    $id = $_POST['id'];
    $text = $_POST['text'];
    $edit_what =$_POST['edit_what'];

    if ($edit_what == "name") {
        $sql = "update ticket_alerts_emails_list set name = '".$text."' where id=".$id;
    }elseif ($edit_what=="email") {
        $sql = "update ticket_alerts_emails_list set email = '".$text."' where id=".$id;
    }
    mysqli_query($con, $sql);
    $main = array();
    $output = array();
    if (mysqli_affected_rows($con)>0) {
        $output = array("response"=>"success");
        array_push($main,$output);
    }else{
        $output = array("response"=>"error");
        array_push($main,$output);
    }
    echo json_encode($main);
?>