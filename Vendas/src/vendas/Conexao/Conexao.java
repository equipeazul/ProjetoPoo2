/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendas.Excecoes.ExcecaoConexao;

/**
 * Implementa classe que realizara a conecao com o banco de dados
 */
public class Conexao implements IConexao {
    
    private static Conexao conexao;
    private String usuario;
    private String senha;
    private String url;
    
    private Conexao() { 
        url = "jdbc:sqlserver://localhost:1433;databaseName=PROJETO";
        senha = "Danil";
        usuario = "";
        
    }
   
    public static Conexao getInstancia() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }
    
    /**
     * Cria uma conexao com um banco de dados
     * @return um objeto de conecao
    */
    public Connection conectar() throws ExcecaoConexao  {
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            throw new ExcecaoConexao(ex);
            //throw new ExcecaoConexao(ExcecaoConexao.erroAoConectar);
        }
        return conn;
    }
    
    /**
     * desconecta um banco de dados
    */
    public void desconectar(Connection conn) throws ExcecaoConexao {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new ExcecaoConexao(ExcecaoConexao.erroAoDesconectar);
        }
    }
    
}
