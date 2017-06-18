/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.entidades;

import java.util.ArrayList;
import java.util.Date;
import vendas.util.IEntityModel;

/**
 *
 * @author aluno
 */
public class Pedido implements IEntityModel{
    
    private Integer idPedido;
    private Date dtVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private String situacao;
    private ArrayList<PedidoProduto> listaPedidoProduto;
    private ArrayList<Pagamento> listaPagamento;
    
    public Pedido(){
      this.cliente = new Cliente();
      this.vendedor = new Vendedor();
      this.listaPedidoProduto = new ArrayList();
      this.listaPagamento = new ArrayList();
    }

    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case "IDPEDIDO": return getIdPedido();
            case "DTVENDA": return getDtVenda();
            case "NOMECLIENTE": return getCliente().getNome();
            case "NOMEVENDEDOR": return getVendedor().getNome();
            case "SITUACAO": return getSituacao();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case "IDPEDIDO": 
                setIdPedido((Integer) value);
                break;
            case "DTVENDA":
                setDtVenda((Date) value);
                break;
            case "NOMECLIENTE":
                getCliente().setNome((String) value);
                break;
            case "NOMEVENDEDOR":
                getVendedor().setNome((String) value);
                break;
            case "SITUACAO":
                setSituacao((String) value);
                break;
        }
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
    
    public ArrayList getListaPedidoProduto() {
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
