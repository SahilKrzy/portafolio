<?php
session_start();
$email = $_SESSION['email'];
$pass1 = $_SESSION['contra'];
$pass2 = $_SESSION['recontra'];
echo 'Email actual: ' . $email;
?>
<html>
    <body>
        <form action="modificar.php" method="POST">
            <label>
                Email nuevo:
                <input type="text" name="email1" id="email1" required/>
            </label>
            <label>
                Confirmar email:
                <input type="text" name="email2" id="email2" required/>
            </label>
            <form action="modificar.php" method="POST">
                <div>
                    <input type="submit" value="Confirmar">
                </div>
            </form>
            <form action="login.php" method="POST">
                <div>
                    <input type="submit" value="ATRAS">
                </div>
            </form>
        </form>
        <form action="Practica_SESSION.php" method="POST">
            <div>
                <input type="submit" value="Volver al Formulario">
            </div>
        </form>
    </body>
</html>

