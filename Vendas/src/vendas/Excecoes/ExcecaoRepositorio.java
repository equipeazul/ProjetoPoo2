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
    public static final String erroAoIncluirVendedor = "Erro ao incluir vendedor";
    public static final String erroAoExcluirVendedor = "Erro ao excluir vendedor";
    public static final String erroAoAlterarVendedor = "Erro ao alterar vendedor";
    public static final String erroAoConsultarVendedor = "Erro ao consultar vendedor";
    
    // Produtos
    public static final String erroAoIncluirProduto = "Erro ao incluir produto";
    public static final String erroAoExcluirProduto = "Erro ao excluir produto";
    public static final String erroAoAlterarProduto = "Erro ao alterar produto";
    public static final String erroAoConsultarProduto = "Erro ao consultar produto";
    
    // Clientes
    public static final String erroAoIncluirCliente = "Erro ao incluir cliente";
    public static final String erroAoExcluirCliente = "Erro ao excluir cliente";
    public static final String erroAoAlterarCliente = "Erro ao alterar cliente";
    public static final String erroAoConsultarCliente = "Erro ao consultar cliente";
    
    // Fabricantes
    public static final String erroAoIncluirFabricante = "Erro ao incluir fabricante";
    public static final String erroAoExcluirFabricante = "Erro ao excluir fabricante";
    public static final String erroAoAlterarFabricante = "Erro ao alterar fabricante";
    public static final String erroAoConsultarFabricante = "Erro ao consultar fabricante";
    
    // Pagamentos
    public static final String erroAoIncluirPagamento = "Erro ao incluir pagamento";
    public static final String erroAoExcluirPagamento = "Erro ao excluir pagamento";
    public static final String erroAoAlterarPagamento = "Erro ao alterar pagamento";
    public static final String erroAoConsultarPagamento = "Erro ao consultar pagamento";
    
    // PedidoProdutos
    public static final String erroAoIncluirPedidoProduto = "Erro ao incluir produto no pedido";
    public static final String erroAoExcluirPedidoProduto = "Erro ao excluir produto do pedido";
    public static final String erroAoAlterarPedidoProduto = "Erro ao alterar produto do pedido";
    public static final String erroAoConsultarPedidoProduto = "Erro ao consultar produtos do pedido";
    
    public ExcecaoRepositorio() {
        
    }
    
    public ExcecaoRepositorio(String mensagem) {
        super(mensagem);
    }
    
    public ExcecaoRepositorio(Exception ex) {
        super(ex);
    }
}

