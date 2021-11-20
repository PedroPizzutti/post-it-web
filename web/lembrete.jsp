<%-- 
    Document   : index
    Created on : 19/11/2021, 21:02:18
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale:1.0">
        <title>Meus Lembretes</title>
        <link rel="shortcut icon" type="imagex/png" href="img/icone.ico">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <jsp:include page="cabeçalho.jsp"></jsp:include>
        <main class="mainLembrete">
            <div class="boasVindas">
                <p>Bem-vindo(a), <strong>${sessionScope.usuario}</strong></p> 
            </div>
        </main>
        
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
