<?php

require "bbdd.php";

$pokemonBatalla = $_POST['pokemon1'];
$pokemonBatalla2 = $_POST['pokemon2'];

$pokemon1 = selectStatsPokemon($pokemonBatalla);
$pokemon2 = selectStatsPokemon($pokemonBatalla2);

$AtaqueP1 = 0;
$defensaP1 = 0;
$velocidadP1 = 0;
$vidaP1 = 0;
$levelP1 = 0;

while ($fila = mysqli_fetch_assoc($pokemon1)) {
    $AtaqueP1 = $fila['attack'];
    $defensaP1 = $fila['defense'];
    $velocidadP1 = $fila['speed'];
    $vidaP1 = $fila['life'];
    $levelP1 = $fila['level'];
}

$ataqueP2 = 0;
$defensaP2 = 0;
$velocidadP2 = 0;
$vidaP2 = 0;
$levelP2 = 0;

while ($fila = mysqli_fetch_assoc($pokemon2)) {
    $ataqueP2 = $fila['attack'];
    $defensaP2 = $fila['defense'];
    $velocidadP2 = $fila['speed'];
    $vidaP2 = $fila['life'];
    $levelP2 = $fila['level'];
}

$golpeP1 = $AtaqueP1 + (2 * $levelP1);
$golpeP2 = $ataqueP2 + (2 * $levelP2);

$vidaActualP1 = $vidaP1;
$vidaActualP2 = $vidaP2;


echo"$pokemonBatalla ***** $pokemonBatalla2<br>";
do{
    echo"$vidaActualP1 ***** $vidaActualP2<br>";
    if($velocidadP1 >= $velocidadP2){
        $vidaActualP2 = $vidaActualP2-$golpeP1;
        if($vidaActualP2>0){
            $vidaActualP1 = $vidaActualP1-$golpeP2;
        } 
    }else{
        $vidaActualP1 = $vidaActualP1-$golpeP2;
        if($vidaActualP1>0){
            $vidaActualP2 = $vidaActualP2-$golpeP1;
        }
    }
    
}while($vidaActualP1>0 && $vidaActualP2>0);

if($vidaActualP1<=0){
    $vidaActualP1=0;
    echo $pokemonBatalla2." gana la batalla<br>";
	
}
if($vidaActualP2<=0){
    $vidaActualP2=0;
    echo $pokemonBatalla." gana la batalla<br>";
}
echo"Vida de $pokemonBatalla: $vidaActualP1<br> Vida de $pokemonBatalla2: $vidaActualP2";
nuevaVida($vidaActualP1, $pokemonBatalla);
nuevaVida($vidaActualP2, $pokemonBatalla2);

