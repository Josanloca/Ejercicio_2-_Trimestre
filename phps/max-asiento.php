<?php

require_once("conexion.php");

$result = mysqli_query($conn, "SELECT MAX(n_sitio) AS mayor FROM entrada WHERE id_usuario_fk =".$_GET["idUsuario"]." AND id_sala_cine_fk= ".$_GET["idSCine"]);
$row = mysqli_fetch_array($result);

if(!$row[0]){
    echo "0";
}else{
    echo $row[0];
}

mysqli_close($conn);

?>