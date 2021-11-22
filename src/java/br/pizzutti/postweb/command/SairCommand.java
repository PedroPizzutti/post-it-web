/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.util.ConstantesMSG;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 * Classe de comando para fechar a sessão.
 */
public class SairCommand implements Command {
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        proxima = "index.jsp";
        
        request.getSession().invalidate();
        request.setAttribute("msgSucesso", ConstantesMSG.MSG_SUCESSO_LOGOUT);
        
        return proxima;
    }
    
}
