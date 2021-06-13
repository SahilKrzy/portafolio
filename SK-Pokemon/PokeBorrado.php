<?php
require "bbdd.php";

$nameP = $_POST['pokemon1'];
deletePokemon($nameP);
header("Location: borrarPokemon.php");