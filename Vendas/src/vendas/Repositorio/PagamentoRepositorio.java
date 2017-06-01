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
import vendas.entidades.Pagamento;
import vendas.entidades.Pedido;

/**
 *
 * @author Felipe
 */
public class PagamentoRepositorio implements IPagamentoRepositorio{

    @Override
    public void incluir(Integer idPedido, Pagamento pagamento) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Pagamentos (IDPEDIDO, FORMAPAGAMENTO,DTVENCIMENTO, VALOR, DTPAGAMENTO, VALORPAGO, SITUACAO) values (?,?,?,?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPedido);
            pstm.setString(2, pagamento.getFormaPagamento()); 
            pstm.setDate(3, (Date) pagamento.getDtVencimento());
            pstm.setDouble(4, pagamento.getValor());
            pstm.setDate(5, (Date) pagamento.getDtPagamento()); 
            pstm.setDouble(6, pagamento.getValorpago());      
            pstm.setString(7, pagamento.getSituacao());    
            
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirPagamento);
        }finally{
            sqlConn.desconectar(conn);
        }   
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM Pagamentos WHERE idPagamento = ? ";
           try{
               PreparedStatement pstm = conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirPagamento);
           }finally{
               sqlConn.desconectar(conn);
           }        }

    @Override
    public void alterar(Pagamento pagamento) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE pagamento SET formadepagamento = ?, dtvencimento = ?, valor = ?, dtpagamento = ?, valorpago = ?, situacao = ?  WHERE idPagamento = ? ";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
                       
            pstm.setString(1, pagamento.getFormaPagamento());
            pstm.setDate(2, (Date) pagamento.getDtVencimento()); 
            pstm.setDouble(3, pagamento.getValor());
            pstm.setDate(4, (Date) pagamento.getDtPagamento());
            pstm.setDouble(5, pagamento.getValorpago()); 
            pstm.setString(6, pagamento.getSituacao()); 
            pstm.setInt(7, pagamento.getIdPagamento()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarPagamento);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    
    // Irá listar pela coluna (formapagamento) do database.
    
    @Override
    public ArrayList<Pagamento> listar(Integer idPedido) throws ExcecaoRepositorio, ExcecaoConexao {
        ArrayList<Pagamento> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Pagamentos WHERE idPedido = ? ";
                
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPedido);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Pagamento>();
            
            while (rset.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rset.getInt("idPagamento"));
                pagamento.setFormaPagamento(rset.getString("formapagamento"));
                pagamento.setDtvencimento(rset.getDate("dtvencimento"));
                pagamento.setValor(rset.getDouble("valor"));
                pagamento.setDtPagamento(rset.getDate("dtpagamento"));
                pagamento.setValorpago(rset.getDouble("valorpago"));
                pagamento.setSituação(rset.getString("situacao"));
                
                lista.add(pagamento);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPagamento);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;   }

    @Override
    public Pagamento consultar(Integer idPagamento) throws ExcecaoRepositorio, ExcecaoConexao {
        Pagamento pagamento = new Pagamento();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Pagamentos WHERE idPagamento = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, idPagamento);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                pagamento.setIdPagamento(rset.getInt("idPagamento"));
                pagamento.setFormaPagamento(rset.getString("formapagamento"));
                pagamento.setDtvencimento(rset.getDate("dtvencimento"));
                pagamento.setValor(rset.getDouble("valor"));
                pagamento.setDtPagamento(rset.getDate("dtpagamento"));
                pagamento.setValorpago(rset.getDouble("valorpago"));
                pagamento.setSituação(rset.getString("situacao"));
 
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarPagamento);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return pagamento; 
    }
    
}
