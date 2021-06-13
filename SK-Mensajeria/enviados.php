<?php

require "bbdd.php";
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
    $mensaje= selectEnviados($_SESSION["user"]);
    while($fila = mysqli_fetch_assoc($mensaje)){
            echo "Enviado a: ".$fila['receiver']."</br></br>Asunto: ".$fila['subject']."</br></br>Hora ".$fila['date']."</br></br>";
        };
        echo "<a href='home.php'>MENU</a>";
} else {
    header("Location: index.php");
}