
package vendas.Regras;

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
    public static void validar(Pedido p) throws ExcecaoRegras{
        if(p.getIdPedido()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }
    public static void verificarDuplicidade(Pedido p) throws ExcecaoRegras{
        try{
            Pedido x= dao.consultar(p.getIdPedido());
            if(x!=null){
                throw new ExcecaoRegras("Pedido já existe");
            }
            }catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            }catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
    } 
    
   public  void verificarExistencia(Integer id) throws ExcecaoRegras{
        try {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_ID_PEDIDO_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
   }
        
        
   public Pedido consultar(Integer id) throws ExcecaoRegras{
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
        
        
        
        
    public static void incluir(Pedido p)throws ExcecaoRegras{
        try{
            dao.incluir(p);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public  void excluir(Pedido pedido) throws ExcecaoRegras{
        try {
            dao.excluir(pedido.getIdPedido());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void alterar(Pedido p)throws ExcecaoRegras{
        if(p.getIdPedido()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Pedido x = dao.consultar(p.getIdPedido());
            if(x==null){
                throw new ExcecaoRegras("Cliente não existe");
            }
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }
        try{
            dao.alterar(p);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        } 
    }
    public static void listar(Pedido p)throws ExcecaoRegras{
        if(p.getCliente().getNome()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            dao.listar(p.getCliente().getNome());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    }    

    
}
