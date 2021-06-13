<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
    $users=selectAllUsers();
    echo "<form action=altaEli.php method='post'>"
    . "Que usuario quieres eliminar: <select name='users'>";
        while($fila = mysqli_fetch_assoc($users)){
            echo "<option value=".$fila['username']. ">" .$fila['username']. "</option>";
        };
    echo"</select><input type='submit' value='enviar'>";
    echo "<a href='home.php'>MENU</a>";
} else{
    header("Location: index.php");
}

