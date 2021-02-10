<?php

require_once("conexion.php");

$sql = "SELECT * FROM usuario ORDER BY id_usuario";

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('id_usuario'=>  $row["id_usuario"]
    ,'nombre'=>    $row["nombre"]
    ,'apellido'=> $row["apellido"]
    ,'numeroTelefono'=> $row["numeroTelefono"]
    ,'email'=> $row["email"]
    );    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>