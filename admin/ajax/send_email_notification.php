<?php
    include("../Common.php");

    $id = $_POST['id'];
    $checked = $_POST['checked'];
    $type =$_POST['type'];

    if ($type == "new_ticket") {
        $sql = "update ticket_alerts_emails_list set new_ticket = ".$checked." where id=".$id;
    }elseif ($type=="status_ticket") {
        $sql = "update ticket_alerts_emails_list set status_ticket = ".$checked." where id=".$id;
    }elseif ($type=="status") {
        $sql = "update ticket_alerts_emails_list set status = ".$checked." where id=".$id;
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