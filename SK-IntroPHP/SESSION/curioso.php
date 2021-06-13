<?php
session_start();

$edad = $_SESSION['edad'];


echo 'La edad del usuario es ' . $edad . '. <br />';
echo 'Sus divisores son: ';
for ($i = $edad; $i > 0; $i--) {
    if ($edad % $i == 0) {
        echo $i . ' ';
    }
}
?>
<html>
    <body>
        <form action="login.php" method="POST">
            <div>
                <input type="submit" value="VOLVER">
            </div>
        </form>
        <form action="Practica_SESSION.php" method="POST">
            <div>
                <input type="submit" value="CERRAR SESION">
            </div>
        </form>
    </body>
</html>
