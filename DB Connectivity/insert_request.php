<?php
 
require_once __DIR__ . '/db_connect.php';

//if (isset($_POST['CENTRE_ID']) ){
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row 
    $email = $_POST['EMAIL'];
    $type = $_POST['TYPE'];
    $amount = $_POST['AMOUNT'];
    $date = $_POST['DATE'];

    $status = $_POST['STATUS'];
    $addr=$_POST['ADDRESS'];
   // $adhaar = $_POST['ADHAAR_NO'];
    //$contact = $_POST['CONTACT'];
    //$centreid = $_POST['CENTRE_ID'];

    $result = mysql_query("SELECT ID FROM CITIZEN WHERE EMAIL='"$email"'");
    
    // echo $row['id'];

    
    
    // check if row inserted or not
    if (mysql_num_rows($result)==0) {
        echo "failed";

    }
    else {
            $row=$result[0];
            $res=mysql_query("INSERT INTO REQUEST(TYPE, CITIZEN_ID, AMOUNT,STATUS,DATE1,ADDRESS) VALUES ('$type','$row['id']','$amount','NO','$date1','$addr')");
            if (mysql_num_rows($res)==0) {
                echo "failed";

            }else {
                echo "success2";
            }



        echo "success";
    }


}
//else
//{
//    echo "not_set";
//}

?>