<?php

include("chksession.php");

include("Common.php");

include("header.php");

					   $sql="select * from  events  order by id ASC";
				

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

                            <h1>Events Management

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

                            <a href="events.php">Events</a>

                            <i class="fa fa-circle"></i>

                        </li>

                        <li>

                            <span class="active">Events</span>

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

                                                    <a href="add_event.php" />

                                                    	<button id="sample_editable_1_2_new" class="btn sbold green" >Create New Event

                                                        	<i class="fa fa-plus"></i>

                                                   	  </button>

                                                    </a>

                                                </div>

                                            </div>

                                        </div>

                                    </div>

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

										}else if(isset($_SESSION['err']) && $_SESSION['err']!='' ){

										?>

										<div class="alert alert-danger  display-hide" style="display:block">

											<button class="close" data-close="alert"></button>

											<span><?php echo $_SESSION['err']; $_SESSION['err']="";?> </span>

										</div>

										

									<?php

										$_SESSION['err']='';

										}

									?>

                                    <div id="" class="">

										
                                            <table class="table table-striped table-bordered table-hover dataTable" id="sample_2">

                                        		<thead>

                                            		<tr role="row">

                                                 
                                                        <th width="106" rowspan="1" class="sorting" style="width: 150px;" tabindex="0" aria-controls="sample_1_2" aria-label=" Status : activate to sort column ascending">Event Name</th>
                                                        <th width="106" rowspan="1" class="sorting" style="width: 150px;" tabindex="0" aria-controls="sample_1_2" aria-label=" Status : activate to sort column ascending">Event Time</th>
                                                        <th width="106" rowspan="1" class="sorting" style="width: 150px;" tabindex="0" aria-controls="sample_1_2" aria-label=" Status : activate to sort column ascending">Event Type</th>
														<th width="106" rowspan="1" class="sorting" style="width: 150px;" tabindex="0" aria-controls="sample_1_2" aria-label=" Status : activate to sort column ascending">Event Data </th>
                                                        
                                                        <th width="115" colspan="1" rowspan="1" class="sorting" style="width: 115px;" tabindex="0" aria-controls="sample_1_2" aria-label=" Actions : activate to sort column ascending"> Actions </th>

                                                	</tr>

                                       			</thead>

                                        		

                                        		<tbody>

												<?php
						
								   $result=mysqli_query($con,$sql);
								   
								  while($row=mysqli_fetch_array($result)){


									   ?>

                                                    <tr class="gradeX odd" role="row">
                                                        
                                                          <td> <?php echo $row['event_name'];?> </td>
                                                          <td> <?php echo $row['event_time'];?> </td>
                                                          <td> <?php echo $row['event_type'];?> </td>
                                                          
                                                   <!--    <img src="profiles_images/'.$_SESSION["image"] profiles_images/'.$img..""admin/img/" />-->
                                                       <td>    
                                                   <?php
												   if($row['event_type']=='Image'){
													echo  " <img src='img/". $row["event_data"]."'  width='100px'  alt=''>";
													
												   }elseif($row['event_type']=='Video'){
													   echo '<video width="100" height="100" controls>
															  <source src="img/'. $row["event_data"].'">
															</video>';
													   
													   }else{
														   echo '<div>'.$row["event_data"].'</div>';
														   }
													?> 
                                                          </td>
														   
                                                          <td>

                                                            <div class="btn-group">

                                                                <button class="btn  btn-xs blue-hoki btn-outline dropdown-toggle btn-width" type="button" data-toggle="dropdown" aria-expanded="false"> Actions

                                                                    <i class="fa fa-angle-down"></i>

                                                                </button>

                                                                <ul class="dropdown-menu" role="menu">

																	
                                                                    <li>

                                                                        

																		<a class="" data-toggle="confirmation" data-placement="left" data-title="Delete Record"

   href="del_event.php?id=<?php echo $row['id'];?>" target="">

   																			<button class="btn btn-xs sbold red btn-width" > 

                                                                                <i class="fa fa-trash-o"></i>Delete 

                                                    						</button>

                                                                        </a>

                                                                    </li>

                                                                    <li>

																	

                                                                        <a href="edit_event.php?id=<?php echo $row['id'];?>" >

                                                                            <button class="btn btn-xs sbold yellow-mint btn-width" > 

                                                                                <i class="fa fa-edit"></i>Edit 

                                                    						</button>

                                                                        </a>

                                                                    </li>
																	
																	<!--<li>

																	

                                                                        <a href="view_company.php?id=" >

                                                                            <button class="btn btn-xs sbold green-mint btn-width" > 

                                                                                <i class="fa fa-eye"></i>View 

                                                    						</button>

                                                                        </a>

                                                                    </li>-->
																	
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

		<script src="../assets/global/plugins/bootstrap-confirmation/bootstrap-confirmation.min.js" type="text/javascript"></script>

		<script src="../assets/pages/scripts/ui-confirmations.min.js" type="text/javascript"></script>

        <script>

            $(document).ready(function()

            {

                $('#clickmewow').click(function()

                {

                    $('#radio1003').attr('checked', 'checked');

                });

            })

        </script>

    </body>



</html>