<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
    $mensaje= selectRecibidos($_SESSION["user"]);
    bandejaEvent($_SESSION["user"]);
    echo"Escoge es mensaje que desear leer:</br></br>";
    echo "<form action=read.php method='post'>";

        while($fila = mysqli_fetch_assoc($mensaje)){
            if($fila['read']==0){
                $leido="[no leido]";
            } else {
            $leido="[leido]"; 
            }
            echo "Enviado por: ".$fila['sender']."</br></br>Asunto: ".$fila['subject']."</br></br>Hora ".$fila['date']." ".$leido."<input type='radio' name='msg' value=".$fila['idmessage']."><br><br>";
        };
    echo"<br><input type='submit' value='leer'>";
    echo "<a href='home.php'>MENU</a>";
}  else{
    header("Location: index.php");
}