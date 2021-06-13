<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
    $contra = $_POST['pass0'];
    $contraN1 = $_POST['pass1'];
    $contraN2 = $_POST['pass12'];
    session_start();
    $contraV=$_SESSION["contra"];
    if($contraN1 != $contraN2){
        echo'La contraseña nueva no coincide';
        echo "<a href='home.php'>MENU</a>";
    } else if($contra != $contraV){
        echo 'Tu contraseña no es correcta';
        echo "<a href='home.php'>MENU</a>";
    } else {
        $_SESSION["contra"]=$contraN1;
        cambiarContra($_SESSION["user"],$contraN1);
        echo 'La contraseña se ha cambiado correctamente';
        echo "<a href='home.php'>MENU</a>";

    }
} else {
    header("Location: index.php");
}