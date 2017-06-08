
package vendas.Regras;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.ClienteRepositorio;
import vendas.Repositorio.IClienteRepositorio;
import vendas.entidades.Cliente;

/**
 *
 * @author heitor santos
 */
public class ClienteRegra {
    private final static IClienteRepositorio dao = new ClienteRepositorio();
    public  void validar(Cliente c) throws ExcecaoRegras{
        if(c.getNome()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
        if(c.getNome().trim().equals("")){
            throw new ExcecaoRegras("Descrição inválida");
        }
    }
    public  void verificarDuplicidade(Cliente c) throws ExcecaoRegras{
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
    public  void incluir(Cliente c)throws ExcecaoRegras{
        try{
            dao.incluir(c);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public  void excluir(Cliente c)throws ExcecaoRegras{
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
            dao.excluir(c);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }       
    }
    public void alterar(Cliente c)throws ExcecaoRegras{
        
        try{
            dao.alterar(c);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        } 
    }
    public ArrayList<Cliente> listar(String nome)throws ExcecaoRegras{
        
        try{
            return dao.listar(nome);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    } 
    public Cliente consultar(Integer id)throws ExcecaoRegras{
        try{
            return dao.consultar(id);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }         
    }

    public Integer ultimo()throws ExcecaoRegras{
        try{
            return dao.ultimo();
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }         
    }    
    
    public Boolean existe(Integer id)throws ExcecaoRegras{
        try{
            return dao.existe(id);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }         
    }    
        

    
    
}
