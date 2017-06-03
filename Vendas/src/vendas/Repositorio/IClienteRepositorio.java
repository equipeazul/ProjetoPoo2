/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.Cliente;

/**
 *
 * @author Felipe
 */
public interface IClienteRepositorio {
    public void incluir(Cliente cliente)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Cliente cliente)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<Cliente> listar(String nome)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Cliente consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;  
    public Cliente consultarCpf(String cpf) throws ExcecaoRepositorio, ExcecaoConexao;
    public Integer Ultimo() throws ExcecaoRepositorio, ExcecaoConexao;
    public Boolean existe(Integer idCliente) throws ExcecaoRepositorio, ExcecaoConexao;
}
