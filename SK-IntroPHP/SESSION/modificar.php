<?php
session_start();
$email1 = $_POST["email1"];
$email2 = $_POST["email2"];

$pass1 = $_SESSION['contra'];
$pass2 = $_SESSION['recontra'];
$_SESSION['email1'] = $email1;
$_SESSION['email2'] = $email2;
if ($email1 == $email2) {
    $_SESSION['email'] = $email1;
    echo 'Se ha cambiado el correo correctamente';
} else {
    echo 'Los correos no coinciden, porfavor comprueba que esten bien.';
    die();
}
?>
<html>
    <body>
        <form action="perfil.php" method="POST">
            <div>
                <input type="submit" value="ATRAS">
            </div>
        </form>
        <form action="Practica_SESSION.php" method="POST">
            <div>
                <input type="submit" value="CERRAR SESION">
            </div>
        </form>
    </body>
</html>
