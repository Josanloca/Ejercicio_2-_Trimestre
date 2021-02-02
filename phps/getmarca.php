<?php

require_once("conexion.php");

$sql = "SELECT DISTINCT MARCA FROM coche ORDER BY MARCA ASC";

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    (
    'marca'=>$row["MARCA"]

    );
    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>