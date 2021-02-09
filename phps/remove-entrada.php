<?php

require_once("conexion.php");


$sql = "DELETE FROM entrada WHERE id_usuario_fk=".$_GET["idUsuario"]." AND id_sala_cine_fk=".$_GET["idCine"]." AND n_sitio=".$_GET["nSitio"];

if ($conn->query($sql) === TRUE) {
  echo "Record deleted successfully";
} else {
  echo "Error deleting record: " . $conn->error;
}

mysqli_close($conn);
?>