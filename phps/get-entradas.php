<?php

require_once("conexion.php");

$sql = "SELECT capacidad_act FROM sala_cine";

$result = $conn->query($sql);

echo $result;

mysqli_close($conn);

?>