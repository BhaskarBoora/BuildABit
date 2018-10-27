<?php
 
require_once __DIR__ . '/db_connect.php';

//if (isset($_POST['CENTRE_ID']) ){
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row 
    $email = $_POST['EMAIL'];
    //$time1 = $_POST['STIME'];
    //$latitude = $_POST['LATITUDE'];
    //$time2 = $_POST['ETIME'];
   // $longitude = $_POST['LONGITUDE'];
    //$adhaar = $_POST['ADHAAR_NO'];
    //$email = $_POST['EMAIL'];
    //$centreid = $_POST['CENTRE_ID'];

     $result = mysql_query("SELECT ID FROM CITIZEN WHERE EMAIL='"$email"'");
    



    //$result = mysql_query("INSERT INTO CITIZEN(NAME, LATITUDE, LONGITUDE, ADHAAR_NO,EMAIL) VALUES ('$namet',$latitude,$longitude,$adhaar,$email)");


    
    
    // check if row inserted or not
    if (mysql_num_rows($result)==0) {
        echo "failed";

    }
    else {
        $row=$result[0];
        $res = mysql_query("SELECT * FROM REQUEST WHERE CITIZEN_ID='"$row['id']"'");



        if ($res->num_rows > 0) {
    // output data of each row
            while($row1 = $res->fetch_assoc()) {
                echo "id: " . $row1["id"]. " - Type: " . $row1["type"]. "Amount " . $row1["amount"]." Status".$row1["status"]."Date".$row1['date1']."Address".$row1['address']. "<br>";
            }
        } else {
            echo "0 results";
        }

        echo "success";
    }


}
//else
//{
//    echo "not_set";
//}

?>