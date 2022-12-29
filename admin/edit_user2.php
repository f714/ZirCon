<?php
    include("chksession.php");
    include("Common.php");

    if (is_numeric($_GET['id'])) {

        if (isset($_POST['password']) and $_POST['password'] !== "") {
            $npass = mysqli_real_escape_string($con, $_POST['password']);
            $new_pass = $npass;
            $sql = "update users set name='" . mysqli_real_escape_string($con, $_POST['name']) . "',username='" . mysqli_real_escape_string($con, $_POST['username']) . "',password='" . $new_pass . "',phone='" . mysqli_real_escape_string($con, $_POST['phone']) . "',email='" . mysqli_real_escape_string($con, $_POST['email']) . "' where id='" . mysqli_real_escape_string($con, $_GET['id']) . "'";

        } else {
            $sql = "update users set name='" . mysqli_real_escape_string($con, $_POST['name']) . "',username='" . mysqli_real_escape_string($con, $_POST['username']) . "',phone='" . mysqli_real_escape_string($con, $_POST['phone']) . "',email='" . mysqli_real_escape_string($con, $_POST['email']) . "' where id='" . mysqli_real_escape_string($con, $_GET['id']) . "'";
        }


        mysqli_query($con, $sql);


        $_SESSION['msg'] = "User has been updated.";


        header('location:users.php');

    } else {

        $_SESSION['err'] = "Sorry User not updated.";
        header('location:edit_user.php?id=' . $_GET['id']);
    }

    mysqli_close($con);
?>