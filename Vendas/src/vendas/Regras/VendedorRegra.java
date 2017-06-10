
package vendas.Regras;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IVendedorRepositorio;
import vendas.Repositorio.VendedorRepositorio;
import vendas.entidades.Vendedor;

/**
 *
 * @author heitor santos
 */
public class VendedorRegra {
    private final static IVendedorRepositorio dao = new  VendedorRepositorio();
    
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDVENDEDOR_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }    
    public static void validar(Vendedor v) throws ExcecaoRegras{
        if(v.getNome().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_NOME_VENDEDOR_INVALIDO);
        }
    }    
    public static void incluir(Vendedor vendedor)throws ExcecaoRegras{
        try{
            dao.incluir(vendedor);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }              
    } 
    public static void excluir(Vendedor vendedor)throws ExcecaoRegras{
        try{
            dao.excluir(vendedor.getIdVendedor());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }    
    }
    public static void alterar(Vendedor vendedor)throws ExcecaoRegras{
        try{
            dao.alterar(vendedor);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        } 
    }
    public static ArrayList<Vendedor> listar(String nome)throws ExcecaoRegras{
        try{
            return dao.listar(nome);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }         
    }   
    public static Vendedor consultar(Integer id) throws ExcecaoRegras{
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
