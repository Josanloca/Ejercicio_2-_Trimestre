<?php

require_once("conexion.php");

$sql = "SELECT * FROM sala_cine WHERE id_pelicula = ". $_GET["idpeli"];

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('id_sala_cine'=>  $row["id_sala_cine"]
    ,'capacidad_max'=>    $row["capacidad_max"]
    ,'capacidad_act'=> $row["capacidad_act"]
    ,'id_pelicula'=> $row["id_pelicula"]
    );    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>