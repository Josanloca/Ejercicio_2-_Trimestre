<?php

require_once("conexion.php");

$sql = "INSERT INTO Customers (iCodigo, sNombre, iStockActual, iStockActual, iStockMaximo, bGrupo,sComentario,bFraObs,bProveedores,iPVP)"
$sql .= " VALUES ('".$_GET["iCodigo"]."', '".$_GET["sNombre"]."', '".$_GET["iStockActual"]."', '".$_GET["iStockMinimo"]."', '".$_GET["iStockMaximo"]."', '".$_GET["bGrupo"]."','".$_GET["sComentario"]."','".$_GET["bFraObs"]."','".$_GET["bProveedores"]."','".$_GET["iPVP"])";


?>