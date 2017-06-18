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
import vendas.Conexao.*;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.Produto;
/**
 *
 * @author Felipe
 */
public class ProdutoRepositorio implements IProdutoRepositorio {
    
    @Override
    public void incluir(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao
    {       
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Produtos (descricao, unidade, precovenda, idfabricante) values (?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidade()); 
            pstm.setDouble(3, produto.getPrecoVenda());
            pstm.setInt(4, produto.getFabricante().getIdFabricante()); 
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_INCLUIR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }
    
    @Override
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao
    {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM Produtos WHERE idProduto = ? ";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_EXCLUIR_PRODUTO);
           }finally{
               sqlConn.desconectar(conn);
           }    
    }
    
    @Override
    public void alterar(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao
    {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE Produtos SET descricao = ? , unidade = ?, precovenda = ?, idfabricante = ?  WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidade()); 
            pstm.setDouble(3, produto.getPrecoVenda()); 
            pstm.setInt(4, produto.getFabricante().getIdFabricante()); 
            pstm.setInt(5, produto.getIdproduto()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
    }
    
    @Override
    public ArrayList<Produto> listar(String descricao)throws ExcecaoRepositorio,ExcecaoConexao
    {
        ArrayList<Produto> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idProduto, descricao, unidade, precovenda, idfabricante FROM produtos ";
        
        if (!descricao.equals("")) {
            sql = sql + " WHERE descricao LIKE '%" + descricao + "%'";
        }
        
        sql = sql + " ORDER BY descricao ";
             
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Produto>();
            while (rset.next()) {
                Produto produto;
                produto = new Produto();
                produto.setIdProduto(rset.getInt("idProduto"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setUnidade(rset.getString("unidade"));
                produto.setPrecoVenda(rset.getDouble("precovenda"));
                produto.getFabricante().setIdFabricante(rset.getInt("idfabricante"));
                
                lista.add(produto);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }
    
    @Override
    public Produto consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao
    {
        Produto produto = null;
        
        
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT Produtos.*, Fabricantes.RazaoSocial FROM Produtos LEFT JOIN Fabricantes ON Fabricantes.IdFabricante = Produtos.IdFabricante WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                produto = new Produto();
                produto.setIdProduto(rset.getInt("idProduto"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setUnidade(rset.getString("unidade"));
                produto.setPrecoVenda(rset.getDouble("precovenda"));
                produto.getFabricante().setIdFabricante(rset.getInt("idfabricante"));
                produto.getFabricante().setRazaoSocial(rset.getString("RazaoSocial"));
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return produto;
    }        
    
    @Override
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao {
        Integer id = 0;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT MAX(idproduto) as id FROM Produtos;";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
         
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                id = rset.getInt("id");
                return id;
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
       
    }
    
@Override
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idProduto FROM Produtos WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            return (rset.next());
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }
    
    @Override
    public Boolean existeNoPedido(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idProduto FROM PEDIDOPRODUTOS WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            return (rset.next());
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }           
    
}
    

