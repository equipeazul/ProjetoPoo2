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
    private String driver;
    private String usuario;
    private String senha;
    private String url;
    
    private Conexao() { 
//        driver = "com.mysql.jdbc.Driver";
//        url = "jdbc:mysql://localhost:3306/projeto";
//        usuario = "root";
//        senha = "1234";
        
        url = "jdbc:sqlserver://localhost:1433;databaseName=PROJETO";
        senha = "aluno";
        usuario = "aluno";
        
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
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ExcecaoConexao(ExcecaoConexao.ERRO_AO_CONECTAR);
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
            throw new ExcecaoConexao(ExcecaoConexao.ERRO_AO_DESCONECTAR);
        }
    }
    
}
