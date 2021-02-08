<?php

require_once("conexion.php");

$sql = "UPDATE sala_cine SET capacidad_act=".$_GET["capacidad"]." WHERE id_sala_cine=".$_GET["idPeli"];

if (mysqli_query($conn, $sql)) {
    echo "Yes";
  } else {
    echo "Error";
  }

mysqli_close($conn);
?>