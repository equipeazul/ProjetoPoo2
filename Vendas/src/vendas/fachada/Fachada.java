package vendas.fachada;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Regras.ClienteRegra;
import vendas.Regras.FabricanteRegra;
import vendas.Regras.VendedorRegra;
import vendas.entidades.Cliente;
import vendas.entidades.Fabricante;
import vendas.entidades.Vendedor;

/**
 *
 * @author aluno
 */
public class Fachada {
    private static Fachada instancia;
    private final ClienteRegra clienteRegra;
    private final VendedorRegra vendedorRegra;
    private final FabricanteRegra fabricanteRegra;
    
    private Fachada(){
        clienteRegra = new ClienteRegra();
        vendedorRegra = new VendedorRegra();
        fabricanteRegra = new FabricanteRegra();
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
    
    public void incluirVendedor(Vendedor c)throws ExcecaoRegras{
        vendedorRegra.validar(c);
        vendedorRegra.incluir(c);
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
   
    public void excluir(Fabricante f) throws ExcecaoRegras{
        fabricanteRegra.verificarExistencia(f.getIdFabricante());
        FabricanteRegra.excluir(f);        
    }
    
    public void incluir(Fabricante f) throws ExcecaoRegras{
        FabricanteRegra.verificarDuplicidade(f);
        FabricanteRegra.incluir(f);
    }
    
    public void alterar(Fabricante f)throws ExcecaoRegras{
        FabricanteRegra.alterar(f);
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
}
