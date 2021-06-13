<?php

require "bbdd.php";

$entrenadores = selectAllTrainerBueno();
$entrenadores2 = selectAllTrainerBueno();



if (isset($_POST['enviar'])){

    $entrenadores = $_POST['trainer1'];
    $entrenadores2 = $_POST['trainer2'];

    if ($entrenadores == $entrenadores2){

        echo "No puedes entrar en batalla contra ti mismo.";
        echo "<a href='index.php'>Vuelves a la lobby Entrenador!</a>";

    }else{

        $pokemonEntre1 = selectPokemonTrainer($entrenadores);
        $pokemonEntre2 = selectPokemonTrainer($entrenadores2);

        echo "<form action=finalBatalla.php method='post'>Pokemon entrenador 1: <select name='pokemon1'>";

        while($fila = mysqli_fetch_assoc($pokemonEntre1)){
            echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
        };
        echo "</select> Pokemon entrenador 2: <select name='pokemon2'>";

        while($fila = mysqli_fetch_assoc($pokemonEntre2)){
            echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
        };

        echo "</select> <input type='submit' value='enviar'>";

    }



}else{
    echo "<form action='batalla.php' method='post'>
            
    Entrenador 1: <select name='trainer1'>";

    while($fila = mysqli_fetch_assoc($entrenadores)){
        echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
    };
    echo "</select> Entrenador 2: <select name='trainer2'>";

    while($fila = mysqli_fetch_assoc($entrenadores2)){
        echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
    };

    echo "</select> <input type='submit' name='enviar'></form>";
}



