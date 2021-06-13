<?php
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
        echo "<form action=altaCambio.php method='post'>
                Contraseña actual:<input type='password' name='pass0' required>
                <br />
                <br />
                Contraseña nueva:<input type='password' name='pass1' required>
                <br />
                <br />
                Verificacion contraseña nueva:<input type='password' name='pass12' required>
                <br />
                <br />
                <input type='submit' value='Enviar'>
                <br />
                </form>
                <form action=index.php>
                <a href='home.php'>MENU</a>";

} else {
        header("Location: index.php");
}