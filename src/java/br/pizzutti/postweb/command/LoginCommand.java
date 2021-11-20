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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class LoginCommand implements Command {
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        proxima = "login.jsp";
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario(usuario);
        usuarioDTO.setSenha(senha);
        
        try{
           
            UsuarioBO usuarioBO = new UsuarioBO();
            boolean isValido = usuarioBO.validarLoginBO(usuarioDTO);
            
            if(isValido){
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean loginCorreto = usuarioDAO.validarUsuario(usuarioDTO);
                
                if(loginCorreto){
                    request.getSession().setAttribute("usuario", usuarioDTO.getUsuario());
                    proxima = "lembrete.jsp";
                } else {
                    request.setAttribute("msgErro", ConstantesMSG.MSG_ERRO_USUARIO_SENHA_INVALIDO);
                }
            }
        } catch (ExceçaoNegocio | ExceçaoPersistencia ex){
            request.setAttribute("msgErro", ex.getMessage());
        }
        return proxima;
    }
}
