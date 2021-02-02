<?php

require_once("conexion.php");

$sql = "SELECT * FROM productos ORDER BY iCodigo";

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('iCodigo'=>$row["iCodigo"]
    ,'sNombre'=>$row["sNombre"]
    ,'iStockActual'=>$row["iStockActual"]
    ,'iStockMinimo'=>$row["iStockMinimo"]
    ,'iStockMaximo'=>$row["iStockMaximo"]
    ,'bGrupo'=>$row["bGrupo"]
    ,'sComentario'=>$row["sComentario"]
    ,'bFraObs'=>$row["bFraObs"]
    ,'bProveedores'=>$row["bProveedores"]
    ,'iPVP'=>$row["iPVP"]
    );
    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>