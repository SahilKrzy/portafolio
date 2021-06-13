<?php
echo "<form action=entrenador.php method='post'>
        Nombre entrenador: <input type='text' name='nombre' required>
        <br />
        <br />
        Numero de pociones:<input type='number' name='potions' required>
        <br />
        <br />
        Numero de pokeballs:<input type='number' name='pokeballs' required>
        <br />
        <br />
        <input type='submit' value='Enviar'>
        <br />
        </form>
        <form action=index.php>
        <input type='submit' value='Menu' href='index.php'>";
?>