
package vendas.Regras;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.ClienteRepositorio;
import vendas.Repositorio.IClienteRepositorio;
import vendas.entidades.Cliente;
import vendas.util.IEntityModel;

/**
 *
 * @author heitor santos
 */
public class ClienteRegra {
    
    private final static IClienteRepositorio dao = new ClienteRepositorio();
    
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void verificarExistenciaNoPedido(Integer id) throws ExcecaoRegras{
        try {
            
            if(dao.existeNoPedido(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_EXISTE_PEDIDO);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }      
    
    public static void validar(Cliente cliente) throws ExcecaoRegras{
        if(cliente.getNome().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_NOME_CLIENTE_INVALIDO);
        }
    }
    
    public static void verificarDuplicidadeCpf(String cpf) throws ExcecaoRegras{
        try {
            Cliente cliente = dao.consultarCpf(cpf);
            if(cliente != null){
                throw new ExcecaoRegras(ExcecaoRegras.ERRO_CPF_JA_CADASTRADO);
            }
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }  
    public static void incluir(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.incluir(cliente);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void excluir(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.excluir(cliente.getIdCliente());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void alterar(Cliente cliente) throws ExcecaoRegras{
        try {
            dao.alterar(cliente);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    
    public static ArrayList<IEntityModel> listarEntity(String nome) throws ExcecaoRegras{
        ArrayList<Cliente> lista = listar(nome);
        ArrayList<IEntityModel> listaEntity = new ArrayList<>();
        for (Cliente item : lista) {
            listaEntity.add((IEntityModel) (item));
        }
        return listaEntity;
    }
    
    public static ArrayList<Cliente> listar(String nome) throws ExcecaoRegras{
        try {
            return dao.listar(nome);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    } 
    
    public static Cliente consultar(Integer id) throws ExcecaoRegras{
        try {
            return dao.consultar(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }

    public static Integer ultimo() throws ExcecaoRegras{
        try {
            return dao.ultimo();
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
    
    public static Boolean existe(Integer id) throws ExcecaoRegras{
        try {
            return dao.existe(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
}
