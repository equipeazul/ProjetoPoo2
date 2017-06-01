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
public class ExcecaoRepositorio extends Exception {
    
    public static final String erroAoIncluirVendedor = "Erro ao incluir vendedor";
    public static final String erroAoExcluirVendedor = "Erro ao excluir vendedor";
    public static final String erroAoAlterarVendedor = "Erro ao alterar vendedor";
    public static final String erroAoConsultarVendedor = "Erro ao consultar vendedor";
    
    public ExcecaoRepositorio() {
        
    }
    
    public ExcecaoRepositorio(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRepositorio(Exception ex) {
        super(ex);
    }
}
