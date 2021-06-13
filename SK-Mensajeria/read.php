<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
            session_start();
    if($_SESSION['user']){
        $id = $_POST['msg'];

        leido($id);
        $msg=imprimirMensaje($id);
        $datos=mysqli_fetch_row($msg);
        echo "Mensaje enviado por ".$datos[1]." el ".$datos[3];
        echo "<br><br>Asunto: ".$datos[5];
        echo "<br><br>Mensaje: ".$datos[6];
        echo "<a href='home.php'>MENU</a>";
    }else{
       header("Location: index.php");
}


