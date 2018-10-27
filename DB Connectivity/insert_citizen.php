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
    $adhaar = $_POST['ADHAAR_NO'];
    $email = $_POST['EMAIL'];
    //$centreid = $_POST['CENTRE_ID'];

    $result = mysql_query("INSERT INTO CITIZEN(NAME, LATITUDE, LONGITUDE, ADHAAR_NO,EMAIL) VALUES ('$namet','$latitude','$longitude','$adhaar','$email')");


    
    
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