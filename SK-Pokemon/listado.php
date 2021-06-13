<?php
require "bbdd.php";
$cont = 1;
$pokemon = selectAll();
while($fila1 = mysqli_fetch_assoc($pokemon)){
    echo 
    "
    Pokemon ".$cont.": <table style='margin-bottom:15px; border-collapse:collapse; text-align: center;'>
        <tr>
            <td style=' border: black solid 1px; padding: 5px;'>Nombre</td>
            <td style=' border: black solid 1px; padding: 5px;'>tipo</td>
            <td style=' border: black solid 1px; padding: 5px;'>habilidad</td>
            <td style=' border: black solid 1px; padding: 5px;'>ataque</td>
            <td style=' border: black solid 1px; padding: 5px;'>defensa</td>
            <td style=' border: black solid 1px; padding: 5px;'>velocidad</td>
            <td style=' border: black solid 1px; padding: 5px;'>life</td>
            <td style=' border: black solid 1px; padding: 5px;'>level</td>
            <td style=' border: black solid 1px; padding: 5px;'>entrenador</td>
        </tr>
        <tr style=' border: black solid 1px; padding: 5px;'>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['name']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['type']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['ability']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['attack']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['defense']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['speed']."</td>
             <td style=' border: black solid 1px; padding: 5px;'>".$fila1['life']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['level']."</td>
            <td style=' border: black solid 1px; padding: 5px;'>".$fila1['trainer']."</td>
        </tr>
    </table> ";
    $cont++;
}

?>