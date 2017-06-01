/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.PedidoProduto;

/**
 *
 * @author Felipe
 */
public interface IPedidoProdutoRepositorio {
    public void incluir(PedidoProduto pedidoProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer idPedido, Integer idProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(PedidoProduto pedidoProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<PedidoProduto> listar(Integer IdPedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public PedidoProduto consultar(Integer idPedido, Integer idProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
}
