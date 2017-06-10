package vendas.fachada;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Regras.ClienteRegra;
import vendas.Regras.FabricanteRegra;
import vendas.Regras.PedidoRegra;
import vendas.Regras.ProdutoRegra;
import vendas.Regras.VendedorRegra;
import vendas.entidades.Cliente;
import vendas.entidades.Fabricante;
import vendas.entidades.Pedido;
import vendas.entidades.Produto;
import vendas.entidades.Vendedor;

/**
 *
 * @author aluno
 */
public class Fachada {
    private static Fachada instancia;
    private final ClienteRegra clienteRegra;
    private final VendedorRegra vendedorRegra;
    private final ProdutoRegra produtoRegra;
    private final FabricanteRegra fabricanteRegra;
    private final PedidoRegra pedidoRegra;
    
    private Fachada(){
        clienteRegra = new ClienteRegra();
        vendedorRegra = new VendedorRegra();
        produtoRegra = new ProdutoRegra();
        fabricanteRegra = new FabricanteRegra();
        pedidoRegra = new PedidoRegra();
    }
    
    public static Fachada getInstancia(){
        if(instancia == null)
            instancia = new Fachada();
        return instancia;
    }
    
    /*#########################################################################
     * Cliente
     *########################################################################*/
    
    public void incluirCliente(Cliente cliente) throws ExcecaoRegras{
        clienteRegra.verificarDuplicidadeCpf(cliente.getCpf());
        clienteRegra.validar(cliente);
        clienteRegra.incluir(cliente);
    }
    
    public void excluirCliente(Cliente cliente) throws ExcecaoRegras{
        clienteRegra.verificarExistencia(cliente.getIdCliente());
        clienteRegra.verificarExistenciaNoPedido(cliente.getIdCliente());
        clienteRegra.excluir(cliente);
    }
    
    public void alterarCliente(Cliente cliente) throws ExcecaoRegras{
        clienteRegra.verificarExistencia(cliente.getIdCliente());
        clienteRegra.validar(cliente);
        clienteRegra.alterar(cliente);
    }
       
    public Cliente consultarCliente(Integer id) throws ExcecaoRegras{
        clienteRegra.verificarExistencia(id);
        return clienteRegra.consultar(id);
    }
    
    public Integer ultimoCliente() throws ExcecaoRegras{
        return clienteRegra.ultimo();
    }
    
    public ArrayList<Cliente> listarClientes(String nome) throws ExcecaoRegras{
        return clienteRegra.listar(nome);
    }
   
    /*#########################################################################
     * Vendedor
     *########################################################################*/
    
    public void incluirVendedor(Vendedor vendedor)throws ExcecaoRegras{
        vendedorRegra.validar(vendedor);
        vendedorRegra.incluir(vendedor);
    }
    
    public void excluirVendedor(Vendedor vendedor)throws ExcecaoRegras{
        vendedorRegra.verificarExistencia(vendedor.getIdVendedor());
        vendedorRegra.excluir(vendedor);
    }
    
    public void alterarVendedor(Vendedor vendedor)throws ExcecaoRegras{
        vendedorRegra.verificarExistencia(vendedor.getIdVendedor());
        vendedorRegra.validar(vendedor);
        vendedorRegra.alterar(vendedor);
    }
       
    public Vendedor consultarVendedor(Integer id)throws ExcecaoRegras{
        vendedorRegra.verificarExistencia(id);
        return vendedorRegra.consultar(id);
    }
    
    public Integer ultimoVendedor()throws ExcecaoRegras{
        return vendedorRegra.ultimo();
    }
    
    public ArrayList<Vendedor> listarVendedores(String nome)throws ExcecaoRegras{
        return vendedorRegra.listar(nome);
    }
   
    /*#########################################################################
     * Produto
     *########################################################################*/
    
    public void incluirProduto(Produto produto) throws ExcecaoRegras{
        produtoRegra.validar(produto);
        produtoRegra.incluir(produto);
    }
    
    public void excluirProduto(Produto produto) throws ExcecaoRegras{
        produtoRegra.verificarExistencia(produto.getIdproduto());
        produtoRegra.verificarExistenciaNoPedido(produto.getIdproduto());
        produtoRegra.excluir(produto);
    }
    
    public void alterarProduto(Produto produto) throws ExcecaoRegras{
        produtoRegra.verificarExistencia(produto.getIdproduto());
        produtoRegra.validar(produto);
        produtoRegra.alterar(produto);
    }
       
    public Produto consultarProduto(Integer id) throws ExcecaoRegras{
        produtoRegra.verificarExistencia(id);
        return produtoRegra.consultar(id);
    }
    
    public Integer ultimoProduto() throws ExcecaoRegras{
        return produtoRegra.ultimo();
    }
    
    public ArrayList<Produto> listarProdutos(String descricao) throws ExcecaoRegras{
        return produtoRegra.listar(descricao);
    }
       
      /*#########################################################################
     * Fabricante
     *########################################################################*/
    
    
    public void excluirFabricante(Fabricante fabricante) throws ExcecaoRegras{
        fabricanteRegra.verificarExistencia(fabricante.getIdFabricante());
        fabricanteRegra.verificarExistenciaNoProduto(fabricante.getIdFabricante());
        FabricanteRegra.excluir(fabricante);        
    }
    
    public void incluirFabricante(Fabricante fabricante) throws ExcecaoRegras{
     //   FabricanteRegra.verificarDuplicidade(fabricante);
        FabricanteRegra.incluir(fabricante);
    }
    
    public void alterarFabricante(Fabricante fabricante)throws ExcecaoRegras{
        FabricanteRegra.alterar(fabricante);
    }
    
    public Fabricante consultarFabricante(Integer id)throws ExcecaoRegras{
        Fabricante fabricante = new Fabricante();
        fabricante = FabricanteRegra.consultar(id);
        return fabricante;
    }
    
    public Integer ultimoFabricante() throws ExcecaoRegras{
        Integer id  = FabricanteRegra.ultimo();
        return id;
    }
      /*#########################################################################
     * Pedido
     *########################################################################*/
    public Pedido consultarPedido(Integer id)throws ExcecaoRegras{
        Pedido pedido = new Pedido();
        pedido = pedidoRegra.consultar(id);
        return pedido;
    }    

}
