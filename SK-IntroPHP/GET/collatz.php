<!DOCTYPE html>
<html>

    <body>
        <form action="collatz.php" method="GET">
            <div>
                <label for="numero">Numero:</label>
                <input id="numero" type="text" name="numero" required />
            </div>
            <br />
            <div>
                <input type="submit" value="Enviar">
            </div>
            <?php
            if (isset($_GET["numero"])) {

                $numero = $_GET["numero"];
                while ($numero != 1) {
                    if ($numero % 2 == 0) {
                        echo $numero . ", ";
                        $numero = $numero / 2;
                    } else {
                        echo $numero . ", ";
                        $numero = ($numero * 3) + 1;
                    }//fin else
                    if ($numero == 1) {
                        echo "1";
                    }//fin if
                }//fin while
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