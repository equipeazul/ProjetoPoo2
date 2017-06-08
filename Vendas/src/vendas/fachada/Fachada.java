package vendas.fachada;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoRegras;
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
        if(instancia==null)
            instancia = new Fachada();
        return instancia;
    }
    
    /*#########################################################################
     * Cliente
     *########################################################################*/
    
    public void incluirCliente(Cliente c)throws ExcecaoRegras{
        clienteRegra.verificarDuplicidade(c);
        clienteRegra.incluir(c);
    }
    
    public void excluirCliente(Cliente c)throws ExcecaoRegras{
        clienteRegra.excluir(c);
    }
    
    public void alterarCliente(Cliente c)throws ExcecaoRegras{
        clienteRegra.alterar(c);
    }
       
    public Cliente consultarCliente(Integer id)throws ExcecaoRegras{
        return clienteRegra.consultar(id);
    }
    
    public Integer ultimoCliente()throws ExcecaoRegras{
        return clienteRegra.ultimo();
    }
    
    public Boolean existeCliente(Integer id)throws ExcecaoRegras{
       return clienteRegra.existe(id);         
    }
    
    public ArrayList<Cliente> listarClientes(String nome)throws ExcecaoRegras{
        return clienteRegra.listar(nome);
    }
   
    /*#########################################################################
     * Vendedor
     *########################################################################*/
    
    public void incluirVendedor(Vendedor c)throws ExcecaoRegras{
        vendedorRegra.verificarDuplicidade(c);
        vendedorRegra.incluir(c);
    }
    
    public void excluirVendedor(Vendedor c)throws ExcecaoRegras{
        vendedorRegra.excluir(c);
    }
    
    public void alterarVendedor(Vendedor c)throws ExcecaoRegras{
        vendedorRegra.alterar(c);
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
