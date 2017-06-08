package vendas.fachada;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Regras.ClienteRegra;
import vendas.Regras.VendedorRegra;
import vendas.entidades.Cliente;
import vendas.entidades.Vendedor;

/**
 *
 * @author aluno
 */
public class Fachada {
    private static Fachada instancia;
    private final ClienteRegra clienteRegra;
    private final VendedorRegra vendedorRegra;
    
    private Fachada(){
        clienteRegra = new ClienteRegra();
        vendedorRegra = new VendedorRegra();
    }
    
    public static Fachada getInstancia(){
        if(instancia == null)
            instancia = new Fachada();
        return instancia;
    }
    
    /*#########################################################################
     * Cliente
     *########################################################################*/
    
    public void incluirCliente(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        clienteRegra.jaCadastrado(cliente.getIdCliente());
        clienteRegra.verificarDuplicidadeCpf(cliente.getCpf());
        clienteRegra.validar(cliente);
        clienteRegra.incluir(cliente);
    }
    
    public void excluirCliente(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        clienteRegra.verificarExistencia(cliente.getIdCliente());
        clienteRegra.excluir(cliente);
    }
    
    public void alterarCliente(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        clienteRegra.verificarExistencia(cliente.getIdCliente());
        clienteRegra.validar(cliente);
        clienteRegra.alterar(cliente);
    }
       
    public Cliente consultarCliente(Integer id) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        clienteRegra.verificarExistencia(id);
        return clienteRegra.consultar(id);
    }
    
    public Integer ultimoCliente() throws ExcecaoRepositorio, ExcecaoConexao{
        return clienteRegra.ultimo();
    }
    
    public ArrayList<Cliente> listarClientes(String nome) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        return clienteRegra.listar(nome);
    }
   
    /*#########################################################################
     * Vendedor
     *########################################################################*/
    
    public void incluirVendedor(Vendedor c)throws ExcecaoRegras{
        vendedorRegra.verificarDuplicidade(c);
        vendedorRegra.incluir(c);
    }
    
    public void excluirVendedor(Vendedor vendedor)throws ExcecaoRegras{
        vendedorRegra.excluir(vendedor);
    }
    
    public void alterarVendedor(Vendedor vendedor)throws ExcecaoRegras{
        vendedorRegra.alterar(vendedor);
    }
       
    public Vendedor consultarVendedor(Integer id)throws ExcecaoRegras{
        return null; // vendedorRegra.consultar(id);
    }
    
    public Integer ultimoVendedor()throws ExcecaoRegras{
        return 0; //vendedorRegra.ultimo();
    }
    
    public Boolean existeVendedor(Integer id)throws ExcecaoRegras{
       return false; //vendedorRegra.existe(id);         
    }
    
    public ArrayList<Vendedor> listarVendedores(String nome)throws ExcecaoRegras{
        return null; //vendedorRegra.listar(nome);
    }
   

}
