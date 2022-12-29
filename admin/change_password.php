v<?php 

include("chksession.php");

include("Common.php");

include('header.php');


 ?>

        <!-- BEGIN CONTAINER -->

        <div class="page-container">

            <!-- BEGIN SIDEBAR -->

            <?php include('left_sidebar.php'); ?>

          
            <div class="page-content-wrapper">

                <!-- BEGIN CONTENT BODY -->

                <div class="page-content">

                    <!-- BEGIN PAGE HEAD-->

                    <div class="page-head">

                        <!-- BEGIN PAGE TITLE -->

                        <div class="page-title">

                            <h1>User Management

                                <small>Change Password</small>

                            </h1>

                        </div>

                     

                    </div>

                  
                    <ul class="page-breadcrumb breadcrumb">

                        <li>

                            <!--<a href="users.php">User</a>-->

                            <i class="fa fa-circle"></i>

                        </li>

                        <li>

                            <span class="active">Change Password</span>

                        </li>

                    </ul>

                    <!-- END PAGE BREADCRUMB -->

                    <!-- BEGIN PAGE BASE CONTENT -->

                    

                    <div class="row">

                    	<div class="col-sm-12">

                        	<div class="portlet box blue ">

                                <div class="portlet-title">

                                    <div class="caption">

                                        <i class="fa fa-gift"></i>Change Password User</div>

                                   
                                </div>

                                <div class="portlet-body form">

                                   <?php

									//echo $sql;

										if(isset($_SESSION['msg']) && $_SESSION['msg']!='' ){

										?>

										<div class="alert alert-success display-hide" style="display:block">

											<button class="close" data-close="alert"></button>

											<span><?php echo $_SESSION['msg']; $_SESSION['msg']="";?> </span>

										</div>

										

									<?php

										$_SESSION['msg']='';

										}else if(isset($_SESSION['err']) and $_SESSION['err']!='' ){

										?>

										<div class="alert alert-danger  display-hide" style="display:block">

											<button class="close" data-close="alert"></button>

											<span><?php echo $_SESSION['err']; $_SESSION['err']="";?> </span>

										</div>

										

									<?php

										$_SESSION['err']='';

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

                                    <form class="form-horizontal" method="post" role="form" action="change_password2.php" enctype="multipart/form-data">

                                        <div class="form-body">
										
								

                                      
											<div class="form-group">

                                                <label class="col-sm-2 control-label">Enter New Password:</label>

                                                <div class="col-sm-4">

                                                    <input name="password" class="form-control" value="" type="password" required> </div>

                                                  

                                            </div>

                                            	
                                            
                                            	
                                            
                                            


                                        <div class="form-actions right1">

                                            <button type="button" class="btn default" onclick="window.location='studyhammer_student.php'">Cancel</button>

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

        <?php include('quick_nav.php'); ?>

        

        

        <!-- END QUICK NAV -->

        <!--[if lt IE 9]>

<script src="../assets/global/plugins/respond.min.js"></script>

<script src="../assets/global/plugins/excanvas.min.js"></script> 

<script src="../assets/global/plugins/ie8.fix.min.js"></script> 

<![endif]-->

        <!-- BEGIN CORE PLUGINS -->

        <?php include('core_plugins.php'); ?>

        <script src="../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>

        <script src="../assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

        <script src="../assets/pages/scripts/components-date-time-pickers.min.js" type="text/javascript"></script>

        <script type="text/javascript">

    		$(".date-picker").datetimepicker({format: 'yyyy-mm-dd hh:ii'});

		</script>

    </body>



</html>