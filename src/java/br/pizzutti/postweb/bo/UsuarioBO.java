/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.bo;

import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExcecaoNegocio;
import br.pizzutti.postweb.util.ConstantesMSG;

/**
 *
 * @author Pedro
 * 
 * Classe destinada à validação do usuario
 * 
 */
public class UsuarioBO {
    
    public boolean validarNovoUsuario(UsuarioDTO usuarioDTO) throws ExcecaoNegocio {
        boolean validacao = true;
        
        if(usuarioDTO.getUsuario() == null || "".equals(usuarioDTO.getUsuario())){
            validacao = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "usuário"));
        }
        
        if(usuarioDTO.getSenha() == null || "".equals(usuarioDTO.getSenha())){
            validacao = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "senha"));

        }
        
        if(usuarioDTO.getNome() == null || "".equals(usuarioDTO.getNome())){
            validacao = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "nome"));

        }
        return validacao;
    }
    
    public boolean validarLoginBO(UsuarioDTO usuarioDTO) throws ExcecaoNegocio{
        boolean validacao = true;
        
        if(usuarioDTO.getUsuario() == null || "".equals(usuarioDTO.getUsuario())){
            validacao = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "usuário"));
        }
        
        if(usuarioDTO.getSenha() == null || "".equals(usuarioDTO.getSenha())){
            validacao = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "senha"));
        }
        
        return validacao;
    }
}
