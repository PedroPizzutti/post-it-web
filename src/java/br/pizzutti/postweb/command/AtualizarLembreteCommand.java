/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.bo.LembreteBO;
import br.pizzutti.postweb.dao.LembreteDAO;
import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.util.ConstantesMSG;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 * Classe de comando para atualizar lembrete
 */
public class AtualizarLembreteCommand implements Command {
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        proxima = "main?acao=prepararAtualizar";
        
        int idLembrete = Integer.parseInt(request.getParameter("idLembrete"));
        String lembrete = request.getParameter("lembrete");
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        
        LembreteDTO lembreteDTO = new LembreteDTO();
        lembreteDTO.setDescricao(lembrete);
        lembreteDTO.setIdLembrete(idLembrete);
        
        try {
            
            LembreteBO lembreteBO = new LembreteBO();
            boolean isValido = lembreteBO.validarLembrete(lembreteDTO);
            
            if(isValido){
                
                LembreteDAO lembreteDAO = new LembreteDAO();
                lembreteDAO.atualizarLembrete(lembreteDTO);
                List<LembreteDTO> listaLembretes = lembreteDAO.listarLembretes(idPessoa);
                request.getSession().setAttribute("listaLembretes", listaLembretes);
 
                proxima = "lembrete.jsp";
                
            } else {
                request.setAttribute("msgErro", ConstantesMSG.MSG_ERRO_LEMBRETE_VAZIO);
            }
            
        } catch (Exception ex){
            request.setAttribute("msgErro", ex.getMessage());
        }
        
        return proxima;
    }
    
}
