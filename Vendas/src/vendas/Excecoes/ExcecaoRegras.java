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
    public static final String ERRO_IDCLIENTE_EXISTE_PEDIDO = "Existe pedidos para este cliente";
    public static final String ERRO_NOME_CLIENTE_INVALIDO = "Nome do cliente inválido";
    public static final String ERRO_CPF_JA_CADASTRADO = "CPF já cadastrado";

    public static final String ERRO_IDVENDEDOR_NAO_EXISTE = "Id do vendedor não existe";
    public static final String ERRO_IDVENDEDOR_JA_CADASTRADO = "Id do vendedor já cadastrado";
    public static final String ERRO_NOME_VENDEDOR_INVALIDO = "Nome do vendedor inválido";

    public static final String ERRO_IDPRODUTO_EXISTE_PEDIDO = "Existe pedidos para este produtos";
    public static final String ERRO_IDPRODUTO_NAO_EXISTE = "Id do produto não existe";
    public static final String ERRO_DESCRICAO_PRODUTO_INVALIDO = "Descrição do produto inválida";
    
    public static final String ERRO_IDFABRICANTE_EXISTE_PRODUTO = "Existe produtos para este fabricante";
    public static final String ERRO_IDFABRICANTE_NAO_EXISTE = "Id do fabricante não existe";
    public static final String ERRO_RAZAO_SOCIAL_FABRICANTE_INVALIDA = "Razão social do fabricante inválida";
    public static final String ERRO_TELEFONE_FABRICANTE_INVALIDA = "Telefone do fabricante inválido";
    
    
    
    
    public static final String ERRO_ID_PEDIDO_NAO_EXISTE = "Id do pedido não existe";
    public static final String ERRO_PRODURO_NAO_EXISTE_NO_PEDIDO = "Produto não existe no pedido";
    public static final String ERRO_PRODUTO_JA_CADASTRADO_NO_PEDIDO = "Produto já cadastrado no pedido";

    public ExcecaoRegras() {
        
    }
    
    public ExcecaoRegras(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRegras(Exception ex) {
        super(ex);
    } 
}
