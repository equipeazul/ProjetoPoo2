package vendas.fachada;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Regras.ClienteRegra;
import vendas.Regras.FabricanteRegra;
import vendas.Regras.PedidoRegra;
import vendas.Regras.ProdutoRegra;
import vendas.Regras.VendedorRegra;
import vendas.Entidades.Cliente;
import vendas.Entidades.Fabricante;
import vendas.Entidades.Pedido;
import vendas.Entidades.PedidoProduto;
import vendas.Entidades.Produto;
import vendas.Entidades.Vendedor;

/**
 *
 * @author aluno
 */
public class Fachada {
    
    private static Fachada instancia;
    
    public static Fachada getInstancia(){
        if(instancia == null)
            instancia = new Fachada();
        return instancia;
    }
    
    /*#########################################################################
    * Cliente
    *########################################################################*/
    
    public void incluirCliente(Cliente cliente) throws ExcecaoRegras{
        ClienteRegra.verificarDuplicidadeCpf(cliente.getCpf());
        ClienteRegra.validar(cliente);
        ClienteRegra.incluir(cliente);
    }
    
    public void excluirCliente(Cliente cliente) throws ExcecaoRegras{
        ClienteRegra.verificarExistencia(cliente.getIdCliente());
        ClienteRegra.verificarExistenciaNoPedido(cliente.getIdCliente());
        ClienteRegra.excluir(cliente);
    }
    
    public void alterarCliente(Cliente cliente) throws ExcecaoRegras{
        ClienteRegra.verificarExistencia(cliente.getIdCliente());
        ClienteRegra.validar(cliente);
        ClienteRegra.alterar(cliente);
    }
       
    public Cliente consultarCliente(Integer id) throws ExcecaoRegras{
        ClienteRegra.verificarExistencia(id);
        return ClienteRegra.consultar(id);
    }
    
    public Integer ultimoCliente() throws ExcecaoRegras{
        return ClienteRegra.ultimo();
    }
    
    public ArrayList<Cliente> listarClientes(String nome) throws ExcecaoRegras{
        return ClienteRegra.listar(nome);
    }
   
    /*#########################################################################
    * Vendedor
    *########################################################################*/
    
    public void incluirVendedor(Vendedor vendedor)throws ExcecaoRegras{
        VendedorRegra.validar(vendedor);
        VendedorRegra.incluir(vendedor);
    }
    
    public void excluirVendedor(Vendedor vendedor)throws ExcecaoRegras{
        VendedorRegra.verificarExistencia(vendedor.getIdVendedor());
        VendedorRegra.excluir(vendedor);
    }
    
    public void alterarVendedor(Vendedor vendedor)throws ExcecaoRegras{
        VendedorRegra.verificarExistencia(vendedor.getIdVendedor());
        VendedorRegra.validar(vendedor);
        VendedorRegra.alterar(vendedor);
    }
       
    public Vendedor consultarVendedor(Integer id)throws ExcecaoRegras{
        VendedorRegra.verificarExistencia(id);
        return VendedorRegra.consultar(id);
    }
    
    public Integer ultimoVendedor()throws ExcecaoRegras{
        return VendedorRegra.ultimo();
    }
    
    public ArrayList<Vendedor> listarVendedores(String nome)throws ExcecaoRegras{
        return VendedorRegra.listar(nome);
    }
    
    /*#########################################################################
    * Produto
    *########################################################################*/
    
    public void incluirProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.validar(produto);
        ProdutoRegra.incluir(produto);
    }
    
    public void excluirProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.verificarExistencia(produto.getIdProduto());
        ProdutoRegra.verificarExistenciaNoPedido(produto.getIdProduto());
        ProdutoRegra.excluir(produto);
    }
    
    public void alterarProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.verificarExistencia(produto.getIdProduto());
        ProdutoRegra.validar(produto);
        ProdutoRegra.alterar(produto);
    }
       
    public Produto consultarProduto(Integer id) throws ExcecaoRegras{
        ProdutoRegra.verificarExistencia(id);
        return ProdutoRegra.consultar(id);
    }
    
    public Integer ultimoProduto() throws ExcecaoRegras{
        return ProdutoRegra.ultimo();
    }
    
    public ArrayList<Produto> listarProdutos(String descricao, String razaoSocial) throws ExcecaoRegras{
        return ProdutoRegra.listar(descricao, razaoSocial);
    }
    
    /*#########################################################################
    * Fabricante
    *########################################################################*/
    
    
    public void excluirFabricante(Fabricante fabricante) throws ExcecaoRegras{
        FabricanteRegra.verificarExistencia(fabricante.getIdFabricante());
        FabricanteRegra.verificarExistenciaNoProduto(fabricante.getIdFabricante());
        FabricanteRegra.excluir(fabricante);        
    }
    
    public void incluirFabricante(Fabricante fabricante) throws ExcecaoRegras{
        FabricanteRegra.validar(fabricante);
        FabricanteRegra.incluir(fabricante);
    }
    
    public void alterarFabricante(Fabricante fabricante)throws ExcecaoRegras{
        FabricanteRegra.validar(fabricante);
        FabricanteRegra.alterar(fabricante);
    }
    
    public Fabricante consultarFabricante(Integer id)throws ExcecaoRegras{
        FabricanteRegra.verificarExistencia(id);
        Fabricante fabricante = new Fabricante();
        fabricante = FabricanteRegra.consultar(id);
        return fabricante;
    }
    
    public ArrayList<Fabricante> listarFabricantes(String razaoSocial) throws ExcecaoRegras{
        return FabricanteRegra.listar(razaoSocial);
    }
    
    public Integer ultimoFabricante() throws ExcecaoRegras{
        Integer id  = FabricanteRegra.ultimo();
        return id;
    }
    
    /*#########################################################################
    * Pedido
    *########################################################################*/
    public Pedido consultarPedido(Integer id, Boolean comProdutos)throws ExcecaoRegras{
        Pedido pedido = new Pedido();
        pedido = PedidoRegra.consultar(id, comProdutos);
        return pedido;
    }    

    public void incluirPedido(Pedido pedido) throws ExcecaoRegras{
        PedidoRegra.validar(pedido);
        PedidoRegra.incluir(pedido);
    }
    
    public void excluirPedido(Pedido pedido) throws ExcecaoRegras{
        PedidoRegra.verificarExistencia(pedido.getIdPedido());
        PedidoRegra.excluir(pedido);
    }
    
    public void alterarPedido(Pedido pedido) throws ExcecaoRegras{
        PedidoRegra.verificarExistencia(pedido.getIdPedido());
        PedidoRegra.validar(pedido);
        PedidoRegra.alterar(pedido);
    }
       
    
    public Integer ultimoPedido() throws ExcecaoRegras{
        return PedidoRegra.ultimo();
    }
    
    public ArrayList<Pedido> listarPedidos(String nomeCliente, String nomeVendedor) throws ExcecaoRegras{
        return PedidoRegra.listar(nomeCliente, nomeVendedor);
    }

    /*#########################################################################
    * PedidoProduto
    *########################################################################*/
    public void incluirPedidoProduto(Integer idPedido, PedidoProduto pedidoProduto) throws ExcecaoRegras{
        PedidoRegra.jaCadastradoProduto(idPedido, pedidoProduto.getProduto().getIdProduto());
        PedidoRegra.validarProduto(pedidoProduto);
        PedidoRegra.incluirProduto(idPedido, pedidoProduto);
    }
    
    public void excluirPedidoProduto(Integer idPedido, PedidoProduto pedidoProduto) throws ExcecaoRegras{
        PedidoRegra.verificarExistenciaProduto(idPedido, pedidoProduto.getProduto().getIdProduto());
        PedidoRegra.excluirProduto(idPedido, pedidoProduto);
    }
    
    public void alterarPedidoProduto(Integer idPedido, PedidoProduto pedidoProduto) throws ExcecaoRegras{
        PedidoRegra.verificarExistenciaProduto(idPedido, pedidoProduto.getProduto().getIdProduto());
        PedidoRegra.validarProduto(pedidoProduto);
        PedidoRegra.alterarProduto(idPedido, pedidoProduto);
    }
}
