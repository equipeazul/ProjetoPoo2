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
import vendas.util.IEntityModel;

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
   
    public ArrayList<IEntityModel> listarClientesEntity(String nome) throws ExcecaoRegras{
        return ClienteRegra.listarEntity(nome);
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
    
    public ArrayList<IEntityModel> listarVendedoresEntity(String descricao) throws ExcecaoRegras{
        return VendedorRegra.listarEntity(descricao);
    }
   
    /*#########################################################################
    * Produto
    *########################################################################*/
    
    public void incluirProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.validar(produto);
        ProdutoRegra.incluir(produto);
    }
    
    public void excluirProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.verificarExistencia(produto.getIdproduto());
        ProdutoRegra.verificarExistenciaNoPedido(produto.getIdproduto());
        ProdutoRegra.excluir(produto);
    }
    
    public void alterarProduto(Produto produto) throws ExcecaoRegras{
        ProdutoRegra.verificarExistencia(produto.getIdproduto());
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
    
    public ArrayList<Produto> listarProdutos(String descricao) throws ExcecaoRegras{
        return ProdutoRegra.listar(descricao);
    }
    
    public ArrayList<IEntityModel> listarProdutosEntity(String descricao) throws ExcecaoRegras{
        return ProdutoRegra.listarEntity(descricao);
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
    
    public ArrayList<IEntityModel> listarFabricantesEntity(String razaosocial) throws ExcecaoRegras{
        return FabricanteRegra.listarEntity(razaosocial);
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
        pedido = PedidoRegra.consultar(id);
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
    
    public ArrayList<Pedido> listar(String nomeCliente, String nomeVendedor) throws ExcecaoRegras{
        return PedidoRegra.listar(nomeCliente, nomeVendedor);
    }
    
}
