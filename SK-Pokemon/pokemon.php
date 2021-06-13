<?php

require "bbdd.php";

$nameP = $_POST['nombreP'];
$type = $_POST['tipo'];
$ability = $_POST['habilidad'];
$attack = $_POST['nivAtaque'];
$defense = $_POST['nivDefensa'];
$speed = $_POST['nivVelocidad'];
$life = $_POST['hp'];
$trainer = $_POST['entrenador'];
$level = 0;

if (insertPokemon($nameP, $type, $ability, $attack, $defense, $speed, $life, $level, $trainer) == 1){

    echo "El pokemon se ha registrado correctamente.";

    if (sumarPokeball($trainer) == 1){

        echo "Se ha sumado el pokemon correctamente.";

    }else{

        echo "El pokemon se ha debilitado durante el proceso.";

    }
    echo "<a href= index.php> Volver al menu</a>";
}else{

    echo "No se ha registrado correctamente.";
    echo "<a href= index.php>Volver al menu</a>";
}