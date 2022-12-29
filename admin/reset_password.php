<?php 
include("Common.php");

$raw_id=decode($_GET['id']);


?>

<!DOCTYPE html>


<html lang="en">

    <!--<![endif]-->

    <!-- BEGIN HEAD -->



    <head>

        <meta charset="utf-8" />

        <title>Admin Panel</title>

        <meta https-equiv="X-UA-Compatible" content="IE=edge">

        <meta content="width=device-width, initial-scale=1" name="viewport" />

        <meta content="" name="description" />

        <meta content="" name="author" />

        <!-- BEGIN GLOBAL MANDATORY STYLES -->

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />

        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN PAGE LEVEL PLUGINS -->

        <link href="../assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />

        <link href="../assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />

        <!-- END PAGE LEVEL PLUGINS -->

        <!-- BEGIN THEME GLOBAL STYLES -->

        <link href="../assets/global/css/components-md.min.css" rel="stylesheet" id="style_components" type="text/css" />

        <link href="../assets/global/css/plugins-md.min.css" rel="stylesheet" type="text/css" />

        <!-- END THEME GLOBAL STYLES -->

        <!-- BEGIN PAGE LEVEL STYLES -->

        <link href="../assets/pages/css/login-2.min.css" rel="stylesheet" type="text/css" />

        <!-- END PAGE LEVEL STYLES -->

        <!-- BEGIN THEME LAYOUT STYLES -->

        <!-- END THEME LAYOUT STYLES -->

        <link rel="shortcut icon" href="favicon.ico" /> </head>

    <!-- END HEAD -->



    <body class=" login">

        <!-- BEGIN LOGO -->

        <div class="logo">

            <a href="javascript:void();">

                <img src="../assets/pages/img/logo-big-white.png" alt="" width="300" /> </a>

        </div>

        <!-- END LOGO -->

        <!-- BEGIN LOGIN -->

        <div class="content">

            <!-- BEGIN LOGIN FORM -->

            <form class="login-form" action="reset_password2.php" method="post" onSubmit="return validate_form();">
                <input type="hidden" name="id" value="<?php echo $raw_id;?>">
                <div class="form-title">

                    <!--<span class="form-title">Welcome.</span>-->

                    <span class="form-subtitle" style="padding-left: 0px;">Please enter new password to change.</span>

                </div>

				<?php

					if(isset($_SESSION['err']) && $_SESSION['err']!='' )
					{

					?>

					<div class="alert alert-success display-hide" style="display:block">

						<button class="close" data-close="alert"></button>

						<span><?php echo $_SESSION['err']; $_SESSION['err']="";?> </span>

                	</div>

					

				<?php

					}

				?>
                <p align="center" style="color: #960002" id="err"></p>
               
                <div class="form-group"> 
                    <label class="control-label visible-ie8 visible-ie9">New Password</label>

                    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="New Password" name="password" id="password" required />
                    <i class="fa fa-eye" id="toggle_Password" style=" cursor: pointer; float: right; margin: -28px 8px 0px 0px;"></i>
                </div>

                <div class="form-group">

                    <label class="control-label visible-ie8 visible-ie9">Confirm Password</label>

                    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="Confirm Password" name="cpassword" id="cpassword" onkeyup='check_v();' required />
                    <i class="fa fa-eye" id="toggle_cPassword" style=" cursor: pointer; float: right; margin: -28px 8px 0px 0px;"></i>
                    <span id='message_div'></span>
                </div>

                <div class="form-actions">

                    <button type="submit" class="btn green btn-block uppercase">Change Password</button>

                </div>

                
                

                

            </form>

            <!-- END LOGIN FORM -->

            <!-- BEGIN FORGOT PASSWORD FORM -->

         

            <!-- END FORGOT PASSWORD FORM -->

            <!-- BEGIN REGISTRATION FORM -->

            

            <!-- END REGISTRATION FORM -->

        </div>

     

        <script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>

        <script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        

        

        <script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>

       
        <script src="../assets/pages/scripts/login.min.js" type="text/javascript"></script>

        <!-- END PAGE LEVEL SCRIPTS -->

        <!-- BEGIN THEME LAYOUT SCRIPTS -->

        <!-- END THEME LAYOUT SCRIPTS -->
        <script type="text/javascript">
        function validate_form(){
            var p=$('#password').val();
            var cp=$('#cpassword').val();
            if(p.length==0){
                $('#err').html("*Password required.");
                $('#password').focus();
                return false;
            }
            if(cp.length==0){
                $('#err').html("*Confirm Password required.");
                $('#cpassword').focus();
                return false;
            }
            if(p==cp){
                return true;
            }else{
                $('#err').html("*Password doesn't match.");
                $('#cpassword').focus();
                return false;
                
            }
            return false;
        }
        </script>
        <script>
            const toggle_Password = document.querySelector('#toggle_Password');
            const id_password = document.querySelector('#password');

            const toggle_cPassword = document.querySelector('#toggle_cPassword');
            const c_password = document.querySelector('#cpassword');

            toggle_Password.addEventListener('click', function (e) {
                // toggle the type attribute
                const type = id_password.getAttribute('type') === 'password' ? 'text' : 'password';
                id_password.setAttribute('type', type);
                // toggle the eye slash icon
                this.classList.toggle('fa-eye-slash');
            });
            toggle_cPassword.addEventListener('click', function (e) {
                // toggle the type attribute
                const type = c_password.getAttribute('type') === 'password' ? 'text' : 'password';
                c_password.setAttribute('type', type);
                // toggle the eye slash icon
                this.classList.toggle('fa-eye-slash');
            });

            //for matching the passwords
            var check_v = function() {
                if (document.getElementById('password').value ==
                    document.getElementById('cpassword').value) {
                    document.getElementById('message_div').style.color = 'green';
                    document.getElementById('message_div').innerHTML = 'Password match';
                } else {
                    document.getElementById('message_div').style.color = 'red';
                    document.getElementById('message_div').innerHTML = 'Password does not match';
                }
            }
        </script>
    </body>



</html>