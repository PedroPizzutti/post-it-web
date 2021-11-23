/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.command;

import br.pizzutti.postweb.dao.LembreteDAO;
import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.exception.ExcecaoPersistencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class PrepararAtualizarCommand implements Command{
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        int idLembrete = Integer.parseInt(request.getParameter("idLembrete"));
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        
        try {
            
        LembreteDAO lembreteDAO = new LembreteDAO();
        String lembrete = lembreteDAO.pegarLembretePorId(idLembrete);
        
        LembreteDTO lembreteDTO = new LembreteDTO();
        lembreteDTO.setIdLembrete(idLembrete);
        lembreteDTO.setIdPessoa(idPessoa);
        lembreteDTO.setDescricao(lembrete);
        
        request.setAttribute("lembreteDTO", lembreteDTO);
        
        } catch (ExcecaoPersistencia ex) {
            request.setAttribute("msgErro", ex.getMessage());
        }
        
        proxima = "atualizarLembrete.jsp";
        
        return proxima;
    }
    
}
