/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dao;

import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExcecaoPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pedro
 * Classe DAO de usuário.
 */
public class UsuarioDAO {
    
    private Connection conexao;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet resultSet;

    public UsuarioDAO() {
    }
    /**
     * 
     * @param usuarioDTO
     * @throws ExcecaoPersistencia
     * 
     * Método para inserção de novos usuários.
     */
    public void inserirUsuario(UsuarioDTO usuarioDTO) throws ExcecaoPersistencia{
        
        try {
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_usuario (login_usuario, senha_usuario, nome_usuario)");
            sql.append(" VALUES (?,?,?)");
                      
            pstm = conexao.prepareCall(sql.toString());
            pstm.setString(1, usuarioDTO.getUsuario());
            pstm.setString(2, usuarioDTO.getSenha());
            pstm.setString(3, usuarioDTO.getNome());
            
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new ExcecaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * 
     * @param usuarioDTO
     * @return
     * @throws ExcecaoPersistencia 
     * 
     * Método para validar usuário e senha.
     */
    public boolean validarUsuario(UsuarioDTO usuarioDTO) throws ExcecaoPersistencia{
        
        boolean isValido = false;
        
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT LOGIN_USUARIO, SENHA_USUARIO FROM TB_USUARIO");
            sql.append(" WHERE LOGIN_USUARIO = ? AND SENHA_USUARIO = ?");
            
            pstm = conexao.prepareCall(sql.toString());
            pstm.setString(1, usuarioDTO.getUsuario());
            pstm.setString(2, usuarioDTO.getSenha());
            
            resultSet = pstm.executeQuery();
            
            if(resultSet.next()){
                isValido = true;
            }

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ExcecaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return isValido;
    }
    
    public boolean checarDisponibilidadeLogin(String usuario) throws ExcecaoPersistencia{
        
        boolean disponivel = true;
        
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT login_usuario FROM tb_usuario");
            sql.append(" WHERE login_usuario = '" + usuario + "'");
            
            stm = conexao.createStatement();
            
            resultSet = stm.executeQuery(sql.toString());
            
            if(resultSet.next()){
                disponivel = false;
            }
            
        } catch (Exception ex){
            throw new ExcecaoPersistencia(ex);
        }
        return disponivel;
    }
    
    public UsuarioDTO usuarioBanco(UsuarioDTO usuarioDTO) throws ExcecaoPersistencia{
        
        UsuarioDTO usuarioBanco = new UsuarioDTO();
        
        try{
            conexao = new Conexao().conectarBanco();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM TB_USUARIO");
            sql.append(" WHERE LOGIN_USUARIO = ? AND SENHA_USUARIO = ?");
            
            pstm = conexao.prepareCall(sql.toString());
            pstm.setString(1, usuarioDTO.getUsuario());
            pstm.setString(2, usuarioDTO.getSenha());
            
            resultSet = pstm.executeQuery();
            
            if(resultSet.next()){
                usuarioBanco.setIdUsuario(resultSet.getInt("id_usuario"));
                usuarioBanco.setNome(resultSet.getString("nome_usuario"));
                usuarioBanco.setUsuario(resultSet.getString("login_usuario"));
                usuarioBanco.setSenha(resultSet.getString("senha_usuario"));
            }

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ExcecaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return usuarioBanco;
    }
}
