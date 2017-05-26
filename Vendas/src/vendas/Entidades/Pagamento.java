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
public class Pagamento {
    
    private Integer idpagamento;
    private String formapagamento;
    private String dtvencimento;
    private Double valor;
    private String dtpagamento;
    private Double valorpago;
    private String situação;

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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

}
