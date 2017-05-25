/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Excecoes;

/**
 *
 * @author Daniel
 */
public class ExcecaoConexao extends Exception{
    
    public static final String erroAoConectar = "Erro ao conectar";
    public static final String erroAoDesconectar = "Erro ao desconectar";
    
    public ExcecaoConexao() {
        
    }
    
    public ExcecaoConexao(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoConexao(Exception ex) {
        super(ex);
    }
    
    
    
    
}
