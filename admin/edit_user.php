<?php

include("chksession.php");

include("Common.php");

include('header.php');

$user = mysqli_query($con, "select * from users where id='" . mysqli_real_escape_string($con, $_GET['id']) . "'");

$u = mysqli_fetch_array($user);

?>

<!-- BEGIN CONTAINER -->

<div class="page-container">

    <!-- BEGIN SIDEBAR -->

    <?php include('left_sidebar.php'); ?>

    <!-- END SIDEBAR -->

    <!-- BEGIN CONTENT -->

    <div class="page-content-wrapper">

        <!-- BEGIN CONTENT BODY -->

        <div class="page-content">

            <!-- BEGIN PAGE HEAD-->

            <div class="page-head">

                <!-- BEGIN PAGE TITLE -->

                <div class="page-title">

                    <h1>User Management

                        <small>Edit User</small>

                    </h1>

                </div>

                <!-- END PAGE TITLE -->

                <!-- BEGIN PAGE TOOLBAR -->


                <!-- END PAGE TOOLBAR -->

            </div>

            <!-- END PAGE HEAD-->

            <!-- BEGIN PAGE BREADCRUMB -->

            <ul class="page-breadcrumb breadcrumb">

                <li>

                    <a href="users.php">Users</a>

                    <i class="fa fa-circle"></i>

                </li>

                <li>

                    <span class="active">Dashboard</span>

                </li>

            </ul>

            <!-- END PAGE BREADCRUMB -->

            <!-- BEGIN PAGE BASE CONTENT -->


            <div class="row">

                <div class="col-sm-12">

                    <div class="portlet box blue ">

                        <div class="portlet-title">

                            <div class="caption">

                                <i class="fa fa-gift"></i>Edit
                            </div>

                            <div class="tools">

                                <a href="" class="collapse"> </a>

                                <!--<a href="#portlet-config" data-toggle="modal" class="config"> </a>-->

                                <!--<a href="edit_user.php" class="reload" target="_parent"> </a>-->

                                <a href="" class="remove"> </a>

                            </div>

                        </div>

                        <div class="portlet-body form">

                            <?php

                            //echo $sql;

                            if (isset($_SESSION['msg']) & $_SESSION['msg'] != '') {

                                ?>

                                <div class="alert alert-success display-hide" style="display:block">

                                    <button class="close" data-close="alert"></button>

                                    <span><?php echo $_SESSION['msg'];
                                        $_SESSION['msg'] = ""; ?> </span>

                                </div>


                                <?php

                                $_SESSION['msg'] = '';

                            } else if (isset($_SESSION['err']) & $_SESSION['err'] != '') {

                                ?>

                                <div class="alert alert-danger  display-hide" style="display:block">

                                    <button class="close" data-close="alert"></button>

                                    <span><?php echo $_SESSION['err'];
                                        $_SESSION['err'] = ""; ?> </span>

                                </div>


                                <?php

                                $_SESSION['err'] = '';

                            }

                            ?>

                            <!--<form role="form">

                                <div class="form-body">

                                    <div class="form-group has-success">

                                        <label class="control-label">Input with success</label>

                                        <input type="text" class="form-control" id="inputSuccess"> </div>

                                    <div class="form-group has-warning">

                                        <label class="control-label">Input with warning</label>

                                        <input type="text" class="form-control" id="inputWarning"> </div>

                                    <div class="form-group has-error">

                                        <label class="control-label">Input with error</label>

                                        <input type="text" class="form-control" id="inputError"> </div>

                                </div>

                                <div class="form-actions">

                                    <button type="button" class="btn default">Cancel</button>

                                    <button type="submit" class="btn red">Submit</button>

                                </div>

                            </form>-->

                            <form class="form-horizontal" method="post" role="form"
                                  action="edit_user2.php?id=<?php echo $u['id'] ?>">

                                <div class="form-body">

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Name</label>

                                        <div class="col-sm-4">

                                            <input class="form-control" name="name" value="<?php echo $u['name']; ?>"
                                                   placeholder="Name" type="text"></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Username</label>

                                        <div class="col-sm-4">

                                            <input name="username" class="form-control"
                                                   value="<?php echo $u['username']; ?>"
                                                   placeholder="username" type="text"></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Email</label>

                                        <div class="col-sm-4">

                                            <input name="email" class="form-control" value="<?php echo $u['email']; ?>"
                                                   placeholder="Email" type="text"></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Password</label>

                                        <div class="col-sm-4">

                                            <input name="password" class="form-control" value=""
                                                   placeholder="Please enter password if you want to change."
                                                   type="password"></div>
                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Phone</label>

                                        <div class="col-sm-4">

                                            <input name="phone" class="form-control" value="<?php echo $u['phone']; ?>"
                                                   placeholder="Phone" type="text"></div>

                                    </div>


                                </div>

                                <div class="form-actions right1">

                                    <button type="button" class="btn default" onclick="window.location='users.php'">
                                        Cancel
                                    </button>

                                    <button type="submit" class="btn green">Submit</button>

                                </div>

                            </form>


                        </div>

                    </div>


                </div>

            </div>


            <!-- END PAGE BASE CONTENT -->

        </div>

        <!-- END CONTENT BODY -->

    </div>

    <!-- END CONTENT -->

    <!-- BEGIN QUICK SIDEBAR -->


    <!-- END QUICK SIDEBAR -->

</div>

<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->

<?php include('footer.php'); ?>


<!-- END FOOTER -->


<!--[if lt IE 9]>

<script src="../assets/global/plugins/respond.min.js"></script>

<script src="../assets/global/plugins/excanvas.min.js"></script>

<script src="../assets/global/plugins/ie8.fix.min.js"></script>

<![endif]-->

<!-- BEGIN CORE PLUGINS -->

<?php include('core_plugins.php'); ?>

<script src="../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>

<script src="../assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"
        type="text/javascript"></script>

<script src="../assets/pages/scripts/components-date-time-pickers.min.js" type="text/javascript"></script>

<script type="text/javascript">

    function load_vendor() {
        var role = $('#role').val();
        if (role == "Vendor" || role == "Manager") {
            $('#id_vendor').show();
            $('#id_vendor').attr("required", true);
            if ($('#id_vendor').val() == "7") {
                $('#id_warehouse').show();
                $('#id_warehouse').attr("required", true);
            }
        } else {
            $('#id_vendor').hide();
            $('#id_vendor').attr("required", false);
            $('#id_warehouse').hide();
            $('#id_warehouse').val(0);
            $('#id_warehouse').attr("required", false);
        }
    }

    function load_warehouses() {
        let vender = $('#id_vendor').val();
        if (vender == '7') {
            $('#id_warehouse').show();
            $('#id_warehouse').attr("required", true);
        } else {
            $('#id_warehouse').hide();
            $('#id_warehouse').val(0);
            $('#id_warehouse').attr("required", false);
        }
    }


</script>

</body>


</html>