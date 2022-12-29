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

                            <h1>Products Management

                                <small>Add Bulk Products</small>

                            </h1>
                        </div>
                    </div>
                    <ul class="page-breadcrumb breadcrumb">
                        <li>
                            <a href="products.php">Products List </a></li>
                        <li>

                            <span class="active">Add Bulk Products</span>

                        </li>

                    </ul>
                    <div class="row">

                    	<div class="col-sm-12">

                        	<div class="portlet box blue ">

                                <div class="portlet-title">

                                    <div class="caption">
                                        Create New Product</div>                                  
                                </div>

                                <div class="portlet-body form">
                                    <form class="form-horizontal" method="post" role="form" action="add_product_bulk2.php" enctype="multipart/form-data">
                                        <div class="form-body">										
											<div class="row">
											
                                            	<div class="col-sm-8">
												<div class="form-group">
                                                        <label class="col-sm-4 control-label">Vendor:</label>
                                                        <div class="col-sm-8">        
                                                            <select name="vendor_id" id="vendor_id" class="form-control" onChange="load_category();">
                                                            <option class="form-control" value="" selected>Select Vendor</option>
                                                            <?php 
                                                            $query = mysqli_query($con,"select * from vendors");
                                                            while($row=mysqli_fetch_array($query)){
                                                            ?>
                                                                <option class="form-control" value="<?php echo $row['id']; ?>" ><?php echo $row['business_name'];?></option>
                                                                <?php
                                                            }
                                                              ?>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Warehouse:</label>        
                                                        <div class="col-sm-8">
                                         <select name="warehouse" class="form-control">
                                                            <option class="form-control" value="">Select warehouse</option>
                                                            <?php 
                                                            $query = mysqli_query($con,"select * from warehouse");
                                                            while($row=mysqli_fetch_array($query)){
                                                            ?>
                                                                <option class="form-control" value="<?php echo $row['id']; ?>"><?php echo $row['name'] ?></option>
                                                                <?php
                                                            }
                                                              ?>
                                                            </select>
                                                         </div>
                                                    </div>
                                                <div class="form-group">
                                                        <label class="col-sm-4 control-label">Category :</label>
                                                        <div class="col-sm-8">        
                                                            <select name="id_category" id="id_category" class="form-control">
                                                            <option class="form-control" value="">Select Category</option>
                                                            <?php
                                        if($_SESSION['login_id_vendor']==6){
                                            $query = mysqli_query($con,"select * from category where id=9");
                                        }else{
                                            $query = mysqli_query($con,"select * from category");
                                            
                                        }
                                        
                                                            while($row=mysqli_fetch_array($query)){
                                                            ?>
                                                                <option class="form-control" value="<?php echo $row['id']; ?>"><?php echo $row['name']; ?></option>
                                                                <?php
                                                            }
                                                              ?>
                                                            </select>
                                                        </div>
                                                    </div>

													
                                                    
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">SKU (Optional):</label>        
                                                        <div class="col-sm-8">
                                                            <input class="form-control" name="sku" value="" type="text" >
                                                         </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Wave:</label>        
                                                        <div class="col-sm-8">
                                                            <input class="form-control" name="wave" value="" type="number" >
                                                         </div>
                                                    </div>
                                                    
                                                     <div class="form-group">
                                                        <label class="col-sm-4 control-label">Product Type:</label>        
                                                        <div class="col-sm-8">
                                                            <select name="product_type" class="form-control">
                                                                
                                                                <option class="form-control" value="NEW" selected>NEW</option>
                                                                <option class="form-control" value="BAU">BAU</option>
                                                                <option class="form-control" value="USED">USED/INTERIM/EXTRA</option>
                                                                
                                                                
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Quantity:</label>        
                                                        <div class="col-sm-8">
                                                            <input class="form-control" name="qty" value="" type="number" required >
                                                         </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Name:</label>        
                                                        <div class="col-sm-8">
                                                            <input class="form-control" name="name" value="" type="text" required >
                                                         </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Description:</label>        
                                                            <div class="col-sm-8">
                                                            <textarea class="form-control" name="description"></textarea>
                                                         </div>
                                                    </div>

                                                  


                                                    
													<div class="form-group">
                                                        <label class="col-sm-4 control-label">Product Image:</label>        
                                                        <div class="col-sm-8">                                                        	
                                                            <input class="form-control" name="product_image" value="" type="file" >        
                                                         </div>        
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Status:</label>        
                                                        <div class="col-sm-8">
                                                            <select name="status" class="form-control">
                                                                <option class="form-control" value="">Select Status</option>
                                                                <option class="form-control" value="Available at warehouse" selected>Available at warehouse</option>
                                                                <option class="form-control" value="Lost at Warehouse/FSL">Lost at Warehouse/FSL</option>
                                                                <option class="form-control" value="Lost in Transit">Lost in Transit</option>
                                                                <option class="form-control" value="In transit">In Transit</option>
                                                                <option class="form-control" value="Damaged received from OEM">Damaged received from OEM</option>
                                                                <option class="form-control" value="Damaged received from User">Damaged received from User</option>
                                                                <option class="form-control" value="Ship Request Acknowledge">Ship Request Acknowledge</option>
                                                                <option class="form-control" value="Dispatch Initiated">Dispatch Initiated</option>
                                                                <option class="form-control" value="Delivered">Delivered</option>
                                                                
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Received Date:</label>        
                                                        <div class="col-sm-8">
                                                            <input class="form-control" name="received_dt" value="" type="date" required >
                                                         </div>
                                                    </div>

										        </div>										        
										    </div>
											
                                        <div class="form-actions right1">
                                            <button type="button" class="btn default" onclick="window.location='products.php'">Cancel</button>
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

        <script src="../assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

        <script src="../assets/pages/scripts/components-date-time-pickers.min.js" type="text/javascript"></script>

        <script type="text/javascript">

    		$(".date-picker").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
             function load_category(){
                var vendor=$('#vendor_id').val();
                
                if(vendor==6){
                    $('#id_category').val(9).change();
                }
            }

		</script>
        <script type="text/javascript" src="js/webcam.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>

    </body>



</html>