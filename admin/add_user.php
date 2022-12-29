<?php

include("chksession.php");

include("Common.php");

include('header.php');

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

                        <small>Add User</small>

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

                                <i class="fa fa-gift"></i> Add New
                            </div>

                            <div class="tools">

                                <a href="" class="collapse"> </a>

                                <!--<a href="#portlet-config" data-toggle="modal" class="config"> </a>

                                <a href="" class="reload"> </a>-->

                                <a href="" class="remove"> </a>

                            </div>

                        </div>

                        <div class="portlet-body form">

                            <form class="form-horizontal" method="post" role="form" action="add_user2.php">

                                <div class="form-body">

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Name</label>

                                        <div class="col-sm-4">

                                            <input class="form-control" name="name" placeholder="Name" type="text"
                                                   required></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Username</label>

                                        <div class="col-sm-4">
                                            <input name="username" class="form-control" placeholder="Username" type="text"
                                                   required></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Email</label>

                                        <div class="col-sm-4">
                                            <input name="email" class="form-control" placeholder="Email" type="email"
                                                   required></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Password</label>

                                        <div class="col-sm-4">

                                            <input name="password" class="form-control" placeholder="Password"
                                                   type="password" required></div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">Phone</label>

                                        <div class="col-sm-4">

                                            <input name="phone" class="form-control" placeholder="Phone" type="text" required>
                                        </div>

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

<!-- BEGIN QUICK NAV -->

<!-- u -->


<!-- END QUICK NAV -->

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


</script>

</body>


</html>