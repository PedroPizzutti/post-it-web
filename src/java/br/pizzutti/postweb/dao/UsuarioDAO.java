/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dao;

import br.pizzutti.postweb.dto.UsuarioDTO;
import br.pizzutti.postweb.exception.ExceçaoPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class UsuarioDAO {
    
    private Connection conexao;
    private PreparedStatement pstm;

    public UsuarioDAO() {
    }
    
    public void inserirUsuario(UsuarioDTO usuarioDTO) throws ExceçaoPersistencia{
        
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
            throw new ExceçaoPersistencia(ex);
        } finally {
            try{
                conexao.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
