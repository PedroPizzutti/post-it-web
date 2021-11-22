/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dao;

import br.pizzutti.postweb.dto.LembreteDTO;
import br.pizzutti.postweb.exception.ExcecaoPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * @throws ExcecaoPersistencia 
     */
    public void inserirLembrete(LembreteDTO lembreteDTO) throws ExcecaoPersistencia{
        
        try {
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_lembrete (descricao_lembrete, id_pessoa) VALUES (?,?)");
            
            pstm = conexao.prepareStatement(sql.toString());
            pstm.setString(1, lembreteDTO.getDescricao());
            pstm.setInt(2, lembreteDTO.getIdPessoa());
            
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ExcecaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Método para listar os lembretes de um usuário.
     * @param idUsuario
     * @return
     * @throws ExcecaoPersistencia 
     */
    public List<LembreteDTO> listarLembretes(int idUsuario) throws ExcecaoPersistencia{
        List<LembreteDTO> listaLembretes = new ArrayList<>();
        
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_lembrete WHERE id_pessoa = ?");
            
            pstm = conexao.prepareStatement(sql.toString());
            pstm.setInt(1, idUsuario);
            
            resultSet = pstm.executeQuery();
            
            while(resultSet.next()){
                LembreteDTO lembreteDTO = new LembreteDTO();
                lembreteDTO.setIdLembrete(resultSet.getInt("id_lembrete"));
                lembreteDTO.setDescricao(resultSet.getString("descricao_lembrete"));
                lembreteDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
                
                listaLembretes.add(lembreteDTO);
            }
        } catch (Exception ex){
            throw new ExcecaoPersistencia(ex);
        } finally {
            try {
                conexao.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return listaLembretes;
    }
}
