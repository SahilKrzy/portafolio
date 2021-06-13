<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
    session_start();

    if($_SESSION['user']){
        $users=selectAllUsers();
        echo 'Lista de usuarios:<br><br>';
            while($fila = mysqli_fetch_assoc($users)){
                echo $fila['username']."<br>";
            };
            echo "<a href='home.php'>MENU</a>";
    } else {
        header("Location: index.php");
    }