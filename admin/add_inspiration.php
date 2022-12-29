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

                    <h1>Inspiration Management

                        <small>Add Inspiration</small>

                    </h1>
                </div>
            </div>
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="inspirations.php">Inspirations List </a></li>
                <li>

                    <span class="active">Add New Inspiration</span>

                </li>

            </ul>
            <div class="row">

                <div class="col-sm-12">

                    <div class="portlet box blue ">

                        <div class="portlet-title">

                            <div class="caption">

                                <i class="fa fa-gift"></i>Create New Inspiration
                            </div>


                        </div>

                        <div class="portlet-body form">

                            <form class="form-horizontal" method="post" role="form" action="add_inspiration2.php"
                                  enctype="multipart/form-data">

                                <div class="form-body">

                                    <div class="row">

                                        <div class="col-sm-8">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Title:</label>
                                                <div class="col-sm-8">
                                                    <input class="form-control" name="title" value=""
                                                           type="text" required>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Image:</label>
                                                <div class="col-sm-8">
                                                    <input class="form-control" name="image" value="" type="file" required>
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


        </div>


    </div>
    <!-- END QUICK SIDEBAR -->

</div>

<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->

<?php include('footer.php'); ?>


<?php //include('quick_nav.php'); ?>


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