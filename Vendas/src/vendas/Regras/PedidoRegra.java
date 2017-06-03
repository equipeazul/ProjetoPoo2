
package vendas.Regras;

import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.IPedidoRepositorio;
import vendas.Repositorio.PedidoRepositorio;
import vendas.entidades.Cliente;
import vendas.entidades.Pedido;


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
                throw new ExcecaoRegras("Cliente já existe");
            }
            }catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            }catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
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
    public static void excluir(Pedido p)throws ExcecaoRegras{
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
            dao.excluir(p);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }       
    }

    
}
