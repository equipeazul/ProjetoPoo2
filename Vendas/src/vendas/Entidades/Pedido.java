/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pedido{
    
    private Integer idPedido;
    private Date dtVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private String situacao;
    private ArrayList<PedidoProduto> listaPedidoProduto;
    private ArrayList<Pagamento> listaPagamento;
    
    public Pedido() {
        this.cliente = new Cliente();
        this.vendedor = new Vendedor();
        this.listaPedidoProduto = new ArrayList<PedidoProduto>();
    }
    
    public Integer getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDtVenda() {
        return this.dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public ArrayList<PedidoProduto> getListaPedidoProduto() {
        return this.listaPedidoProduto;
    }

    public void setListaPedidoProduto(ArrayList listaPedidoProduto) {
        this.listaPedidoProduto = listaPedidoProduto;
    }
    
    public ArrayList<Pagamento> getListaPagamento() {
        return this.listaPagamento;
    }

    public void setListaPagamento(ArrayList listaPagamento) {
        this.listaPagamento = listaPagamento;
    }
    
}
