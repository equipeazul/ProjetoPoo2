
package vendas.Regras;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.ClienteRepositorio;
import vendas.Repositorio.IClienteRepositorio;
import vendas.entidades.Cliente;

/**
 *
 * @author heitor santos
 */
public class ClienteRegra {
    
    private final static IClienteRepositorio dao = new ClienteRepositorio();
    
    public  void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public  void validar(Cliente cliente) throws ExcecaoRegras{
        if(cliente.getNome().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_NOME_CLIENTE_INVALIDO);
        }
    }
    
    public  void verificarDuplicidadeCpf(String cpf) throws ExcecaoRegras{
        try {
            Cliente cliente = dao.consultarCpf(cpf);
            if(cliente != null){
                throw new ExcecaoRegras(ExcecaoRegras.ERRO_CPF_JA_CADASTRADO);
            }
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }  
    public  void incluir(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.incluir(cliente);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public  void excluir(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.excluir(cliente.getIdCliente());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public void alterar(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.alterar(cliente);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    public ArrayList<Cliente> listar(String nome) throws ExcecaoRegras{
        try {
            return dao.listar(nome);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    } 
    
    public Cliente consultar(Integer id) throws ExcecaoRegras{
        try {
            return dao.consultar(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }

    public Integer ultimo() throws ExcecaoRegras{
        try {
            return dao.ultimo();
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
    
    public Boolean existe(Integer id) throws ExcecaoRegras{
        try {
            return dao.existe(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
}
