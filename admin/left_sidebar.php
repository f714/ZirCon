<?php

$page = explode('/admin/', $_SERVER['REQUEST_URI']);

$p = explode('.php', $page[1]);

$p = $p[0];

$active = 'active open';

//echo $p;

?>


<div class="page-sidebar-wrapper">


    <div class="page-sidebar navbar-collapse collapse">


        <ul class="page-sidebar-menu   " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
            <li class="nav-item start <?php if ($p == "welcome") {
                echo $active;
            } ?>">
                <a href="welcome.php" class="nav-link ">
                    <i class="icon-home"></i>
                    <span class="title">Dashboard</span>
                    <span class="selected"></span>
                </a>
            </li>


            <li class="nav-item start <?php if ($p == "verses" or $p == "add_verse" or $p == "edit_verse") {
                echo $active;
            } ?>">
                <a href="javascript:;" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">Verses Management</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>

                <ul class="sub-menu">
                    <li class="nav-item start <?php if ($p == "verses") {
                        echo 'active';
                    } ?>">
                        <a href="verses.php" class="nav-link ">
                            <i class="fa fa-list"></i>
                            <span class="title">Verses List</span>
                        </a>
                    </li>

                    <li class="nav-item start <?php if ($p == "add_verse") {
                        echo 'active';
                    } ?>">
                        <a href="add_verse.php" class="nav-link ">
                            <i class="fa fa-plus"></i>
                            <span class="title">Add new Verse</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="nav-item start <?php if ($p == "diseases" or $p == "add_diseases" or $p == "edit_diseases") {
                echo $active;
            } ?>">
                <a href="javascript:;" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">Disease Management</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>

                <ul class="sub-menu">
                    <li class="nav-item start <?php if ($p == "diseases") {
                        echo 'active';
                    } ?>">
                        <a href="diseases.php" class="nav-link ">
                            <i class="fa fa-list"></i>
                            <span class="title">Disease List</span>
                        </a>
                    </li>

                    <li class="nav-item start <?php if ($p == "add_diseases") {
                        echo 'active';
                    } ?>">
                        <a href="add_diseases.php" class="nav-link ">
                            <i class="fa fa-plus"></i>
                            <span class="title">Add new Diseases</span>
                        </a>
                    </li>
                </ul>
            </li>


            <li class="nav-item start <?php if ($p == "inspirations" or $p == "add_inspiration" or $p == "edit_inspiration") {
                echo $active;
            } ?>">
                <a href="javascript:;" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">Inspirations Management</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>

                <ul class="sub-menu">
                    <li class="nav-item start <?php if ($p == "inspirations") {
                        echo 'active';
                    } ?>">
                        <a href="inspirations.php" class="nav-link ">
                            <i class="fa fa-list"></i>
                            <span class="title">Inspirations List</span>
                        </a>
                    </li>

                    <li class="nav-item start <?php if ($p == "add_inspiration") {
                        echo 'active';
                    } ?>">
                        <a href="add_inspiration.php" class="nav-link ">
                            <i class="fa fa-plus"></i>
                            <span class="title">Add new Inspiration</span>
                        </a>
                    </li>
                </ul>
            </li>


            <li class="nav-item start <?php if ($p == "users" or $p == "add_user") {
                echo $active;
            } ?>">

                <a href="javascript:;" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">Users Managemnet</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>

                <ul class="sub-menu">
                    <li class="nav-item start <?php if ($p == "user") {
                        echo 'active';
                    } ?>">
                        <a href="users.php" class="nav-link ">
                            <i class="fa fa-list"></i>
                            <span class="title">Users List </span>
                        </a>
                    </li>

                    <li class="nav-item start <?php if ($p == "add_user") {
                        echo 'active';
                    } ?>">
                        <a href="add_user.php" class="nav-link ">
                            <i class="fa fa-plus"></i>
                            <span class="title">Add User</span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

        <!-- END SIDEBAR MENU -->

    </div>

    <!-- END SIDEBAR -->

</div>
            
 