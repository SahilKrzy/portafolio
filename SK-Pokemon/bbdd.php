<?php

function conectar(){
    $conector = mysqli_connect("localhost","root","DAM1T_M03","stukemon");
    if (!$conector){
        die("Error".mysqli_connect_error());
    }
    return $conector;
}

function desconectar($conectar){
    mysqli_close($conectar);
}

function selectAll(){

    $c = conectar();
    $select = "SELECT * from pokemon order by life desc";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function selectAllTrainer(){

    $c = conectar();
    $select = "SELECT count(*) as 'Numero de Pokemons' from pokemon where trainer = '$nombre'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}
function selectAllTrainerBueno(){

    $c = conectar();
    $select = "SELECT name from trainer where pokeballs >=1";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}
function selectMejorarVidaTrainer(){

    $c = conectar();
    $select = "SELECT name from trainer where potions >=1";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}
function selectPokemonTrainer($entrenador){
    $c = conectar();
    $select = "SELECT name from pokemon where trainer = '$entrenador'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}
function selectVidaPokemonTrainer($entrenador){
    $c = conectar();
    $select = "SELECT life from pokemon where trainer = '$entrenador'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function selectStatsPokemon($name){

    $c = conectar();
    $select = "SELECT attack,defense,speed,life,level,trainer from pokemon where name = '$name'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;

}

function insertEntrenador ($name, $pokeballs, $potions, $points){

    $c = conectar();
    $insert = "INSERT INTO trainer(name,pokeballs,potions,points) values ('$name', $pokeballs, $potions, $points)";
    $resultado = mysqli_query($c,$insert);
    desconectar($c);
    return $resultado;

}

function insertPokemon ($nameP, $type, $ability, $attack, $defense, $speed, $life, $level, $trainer){

    $c = conectar();
    $insert = "INSERT INTO pokemon(name, type, ability, attack, defense, speed, life, level, trainer) values ('$nameP', '$type', '$ability', $attack, $defense, $speed, $life, $level, '$trainer')";
    $resultado = mysqli_query($c,$insert);
    desconectar($c);
    return $resultado;

}

function sumarPokeball($name){

    $c = conectar();
    $select = "SELECT pokeballs FROM trainer WHERE name='$name'";
    $resultado = mysqli_query($c,$select);
    $pokeballs = 0;
    while($fila = mysqli_fetch_assoc($resultado)){
        $pokeballs = $fila['pokeballs'];
    }
    $pokeballsSumadas = $pokeballs + 1;
    $insert = "UPDATE trainer SET pokeballs = $pokeballsSumadas WHERE name = '$name'";
    $resultadoBueno = mysqli_query($c,$insert);
    desconectar($c);
    return $resultadoBueno;
}

function nuevaVida ($nuevaVida, $name){

    $c = conectar();
    $insert = "UPDATE pokemon SET life = $nuevaVida where name = '$name'";
    $resultado = mysqli_query($c,$insert);
    desconectar($c);
    return $resultado;

}

function deletePokemon ($nameP){
    $c = conectar();
    $delete = "DELETE from pokemon where name = '$nameP'";
    $resultado = mysqli_query($c,$delete);
    if ($resultado == 1){
        $resultado = "Se ha eliminado correctamente.";
    }else{
         $resultado = "No se ha podido eliminar.";
    }
    desconectar($c);
    return $resultado;

}

function nivelPokemon ($nameP){
    $c = conectar();
    $select = "SELECT * FROM pokemon where name = '$nameP' order by level desc";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function pvidaPokemon ($nameP){
    $c = conectar();
    $select = "SELECT * FROM pokemon where name = '$nameP' order by life desc";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function selectPokemonNecesario($entrenador){
    $c = conectar();
    $select = "SELECT * from pokemon where trainer = '$entrenador'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function rankingEntrenador(){

    $c = conectar();
    $select = "SELECT * from trainer order by points desc";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function puntosEntrenador(){

    $c = conectar();
    $select = "SELECT * from trainer order by points desc";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}