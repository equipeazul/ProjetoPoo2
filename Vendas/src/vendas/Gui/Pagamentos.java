/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "pagamentos", catalog = "vendas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pagamentos.findAll", query = "SELECT p FROM Pagamentos p")
    , @NamedQuery(name = "Pagamentos.findByIdpagamento", query = "SELECT p FROM Pagamentos p WHERE p.idpagamento = :idpagamento")
    , @NamedQuery(name = "Pagamentos.findByIdpedido", query = "SELECT p FROM Pagamentos p WHERE p.idpedido = :idpedido")
    , @NamedQuery(name = "Pagamentos.findByFormapagamento", query = "SELECT p FROM Pagamentos p WHERE p.formapagamento = :formapagamento")
    , @NamedQuery(name = "Pagamentos.findByDtvencimento", query = "SELECT p FROM Pagamentos p WHERE p.dtvencimento = :dtvencimento")
    , @NamedQuery(name = "Pagamentos.findByValor", query = "SELECT p FROM Pagamentos p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pagamentos.findByDtpagamento", query = "SELECT p FROM Pagamentos p WHERE p.dtpagamento = :dtpagamento")
    , @NamedQuery(name = "Pagamentos.findByValorpago", query = "SELECT p FROM Pagamentos p WHERE p.valorpago = :valorpago")
    , @NamedQuery(name = "Pagamentos.findBySituacao", query = "SELECT p FROM Pagamentos p WHERE p.situacao = :situacao")})
public class Pagamentos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPAGAMENTO")
    private Integer idpagamento;
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private int idpedido;
    @Basic(optional = false)
    @Column(name = "FORMAPAGAMENTO")
    private String formapagamento;
    @Basic(optional = false)
    @Column(name = "DTVENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtvencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "DTPAGAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtpagamento;
    @Basic(optional = false)
    @Column(name = "VALORPAGO")
    private BigDecimal valorpago;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private String situacao;

    public Pagamentos() {
    }

    public Pagamentos(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public Pagamentos(Integer idpagamento, int idpedido, String formapagamento, Date dtvencimento, BigDecimal valor, Date dtpagamento, BigDecimal valorpago, String situacao) {
        this.idpagamento = idpagamento;
        this.idpedido = idpedido;
        this.formapagamento = formapagamento;
        this.dtvencimento = dtvencimento;
        this.valor = valor;
        this.dtpagamento = dtpagamento;
        this.valorpago = valorpago;
        this.situacao = situacao;
    }

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
        Integer oldIdpagamento = this.idpagamento;
        this.idpagamento = idpagamento;
        changeSupport.firePropertyChange("idpagamento", oldIdpagamento, idpagamento);
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        int oldIdpedido = this.idpedido;
        this.idpedido = idpedido;
        changeSupport.firePropertyChange("idpedido", oldIdpedido, idpedido);
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        String oldFormapagamento = this.formapagamento;
        this.formapagamento = formapagamento;
        changeSupport.firePropertyChange("formapagamento", oldFormapagamento, formapagamento);
    }

    public Date getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(Date dtvencimento) {
        Date oldDtvencimento = this.dtvencimento;
        this.dtvencimento = dtvencimento;
        changeSupport.firePropertyChange("dtvencimento", oldDtvencimento, dtvencimento);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        BigDecimal oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Date getDtpagamento() {
        return dtpagamento;
    }

    public void setDtpagamento(Date dtpagamento) {
        Date oldDtpagamento = this.dtpagamento;
        this.dtpagamento = dtpagamento;
        changeSupport.firePropertyChange("dtpagamento", oldDtpagamento, dtpagamento);
    }

    public BigDecimal getValorpago() {
        return valorpago;
    }

    public void setValorpago(BigDecimal valorpago) {
        BigDecimal oldValorpago = this.valorpago;
        this.valorpago = valorpago;
        changeSupport.firePropertyChange("valorpago", oldValorpago, valorpago);
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        changeSupport.firePropertyChange("situacao", oldSituacao, situacao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagamento != null ? idpagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentos)) {
            return false;
        }
        Pagamentos other = (Pagamentos) object;
        if ((this.idpagamento == null && other.idpagamento != null) || (this.idpagamento != null && !this.idpagamento.equals(other.idpagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vendas.Gui.Pagamentos[ idpagamento=" + idpagamento + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
