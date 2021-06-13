<?php
session_start();
?>
<!DOCTYPE html>
<html>

    <body>
        <form action="calculo.php" method="POST">   
            <div>
                <label for="dia1">Dia 1:</label>
                <input id="dia1" type="text" name="dia1" required />
            </div>
            <br />
            <div>
                <label for="dia2">Dia 2:</label>
                <input id="dia2" type="text" name="dia2" required />
            </div>
            <br />
            <div>
                <label for="dia3">Dia 3:</label>
                <input id="dia3" type="text" name="dia3" required />
            </div>
            <br />
            <div>
                <label for="dia4">Dia 4:</label>
                <input id="dia4" type="text" name="dia4" required />
            </div>
            <br />
            <div>
                <label for="dia5">Dia 5:</label>
                <input id="dia5" type="text" name="dia5" required />
            </div>
            <br />
            <div>
                <label for="dia6">Dia 6:</label>
                <input id="dia6" type="text" name="dia6" required />
            </div>
            <div>
                <label for="dia7">Dia 7:</label>
                <input id="dia7" type="text" name="dia7" required />
            </div>
            <br />
            <div>
                <input type="submit" value="Enviar">
            </div>
        </form>
        <br />
        <form action="Practica_SESSION.php" method="POST">
            <div>
                <input type="submit" value="CERRAR SESION">
            </div>
        </form>
    </body>
</html>
