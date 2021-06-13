<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
            session_start();
    if($_SESSION['user']){
       $user = $_POST['users'];
        $msg=ultimoInicio($user);
        $datos=mysqli_fetch_row($msg);
        if($datos==null){
            echo"$user todavia no ha iniciado por primera ver";
            echo "<a href='home.php'>MENU</a>";
        } else {
        echo "El ultimo inicio de sesion de ".$datos[1]." es el ".$datos[2];
        echo "<a href='home.php'>MENU</a>";
        }
    }else{
        header("Location: index.php");
    }

