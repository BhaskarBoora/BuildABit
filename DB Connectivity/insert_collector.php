<?php
 
require_once __DIR__ . '/db_connect.php';

//if (isset($_POST['CENTRE_ID']) ){
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row 
    $namet = $_POST['NAME'];
    //$time1 = $_POST['STIME'];
    $latitude = $_POST['LATITUDE'];
    //$time2 = $_POST['ETIME'];
    $longitude = $_POST['LONGITUDE'];
    $type =$_POST['TYPE_COLLECTS'];
    $adhaar = $_POST['ADHAAR_NO'];
    //$centreid = $_POST['CENTRE_ID'];

    $result = mysql_query("INSERT INTO COLLECTOR(NAME, LATITUDE, LONGITUDE, TYPE_COLLECTS,ADHAAR_NO) VALUES ('$namet','$latitude','$longitude','$type','$adhaar')");


    
    
    // check if row inserted or not
    if (mysql_num_rows($result)==0) {
        echo "failed";

    }
    else {
        echo "success";
    }


}
//else
//{
//    echo "not_set";
//}

?>