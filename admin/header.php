<!DOCTYPE html>



<html lang="en">

    <!--<![endif]-->

    <!-- BEGIN HEAD -->



    <head>

        <meta charset="utf-8" />

        <title>Zircon</title>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta content="width=device-width, initial-scale=1" name="viewport" />

        <meta content="Inventory Management System" name="description" />

        <meta content="" name="author" />

        <!-- BEGIN GLOBAL MANDATORY STYLES -->

        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />

        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN PAGE LEVEL PLUGINS -->

       <link href="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css" />

		

		<link href="../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css" />

        <!-- END PAGE LEVEL PLUGINS -->

        <!-- BEGIN THEME GLOBAL STYLES -->

        <link href="../assets/global/css/components-md.min.css" rel="stylesheet" id="style_components" type="text/css" />

        

       	<link href="../assets/global/css/plugins-md.min.css" rel="stylesheet" type="text/css" />

        <!-- END THEME GLOBAL STYLES -->

        <!-- BEGIN THEME LAYOUT STYLES -->

        <link href="../assets/layouts/layout4/css/layout.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/layouts/layout4/css/themes/default.min.css" rel="stylesheet" type="text/css" id="style_color" />

        <link href="../assets/layouts/layout4/css/custom.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet" type="text/css" />
		    <link href="../assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />


		<link href="../assets/global/css/style.css" rel="stylesheet" type="text/css" />
        
		        <link href="../assets/pages/css/invoice-2.min.css" rel="stylesheet" type="text/css" />

        <!-- END THEME LAYOUT STYLES -->

        <link href="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="css/custom.css" rel="stylesheet" type="text/css" />

        <link rel="shortcut icon" href="favicon.ico" /> 
        

		

		</head>

    <!-- END HEAD -->



    <body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo page-md">

        <!-- BEGIN HEADER -->

        <div class="page-header navbar navbar-fixed-top">

            <!-- BEGIN HEADER INNER -->

            <div class="page-header-inner ">

                <!-- BEGIN LOGO -->

                <div class="page-logo" style="background-color:#ffffff;">

                    <a href="welcome.php">
                        <h1 class="logo-default bold" >Z<img src="../assets/pages/img/logo-candle.jpg" alt="logo" width="20" style="margin-bottom: 20px;" />rcon</h1>
                        <!--<img src="../assets/pages/img/logo-big-white.png" width="150" style="margin-top:15px;"  alt="logo" class="logo-default" />--> </a>

                    <div class="menu-toggler sidebar-toggler">

                        <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->

                    </div>

                </div>

                <!-- END LOGO -->

                <!-- BEGIN RESPONSIVE MENU TOGGLER -->

                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>

                <!-- END RESPONSIVE MENU TOGGLER -->

                <!-- BEGIN PAGE ACTIONS -->

                <!-- DOC: Remove "hide" class to enable the page header actions -->

                

                <!-- END PAGE ACTIONS -->

                <!-- BEGIN PAGE TOP -->

                <div class="page-top">

                    <!-- BEGIN HEADER SEARCH BOX -->

                    <!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->

                    <!--<form class="search-form" action="page_general_search_2.html" method="GET">

                        <div class="input-group">

                            <input type="text" class="form-control input-sm" placeholder="Search..." name="query">

                            <span class="input-group-btn">

                                <a href="javascript:;" class="btn submit">

                                    <i class="icon-magnifier"></i>

                                </a>

                            </span>

                        </div>

                    </form>-->

                    <!-- END HEADER SEARCH BOX -->

                    <!-- BEGIN TOP NAVIGATION MENU -->

                    <div class="top-menu">

                        <ul class="nav navbar-nav pull-right">

                            <li class="separator hide"> </li>

                            <!-- BEGIN NOTIFICATION DROPDOWN -->

                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->

                            <!-- DOC: Apply "dropdown-hoverable" class after "dropdown" and remove data-toggle="dropdown" data-hover="dropdown" data-close-others="true" attributes to enable hover dropdown mode -->

                            <!-- DOC: Remove "dropdown-hoverable" and add data-toggle="dropdown" data-hover="dropdown" data-close-others="true" attributes to the below A element with dropdown-toggle class -->

                            <!--<li class="dropdown dropdown-extended dropdown-notification dropdown-dark" id="header_notification_bar">

                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">

                                    <i class="icon-bell"></i>

                                    <span class="badge badge-success"> 7 </span>

                                </a>

                                <ul class="dropdown-menu">

                                    <li class="external">

                                        <h3>

                                            <span class="bold">12 pending</span> notifications</h3>

                                        <a href="page_user_profile_1.html">view all</a>

                                    </li>

                                    <li>

                                        <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">just now</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-success">

                                                            <i class="fa fa-plus"></i>

                                                        </span> New user registered. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">3 mins</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-danger">

                                                            <i class="fa fa-bolt"></i>

                                                        </span> Server #12 overloaded. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">10 mins</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-warning">

                                                            <i class="fa fa-bell-o"></i>

                                                        </span> Server #2 not responding. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">14 hrs</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-info">

                                                            <i class="fa fa-bullhorn"></i>

                                                        </span> Application error. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">2 days</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-danger">

                                                            <i class="fa fa-bolt"></i>

                                                        </span> Database overloaded 68%. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">3 days</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-danger">

                                                            <i class="fa fa-bolt"></i>

                                                        </span> A user IP blocked. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">4 days</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-warning">

                                                            <i class="fa fa-bell-o"></i>

                                                        </span> Storage Server #4 not responding dfdfdfd. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">5 days</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-info">

                                                            <i class="fa fa-bullhorn"></i>

                                                        </span> System Error. </span>

                                                </a>

                                            </li>

                                            <li>

                                                <a href="javascript:;">

                                                    <span class="time">9 days</span>

                                                    <span class="details">

                                                        <span class="label label-sm label-icon label-danger">

                                                            <i class="fa fa-bolt"></i>

                                                        </span> Storage server failed. </span>

                                                </a>

                                            </li>

                                        </ul>

                                    </li>

                                </ul>

                            </li>-->

                            <!-- END NOTIFICATION DROPDOWN -->

                            <li class="separator hide"> </li>

                            <!-- BEGIN INBOX DROPDOWN -->

                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->

							

                            <!-- END INBOX DROPDOWN -->

                            <li class="separator hide"> </li>

                            <!-- BEGIN USER LOGIN DROPDOWN -->

                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->

                            <li class="dropdown dropdown-user dropdown-dark">

                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">

                                    <span class="username username-hide-on-mobile"><span style="color: #ffffff;font-size:20px;"> <?php echo $_SESSION['login_name'];?> </span></span>&nbsp;&nbsp;<i class="icon-settings"
                                                             style="color: #ffffff;font-size:20px;"></i>&nbsp;&nbsp;<i
                                        class="icon-user" style="color: #ffffff;font-size: 20px;"></i>

                                    <!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->

                                     </a>

                                <ul class="dropdown-menu dropdown-menu-default">

                                   

                                    <li>

                                        <!--<a href="change_password.php">-->

										<a href="change_password.php">

                                            <i class="icon-lock"></i>Change Password </a>

                                    </li>

                                    <li>

                                        <a href="logout.php">

                                            <i class="icon-key"></i> Log Out </a>

                                    </li>

                                </ul>

                            </li>

                            <!-- END USER LOGIN DROPDOWN -->

                            <!-- BEGIN QUICK SIDEBAR TOGGLER -->

                            

                            <!-- END QUICK SIDEBAR TOGGLER -->

                        </ul>

                    </div>

                    <!-- END TOP NAVIGATION MENU -->

                </div>

                <!-- END PAGE TOP -->

            </div>

            <!-- END HEADER INNER -->

        </div>

        <!-- END HEADER -->

        <!-- BEGIN HEADER & CONTENT DIVIDER -->

        <div class="clearfix"> </div>

        <!-- END HEADER & CONTENT DIVIDER -->

