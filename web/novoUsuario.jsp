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
        <header>
        </header>
        <main>
            
            <form method="post" action="main?acao=novoUsuario">
                <fieldset class="usuario" id="novoUsuario">
                    <legend>Novo Usuário</legend>
                    <table>
                        <tr>
                             <jsp:include page="msg.jsp"></jsp:include>
                        </tr>
                        <tr>
                            <td><label for="usuario">Usuário:</label></td>
                            <td><input type="text" id="usuario" name="usuario" value="${param.usuario}"></td>
                        </tr>
                        <tr>
                            <td><label for="senha">Senha:</label></td>
                            <td><input type="password" id="senha" name="senha"></td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome:</label></td>
                            <td><input type="text" id="nome" name="nome" value="${param.nome}"></td>
                        </tr>
                    </table>
                        <input type="submit" value="Cadastrar" id="cadastrar">
                        <input type="button" value="Voltar" id="voltar" onclick="location.href='login.jsp';">
                </fieldset>
            </form>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
