
package vendas.Regras;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IPedidoRepositorio;
import vendas.Repositorio.PedidoRepositorio;
import vendas.entidades.Pedido;

/**
 *
 * @author heitor santos
 */
public class PedidoRegra {
    
    private final static IPedidoRepositorio dao = new PedidoRepositorio();
    
    public static void validar(Pedido pedido) throws ExcecaoRegras{
        
        
    }    
    
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_ID_PEDIDO_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
               
    public static Pedido consultar(Integer id) throws ExcecaoRegras{
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
        
    public static void incluir(Pedido pedido)throws ExcecaoRegras{
        try{
            dao.incluir(pedido);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }              
    }
    public static void excluir(Pedido pedido) throws ExcecaoRegras{
        try {
            dao.excluir(pedido.getIdPedido());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void alterar(Pedido pedido)throws ExcecaoRegras{
        try{
            dao.alterar(pedido);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        } 
    }
    
    public static ArrayList<Pedido> listar(String nomeCliente, String nomoVendedor)throws ExcecaoRegras{
        
        try{
            return dao.listar(nomeCliente, nomoVendedor);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }             
    }    

    
}
