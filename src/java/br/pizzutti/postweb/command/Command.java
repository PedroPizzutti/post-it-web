package br.pizzutti.postweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Pedro
 * 
 * Interface para as classes de comando.
 */
public interface Command {
    
    /**
     * método do padrão comando.
     * @param request
     * @return 
     */
    public String execute(HttpServletRequest request);
    
}
