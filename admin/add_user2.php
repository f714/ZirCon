<?php

    include("chksession.php");

    include("Common.php");

    $pass = mysqli_real_escape_string($con, $_POST['password']);



    mysqli_query($con, "insert into users set name='" . mysqli_real_escape_string($con, $_POST['name']) . "',username='" . mysqli_real_escape_string($con, $_POST['username']) . "',password='" . $pass . "',phone='" . mysqli_real_escape_string($con, $_POST['phone']) . "',email='" . mysqli_real_escape_string($con, $_POST['email']) . "',reg_date=now()");

    $_SESSION['msg'] = "User has been added.";


    mysqli_close($con);

    header('location:users.php');


?>