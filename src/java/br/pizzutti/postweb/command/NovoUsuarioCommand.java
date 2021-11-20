/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.bo.UsuarioBO;
import br.pizzutti.postweb.dao.UsuarioDAO;
import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExceçaoNegocio;
import br.pizzutti.postweb.exception.ExceçaoPersistencia;
import br.pizzutti.postweb.util.ConstantesMSG;
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
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario(usuario);
        usuarioDTO.setSenha(senha);
        usuarioDTO.setNome(nome);
        
        try {
            
            UsuarioBO usuarioBO = new UsuarioBO();
            boolean isValido = usuarioBO.validarNovoUsuario(usuarioDTO);
            
            if(isValido){
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.inserirUsuario(usuarioDTO);
                proxima = "login.jsp";
                request.setAttribute("msgSucesso", ConstantesMSG.MSG_SUCESSO_CAD_USUARIO);
            } else {
                request.setAttribute("msgErro", ConstantesMSG.MSG_ERRO_CAD_USUARIO);
            }
        } catch (Exception ex) {
            proxima = "novoUsuario.jsp";
            request.setAttribute("msgErro", ex.getMessage());
        }
        return proxima;
    }
    
}
