/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.entidades;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Pedido {
    
    private Integer idpedido;
    private String dtvenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private String situacao;
    private ArrayList<PedidoProduto> listaPedidoProduto;
    private ArrayList<Pagamento> listaPagamento;
    
    public Pedido(){
      Cliente cliente = new Cliente();
      Vendedor vendedor = new Vendedor();
      listaPedidoProduto = new ArrayList();
      listaPagamento = new ArrayList();
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public String getDtvenda() {
        return dtvenda;
    }

    public void setDtvenda(String dtvenda) {
        this.dtvenda = dtvenda;
    }

    public Vendedor getVendedores() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
