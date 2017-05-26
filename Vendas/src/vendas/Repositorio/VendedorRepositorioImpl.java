/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.Conexao.Conexao;
import vendas.entidades.Vendedor;
import vendas.Conexao.IConexao;
import vendas.Excecoes.DAOException;
import vendas.Excecoes.ExcecaoConexao;


public class VendedorRepositorioImpl implements IVendedorRepositorio{

    @Override
    public void incluir(Vendedor vendedor) throws DAOException,ExcecaoConexao {
        
        IConexao g = Conexao.getInstancia();
        Connection c = g.conectar();
        String sql ="INSERT INTO Vendedores values(?,?)";
        try{
            PreparedStatement pstm= c.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Vendedor vendedor) {
    }

    @Override
    public void alterar(Vendedor vendedor) {
    }

    @Override
    public ArrayList<Vendedor> listar(String nome) {
    return null;
    }

    @Override
    public Vendedor consultar(Integer id) {
        return null;
    }
    
    
}
