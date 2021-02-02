<?php

$DBHOST = "db-proyecto.cpslq1j7jr77.eu-west-3.rds.amazonaws.com";
$DBPORT = "3306";
$DBNAME = "db_proyecto";
$DBUSER = "admin";
$DBPASS = "Josanloca199618";

$conn = mysqli_connect($DBHOST,$DBUSER,$DBPASS,$DBNAME);
mysqli_set_charset($conn, "utf8");

//echo "Conectado!";
//mysqli_close($conn);

?>