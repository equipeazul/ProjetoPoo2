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
public class PedidosProdutos {
    
    private Pedidos pedidos;
    private Produtos produtos;
    private double valor;
    private int quantidades; // <--- No banco de dados o atributo está em decimal, troque para integer!

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(int quantidades) {
        this.quantidades = quantidades;
    }
    
}
