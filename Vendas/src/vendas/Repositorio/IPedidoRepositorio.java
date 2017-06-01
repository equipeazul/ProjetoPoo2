/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.*;

/**
 *
 * @author Felipe
 */
public interface IPedidoRepositorio {
    
    public void incluir(Pedido pedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Pedido pedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList listar(String nome)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Pedido consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    
}
