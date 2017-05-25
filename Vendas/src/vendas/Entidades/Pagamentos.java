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
public class Pagamentos {
    
    private int idpagamento;
    private String formapagamento;
    private String dtvencimento;
    private double valor;
    private String dtpagamento;
    private double valorpago;
    private String situação;
    private Pedidos pedidos;

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(String dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDtpagamento() {
        return dtpagamento;
    }

    public void setDtpagamento(String dtpagamento) {
        this.dtpagamento = dtpagamento;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public String getSituação() {
        return situação;
    }

    public void setSituação(String situação) {
        this.situação = situação;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
