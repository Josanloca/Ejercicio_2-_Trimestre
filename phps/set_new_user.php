<?php

require_once("conexion.php");

$sql = "INSERT INTO `usuario` (`nombre`, `apellido`, `numeroTelefono`, `email`, `fecha`, `contrasena`)";
$sql .= " VALUES ('".$_GET["nombre"]."', '".$_GET["apellido"]."', '".$_GET["numeroTelefono"]."', '".$_GET["email"]."', '".$_GET["fecha"]."', '".$_GET["contrasena"]."')";


if (mysqli_query($conn, $sql)) {
    echo "Yes";
  } else {
    echo "Error";
  }

mysqli_close($conn);
?>