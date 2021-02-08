<?php

require_once("conexion.php");

$sql = "SELECT MAX(n_sitio) AS mayor FROM entrada WHERE id_usuario_fk =".$_GET["idUsuario"]." AND id_sala_cine_fk= ".$_GET["idSCine"];

$result = $conn->query($sql);

$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    (
    'mayor'=>$row["mayor"]
    );
};
echo $miArray[0]["mayor"];

mysqli_close($conn);

?>