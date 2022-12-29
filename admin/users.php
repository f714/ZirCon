<?php
include("chksession.php");
include("Common.php");
include("header.php");
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

                        <!--<small>statistics, charts, recent events and reports</small>-->

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

                    <a href="welcome.php">Home</a>

                    <i class="fa fa-circle"></i>

                </li>

                <li>

                    <span class="active">Users</span>

                </li>

            </ul>

            <!-- END PAGE BREADCRUMB -->

            <!-- BEGIN PAGE BASE CONTENT -->


            <div class="row">

                <div class="col-md-12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet light bordered">


                        <div class="portlet-body">

                            <div class="table-toolbar">

                                <div class="row">

                                    <div class="col-md-6">

                                        <div class="btn-group">

                                            <a href="add_user.php"/>

                                            <button id="sample_editable_1_2_new" class="btn sbold green"> Add New

                                                <i class="fa fa-plus"></i>

                                            </button>

                                            </a>

                                        </div>

                                    </div>

                                </div>

                            </div>

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

                            <div id="sample_1_2_wrapper" class="dataTables_wrapper">


                                <table class="table table-striped table-bordered table-hover table-checkable order-column dataTable"
                                       id="sample_2" role="grid" aria-describedby="sample_1_2_info">

                                    <thead>

                                    <tr role="row">


                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 24px;"
                                            aria-label=" Email : activate to sort column ascending"> S No
                                        </th>

                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 104px;"
                                            aria-label=" Status : activate to sort column ascending">Name
                                        </th>

                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 104px;"
                                            aria-label=" Status : activate to sort column ascending">Username / Password
                                        </th>

                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 112px;"
                                            aria-label=" Joined : activate to sort column ascending"> Email / Phone
                                        </th>

                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 112px;"
                                            aria-label=" Joined : activate to sort column ascending"> Reg. Date
                                        </th>

                                        <th class="sorting" tabindex="0" aria-controls="sample_1_2" rowspan="1"
                                            colspan="1" style="width: 115px;"
                                            aria-label=" Actions : activate to sort column ascending"> Actions
                                        </th>

                                    </tr>

                                    </thead>


                                    <tbody>

                                    <?php

                                    $sql = "select * from users;";
                                    $result = mysqli_query($con, $sql);
                                    while ($row = mysqli_fetch_array($result)) {


                                        ?>

                                        <tr class="gradeX odd" role="row">

                                            <td>

                                                <?php echo $row['id']; ?>

                                            </td>

                                            <td>

                                                <?php echo $row['name']; ?>

                                            </td>

                                            <td>

                                                <strong>U:</strong> <?php echo $row['username']; ?><br/>

                                                <strong>P:</strong> <?php echo $row['password']; ?></td>

                                            <td><?php echo $row['email']; ?> /
                                                <br/>

                                                <?php echo $row['phone']; ?>

                                            </td>

                                            <td class="center">

                                                <?php

                                                $rdate = $row['reg_date'];
                                                $date = date_create($rdate);
                                                echo date_format($date, "d/m/Y");

                                                ?>

                                            </td>


                                            <td>

                                                <div class="btn-group">

                                                    <button class="btn  btn-xs blue-hoki btn-outline dropdown-toggle btn-width"
                                                            type="button" data-toggle="dropdown"
                                                            aria-expanded="false"> Actions

                                                        <i class="fa fa-angle-down"></i>

                                                    </button>

                                                    <ul class="dropdown-menu" role="menu">


                                                        <li>


                                                            <a class="" data-toggle="confirmation"
                                                               data-placement="left" data-title="Delete Record"
                                                               href="del_user.php?id=<?php echo $row['id']; ?>"
                                                               target="">

                                                                <button class="btn btn-xs sbold red btn-width">

                                                                    <i class="fa fa-trash-o"></i>Delete

                                                                </button>

                                                            </a>

                                                        </li>

                                                        <li>


                                                            <a href="edit_user.php?id=<?php echo $row['id']; ?>">

                                                                <button class="btn btn-xs sbold yellow-mint btn-width">

                                                                    <i class="fa fa-edit"></i>Edit

                                                                </button>

                                                            </a>

                                                        </li>


                                                    </ul>

                                                </div>

                                            </td>

                                        </tr>


                                        <?php


                                    }

                                    ?>

                                    </tbody>

                                </table>


                            </div>

                        </div>

                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

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


<!-- BEGIN CORE PLUGINS -->

<?php include('core_plugins.php'); ?>


<!-- END THEME LAYOUT SCRIPTS -->

<script src="../assets/global/plugins/bootstrap-confirmation/bootstrap-confirmation.min.js"
        type="text/javascript"></script>

<script src="../assets/pages/scripts/ui-confirmations.min.js" type="text/javascript"></script>


</body>


</html>