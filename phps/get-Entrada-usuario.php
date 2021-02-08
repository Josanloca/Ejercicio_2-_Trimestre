<?php

require_once("conexion.php");

$sql = "SELECT COUNT(id_entrada) as Suma FROM entrada WHERE id_usuario_fk = ".$_GET["idUsuario"];

$result = $conn->query($sql);

$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    (
    'Suma'=>$row["Suma"]
    );
};
echo $miArray[0]["Suma"];

mysqli_close($conn);

?>