<!DOCTYPE html>
<html lang="en">

    <body>
        <form action="login.php" method='POST'>
        <div>
            <label for="nombre">Nombre:</label>
            <input id="nombre" type="text" name="nombre" required />
        </div>
        <br />
        <div>
            <label for="email">Email:</label>
            <input id="email" type="text" name="email" required />
        </div>
        <br />
        <div>
            <label>
                Contraseña:
                <input type="password" name="pass1" id="pass1" required/>
            </label>
            <label>
                Confirmar contraseña:
                <input type="password" name="pass2" id="pass2" required/>
            </label>            
        </div>
        <br />
        <div>
            <div>
                <label for="edad">Edad:</label>
                <input id="edad" type="text" name="edad" required />
            </div>
            <br />
            <div>
                <label for="ciudad">Ciudad:</label>
                <input id="ciudad" type="none" name="ciudad" required />
            </div>
            <br />
            <div>
                <label for="sexo" required >Sexo:</label>
                <label for="hombre">Hombre</label>
                <input type="radio" name="sexo" value="hombre" id="hombre">
                <label for="mujer">Mujer</label>
                <input type="radio" name="sexo" value="mujer" id="mujer">
                <label for="prefierono">Prefiero no especificarlo</label>
                <input type="radio" name="sexo" value="prefierono" id="prefierono">
            </div>
            <br />
            <input type="submit" value="REGISTRAR">
            </form>
    </body>

</html>

