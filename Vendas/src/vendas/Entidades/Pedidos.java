/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.entidades;

/**
 *
 * @author aluno
 */
public class Pedidos {
    
    private int idpedido;
    private String dtvenda;
    private Vendedores vendedores;
    private Clientes clientes;
    private String situacao;
    
    public Pedidos(){
      Clientes c = new Clientes();
      Vendedores v = new Vendedores();
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getDtvenda() {
        return dtvenda;
    }

    public void setDtvenda(String dtvenda) {
        this.dtvenda = dtvenda;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
