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
public class DAOException extends Exception {
    
    
    public static final String erroAoIncluirVendedor = "Erro ao incluir vendedor";
    
    public DAOException() {
        
    }
    
    public DAOException(String mensagem) {
        super(mensagem);
    }
    
    public DAOException(Exception ex) {
        super(ex);
    }
}

