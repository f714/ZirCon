<?php

$page=explode('/admin/',$_SERVER['REQUEST_URI']);

$p=explode('.php',$page[1]);

$p=$p[0];

$active='active open';

//echo $p;

?>



<div class="page-sidebar-wrapper">

                <!-- BEGIN SIDEBAR -->

                <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->

                <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->

                <div class="page-sidebar navbar-collapse collapse">

                    <!-- BEGIN SIDEBAR MENU -->

                    <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->

                    <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->

                    <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->

                    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->

                    <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->

                    <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->

                    <ul class="page-sidebar-menu   " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                    
                    
                    

                        <li class="nav-item start <?php if($p=="welcome"){echo $active;}?>">

                            <a href="welcome.php" class="nav-link ">

                                <i class="icon-home"></i>

                                <span class="title">Dashboard</span>

                                <span class="selected"></span>

                 

                            </a>

                           
                        </li>
                        
                         <?php 
								if($_SESSION['login_role']=="Admin" or $_SESSION['login_role']=="user"){
						?>
						
						<li class="nav-item start <?php if($p=="studyhammer_students"){echo $active;}?>">
						
													<a href="javascript:;" class="nav-link nav-toggle">
						
														<i class="icon-layers"></i>
						
														<span class="title">Products</span>
						
														<span class="selected"></span>
						
														<span class="arrow open"></span>
						
													</a>
						
													<ul class="sub-menu">
						
														<li class="nav-item start <?php if($p=="product_categories" or $p=="add_product_category"){echo 'active';}?>">
						
															<a href="add_product_category.php" class="nav-link ">
						
																<i class="fa fa-list"></i>
						
																<span class="title">Product Category </span>
						
															</a>
						
														</li>
														
														<li class="nav-item start <?php if($p=="product_categories"){echo 'active';}?>">
						
															<a href="add_product_category.php" class="nav-link ">
						
																<i class="fa fa-list"></i>
						
																<span class="title">Product List </span>
						
															</a>
						
														</li>
														
														<li class="nav-item start <?php if($p=="add_product"){echo 'active';}?>">
						
															<a href="add_product_category.php" class="nav-link ">
						
																<i class="fa fa-list"></i>
						
																<span class="title">Add Product</span>
						
															</a>
						
														</li>																												
														<li class="nav-item start <?php if($p=="orders" or $p=="add_order"){echo 'active';}?>">
						
															<a href="orders.php" class="nav-link ">
						
																<i class="fa fa-list"></i>
						
																<span class="title">Order List </span>
						
															</a>
						
														
														
														<li class="nav-item start <?php if($p=="add_order"){echo 'active';}?>">
						
															<a href="add_order.php" class="nav-link ">
						
																<i class="fa fa-list"></i>
						
																<span class="title">Add Order</span>
						
															</a>
						
														</li>
														
														</li>
														
													</ul>
						
												</li>
                        
						<?php
							}else{
							
						$_SESSION['err']="Invalid Login ID/Password, Please try again.";
	
						header("location:index.php");
							
                        
							}
						?>

                    </ul>

                    <!-- END SIDEBAR MENU -->

                </div>

                <!-- END SIDEBAR -->

            </div>
            
 