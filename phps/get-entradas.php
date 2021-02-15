<?php

require_once("conexion.php");

$sql = "SELECT capacidad_act FROM sala_cine WHERE id_sala_cine = ".$_GET["idPelicula"];

$result = $conn->query($sql);

$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    (
    'capacidad_act'=>$row["capacidad_act"]
    );
};



//$salidaJSON = json_encode($miArray);

//echo $salidaJSON;

echo $miArray[0]["capacidad_act"];

mysqli_close($conn);

?>