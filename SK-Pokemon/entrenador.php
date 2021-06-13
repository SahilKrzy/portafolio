<?php

require "bbdd.php";

$name = $_POST['nombre'];
$potions = $_POST['potions'];
$pokeballs = $_POST['pokeballs'];
$points = 0;

if (insertEntrenador($name,$pokeballs,$potions,$points) == 1){

    echo "El trainer se ha creado bien.";
    
    echo "<form action=index.php><input type='submit' value='Menu' href='index.php'>";

}else{

    echo "El trainer no se ha creado correctamente.";
echo "<form action=index.php><input type='submit' value='Menu' href='index.php'>";
}