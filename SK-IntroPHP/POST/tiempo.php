<?php
if (isset($_POST["hora"]) && isset($_POST["min"]) && isset($_POST["sec"])) {
    $hora = $_POST["hora"];
    $min = $_POST["min"];
    $sec = $_POST["sec"];

    if (($hora >= 00 && $hora <= 23) && ($min >= 00 && $min <= 59) && ($sec >= 00 && $sec <= 59)) {
        echo 'Has introducido la hora: ' . $hora . ':' . $min . ':' . $sec . '<br />';
        echo '<br />';
        $sec += 1;
        if ($sec == 60) {
            $sec = 00;
            $min += 1;
            if ($min == 60) {
                $min = 00;
                $hora += 1;
                if ($hora == 24) {
                    $hora = 00;
                    echo "Un segundo más tarde es: " . $hora . ":" . $min . ":" . $sec;
                } else {
                    echo "Un segundo más tarde es: " . $hora . ":" . $min . ":" . $sec;
                }
            } else {
                echo "Un segundo más tarde es: " . $hora . ":" . $min . ":" . $sec;
            }
        } else {
            echo "Un segundo más tarde es: " . $hora . ":" . $min . ":" . $sec;
        }
    } else {
        echo 'Has introducido los datos mal. Vuelve al Formulario y rellenalos de forma correcta.';
    }
}
?>
<!DOCTYPE html>
<html>
    <body>
        <form action="FormularioTiempo.php" method="POST">   
            <div>
                <input type="submit" value="Volver al Formulario">
            </div>
        </form>
    </body>
</html>
------------------------------------------------------CODIGO DE  SAHIL KUMAR------------------------------------------------