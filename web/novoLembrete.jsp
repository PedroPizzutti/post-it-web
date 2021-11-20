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
        <header></header>
        <main>
            <form action="###" method="post">
                <fieldset>
                    <table>
                        <tr>
                            <td>${idUsuario}</td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
