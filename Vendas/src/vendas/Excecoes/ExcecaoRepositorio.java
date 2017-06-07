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
    
    // Vendedores
    public static final String ERRO_AO_INCLUIR_VENDEDOR = "Erro ao incluir vendedor";
    public static final String ERRO_AO_EXCLUIR_VENDEDOR = "Erro ao excluir vendedor";
    public static final String ERRO_AO_ALTERAR_VENDEDOR = "Erro ao alterar vendedor";
    public static final String ERRO_AO_CONSULTAR_VENDEDOR = "Erro ao consultar vendedor";
    
    // Produtos
    public static final String ERRO_AO_INCLUIR_PRODUTO = "Erro ao incluir produto";
    public static final String ERRO_AO_EXCLUIR_PRODUTO = "Erro ao excluir produto";
    public static final String ERRO_AO_ALTERAR_PRODUTO = "Erro ao alterar produto";
    public static final String ERRO_AO_CONSULTAR_PRODUTO = "Erro ao consultar produto";
    
    // Clientes
    public static final String ERRO_AO_INCLUIR_CLIENTE = "Erro ao incluir cliente";
    public static final String ERRO_AO_EXCLUIR_CLIENTE = "Erro ao excluir cliente";
    public static final String ERRO_AO_ALTERAR_CLIENTE = "Erro ao alterar cliente";
    public static final String ERRO_AO_CONSULTAR_CLIENTE = "Erro ao consultar cliente";
    
    // Fabricantes
    public static final String ERRO_AO_INCLUIR_FABRICANTE = "Erro ao incluir fabricante";
    public static final String ERRO_AO_EXCLUIR_FABRICANTE = "Erro ao excluir fabricante";
    public static final String ERRO_AO_ALTERAR_FABRICANTE = "Erro ao alterar fabricante";
    public static final String ERRO_AO_CONSULTAR_FABRICANTE = "Erro ao consultar fabricante";
    
    // Pagamentos
    public static final String ERRO_AO_INCLUIR_PAGAMENTO = "Erro ao incluir pagamento";
    public static final String ERRO_AO_EXCLUIR_PAGAMENTO = "Erro ao excluir pagamento";
    public static final String ERRO_AO_ALTERAR_PAGAMENTO = "Erro ao alterar pagamento";
    public static final String ERRO_AO_CONSULTAR_PAGAMENTO = "Erro ao consultar pagamento";
    
    // PedidoProdutos
    public static final String ERRO_AO_INCLUIR_PEDIDOPRODUTO = "Erro ao incluir produto no pedido";
    public static final String ERRO_AO_EXCLUIR_PEDIDOPRODUTO = "Erro ao excluir produto do pedido";
    public static final String ERRO_AO_ALTERAR_PEDIDOPRODUTO = "Erro ao alterar produto do pedido";
    public static final String ERRO_AO_CONSULTAR_PEDIDOPRODUTO = "Erro ao consultar produtos do pedido";
    
    // Pedidos
    public static final String ERRO_AO_INCLUIR_PEDIDO = "Erro ao incluir pedido";
    public static final String ERRO_AO_EXCLUIR_PEDIDO = "Erro ao excluir pedido";
    public static final String ERRO_AO_ALTERAR_PEDIDO = "Erro ao alterar pedido";
    public static final String ERRO_AO_CONSULTAR_PEDIDO = "Erro ao consultar pedido";
    
    public ExcecaoRepositorio() {
        
    }
    
    public ExcecaoRepositorio(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRepositorio(Exception ex) {
        super(ex);
    }
}

