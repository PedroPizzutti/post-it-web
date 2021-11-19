/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.dao.UsuarioDAO;
import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExceçaoPersistencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 * Classe de comando de criação de um novo usuário.
 * 
 */
public class NovoUsuarioCommand implements Command{
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        proxima = "login.jsp";
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setUsuario(usuario);
        usuarioDTO.setSenha(senha);
        usuarioDTO.setNome(nome);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try {
            usuarioDAO.inserirUsuario(usuarioDTO);
            proxima = "login.jsp";
        } catch (ExceçaoPersistencia ex) {
            throw new RuntimeException(ex);
        }
        return proxima;
    }
    
}
