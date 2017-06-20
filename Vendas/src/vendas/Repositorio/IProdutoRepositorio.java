/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Entidades.Produto;

/**
 *
 * @author Felipe
 */
public interface IProdutoRepositorio {
    public void incluir(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList listar(String descricao, String razaoSocial)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Produto consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existe(Integer Id) throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existeNoPedido(Integer Id) throws ExcecaoRepositorio, ExcecaoConexao;
}
