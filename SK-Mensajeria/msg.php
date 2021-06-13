<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
            session_start();
   if($_SESSION['user']){
        $users=selectAllUsers();
        echo "<form action=send.php method='post'>"
        . "A quien quieres enviar el mensaje: <select name='users'>";
            while($fila = mysqli_fetch_assoc($users)){
                echo "<option value=".$fila['username']. ">" .$fila['username']. "</option>";
            };
        echo"</select>Asunto:<input type='text' name='asunto' required>"
            . "Mensaje: <textarea name='mensaje'></textarea><br>";

        echo "<input type='submit' value='enviar'>";
        echo "<a href='home.php'>MENU</a>";
    } else {
       header("Location: index.php");
    }
