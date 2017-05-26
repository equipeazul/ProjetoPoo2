/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.entidades;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pagamento {
    
    private Integer idPagamento;
    private String formaPagamento;
    private Date dtVencimento;
    private Double valor;
    private Date dtPagamento;
    private Double valorPago;
    private String situacao;

    public Integer getIdPagamento() {
        return this.idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtvencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getdtPagamento() {
        return this.dtPagamento;
    }

    public void setdtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public double getValorpago() {
        return this.valorPago;
    }

    public void setValorpago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituação(String situacao) {
        this.situacao = situacao;
    }

}
