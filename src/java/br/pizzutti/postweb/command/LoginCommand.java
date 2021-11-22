/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.bo.LembreteBO;
import br.pizzutti.postweb.bo.UsuarioBO;
import br.pizzutti.postweb.dao.UsuarioDAO;
import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExcecaoNegocio;
import br.pizzutti.postweb.exception.ExcecaoPersistencia;
import br.pizzutti.postweb.util.ConstantesMSG;
import java.util.List;
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
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        UsuarioDTO usuarioNegocio = new UsuarioDTO();
        usuarioNegocio.setUsuario(usuario);
        usuarioNegocio.setSenha(senha);
        
        try{
           
            UsuarioBO usuarioBO = new UsuarioBO();
            boolean isValido = usuarioBO.validarLoginBO(usuarioNegocio);
            
            if(isValido){
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean loginAutorizado = usuarioDAO.validarUsuario(usuarioNegocio);
                
                if(loginAutorizado){
                    UsuarioDTO usuarioBanco = usuarioDAO.usuarioBanco(usuarioNegocio);
                    LembreteBO lembreteBO = new LembreteBO();
                    List<LembreteDTO> listaLembretes = lembreteBO.listarLembretes(usuarioBanco.getIdUsuario());
                    
                    request.getSession().setAttribute("listaLembretes", listaLembretes);
                    request.getSession().setAttribute("usuarioDTO", usuarioBanco);
                    
                    proxima = "lembrete.jsp";
                } else {
                    request.setAttribute("msgErro", ConstantesMSG.MSG_ERRO_USUARIO_SENHA_INVALIDO);
                }
            }
        } catch (ExcecaoNegocio | ExcecaoPersistencia ex){
            request.setAttribute("msgErro", ex.getMessage());
        }
        return proxima;
    }
}
