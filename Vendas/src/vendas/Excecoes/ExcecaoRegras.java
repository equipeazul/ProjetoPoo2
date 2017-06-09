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
    public static final String ERRO_IDCLIENTE_JA_CADASTRADO = "Id do cliente já cadastrado";
    public static final String ERRO_NOME_CLIENTE_INVALIDO = "Nome do cliente inválido";
    public static final String ERRO_CPF_JA_CADASTRADO = "CPF já cadastrado";
    public static final String ERRO_IDVENDEDOR_NAO_EXISTE = "Id do vendedor não existe";
    public static final String ERRO_IDVENDEDOR_JA_CADASTRADO = "Id do vendedor já cadastrado";
    public static final String ERRO_NOME_VENDEDOR_INVALIDO = "Nome do vendedor inválido";

    public ExcecaoRegras() {
        
    }
    
    public ExcecaoRegras(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRegras(Exception ex) {
        super(ex);
    } 
}
