package vendas.Regras;

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
    public static void validar(Produto p) throws ExcecaoRegras{
        if(p.getDescricao()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
        if(p.getDescricao().trim().equals("")){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }  
    public static void verificarDuplicidade(Produto p) throws ExcecaoRegras{
        /*
        try{
            Produto x= dao.consultar(p.getIdProduto());
            if(x!=null){
                throw new ExcecaoRegras("Cliente já existe");
            }
            } catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            } catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
*/
    }
    public static void incluir(Produto p)throws ExcecaoRegras{
        try{
            dao.incluir(p);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public static void excluir(Produto p)throws ExcecaoRegras{
        /*
        if(p.getIdProduto()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Produto x = dao.consultar(p.getIdProduto());
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
*/
    }
    public static void alterar(Produto p)throws ExcecaoRegras{
        /*
        if(p.getIdProduto()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Produto x = dao.consultar(p.getIdProduto());
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
*/
    } 
    public static void listar(Produto p)throws ExcecaoRegras{
        if(p.getDescricao()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            dao.listar(p.getDescricao());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    }    
}
