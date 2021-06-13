<!DOCTYPE html>
<html>

    <body>
        <form action="edad.php" method="GET">   
            <div>
                <label for="dia">Día:</label>
                <input id="dia" type="text" name="dia" required />
            </div>
            <br />
            <div>
                <label for="mes">Mes:</label>
                <input id="mes" type="text" name="mes" required />
            </div>
            <br />
            <div>
                <label for="anio">Año:</label>
                <input id="anio" type="text" name="anio" required />
            </div>
            <br />
            <div>
                <input type="submit" value="Enviar">
            </div>

            <?php
            if (isset($_GET["dia"]) && isset($_GET["mes"]) && isset($_GET["anio"])) {

                $dia = $_GET["dia"];
                $mes = $_GET["mes"];
                $any = $_GET["anio"];
                $actual = 2021;
                $edad = $actual - $any;
                echo 'DIA: ' . $dia . "<br>";
                echo 'MES: ' . $mes . "<br>";
                echo 'AÑO: ' . $any . "<br>";
                echo 'EDAD: ' . $edad . ' años';
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