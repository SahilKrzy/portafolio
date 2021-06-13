<?php
require "bbdd.php";
$cont = 1;
$entrenador = rankingEntrenador();
while($fila1 = mysqli_fetch_assoc($entrenador)){
    echo 
    "
    TOP ".$cont.": <table style='margin-bottom:15px; border-collapse:collapse; text-align: center;'>
        <tr>
            <td style=' border: black solid 1px; padding: 5px;'>NOMBRE</td>
            <td style=' border: black solid 1px; padding: 5px;'>PUNTOS</td>
        </tr>
        <tr style=' border: black solid 1px; padding: 5px;'>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['name']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['points']."</td>
        </tr>
    </table> ";
    $cont++;
}