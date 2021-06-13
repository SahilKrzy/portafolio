<?php

require "bbdd.php";

$entrenadores = selectAllTrainer();

echo "<form action=pokemon.php method='post'>
        Nombre Pokemon: <input type='text' name='nombreP' required>.<br>
        Tipo:<select name='tipo'>
        <option value='acero'>Acero</option>
        <option value='agua'>Agua</option>
        <option value='bicho'>Bicho</option>
        <option value='dragon'>Dragon</option>
        <option value='electrico'>Electrico</option>
        <option value='fantasma'>Fantasma</option>
        <option value='fuego'>Fuego</option>
        <option value='hada'>Hada</option>
        <option value='hielo'>Hielo</option>
        <option value='lucha'>Lucha</option>
        <option value='normal'>Normal</option>
        <option value='planta'>Planta</option>
        <option value='psiquico'>Psiquico</option>
        <option value='roca'>Roca</option>
        <option value='siniestro'>Siniestro</option>
        <option value='tierra'>Tierra</option>
        <option value='veneno'>Veneno</option>
        <option value='volador'>Volador</option>
        </select>.<br>
        Habilidad: <textarea name='habilidad'></textarea><br>
        Nivel ataque : <input type='number' name='nivAtaque' required>
        Nivel Defensa : <input type='number' name='nivDefensa' required>
        Nivel Velocidad : <input type='number' name='nivVelocidad' required>
        Vida : <input type='number' name='hp' required>
        Entrenador: <select name='entrenador'>";

while ($fila = mysqli_fetch_assoc($entrenadores)) {
        echo "<option value=" . $fila['name'] . ">" . $fila['name'] . "</option>";
}

echo "</select> <input type='submit' value='enviar'>";
