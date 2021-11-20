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
        <link rel="shortcut icon" type="imagex/png" href="img/icone.ico">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <main>
            <form action="main?acao=login" method="post">
                <fieldset class="usuario">
                    <h2><img src="img/logo_lembrete.png" alt="logo lembrete"></h2>
                    <jsp:include page="msg.jsp"></jsp:include>
                    <table>
                        <tr>
                            <td><label for="usuario">Usuário:</label></td>
                            <td><input type="text" id="usuario" name="usuario" value="${param.usuario}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha" name="senha"></td>
                        </tr>
                    </table>
                    <input type="submit" value="Logar" id="logar">
                    <input type="button" value="Novo Usuário" id="novoUsuario" onclick="location.href='novoUsuario.jsp';">
                </fieldset>
            </form>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
