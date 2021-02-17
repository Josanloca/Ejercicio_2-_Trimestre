<?php
$imagenData = $_POST["imgData"];
$imagenName = $_POST["imgName"];

$path = "img/" . $imagenName . ".jpg";

file_put_contents($path, base64_decode($imagenData));

echo "OK";

?>