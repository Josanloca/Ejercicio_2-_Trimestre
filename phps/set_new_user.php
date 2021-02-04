<?php

require_once("conexion.php");

$sql = "INSERT INTO `usuario` (`nombre`, `apellido`, `numeroTelefono`, `email`, `fecha`, `contrasena`)";
$sql .= " VALUES ('".$_GET["nombre"]."', '".$_GET["apellido"]."', '".$_GET["numeroTelefono"]."', '".$_GET["email"]."', '".$_GET["fecha"]."', '".$_GET["contrasena"]."')";

echo $sql;

if (mysqli_query($conn, $sql)) {
    echo "New record created successfully";
  } else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
  }

mysqli_close($conn);
?>