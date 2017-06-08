
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
    
    public  void verificarExistencia(Integer id) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        if(!dao.existe(id)){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_NAO_EXISTE);
        }
    }
    
    public  void jaCadastrado(Integer id) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        if(dao.existe(id)){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_JA_CADASTRADO);
        }
    }
    
    public  void validar(Cliente cliente) throws ExcecaoRegras{
        if(cliente.getNome().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_NOME_CLIENTE_INVALIDO);
        }
    }
    
    public  void verificarDuplicidadeCpf(String cpf) throws ExcecaoRepositorio, ExcecaoConexao, ExcecaoRegras{
        Cliente cliente = dao.consultarCpf(cpf);
        if(cliente != null){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_CPF_JA_CADASTRADO);
        }
    }  
    public  void incluir(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao{
        dao.incluir(cliente);
    }
    
    public  void excluir(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao{
        dao.excluir(cliente.getIdCliente());
    }
    
    public void alterar(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao{
        dao.alterar(cliente);
    }
    public ArrayList<Cliente> listar(String nome) throws ExcecaoRepositorio, ExcecaoConexao{
        return dao.listar(nome);
    } 
    
    public Cliente consultar(Integer id) throws ExcecaoRepositorio, ExcecaoConexao{
        return dao.consultar(id);
    }

    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao{
        return dao.ultimo();
    }    
    
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao{
        return dao.existe(id);
    }    
}
