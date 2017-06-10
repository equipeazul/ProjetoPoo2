package vendas.Regras;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IProdutoRepositorio;
import vendas.Repositorio.ProdutoRepositorio;
import vendas.entidades.Produto;

/**
 *
 * @author heitor santos
 */
public class ProdutoRegra {
    
    private final static IProdutoRepositorio dao = new ProdutoRepositorio();
    
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDPRODUTO_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void verificarExistenciaNoPedido(Integer id) throws ExcecaoRegras{
        try {
            
            if(dao.existeNoPedido(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDPRODUTO_EXISTE_PEDIDO);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
    
    public static void validar(Produto produto) throws ExcecaoRegras{
        if(produto.getDescricao().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_DESCRICAO_PRODUTO_INVALIDO);
        }
    }
    
    public static void incluir(Produto produto) throws ExcecaoRegras{
        try {
            dao.incluir(produto);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void excluir(Produto produto) throws ExcecaoRegras{
        try {
            dao.excluir(produto.getIdproduto());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void alterar(Produto produto) throws ExcecaoRegras{
        try {
            dao.alterar(produto);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    public static ArrayList<Produto> listar(String descricao) throws ExcecaoRegras{
        try {
            return dao.listar(descricao);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    } 
    
    public static Produto consultar(Integer id) throws ExcecaoRegras{
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
    
    public Boolean existe(Integer id) throws ExcecaoRegras{
        try {
            return dao.existe(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    } 
}
