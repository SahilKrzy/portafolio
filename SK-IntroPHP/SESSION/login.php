<?php
session_start();
if (isset($_POST["pass1"]) && isset($_POST["pass2"]) && isset($_POST["email"]) && isset($_POST["edad"]) && isset($_POST["nombre"])) {
    $pass1 = $_POST["pass1"];
    $pass2 = $_POST["pass2"];
    $edad = $_POST["edad"];
    $email = $_POST["email"];
    $nombre = $_POST["nombre"];

    $_SESSION['nombre'] = $nombre;
    $_SESSION['edad'] = $edad;
    $_SESSION['contra'] = $pass1;
    $_SESSION['recontra'] = $pass2;
    $_SESSION['email'] = $email;
}

if ($pass1 == $pass2 && strlen($pass1) >= 6 && (strpos($pass1, 'a') || strpos($pass1, 'A'))) {
    if ($edad > 0) {
        echo 'Logeo correcto! <br />';
    } else {
        echo 'Edad Incorrecta! <br />';
    }
} else {
    echo 'Contraseña Incorrecta';
    die();
}
?>
<!DOCTYPE html>
<html lang="en">

    <body>
        <a id ="tiempo" href="perfil.php">Modificar Perfil</a>
        <br />
        <a id ="tria" href="curioso.php">Datos curiosos de la edad</a>
        <br />
        <a id ="viaje" href="gastos.php">Consulta de gastos</a>
        <br />
    </body>

</html>


