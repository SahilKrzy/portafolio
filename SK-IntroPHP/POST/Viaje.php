<?php

if (isset($_POST["tramo1"]) && isset($_POST["tramo2"]) && isset($_POST["tramo3"]) && isset($_POST["tramo4"]) && isset($_POST["tramo5"])) {
    $tramo1 = $_POST["tramo1"];
    $tramo2 = $_POST["tramo2"];
    $tramo3 = $_POST["tramo3"];
    $tramo4 = $_POST["tramo4"];
    $tramo5 = $_POST["tramo5"];

    $tiempohora = $tramo1 + $tramo2 + $tramo3 + $tramo4 + $tramo5;
    echo 'Tramo 1: ' . $tramo1 . '<br />';
    echo '<br /> Tramo 2: ' . $tramo2 . '<br />';
    echo '<br /> Tramo 3: ' . $tramo3 . '<br />';
    echo '<br /> Tramo 4: ' . $tramo4 . '<br />';
    echo '<br /> Tramo 5: ' . $tramo5 . '<br />';

    $minutos = 0;
    $horas = 0;
    for ($i = 1; $i <= $tiempohora; $i++) {
        $minutos++;
        if ($minutos == 60) {
            $minutos = 0;
            $horas++;
        }
    }
    echo '<br /> Duración total del viaje: '.$horas.':'.$minutos. '<br />';
}
?>
<html>
    <body>
        <form action="FormularioViaje.php" method="POST">   
            <div>
                <input type="submit" value="Volver al Formulario">
            </div>
        </form>
    </body>
</html>
------------------------------------------------------CODIGO DE  SAHIL KUMAR------------------------------------------------