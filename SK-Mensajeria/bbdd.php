<?php


function conectar(){

    $conector = mysqli_connect("localhost","root","DAM1T_M03","msg");
    if (!$conector){
        die("Error".mysqli_connect_error());
    }
    return $conector;
}

function desconectar($conectar){
    mysqli_close($conectar);
}

function insertUsuario ($user, $name, $apellido, $contra,$type){

    $c = conectar();
    $insert = "INSERT INTO user(username,name,surname,password,type) values ('$user', '$name', '$apellido', '$contra',$type)";
    $resultado = mysqli_query($c,$insert);
    desconectar($c);
    return $resultado;
}

function comprobarExistencia ($user) {
    $c = conectar();
    $select = "SELECT username FROM user WHERE username = '$user'";
    $resultado = mysqli_query($c,$select);
    $num = mysqli_num_rows($resultado);
    desconectar($c);
    return $num;
}

function iniciarSesion ($user, $contra){
    $c = conectar();
    $select = "SELECT * FROM user WHERE username = '$user' and password = '$contra'";
    $resultado = mysqli_query($c,$select);
    $num = mysqli_num_rows($resultado);
    desconectar($c);
    return $num;
}

function inicioEvent($user){
    $c = conectar();
    $select = "insert into event(user,date,type) values('$user', now(), 'I')";
    mysqli_query($c,$select);
    desconectar($c);
}

function cambiarContra($user,$contra){
    $c = conectar();
    $select = "UPDATE user SET password = '$contra' where username ='$user'";
    mysqli_query($c,$select);
    desconectar($c);
}

function selectAllUsers(){
    $c = conectar();
    $select = "SELECT * from user";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function enviarMensaje($emisor, $receptor, $asunto, $mensaje) {
   $c = conectar();
    $select = "insert into message(sender, receiver, date, `read`, subject, body) values('$emisor', '$receptor', now(), 0, '$asunto', '$mensaje');";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado; 
}

function redaccionEvent($user){
    $c = conectar();
    $select = "insert into event(user,date,type) values('$user', now(), 'R')";
    mysqli_query($c,$select);
    desconectar($c);
}

function bandejaEvent($user){
    $c = conectar();
    $select = "insert into event(user,date,type) values('$user', now(), 'C')";
    mysqli_query($c,$select);
    desconectar($c);
}

function selectRecibidos($user){
    $c = conectar();
    $select = "select * from message where receiver ='$user';";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function imprimirMensaje($id) {
    $c = conectar();
    $select = "select * from message where idmessage =$id;";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function leido($id){
    $c = conectar();
    $select = "UPDATE message SET `read` = 1 where idmessage =$id";
    mysqli_query($c,$select);
    desconectar($c);
}

function selectEnviados($user){
    $c = conectar();
    $select = "select * from message where sender ='$user';";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function comprobarAdmin ($user) {
    $c = conectar();
    $select = "SELECT type FROM user WHERE username = '$user'";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
} 

function eliminarUsuario ($user){
    $c = conectar();
    $select = "delete from user where username = '$user';";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
}

function selectAllMessages(){
    $c = conectar();
    $select = "select * from message;";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}

function ultimoInicio($user) {
    $c = conectar();
    $select = "select * from event where idevent = (select MAX(idevent) from event where type='I' and user='$user');";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
}
 function ranking() {
    $c = conectar();
    $select = "select COUNT(type), user from event where type = 'R' group by user;";
    $resultado = mysqli_query($c,$select);
    desconectar($c);
    return $resultado;
 }