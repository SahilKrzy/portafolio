<?php
if (strlen(session_id()) < 1)
session_start();

if($_SESSION['user']){
        echo "<form action=altaReg.php method='post'>
                Nombre de usuario: <input type='text' name='user' required>
                <br />
                <br />
                Nombre:<input type='text' name='name' required>
                <br />
                <br />
                Apellido:<input type='text' name='ape' required>
                <br />
                <br />
                Contraseña:<input type='password' name='pass' required>
                <br />
                <br />
                Usuario</label><input type='radio' name='type' value='0' required><br><br>
                Administrador</label><input type='radio' name='type' value='1' required><br><br>
                <input type='submit' value='Enviar'>
                <br />
                
                </form>
                <a href='home.php'>MENU</a>";
} else {
        header("Location: index.php");
}