<?php

require_once("conexion.php");

$sql = "SELECT id_usuario FROM usuario WHERE email = "."'".$_GET["sEmail"]."' AND contraseña = '".$_GET["sContrasena"]."'";

$result = $conn->query($sql);

if(mysqli_fetch_assoc($result)){
    echo "ok";
}else{
    echo "error";
}

mysqli_close($conn);

?>