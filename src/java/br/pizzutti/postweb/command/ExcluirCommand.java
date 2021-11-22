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
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 * Classe de comando de exclusão de lembrete
 * 
 */
public class ExcluirCommand implements Command {
    
    private String proxima;

    @Override
    public String execute(HttpServletRequest request) {
        
        int idLembrete = Integer.parseInt(request.getParameter("idLembrete"));
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
     
        try {
        LembreteDAO lembreteDAO = new LembreteDAO();
        lembreteDAO.excluirLembrete(idLembrete);
        List<LembreteDTO> listaLembretes = lembreteDAO.listarLembretes(idPessoa);
        request.getSession().setAttribute("listaLembretes", listaLembretes);
        proxima = "lembrete.jsp";

        } catch(Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    
    return proxima;
    }
}
