/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.postweb.dao;

import br.pizzutti.postweb.util.ConstantesBD;
import static br.pizzutti.postweb.util.ConstantesBD.CONEXAO_BD_PROPERTIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * @author Pedro
 * 
 * Classe destinada ao estabelecimento de conexão com o banco de dados
 */
public class Conexao {
    
    private static final ResourceBundle configBD = ResourceBundle.getBundle(CONEXAO_BD_PROPERTIES);
    public Connection conexao;
    
    public Conexao() {
    }
    
    public Connection conectarBanco() throws ClassNotFoundException, SQLException{
        
        if(conexao == null){
            String driverName = configBD.getString(ConstantesBD.CONEXAO_BD_DRIVER);
            Class.forName(driverName);
            
            String url = configBD.getString(ConstantesBD.CONEXAO_BD_URL);
            String user = configBD.getString(ConstantesBD.CONEXAO_BD_USER);
            String password = configBD.getString(ConstantesBD.CONEXAO_BD_PASSWORD);
            
            conexao = DriverManager.getConnection(url, user, password);
        }
        return conexao;
    }   
}
