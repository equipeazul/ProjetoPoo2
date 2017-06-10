package vendas.Regras;


import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IPagamentoRepositorio;
import vendas.Repositorio.PagamentoRepositorio;
import vendas.entidades.Pagamento;

/**
 *
 * @author heitor santos
 */
public class PagamentoRegra {
    
    private final static IPagamentoRepositorio dao = new PagamentoRepositorio();
        
    public static void validar(Pagamento pagamento) throws ExcecaoRegras{
        
        
    }    
    
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDCLIENTE_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
            
    public static void incluir(Pagamento pagamento)throws ExcecaoRegras{
        try{
            dao.incluir(pagamento);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }             
    }
    
    public static void excluir(Pagamento pagamento)throws ExcecaoRegras{
        try {
            dao.excluir(pagamento.getIdPagamento());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    } 
    public static void alterar(Pagamento pagamento)throws ExcecaoRegras{
        try{
            dao.alterar(pagamento);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        } 
    }
    
    public static ArrayList<Pagamento> listar(Integer idPedido) throws ExcecaoRegras{
        try {
            return dao.listar(idPedido);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }   
}
