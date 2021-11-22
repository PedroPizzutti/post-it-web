<%-- 
    Document   : novoLembrete.jsp
    Created on : 20/11/2021, 16:29:31
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Novo Lembrete</title>
        <link rel="shortcut icon" type="imagex/png" href="img/icone.ico">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <main>
            <jsp:include page="msg.jsp"></jsp:include>  
            <form action="main?acao=novoLembrete" method="post">
                <fieldset class="novoLembrete">
                    <legend>Novo Lembrete</legend>
                    <input type="number" name="idPessoa" value="${usuarioDTO.idUsuario}" style="display: none">
                    <textarea rows="3" cols="10" autofocus="true" maxlength="40" name="lembrete"></textarea>
                    <input type="submit" value="Colar no Mural" id="botaoNovoLembrete">
                </fieldset>
            </form>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
