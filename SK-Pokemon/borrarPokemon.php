<?php

require "bbdd.php";

$entrenador = selectAllTrainerBueno();
if (isset($_POST['enviar'])){
    $entrenador = $_POST['trainer'];

    $pokemonEntre = selectPokemonTrainer($entrenador);

    echo "<form action= PokeBorrado.php method='post'>
        Pokemon a eliminar: <select name='pokemon1'>";
    
    while($fila = mysqli_fetch_assoc($pokemonEntre)){
        echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
    };
    echo "</select> <input type='submit' value='enviar'>";
    echo "<a href= index.php> Volver al menu</a>";
        
}else{
    echo "<form action='borrarPokemon.php' method='post'>
            
    Entrenador: <select name='trainer'>";

    while($fila = mysqli_fetch_assoc($entrenador)){
        echo "<option value=".$fila['name']. ">" .$fila['name']. "</option>";
    };

    echo "</select> <input type='submit' name='enviar'></form>";
    echo "<a href= index.php> Volver al menu</a>";
}