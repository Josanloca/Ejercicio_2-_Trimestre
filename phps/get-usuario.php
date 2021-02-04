<?php

require_once("conexion.php");

$sql = "SELECT * FROM usuario WHERE email = '". $_GET["email"]."'";

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('id_usuario'=>  $row["id_usuario"]
    ,'nombre'=>    $row["nombre"]
    ,'apellido'=> $row["apellido"]
    ,'numeroTelefono'=> $row["numeroTelefono"]
    ,'email'=> $row["email"]
    ,'fecha'=> $row["fecha"]
    ,'contraseña'=> $row["contraseña"]
    );    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>