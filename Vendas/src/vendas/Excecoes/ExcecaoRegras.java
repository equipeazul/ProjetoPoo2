/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Excecoes;

/**
 *
 * @author aluno
 */
public class ExcecaoRegras extends Exception {
    
    public static final String ERRO_IDCLIENTE_NAO_EXISTE = "Id do cliente não existe";
    
    public ExcecaoRegras() {
        
    }
    
    public ExcecaoRegras(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRegras(Exception ex) {
        super(ex);
    } 
}
