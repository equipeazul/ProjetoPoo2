/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Regras;

import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.FabricanteRepositorio;
import vendas.Repositorio.IFabricanteRepositorio;
import vendas.entidades.Fabricante;

/**
 *
 * @author heitor santos
 */
public class FabricanteRegra {
     private final static IFabricanteRepositorio dao = new FabricanteRepositorio();
    public static void validar(Fabricante f) throws ExcecaoRegras{
        if(f.getRazaoSocial()==null){
            throw new ExcecaoRegras("Descrição inválida");
        }
        if(f.getRazaoSocial().trim().equals("")){
            throw new ExcecaoRegras("Descrição inválida");
        }
    } 
    public static void verificarDuplicidade(Fabricante f) throws ExcecaoRegras{
        try{
            Fabricante x= dao.consultar(f.getRazaoSocial());
            if(x!=null){
                throw new ExcecaoRegras("Fabricante já existe");
            }
            } catch(ExcecaoConexao e){
                throw new ExcecaoRegras("Erro na conexão");
            } catch(ExcecaoRepositorio e){
                throw new ExcecaoRegras("Erro na DAO");
            }              
    }  
    public static void incluir(Fabricante f)throws ExcecaoRegras{
        try{
            dao.incluir(f);
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }              
    }
    public static void excluir(Fabricante f)throws ExcecaoRegras{
        if(f.getIdFabricante()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Fabricante x = dao.consultar(f.getIdFabricante());
            if(x==null){
                throw new ExcecaoRegras("Fabricante não existe");
            }
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }
        try{
            dao.excluir(f);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }       
    }
    public static void alterar(Fabricante f)throws ExcecaoRegras{
        if(f.getIdFabricante()==null){
            throw new ExcecaoRegras("ID inválido");
        }
        try{
            Fabricante x = dao.consultar(f.getIdFabricante());
            if(x==null){
                throw new ExcecaoRegras("Cliente não existe");
            }
        }catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        }catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }
        try{
            dao.alterar(f);
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        } 
    }
    public static void listar(Fabricante f)throws ExcecaoRegras{
        if(f.getRazaoSocial()==null){
            throw new ExcecaoRegras("Razao Social inválido");
        }
        try{
            dao.listar(f.getRazaoSocial());
        } catch(ExcecaoConexao e){
            throw new ExcecaoRegras("Erro na conexão");
        } catch(ExcecaoRepositorio e){
            throw new ExcecaoRegras("Erro na DAO");
        }             
    } 
}
