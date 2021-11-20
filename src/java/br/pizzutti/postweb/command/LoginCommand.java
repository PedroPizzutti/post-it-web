/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class LoginCommand implements Command {
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        proxima = "index.jsp";
        
        return proxima;
    }
    
}
