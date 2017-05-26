/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.Conexao.Conexao;
import vendas.entidades.Vendedor;
import vendas.Conexao.IConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Excecoes.ExcecaoConexao;


public class VendedorRepositorio implements IVendedorRepositorio{

    @Override
    public Integer incluir(Vendedor vendedor) throws ExcecaoRepositorio,ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO (nome, comissao) vendedores VALUES (?, ?)";
        Integer id = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirVendedor);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio,ExcecaoConexao  {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="DELETE FROM vendedores WHERE IdVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirVendedor);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void alterar(Vendedor vendedor) throws ExcecaoRepositorio,ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE vendedores SET nome = ? , comissao = ? VALUES (?, ?) WHERE idVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.setInt(3, vendedor.getIdVendedor()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarVendedor);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public ArrayList listar(String nome) throws ExcecaoRepositorio,ExcecaoConexao {

        ArrayList lista = null;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idVendedor, nome, comissao FROM vendedores ";
        
        if (!nome.equals("")) {
            sql = sql + " WHERE nome LIKE '%" + nome + "%'";
        }
             
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList();
            while (rset.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor = new Vendedor();
                vendedor.setIdVendedor(rset.getInt("idVendedor"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setComissao(rset.getDouble("comissao"));
                lista.add(vendedor);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarVendedor);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }

    @Override
    public Vendedor consultar(Integer id) throws ExcecaoRepositorio,ExcecaoConexao {
        
        Vendedor vendedor = null;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idVendedor, nome, comissao FROM Vendedores WHERE idVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                vendedor = new Vendedor();
                vendedor.setIdVendedor(rset.getInt("idVendedor"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setComissao(rset.getDouble("comissao"));
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarVendedor);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return vendedor;
    }
    
    
}
