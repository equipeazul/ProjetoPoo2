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
public interface IPedidoRepositorio {
    
    public void incluir(Pedido pedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Pedido pedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList listar(String nomeCliente, String nomeVendedor)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Pedido consultar(Integer id, Boolean comProdutos)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existe(Integer Id) throws ExcecaoRepositorio, ExcecaoConexao;
    
    public void incluirProduto(Integer idPedido, PedidoProduto pedidoProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluirProduto(Integer idPedido, Integer idProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterarProduto(Integer idPedido, PedidoProduto pedidoProduto)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<PedidoProduto> listarProduto(Integer IdPedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Boolean existeProduto(Integer idPedido, Integer idProduto) throws ExcecaoRepositorio, ExcecaoConexao;
}
