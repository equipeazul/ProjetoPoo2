/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import java.sql.Connection;
import vendas.Conexao.Conexao;
import vendas.Conexao.IConexao;
import vendas.Excecoes.DAOException;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Repositorio.IVendedorRepositorio;
import vendas.Repositorio.VendedorRepositorioImpl;
import vendas.entidades.Vendedor;

/**
 *
 * @author Daniel
 */
public class Vendas {

    /**
     * @param args the command line arguments
     * @author EquipeAzul
     */
    public static void main(String[] args) {
        
        try {
            
            Vendedor vendedor = new Vendedor();
            
            vendedor.setNome("Edson");
            vendedor.setComissao(5);
            
            IVendedorRepositorio vendedorRepositorio = new VendedorRepositorioImpl();
            
            vendedorRepositorio.incluir(vendedor);
            
        } catch (ExcecaoConexao ex) {
            System.out.println(ExcecaoConexao.erroAoConectar);
        } catch (DAOException ex) {
            System.out.println(DAOException.erroAoIncluirVendedor);
        }
        
    }
    
}
