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

        <!-- B EGIN CONTENT BODY -->

        <div class="page-content">

            <!-- BEGIN PAGE HEAD-->

            <div class="page-head">

                <!-- BEGIN PAGE TITLE -->

                <div class="page-title">

                    <h1>Welcome

                        <small>statistics</small>

                    </h1>

                </div>

                <!-- END PAGE TITLE -->

            </div>

            <!-- END PAGE HEAD-->

            <!-- BEGIN PAGE BREADCRUMB -->

            <ul class="page-breadcrumb breadcrumb">

                <!--<li>

                    <a href="welcome.php">Home</a>

                    <i class="fa fa-circle"></i>

                </li>-->

                <li>

                    <span class="active">Dashboard</span>

                </li>

            </ul>

            <!-- END PAGE BREADCRUMB -->

            <!-- BEGIN PAGE BASE CONTENT -->
            <div class="row widget-row">


                <!-- END WIDGET THUMB -->

                <div class="col-md-4">

                    <!-- BEGIN WIDGET THUMB -->

                    <?php

                    $verses = 0;


                            $sql = "SELECT count(id) as count FROM verses ";


                    if ($result = mysqli_query($con, $sql)) {

                        $rowcount = mysqli_fetch_array($result);

                        $verses = $rowcount['count'];

                        mysqli_free_result($result);

                    }

                    ?>

                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">

                        <h4 class="widget-thumb-heading">Total Verses</h4>

                        <div class="widget-thumb-wrap">

                            <i class="widget-thumb-icon bg-green icon-layers"></i>

                            <div class="widget-thumb-body">

                                <span class="widget-thumb-subtitle"></span>

                                <span class="widget-thumb-body-stat" data-counter="counterup"
                                      data-value="<?php echo $verses; ?>">0</span>

                            </div>

                        </div>

                    </div>


                    <!-- END WIDGET THUMB -->

                </div>

                <div class="col-md-4">

                    <!-- BEGIN WIDGET THUMB -->

                    <?php

                    $diseases = 0;


                    $sql = "SELECT count(id) as count FROM diseases ";


                    if ($result = mysqli_query($con, $sql)) {

                        $rowcount = mysqli_fetch_array($result);

                        $diseases = $rowcount['count'];

                        mysqli_free_result($result);

                    }

                    ?>

                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">

                        <h4 class="widget-thumb-heading">Total Diseases</h4>

                        <div class="widget-thumb-wrap">

                            <i class="widget-thumb-icon bg-green icon-layers"></i>

                            <div class="widget-thumb-body">

                                <span class="widget-thumb-subtitle"></span>

                                <span class="widget-thumb-body-stat" data-counter="counterup"
                                      data-value="<?php echo $diseases; ?>">0</span>

                            </div>

                        </div>

                    </div>


                    <!-- END WIDGET THUMB -->

                </div>

                <div class="col-md-4">

                    <!-- BEGIN WIDGET THUMB -->

                    <?php

                    $inspirations = 0;


                    $sql = "SELECT count(id) as count FROM inspirations ";


                    if ($result = mysqli_query($con, $sql)) {

                        $rowcount = mysqli_fetch_array($result);

                        $inspirations = $rowcount['count'];

                        mysqli_free_result($result);

                    }

                    ?>

                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">

                        <h4 class="widget-thumb-heading">Total Inspirations</h4>

                        <div class="widget-thumb-wrap">

                            <i class="widget-thumb-icon bg-green icon-layers"></i>

                            <div class="widget-thumb-body">

                                <span class="widget-thumb-subtitle"></span>

                                <span class="widget-thumb-body-stat" data-counter="counterup"
                                      data-value="<?php echo $inspirations; ?>">0</span>

                            </div>

                        </div>

                    </div>


                    <!-- END WIDGET THUMB -->

                </div>

                <!-- END WIDGET THUMB -->
            </div>




        </div>

        <!-- END CONTENT BODY -->

    </div>

</div>


<?php include('footer.php'); ?>


<?php //include('quick_nav.php'); ?>



<?php include('core_plugins.php'); ?>


<!-- END THEME LAYOUT SCRIPTS -->


</body>


</html>