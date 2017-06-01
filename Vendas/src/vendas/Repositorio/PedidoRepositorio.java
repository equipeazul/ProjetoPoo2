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
           throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirPedido);
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
               throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirPedido);
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
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarPedido);
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
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPedido);
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
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPedido);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return pedido;    
    }
    
}
