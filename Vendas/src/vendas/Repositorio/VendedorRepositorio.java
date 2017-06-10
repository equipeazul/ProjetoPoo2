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
import javax.swing.JOptionPane;
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
        String sql ="INSERT INTO vendedores  (nome, comisao) VALUES (?,?)";
        Integer id = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao());            
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_INCLUIR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio,ExcecaoConexao  {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="DELETE FROM vendedores WHERE idVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_EXCLUIR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void alterar(Vendedor vendedor) throws ExcecaoRepositorio,ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE vendedores SET nome = ? , comisao = ? WHERE idVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setDouble(2, vendedor.getComissao()); 
            pstm.setInt(3, vendedor.getIdVendedor()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public ArrayList<Vendedor> listar(String nome) throws ExcecaoRepositorio,ExcecaoConexao {

        ArrayList<Vendedor> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idVendedor, nome, comisao FROM vendedores ";
        
        if (!nome.equals("")) {
            sql = sql + " WHERE nome LIKE '%" + nome + "%'";
        }
             
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Vendedor>();
            while (rset.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdVendedor(rset.getInt("idVendedor"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setComissao(rset.getDouble("comisao"));
                lista.add(vendedor);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_VENDEDOR);
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
        String sql ="SELECT * FROM Vendedores WHERE idVendedor = ? ;";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                vendedor = new Vendedor();
                vendedor.setIdVendedor(rset.getInt("idVendedor"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setComissao(rset.getDouble("comisao"));
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return vendedor;
    }
    
    @Override
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao {
        Integer id = 0;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT MAX(idvendedor) as id FROM Vendedores;";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
         
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                id = rset.getInt("id");
                return id;
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
        
    }
    
    @Override
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idVendedor FROM Vendedores WHERE idVendedor = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            return (rset.next());
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_VENDEDOR);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }   
       
    
}
