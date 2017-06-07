/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.Conexao.Conexao;
import vendas.Conexao.IConexao;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.*;

/**
 *
 * @author Felipe
 */
public class PedidoRepositorio implements IPedidoRepositorio
{

    @Override
    public void incluir(Pedido pedido) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Pedidos (DTVENDA, IDVENDEDOR,IDCLIENTE, SITUACAO) values (?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1, (Date) pedido.getDtVenda());
            pstm.setInt(2, pedido.getVendedor().getIdVendedor()); 
            pstm.setInt(3, pedido.getCliente().getIdCliente());
            pstm.setString(4, pedido.getSituacao()); 
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_INCLUIR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM pedidos WHERE idPedido = ? ";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_EXCLUIR_PEDIDO);
           }finally{
               sqlConn.desconectar(conn);
           }    
    }

    @Override
    public void alterar(Pedido pedido) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE produto SET idVendedor = ? , SITUACAO = ?  WHERE idPedido = ? ";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
                       
            pstm.setInt(1, pedido.getVendedor().getIdVendedor());
            pstm.setString(2, pedido.getSituacao()); 
            pstm.setInt(3, pedido.getIdPedido()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
   }

    @Override
    public ArrayList listar(String nome) throws ExcecaoRepositorio, ExcecaoConexao {
        ArrayList<Pedido> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT Pedidos.*, Clientes.Nome as nomeCliente, Vendedores.Nome as nomeVendedor FROM Pedidos " +
                " LEFT JOIN Clientes ON Pedidos.idcliente = Clientes.idcliente " +
                " LEFT JOIN Vendedores ON Pedidos.idvendedor = Vendedores.idvendedor ";
        
        if (!nome.equals("")) {
            sql = sql + " WHERE Clientes.Nome LIKE '%" + nome + "%'";
        }
             
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Pedido>();
            
            while (rset.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setDtVenda(rset.getDate("Dtvenda"));
                pedido.getVendedor().setIdVendedor(rset.getInt("idvendedor"));
                pedido.getVendedor().setNome(rset.getString("nomevendedor"));
                pedido.getCliente().setIdCliente(rset.getInt("idcliente"));
                pedido.getCliente().setNome(rset.getString("nomeCliente"));
                pedido.setSituacao(rset.getString("situacao"));
                lista.add(pedido);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }

    @Override
    public Pedido consultar(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        Pedido pedido = new Pedido();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Pedidos WHERE idPedidos = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setDtVenda(rset.getDate("Dtvenda"));
                pedido.getVendedor().setIdVendedor(rset.getInt("idvendedor"));
                pedido.getCliente().setIdCliente(rset.getInt("idcliente"));
                pedido.setSituacao(rset.getString("situacao"));
 
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return pedido;    
    }
    
    @Override
    public void incluirProduto(Integer idPedido, PedidoProduto pedidoproduto) throws ExcecaoRepositorio, ExcecaoConexao {
                IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO PedidoProduto (idpedido, idproduto, valor, quantidade) values (?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pedidoproduto.getProduto().getIdproduto());
            pstm.setInt(2, idPedido); 
            pstm.setDouble(3, pedidoproduto.getValor());
            pstm.setInt(4, pedidoproduto.getQuantidade()); 
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_INCLUIR_PEDIDOPRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public void excluirProduto(Integer idPedido, Integer idProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM PedidoProduto WHERE idProduto = ? and idPedido = ? ";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, idProduto);
               pstm.setInt(2, idPedido);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_EXCLUIR_PEDIDOPRODUTO);
           }finally{
               sqlConn.desconectar(conn);
           }   
    }

    @Override
    public void alterarProduto(Integer idPedido, PedidoProduto pedidoProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE pedidoproduto SET valor = ? , quantidade = ?  WHERE idProduto = ? and idPedido = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, pedidoProduto.getValor());
            pstm.setInt(2, pedidoProduto.getQuantidade()); 
            pstm.setInt(3, pedidoProduto.getProduto().getIdproduto()); 
            pstm.setInt(4, idPedido); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_PEDIDOPRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    @Override
    public ArrayList<PedidoProduto> listarProduto(Integer idPedido) throws ExcecaoRepositorio, ExcecaoConexao {
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
                pedidoProduto.setValor(rset.getDouble("valor"));
                pedidoProduto.setQuantidade(rset.getInt("quantidade"));
                
                lista.add(pedidoProduto);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDOPRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }

    @Override
    public PedidoProduto consultarProduto(Integer idPedido, Integer idProduto) throws ExcecaoRepositorio, ExcecaoConexao {
        
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
                pedidoProduto.setValor(rset.getDouble("valor"));
                pedidoProduto.setQuantidade(rset.getInt("quantidade"));
                
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDOPRODUTO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return pedidoProduto;
    }     
    
    @Override
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao {
        Integer id = 0;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT MAX(idpedido) as id FROM Pedidos;";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
         
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                id = rset.getInt("id");
                return id;
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
        
    }
    
    @Override
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idPedido FROM Pedidos WHERE idPedido = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            return (rset.next());
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_PEDIDO);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }   
}
