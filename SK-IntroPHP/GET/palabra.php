<!DOCTYPE html>
<html>

    <body>
        <form action="palabra.php" method="GET">
            <div>
                <label for="p1">Palabra1:</label>
                <input id="p1" type="text" name="p1" required />
            </div>
            <br />
            <div>
                <label for="p2">Palabra2:</label>
                <input id="p2" type="text" name="p2" required />
            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>

            <?php
            if (isset($_GET["p1"]) && isset($_GET["p2"])) {

                $p1 = $_GET["p1"];
                $p2 = $_GET["p2"];

                if (strlen($p1) > strlen($p2)) {
                    $result = strlen($p1) - strlen($p2);
                    if (strlen($p1) == (strlen($p2) + 1)) {
                        echo 'La Palabra1: ' . $p1 . ' tiene ' . $result . ' letra más que la Palabra2: ' . $p2;
                    } else {
                        echo 'La Palabra1: ' . $p1 . ' tiene ' . $result . ' letras más que la Palabra2: ' . $p2;
                    }
                } else if (strlen($p1) < strlen($p2)) {
                    $result = strlen($p2) - strlen($p1);
                    if (strlen($p2) == (strlen($p1) + 1)) {
                        echo 'La Palabra2: ' . $p2 . ' tiene ' . $result . ' letra más que la Palabra1: ' . $p1;
                    } else {
                        echo 'La Palabra2: ' . $p2 . ' tiene ' . $result . ' letras más que la Palabra1: ' . $p1;
                    }
                } else {
                    $result = strlen($p1);
                    echo 'Las dos palabras tienen la misma cantidad de letras. Que es: ' . $result;
                }
            }
            ?>
        </form>
        <form action="Practica_GET.php" method="GET">
            <div>
                <input type="submit" value="Volver al Principio de todo">
            </div>
        </form>
    </body>
</html>
------------------------------------------------------CODIGO DE  SAHIL KUMAR------------------------------------------------
