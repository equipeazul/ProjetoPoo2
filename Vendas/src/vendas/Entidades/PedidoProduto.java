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
public class PedidoProduto {
    
    private Produto produto;
    private Pedido pedido;
    private Double valor;
    private Integer quantidade; 

    
    public PedidoProduto() {
        this.produto = new Produto();
        this.pedido = new Pedido();
    }

        public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }



    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
