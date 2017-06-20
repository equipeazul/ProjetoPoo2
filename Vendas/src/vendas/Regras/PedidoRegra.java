
package vendas.Regras;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IPedidoRepositorio;
import vendas.Repositorio.PedidoRepositorio;
import vendas.Entidades.Pedido;
import vendas.Entidades.PedidoProduto;

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
               
    public static Pedido consultar(Integer id, Boolean comProdutos) throws ExcecaoRegras{
        try {
            return dao.consultar(id, comProdutos);
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
    
    public static ArrayList<Pedido> listar(String nomeCliente, String nomeVendedor)throws ExcecaoRegras{
        
        try{
            return dao.listar(nomeCliente, nomeVendedor);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }             
    }    

    public static void validarProduto(PedidoProduto pedidoProduto) throws ExcecaoRegras{
        
        
    }    
    
    public static void verificarExistenciaProduto(Integer idPedido, Integer idProduto) throws ExcecaoRegras{
        try {
            if(!dao.existeProduto(idPedido, idProduto)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_PRODURO_NAO_EXISTE_NO_PEDIDO);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
               
    public static void jaCadastradoProduto(Integer idPedido, Integer idProduto) throws ExcecaoRegras{
        try {
            if(dao.existeProduto(idPedido, idProduto)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_PRODUTO_JA_CADASTRADO_NO_PEDIDO);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
               
    public static void incluirProduto(Integer idPedido, PedidoProduto pedidoProduto)throws ExcecaoRegras{
        try{
            dao.incluirProduto(idPedido, pedidoProduto);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }              
    }
    public static void excluirProduto(Integer idPedido, PedidoProduto pedidoProduto) throws ExcecaoRegras{
        try {
            dao.excluirProduto(idPedido, pedidoProduto.getProduto().getIdProduto());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void alterarProduto(Integer idPedido, PedidoProduto pedidoProduto)throws ExcecaoRegras{
        try{
            dao.alterarProduto(idPedido, pedidoProduto);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        } 
    }
    
    
}
