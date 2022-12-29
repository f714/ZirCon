<?php
$con = mysqli_connect("localhost","root","","zircon_db");
mysqli_select_db($con,"zircon_db")or die("db not connected");


$base_url="http://localhost/Zircon/admin/";

define("appname","IMS");
//include('paginate.php');
$per_page = 15; 
$page=explode('/',$_SERVER['REQUEST_URI']);
$p=explode('.php',$page[1]);
$p=$p[0];
$active='class="active"';

function encode($input){
    return strtr(base64_encode($input), '&^$%@!+/=qwertyuioplkjhgfdsazxcvbnm091238767546', '-_,');
}

function decode($input){
    return base64_decode(strtr($input, '-_,', '&^$%@!+/=qwertyuioplkjhgfdsazxcvbnm091238767546'));
}

function mysqli_result($res,$row=0,$col=0){ 
    $numrows = mysqli_num_rows($res); 
    if ($numrows && $row <= ($numrows-1) && $row >=0){
        mysqli_data_seek($res,$row);
        $resrow = (is_numeric($col)) ? mysqli_fetch_row($res) : mysqli_fetch_assoc($res);
        if (isset($resrow[$col])){
            return $resrow[$col];
        }
    }
    return false;
}
?>
