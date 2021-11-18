<%-- 
    Document   : login
    Created on : 17/11/2021, 11:24:17
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale:1.0">
        <title>Lembrete Login</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <main>
            <form>
                <fieldset id="fieldsetLogin">
                    <h2><img src="img/logo_lembrete.png" alt="logo lembrete"></h2>
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
                    <input type="button" value="Logar" id="logar">
                    <input type="button" value="Novo Usuário" id="novoUsuario">
                </fieldset>
            </form>
        </main>
    </body>
</html>
