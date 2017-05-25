/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Conexao;

import java.sql.Connection;
import vendas.Excecoes.ExcecaoConexao;
/**
 *
 * @author Daniel
 */
public interface IConexao {
    
    /**
     *
     * @return
     */
    public Connection conectar() throws ExcecaoConexao  ;

    /**
     *
     */
    public void desconectar(Connection conn) throws ExcecaoConexao ;
    
}
