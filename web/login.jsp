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
        <title>Post-it Login</title>
    </head>
    <body>
        <form>
        <fieldset>
            <h2>Post-it Login</h2>
            <table>
                <tr>
                    <td><label for="usuario">Usuário:</label></td>
                    <td><input type="text" id="usuario"></td>
                </tr>
                <tr>
                    <td><label for="senha">Senha:</label></td>
                    <td><input type="password" id="senha"></td>
                </tr>
                <tr>
                    <td><input type="button" value="Novo Usuário"><input type="button" value="Logar"></td>
                </tr>
            </table>
        </fieldset>
        </form>
    </body>
</html>
