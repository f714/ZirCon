<?php

include("chksession.php");

include("Common.php");

include("header.php");
$sql = "select * from verses order by title ASC";

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

                    <h1>Verses Management

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

                    <a href="verses.php">Verses</a>

                    <i class="fa fa-circle"></i>

                </li>

                <li>

                    <span class="active">Verses</span>

                </li>

            </ul>
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet light bordered">
                        <div class="portlet-body">
                            <div class="table-toolbar">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="btn-group">
                                            <a href="add_verse.php">
                                                <button id="sample_editable_1_2_new" class="btn sbold green">Create New
                                                    Verses
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <?php

                            //echo $sql;

                            if (isset($_SESSION['msg']) && $_SESSION['msg'] != '') {
                                ?>
                                <div class="alert alert-success display-hide" style="display:block">
                                    <button class="close" data-close="alert"></button>
                                    <span><?php echo $_SESSION['msg'];
                                        $_SESSION['msg'] = ""; ?> </span>
                                </div>


                                <?php

                                $_SESSION['msg'] = '';
                            } else if (isset($_SESSION['err']) && $_SESSION['err'] != '') {
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

                            <div id="" class="">
                                <table class="table table-striped table-bordered table-hover dataTable" id="sample_5">
                                    <thead>
                                    <tr role="row">
                                        <th width="80" rowspan="1" class="sorting" style="width: 80px;" tabindex="0"
                                            aria-controls="sample_1_2"
                                            aria-label=" Status : activate to sort column ascending">ID
                                        </th>
                                        <th width="30" rowspan="1" class="sorting" style="width: 30px;" tabindex="0"
                                            aria-controls="sample_1_2"
                                            aria-label=" Status : activate to sort column ascending"> Title
                                        </th>
                                        <th width="200" rowspan="1" class="sorting" style="width: 200px;" tabindex="0"
                                            aria-controls="sample_1_2"
                                            aria-label=" Status : activate to sort column ascending">Verse
                                        </th>

                                        <th width="200" rowspan="1" class="sorting" style="width: 200px;" tabindex="0"
                                            aria-controls="sample_1_2"
                                            aria-label=" Status : activate to sort column ascending">translation
                                        </th>

                                        <th width="106" rowspan="1" class="sorting" style="width: 150px;" tabindex="0"
                                            aria-controls="sample_1_2"
                                            aria-label=" Status : activate to sort column ascending">Created Date
                                        </th>
                                        <th width="115" colspan="1" rowspan="1" class="sorting" style="width: 115px;"
                                            tabindex="0" aria-controls="sample_1_2"
                                            aria-label=" Actions : activate to sort column ascending"> Actions
                                        </th>

                                    </tr>

                                    </thead>

                                    <tbody>

                                    <?php

                                    $result = mysqli_query($con, $sql);
                                    while ($row = mysqli_fetch_array($result)) {

                                        ?>

                                        <tr class="gradeX odd" role="row">
                                            <td> <?php echo $row['id']; ?> </td>
                                            <td> <?php echo $row['title']; ?> </td>
                                            <td> <?php echo $row['verse']; ?> </td>
                                            <td> <?php echo $row['translation']; ?> </td>
                                            <td> <?php echo $row['created_date']; ?> </td>

                                            <td>
                                                <div class="btn-group">
                                                    <button class="btn  btn-xs blue-hoki btn-outline dropdown-toggle btn-width"
                                                            type="button" data-toggle="dropdown" aria-expanded="false">
                                                        Actions
                                                        <i class="fa fa-angle-down"></i>
                                                    </button>

                                                    <ul class="dropdown-menu" role="menu">
                                                        <li>
                                                            <a class="" data-toggle="confirmation"
                                                               data-placement="left" data-title="Delete Record"
                                                               href="del_verse.php?id=<?php echo $row['id']; ?>"
                                                               target="">
                                                                <button class="btn btn-xs sbold red btn-width">
                                                                    <i class="fa fa-trash-o"></i>Delete
                                                                </button>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="edit_verse.php?id=<?php echo $row['id']; ?>">
                                                                <button class="btn btn-xs sbold yellow-mint btn-width">
                                                                    <i class="fa fa-edit"></i>Edit
                                                                </button>
                                                            </a>
                                                        </li>

                                                    </ul>
                                                </div>
                                            </td>
                                            <!--<td>


                                                <a class="" data-toggle="confirmation" data-placement="left"
                                                   data-title="Delete Record"
                                                   href="del_ticket.php?id=<?php /*echo $row['id']; */ ?>"
                                                   target="">
                                                    <button class="btn btn-xs sbold red btn-width">
                                                        <i class="fa fa-trash-o"></i>Delete
                                                    </button>
                                                </a>

                                                <a href="edit_ticket.php?id=<?php /*echo $row['id']; */ ?>">
                                                    <button class="btn btn-xs sbold yellow-mint btn-width">
                                                        <i class="fa fa-edit"></i>Edit
                                                    </button>
                                                </a>

                                            </td>-->

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
<!-- END FOOTER -->
<!-- BEGIN QUICK NAV -->
<?php //include('quick_nav.php'); ?>

<!-- END QUICK NAV -->

<!--[if lt IE 9]>

<script src="../assets/global/plugins/respond.min.js"></script>

<script src="../assets/global/plugins/excanvas.min.js"></script>

<script src="../assets/global/plugins/ie8.fix.min.js"></script>

<![endif]-->

<!-- BEGIN CORE PLUGINS -->

<?php include('core_plugins.php'); ?>


<!-- END THEME LAYOUT SCRIPTS -->

<script src="../assets/global/plugins/bootstrap-confirmation/bootstrap-confirmation.min.js"
        type="text/javascript"></script>
<script src="../assets/pages/scripts/ui-confirmations.min.js" type="text/javascript"></script>
<script>

    $(document).ready(function () {
        $('#clickmewow').click(function () {
            $('#radio1003').attr('checked', 'checked');
        });
    })
</script>
</body>
</html>