<?php

require_once("conexion.php");

$sql = "SELECT capacidad_max FROM sala_cine WHERE id_sala_cine = ".$_GET["idPelicula"];

$result = $conn->query($sql);

$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    (
    'capacidad_max'=>$row["capacidad_max"]
    );
};
echo $miArray[0]["capacidad_max"];

mysqli_close($conn);

?>