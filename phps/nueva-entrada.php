<?php

require_once("conexion.php");

$sql = "INSERT INTO `db_proyecto`.`entrada` (`n_sitio`, `id_usuario_fk`, `id_sala_cine_fk`)";
$sql .= "VALUES ('".$_GET["n_sitio"]."', '".$_GET["idUsuario"]."', '".$_GET["idSCine"]."')";



if (mysqli_query($conn, $sql)) {
    echo "Yes";
  } else {
    echo "Error";
  }

mysqli_close($conn);
?>