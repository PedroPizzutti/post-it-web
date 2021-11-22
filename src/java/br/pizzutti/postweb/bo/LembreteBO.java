/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.bo;

import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.exception.ExcecaoNegocio;
import br.pizzutti.postweb.util.ConstantesMSG;

/**
 *
 * @author Pedro
 * Classe BO de lembrete
 */
public class LembreteBO {
    
    public boolean validarLembrete(LembreteDTO lembreteDTO) throws ExcecaoNegocio{
        boolean isValido = true;
        
        if(lembreteDTO.getDescricao() == null || "".equals(lembreteDTO.getDescricao())){
            isValido = false;
            throw new ExcecaoNegocio(ConstantesMSG.MSG_ERRO_LEMBRETE_VAZIO);
        }
        return isValido;
    }
    
}
