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
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Excecoes.ExcecaoConexao;


public class VendedorRepositorio implements IVendedorRepositorio{

    @Override
    public void incluir(Vendedor vendedor) throws ExcecaoRepositorio,ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO (nome, comissao) Vendedores VALUES (?, ?)";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(e);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio,ExcecaoConexao  {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="DELETE FROM Vendedores WHERE IdVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(e);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void alterar(Vendedor vendedor)  throws ExcecaoRepositorio,ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE Vendedores SET nome = ? , comissao = ?   VALUES (?, ?) WHERE IdVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.setInt(3, vendedor.getIdvendedor()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(e);
        }finally{
            sqlConn.desconectar(conn);
        }
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
