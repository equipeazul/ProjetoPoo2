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
import vendas.entidades.Fabricante;

/**
 *
 * @author Felipe
 */
public class FabricanteRepositorio implements IFabricanteRepositorio {

    @Override
    public void incluir(Fabricante fabricante) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Fabricantes (razaosocial, telefone) values (?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, fabricante.getRazaoSocial());
            pstm.setString(2, fabricante.getTelefone()); 
            
            pstm.executeUpdate();
            
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_INCLUIR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }   
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
         IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM Fabricantes WHERE idFabricante = ?";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
               
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_EXCLUIR_FABRICANTE);
           }finally{
               sqlConn.desconectar(conn);
           }   
    }

    @Override
    public void alterar(Fabricante fabricante) throws ExcecaoRepositorio, ExcecaoConexao {
          IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE fabricantes SET razaosocial = ?, telefone = ?  WHERE idFabricante = ? ";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
                       
            pstm.setString(1, fabricante.getRazaoSocial());
            pstm.setString(2, fabricante.getTelefone()); 
            pstm.setInt(3, fabricante.getIdFabricante());
            
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_ALTERAR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    //Irá listar pela columa (razaosocial) do database
    
    @Override
    public ArrayList<Fabricante> listar(String nome) throws ExcecaoRepositorio, ExcecaoConexao {
           ArrayList<Fabricante> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Fabricantes ";
        
        if (!nome.equals("")) {
            sql = sql + " WHERE razaosocial LIKE '%" + nome + "%'";
        }
             
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Fabricante>();
            
            while (rset.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setIdFabricante(rset.getInt("idfabricante"));
                fabricante.setRazaoSocial(rset.getString("razaosocial"));
                fabricante.setTelefone(rset.getString("telefone"));
                
                lista.add(fabricante);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }
        return lista;
    }

    @Override
    public Fabricante consultar(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        Fabricante fabricante = new Fabricante();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Fabricantes WHERE idFabricante = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                fabricante.setIdFabricante(rset.getInt("idfabricante"));
                fabricante.setRazaoSocial(rset.getString("razaosocial"));
                fabricante.setTelefone(rset.getString("telefone"));

 
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return fabricante;    
    }

    @Override
    public Integer ultimo() throws ExcecaoRepositorio, ExcecaoConexao {
        Integer id = 0;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT MAX(idfabricante) as id FROM Fabricantes;";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
         
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                id = rset.getInt("id");
                return id;
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }
        return id;
        
    }
    
    @Override
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idFabricante FROM Fabricantes WHERE idFabricante = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            return (rset.next());
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.ERRO_AO_CONSULTAR_FABRICANTE);
        }finally{
            sqlConn.desconectar(conn);
        }
        
    }   
}
