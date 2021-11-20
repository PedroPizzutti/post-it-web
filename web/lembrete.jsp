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
        <header>
            <div class="cabeçalho">
                <a href="novoLembrete.jsp"><img src="img/logo_lembrete.png" alt="Logo Lembrete"></a>
            </div>
        </header>
        <main class="mainLembrete">
            <div class="boasVindas">
                <p id="nomeLembrete">Lembretes de <strong>${sessionScope.usuarioDTO.nome}</strong></p>
            </div>
            <fieldset>
            <div id="campoLembretes">
            <fieldset class="lembrete">
                <legend></legend>
            </fieldset>
            <fieldset class="lembrete">
                <legend></legend>
            </fieldset>
            </fieldset>
            <p><a id="deslogar" href="###">Sair</a></p>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
