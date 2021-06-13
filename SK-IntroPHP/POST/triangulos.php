<?php

if (isset($_POST["a"]) && isset($_POST["b"]) && isset($_POST["c"])) {
    $a = $_POST["a"];
    $b = $_POST["b"];
    $c = $_POST["c"];
    if ($a > ($b + $c) || $b > ($a + $c) || $c > ($a + $b)) {
        echo 'Uno de los lados es mas grande que la suma de los otros dos. Revisa los datos.';
    } else {
        echo 'a: ' . $a . '<br />';
        echo 'b: ' . $b . '<br />';
        echo 'c: ' . $c . '<br />';
        if ($a == $b && $a == $c || $b == $a && $b == $c || $c == $b && $c == $b) {
            echo 'Es un triangulo Equilátero';
        } else if ($a == $b || $a == $c || $c == $b) {
            echo 'Es un triangulo Isósceles';
        } else {
            echo 'Es un triangulo Escaleno';
        }
    }
}
?>
<html>
    <body>
        <form action="FormularioTriangulos.php" method="POST">   
            <div>
                <input type="submit" value="Volver al Formulario">
            </div>
        </form>
    </body>
</html>
------------------------------------------------------CODIGO DE  SAHIL KUMAR------------------------------------------------