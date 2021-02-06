<?php

require_once("conexion.php");

$sql = "SELECT * FROM pelicula ORDER BY id_pelicula";

$result = $conn->query($sql);


$miArray = array();

while ($row = mysqli_fetch_assoc($result)){
    $miArray[]= array
    ('id_pelicula'=>  $row["id_pelicula"]
    ,'nombre_pelicula'=>    $row["nombre_pelicula"]
    ,'icca'=> $row["icca"]
    ,'genero'=> $row["genero"]
    );    
};

$salidaJSON = json_encode($miArray);

echo $salidaJSON;

mysqli_close($conn);

?>