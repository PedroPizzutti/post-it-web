<%-- 
    Document   : novoUsuario
    Created on : 18/11/2021, 10:56:53
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale:1.0">
        <title>Lembrete Login</title>
        <link rel="shortcut icon" type="imagex/png" href="img/icone.ico">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <main>
            <form>
                <fieldset class="usuario" id="novoUsuario">
                    <legend>Novo Usuário</legend>
                    <table>
                        <tr>
                            <td><label for="usuario">Usuário:</label></td>
                            <td><input type="text" id="usuario"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha"></td>
                        </tr>
                    </table>
                    <input type="submit" value="Cadastrar" id="cadastrar">
                </fieldset>
            </form>
        </main>
    </body>
</html>
