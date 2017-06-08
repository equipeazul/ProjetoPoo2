package vendas.Regras;


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
    public static void validar(Pagamento p) throws ExcecaoRegras{
        if(p.getIdPagamento()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }    
    public static void verificarDuplicidade(Pagamento p) throws ExcecaoRegras{
        try{
            Pagamento x= dao.consultar(p.getPedido().getIdPedido());
            if(x!=null){
                throw new ExcecaoRegras("Pagamento já existe");
            }
            } catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            } catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
    }
    public static void incluir(Pagamento p)throws ExcecaoRegras{
        try{
            dao.incluir(p);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public static void excluir(Pagamento p)throws ExcecaoRegras{
        if(p.getIdPagamento()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Pagamento x = dao.consultar(p.getIdPagamento());
            if(x==null){
                throw new ExcecaoRegras("Pagamento não existe");
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
    public static void alterar(Pagamento p)throws ExcecaoRegras{
        if(p.getIdPagamento()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Pagamento x = dao.consultar(p.getIdPagamento());
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
    public static void listar(Pagamento p)throws ExcecaoRegras{
        if(p.getPedido().getIdPedido()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            dao.listar(p.getPedido().getIdPedido());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    }  
}
