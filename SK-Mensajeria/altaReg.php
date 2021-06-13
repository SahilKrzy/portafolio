<?php

require "bbdd.php";
if (isset($_POST["type"])) {
    $type = $_POST["type"];
} else {
    $type = 1; //ESTA PUESTO EL 1 PARA QUE CUANDO INICIES SESION SEAS ADMIN, PERO ESTARIA PUESTO EL 0 PARA QUE SEA QUIEN SEA EL QUE SE REGISTRE SEA UN USUARIO NORMAL Y CORRIENTE.
}
$user = $_POST['user'];
$name = $_POST['name'];
$apellido = $_POST['ape'];
$contra = $_POST['pass'];
if (comprobarExistencia($user) > 0) {
    echo 'El nombre de usuario ya existe, prueba con otro';
    echo "<form action=index.php><input type='submit' value='Menu' href='index.php'>";
} else if (insertUsuario($user, $name, $apellido, $contra, $type) == 1) {

    echo "El usuario se ha creado bien.";
} else {

    echo "El usuario no se ha creado correctamente.";
}  