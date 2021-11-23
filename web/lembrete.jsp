<%-- 
    Document   : index
    Created on : 19/11/2021, 21:02:18
    Author     : Pedro
--%>

<%@page import="java.util.List"%>
<%@page import="br.pizzutti.postweb.dto.LembreteDTO"%>
<%@page import="br.pizzutti.postweb.dto.LembreteDTO"%>
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
            <fieldset class="blocoLembrete">
                <div class="boasVindas">
                    <p id="nomeLembrete">Mural de <strong>${sessionScope.usuarioDTO.nome}</strong></p>
                    <a id="deslogar" href="main?acao=logout">Sair</a> 
                </div>
                <div id="campoLembretes">
                    <%
                        List<LembreteDTO> listaLembrete = (List<LembreteDTO>) session.getAttribute("listaLembretes");
                        for(LembreteDTO lembrete : listaLembrete){
                    %>
                    <fieldset class="lembrete">
                        <p class="botoesLembrete">
                            <a href="main?acao=prepararAtualizar&idLembrete=<%=lembrete.getIdLembrete()%>&idPessoa=<%=lembrete.getIdPessoa()%>">
                                <img class="botaoImg" src="img/botao-atualizar.png" alt="botao atualizar"></a>
                            <a href="main?acao=excluir&idLembrete=<%=lembrete.getIdLembrete()%>&idPessoa=<%=lembrete.getIdPessoa()%>" title="excluir">
                                <img class="botaoImg" src="img/botao-fechar.png" alt="botao excluir"></a>
                        </p>
                        <p id="paragrafoLembrete"><%=lembrete.getDescricao()%></p>
      
                    </fieldset>
                    <%
                    }
                    %>
                </div>
            </fieldset>
        </main>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
