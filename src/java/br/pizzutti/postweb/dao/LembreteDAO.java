/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dao;

import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.exception.ExceçaoPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 * Classe DAO de lembrete
 */
public class LembreteDAO {
    private Connection conexao;
    private PreparedStatement pstm;
    private ResultSet resultSet;
    
    /**
     * Método de inserir um novo lembrete.
     * @param lembreteDTO
     * @throws ExceçaoPersistencia 
     */
    public void inserirLembrete(LembreteDTO lembreteDTO) throws ExceçaoPersistencia{
        
        try {
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_lembrete (descricao_lembrete, id_pessoa) VALUES (?,?)");
            
            pstm = conexao.prepareStatement(sql.toString());
            pstm.setString(1, lembreteDTO.getDescricao());
            pstm.setInt(2, lembreteDTO.getIdPessoa());
            
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ExceçaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
