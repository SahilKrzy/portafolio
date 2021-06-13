<?php
require "bbdd.php";

$user = $_POST['user'];
$contra = $_POST['pass'];

if(iniciarSesion($user, $contra)==1){
    inicioEvent($user);
    session_start();
    $_SESSION["user"] = $user;
    $_SESSION["contra"] = $contra;
    header("Location: home.php");
    
} else {
    echo 'El usuario o la contraseña es incorrecto<br>';
    echo "<a href='index.php'>MENU</a>";
}