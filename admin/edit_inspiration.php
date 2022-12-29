<?php

include("chksession.php");

include("Common.php");

include('header.php');

$customers = mysqli_query($con, "select * from inspirations where id='" . mysqli_real_escape_string($con, $_GET['id']) . "'");

$c = mysqli_fetch_array($customers);

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

                    <h1>Inspiration Management

                        <small>Edit Inspiration</small>

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

                    <a href="inspirations.php">Inspirations</a></li>

                <li>

                    <span class="active">Edit Inspiration</span>

                </li>

            </ul>

            <!-- END PAGE BREADCRUMB -->

            <!-- BEGIN PAGE BASE CONTENT -->


            <div class="row">

                <div class="col-sm-12">

                    <div class="portlet box blue ">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift"></i>Edit Inspiration
                            </div>
                        </div>

                        <div class="portlet-body form">


                            <form class="form-horizontal" method="post" role="form"
                                  action="edit_inspiration2.php?id=<?php echo $c['id'] ?>"
                                  enctype="multipart/form-data">

                                <div class="form-body">

                                    <div class="row">

                                        <div class="col-sm-8">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Title:</label>
                                                <div class="col-sm-8">
                                                    <input class="form-control" name="title"
                                                           value="<?php echo $c['title'] ?>" type="text">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Image:</label>
                                                <div class="col-sm-8">
                                                    <img width="150px" src="inspiration_images/<?php echo $c['image']; ?>"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Select New Image:</label>

                                                <div class="col-sm-8">
                                                    <input class="form-control" name="image" value=""
                                                           type="file">
                                                </div>
                                            </div>
                                        </div>


                                    </div>


                                    <div class="form-actions right1">

                                        <button type="button" class="btn default"
                                                onclick="window.location='inspirations.php'">Cancel
                                        </button>

                                        <button type="submit" class="btn green">Save</button>

                                    </div>
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

<?php //include('quick_nav.php'); ?>

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

    $(".date-picker").datetimepicker({format: 'yyyy-mm-dd hh:ii'});

</script>
<script type="text/javascript" src="js/webcam.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>

</body>


</html>