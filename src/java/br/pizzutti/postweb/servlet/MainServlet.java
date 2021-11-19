package br.pizzutti.postweb.servlet;

import br.pizzutti.postweb.command.Command;
import br.pizzutti.postweb.command.NovoUsuarioCommand;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    
    private static final long serialVersion = 1L;
    
    private Map<String, Command> comandos = new HashMap<String, Command>();

    @Override
    public void init(){
        comandos.put("novoUsuario", new NovoUsuarioCommand());
    }

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String proxima = null;
        
        try{
            Command comando = verificarComando(acao);
            proxima = comando.execute(request);
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        request.getRequestDispatcher(proxima).forward(request, response);
    }
    
    private Command verificarComando(String acao){
        Command comando = null;
        
        for(String key : comandos.keySet()){
            if(key.equalsIgnoreCase(acao)){
                comando = comandos.get(key);
            }
        } 
        return comando;
    }
}

       
