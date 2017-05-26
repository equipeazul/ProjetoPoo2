/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

/**
 *
 * @author aluno
 */
import java.util.ArrayList;
import vendas.Excecoes.DAOException;
import vendas.Excecoes.ExcecaoConexao;
import vendas.entidades.Vendedor;

public interface IVendedorRepositorio {
    
    public void incluir(Vendedor vendedor)throws DAOException,ExcecaoConexao ;
    public void excluir(Vendedor vendedor)throws DAOException,ExcecaoConexao ;
    public void alterar(Vendedor vendedor)throws DAOException,ExcecaoConexao ;
    public ArrayList<Vendedor> listar(String nome)throws DAOException,ExcecaoConexao ;
    public Vendedor consultar(Integer id)throws DAOException,ExcecaoConexao ;
}
