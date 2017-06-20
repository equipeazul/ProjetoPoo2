/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Entidades.*;

/**
 *
 * @author Felipe
 */
public interface IFabricanteRepositorio {
    public void incluir(Fabricante fabricante)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Fabricante fabricante)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<Fabricante> listar(String nome)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Fabricante consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ; 
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existe(Integer Id) throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existeNoProduto(Integer id) throws ExcecaoRepositorio, ExcecaoConexao;
}
