/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Regras;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       
    public static void verificarExistencia(Integer id) throws ExcecaoRegras{
        try 
        {
            if(!dao.existe(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDFABRICANTE_NAO_EXISTE);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
          throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    public static void validar(Fabricante fabricante) throws ExcecaoRegras{
        if(fabricante.getRazaoSocial().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_RAZAO_SOCIAL_FABRICANTE_INVALIDA);
        }
        
        if(fabricante.getTelefone().trim().equals("")){
            throw new ExcecaoRegras(ExcecaoRegras.ERRO_TELEFONE_FABRICANTE_INVALIDA);
        }
    } 
        
    public static void incluir(Fabricante fabricante)throws ExcecaoRegras{
        try
        {
            dao.incluir(fabricante);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }             
    }
    public static void excluir(Fabricante fabricante)throws ExcecaoRegras{
        try
        {
            dao.excluir(fabricante.getIdFabricante());
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }       
    }
    public static void alterar(Fabricante fabricante)throws ExcecaoRegras{
        try{
            dao.alterar(fabricante);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    public static ArrayList<Fabricante> listar(String razaoSocial)throws ExcecaoRegras{
        try{
            return dao.listar(razaoSocial);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }             
    }
    
    public static Fabricante consultar(Integer id)throws ExcecaoRegras{
        Fabricante fabricante = new Fabricante();
        try 
        {
             fabricante = dao.consultar(id);
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
             throw new ExcecaoRegras(ex.getMessage()); 
        }
        return fabricante;
    }
    
    public static Integer ultimo() throws ExcecaoRegras{
        try 
        {
            return dao.ultimo();
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
        
    public static void verificarExistenciaNoProduto(Integer id) throws ExcecaoRegras{
        try 
        {            
            if(dao.existeNoProduto(id)){
               throw new ExcecaoRegras(ExcecaoRegras.ERRO_IDFABRICANTE_EXISTE_PRODUTO);
            }   
        } catch (ExcecaoRepositorio | ExcecaoConexao ex) {
            throw new ExcecaoRegras(ex.getMessage()); 
        }
    }
    
    
   
        
    
}
