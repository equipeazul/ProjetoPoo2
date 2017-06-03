
package vendas.Regras;

import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.ClienteRepositorio;
import vendas.Repositorio.IClienteRepositorio;
import vendas.entidades.Cliente;


public class ClienteRegra {
    private final static IClienteRepositorio dao = new ClienteRepositorio();
    public static void validar(Cliente c) throws ExcecaoRegras{
        if(c.getNome()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
        if(c.getNome().trim().equals("")){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }
    public static void verificarDuplicidade(Cliente c) throws ExcecaoRegras{
        try{
            Cliente x= dao.consultarCpf(c.getCpf());
            if(x!=null){
                throw new ExcecaoRegras("Cliente já existe");
            }
            } catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            } catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
    }  
    public static void incluir(Cliente c)throws ExcecaoRegras{
        try{
            dao.incluir(c);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public static void excluir(Cliente c)throws ExcecaoRegras{
        if(c.getIdCliente()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Cliente x = dao.consultar(c.getIdCliente());
            if(x==null){
                throw new ExcecaoRegras("Cliente não existe");
            }
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }
        try{
            dao.excluir(c.getIdCliente());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }       
    }
    public static void alterar(Cliente c)throws ExcecaoRegras{
        if(c.getIdCliente()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Cliente x = dao.consultar(c.getIdCliente());
            if(x==null){
                throw new ExcecaoRegras("Cliente não existe");
            }
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }
        try{
            dao.alterar(c);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        } 
    }
        public static void listar(Cliente c)throws ExcecaoRegras{
        if(c.getNome()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            dao.listar(c.getNome());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
        }    
}
