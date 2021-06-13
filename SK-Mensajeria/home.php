<?php
require "bbdd.php";

if (strlen(session_id()) < 1)
    session_start();

    if($_SESSION['user']){
        $num=comprobarAdmin($_SESSION["user"]);
        $type= mysqli_fetch_assoc($num);
        if($type['type']==1){
            echo "<a href=listado.php>Listado</a> <br />";
            echo "<a href=adminReg.php>Registrar usuario</a><br />";
            echo "<a href=eliminar.php>Eliminar usuario</a><br />";
            echo "<a href=listaMsg.php>Mensajes de todos</a><br />";
            echo "<a href=ultIni.php>Ultimo inicio de sesion</a><br />";
            echo "<a href=rank.php>Ranking</a><br />";
        }
?>

            <a href=cambiar.php>Cambiar contraseña</a>
            <br />
            <a href=msg.php>Enviar mensaje</a>
            <br />
            <a href=bandeja.php>Bandeja de entrada</a>
            <br />
            <a href=enviados.php>Mensajes enviados</a>
            <br />
            <a href=logout.php>Cerrar sesion</a>
    <?php
    } else {
        header("Location: index.php");
    }