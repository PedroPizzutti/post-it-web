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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 * Classe DAO de lembrete
 */
public class LembreteDAO {
    private Connection conexao;
    private PreparedStatement pstm;
    private Statement stm;
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
    
    public void atualizarLembrete(LembreteDTO lembreteDTO) throws ExcecaoPersistencia{
        
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tb_lembrete SET descricao_lembrete = ?");
            sql.append(" WHERE id_lembrete = ?");
            
            pstm = conexao.prepareCall(sql.toString());
            pstm.setString(1, lembreteDTO.getDescricao());
            pstm.setInt(2, lembreteDTO.getIdLembrete());
            
            pstm.executeUpdate();
            
        } catch (Exception ex){
            throw new ExcecaoPersistencia(ex);
        } finally {
            try {
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
    
    /**
     * Método para pegar a descrição de um lembrete através do ID do Lembrete.
     * @param idLembrete
     * @return
     * @throws ExcecaoPersistencia 
     */
    public String pegarLembretePorId(int idLembrete) throws ExcecaoPersistencia{
        try {
            
            conexao = new Conexao().conectarBanco();
            
            String lembrete = "";
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_lembrete WHERE id_lembrete = " + idLembrete);
            
            stm = conexao.createStatement();
            
            resultSet = stm.executeQuery(sql.toString());
            
            if(resultSet.next()){
                lembrete = resultSet.getString("descricao_lembrete");
            }
            
            return lembrete;
        } catch(Exception ex){
            throw new ExcecaoPersistencia(ex);
        } finally {
            try {
                conexao.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Método para excluir lembretes.
     * @param idLembrete
     * @throws ExcecaoPersistencia 
     */
    public void excluirLembrete(int idLembrete) throws ExcecaoPersistencia{
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM tb_lembrete WHERE id_lembrete = " + idLembrete);
            
            stm = conexao.createStatement();
            stm.executeUpdate(sql.toString());
            
        } catch (Exception ex){
            throw new ExcecaoPersistencia(ex);
        } finally {
            try {
                conexao.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
