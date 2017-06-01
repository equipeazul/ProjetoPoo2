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
import vendas.Conexao.IConexao;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.Pedido;
import vendas.entidades.PedidoProduto;
import vendas.entidades.Produto;

/**
 *
 * @author Felipe
 */
public class PedidoProdutoRepositorio implements IPedidoProdutoRepositorio {

    @Override
    public void incluir(PedidoProduto pedidoproduto) throws ExcecaoRepositorio, ExcecaoConexao {
                IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO PedidoProduto (idpedido, idproduto, valor, quantidade) values (?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pedidoproduto.getProduto().getIdproduto());
            pstm.setInt(2, pedidoproduto.getIdPedido()); 
            pstm.setDouble(3, pedidoproduto.getValor());
            pstm.setInt(4, pedidoproduto.getQuantidade()); 
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirPedidoProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void excluir(Integer idPedido, Integer idProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM PedidoProduto WHERE idProduto = ? and idPedido = ? ";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, idProduto);
               pstm.setInt(2, idPedido);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirPedidoProduto);
           }finally{
               sqlConn.desconectar(conn);
           }   
    }

    @Override
    public void alterar(PedidoProduto pedidoProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE pedidoproduto SET valor = ? , quantidade = ?  WHERE idProduto = ? and idPedido = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, pedidoProduto.getValor());
            pstm.setInt(2, pedidoProduto.getQuantidade()); 
            pstm.setInt(3, pedidoProduto.getProduto().getIdproduto()); 
            pstm.setInt(4, pedidoProduto.getIdPedido()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarPedidoProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public ArrayList<PedidoProduto> listar(Integer idPedido) throws ExcecaoRepositorio, ExcecaoConexao {
        ArrayList<PedidoProduto> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT pedidoprodutos.idProduto, pedidoprodutos.idPedido, pedidoprodutos.valor, pedidoprodutos.quantidade, " +
                    "       produtos.descricao, produtos.unidade, produtos.precovenda FROM pedidoprodutos INNER JOIN produtos on pedidoprodutos.idproduto = produtos.idproduto ";
        
        if (!idPedido.equals(0)) {
            sql = sql + " WHERE idPedido = " + idPedido;
        }
             
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<PedidoProduto>();
            while (rset.next()) {
                PedidoProduto pedidoProduto  = new PedidoProduto();
                
                pedidoProduto.getProduto().setIdProduto(rset.getInt("idProduto"));
                pedidoProduto.getProduto().setDescricao(rset.getString("descricao"));
                pedidoProduto.getProduto().setUnidade(rset.getString("descricao"));
                pedidoProduto.getProduto().setDescricao(rset.getString("unidade"));
                pedidoProduto.getProduto().setPrecoVenda(rset.getDouble("precovenda"));
                pedidoProduto.setIdPedido(rset.getInt("idPedido"));
                pedidoProduto.setValor(rset.getDouble("valor"));
                pedidoProduto.setQuantidade(rset.getInt("quantidade"));
                
                lista.add(pedidoProduto);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPedidoProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }

    @Override
    public PedidoProduto consultar(Integer idPedido, Integer idProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        
        PedidoProduto pedidoProduto = new PedidoProduto();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM PedidoProdutos WHERE idPedido = ? and idProduto = ?;";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, idPedido);
            pstm.setInt(2, idProduto);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                pedidoProduto.getProduto().setIdProduto(rset.getInt("idProduto"));
                pedidoProduto.getProduto().setDescricao(rset.getString("descricao"));
                pedidoProduto.getProduto().setUnidade(rset.getString("descricao"));
                pedidoProduto.getProduto().setDescricao(rset.getString("unidade"));
                pedidoProduto.getProduto().setPrecoVenda(rset.getDouble("precovenda"));
                pedidoProduto.setIdPedido(rset.getInt("idPedido"));
                pedidoProduto.setValor(rset.getDouble("valor"));
                pedidoProduto.setQuantidade(rset.getInt("quantidade"));
                
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPedidoProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return pedidoProduto;
    }     

}
    
    

