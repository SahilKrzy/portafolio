<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
    session_start();

    if($_SESSION['user']){
        $mensajes= selectAllMessages();
        while($fila = mysqli_fetch_assoc($mensajes)){
            if($fila['read']==0){
                $leido="[no leido]";
            } else {
            $leido="[leido]"; 
            }
            echo "Enviado por: ".$fila['sender']."</br></br>Recibido por: ".$fila['receiver']."</br></br>Asunto: ".$fila['subject']."</br></br>Hora ".$fila['date']." ".$leido."</br></br>";
        }
        echo "<a href='home.php'>MENU</a>";
    } else {
        header("Location: index.php");
    }
