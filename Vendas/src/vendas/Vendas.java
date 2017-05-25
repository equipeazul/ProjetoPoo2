/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import java.sql.Connection;
import vendas.Conexao.Conexao;
import vendas.Conexao.IConexao;
import vendas.Excecoes.ExcecaoConexao;

/**
 *
 * @author Daniel
 */
public class Vendas {

    /**
     * @param args the command line arguments
     * @author EquipeAzul
     */
    public static void main(String[] args) {
        
        try {
            IConexao conn;
            conn = Conexao.getInstancia();
            conn.conectar();
            System.out.println("Conectado");
            
        } catch (ExcecaoConexao ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
