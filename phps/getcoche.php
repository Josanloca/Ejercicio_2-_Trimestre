<?php

require_once("conexion.php");

$sql = "SELECT * FROM COCHE WHERE ID_COCHE =". $_GET["id"];

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('id_coche'=>  $row["ID_COCHE"]
    ,'marca'=>    $row["MARCA"]
    ,'modelo'=>   $row["MODELO"]
    ,'potencia'=> $row["POTENCIA"]
    );    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>