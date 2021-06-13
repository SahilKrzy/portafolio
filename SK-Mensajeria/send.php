<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
            session_start();
    if($_SESSION['user']){
       $receptor = $_POST['users'];
        $asunto = $_POST['asunto'];
        $mensaje = $_POST['mensaje'];
        session_start();
        $_SESSION["user"];
        enviarMensaje($_SESSION["user"], $receptor, $asunto, $mensaje);
        redaccionEvent($_SESSION["user"]);
        header("Location: home.php");
    } else {
       header("Location: index.php");
    }
