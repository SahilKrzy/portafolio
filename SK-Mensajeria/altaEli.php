<?php
require "bbdd.php";

$user = $_POST['users'];
eliminarUsuario($user);
header("Location: eliminar.php");
