<?php

require "bbdd.php";

$entrenador  = selectMejorarVidaTrainer();

if (isset($_POST['enviar'])){
    $entrenador = $_POST['trainer'];
    $nombrePokemon = selectPokemonTrainer($entrenador);
    $vida = selectVidaPokemonTrainer($entrenador);

    $fila1 = mysqli_fetch_assoc($nombrePokemon);
    $fila2 = mysqli_fetch_assoc($vida);

    echo "<form action=finalBatalla.php method='post'>Pokemon a elegir: <select name='pokemon1'>";

    while($fila = mysqli_fetch_assoc($nombrePokemon)){
        echo $fila1." ---> ".$fila2;

    };
        echo "<a href= index.php> Volver al menu</a>";

}else{
    echo "<form action='mejorarVida.php' method='post'>
            Entrenador: <select name='trainer'>";

    while($fila = mysqli_fetch_assoc($entrenador)){
        echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
    };

    echo "</select> <input type='submit' name='enviar'></form>";
    echo "<a href= index.php> Volver al menu</a>";
}