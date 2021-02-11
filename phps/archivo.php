<?php
$imagenData = $_POST["imgData"];
$imagenName = $_POST["imgName"];

$path = $imagenName . ".jpg";

file_put_contents($path, base64_decode($imagenData));

echo "OK";
?>
