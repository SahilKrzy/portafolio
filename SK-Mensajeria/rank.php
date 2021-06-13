<?php
require "bbdd.php";
if (strlen(session_id()) < 1)
            session_start();
   if($_SESSION['user']){
       $rank= ranking();
        while($fila = mysqli_fetch_assoc($rank)){
            echo $fila['user']."</br></br>Cantidad: ".$fila['COUNT(type)']."</br></br>";
        }
        echo "<a href='home.php'>MENU</a>";
}else{
       header("Location: index.php");
}
