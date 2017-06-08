
package vendas.Regras;

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
    public static void validar(Vendedor v) throws ExcecaoRegras{
        if(v.getNome()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
        if(v.getNome().trim().equals("")){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }
    public static void verificarDuplicidade(Vendedor v) throws ExcecaoRegras{
        try{
            Vendedor x= dao.consultar(v.getIdVendedor());
            if(x!=null){
                throw new ExcecaoRegras("Cliente já existe");
            }
            } catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            } catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
    } 
    public static void incluir(Vendedor v)throws ExcecaoRegras{
        try{
            dao.incluir(v);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    } 
    public static void excluir(Vendedor v)throws ExcecaoRegras{
        try{
            dao.excluir(v.getIdVendedor());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }       
    }
    public static void alterar(Vendedor v)throws ExcecaoRegras{
        try{
            dao.alterar(v);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        } 
    }
    public static void listar(Vendedor v)throws ExcecaoRegras{
        if(v.getNome()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            dao.listar(v.getNome());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    }   
    
}
