/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "pedidos", catalog = "vendas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdpedido", query = "SELECT p FROM Pedidos p WHERE p.idpedido = :idpedido")
    , @NamedQuery(name = "Pedidos.findByDtvenda", query = "SELECT p FROM Pedidos p WHERE p.dtvenda = :dtvenda")
    , @NamedQuery(name = "Pedidos.findByIdvendedor", query = "SELECT p FROM Pedidos p WHERE p.idvendedor = :idvendedor")
    , @NamedQuery(name = "Pedidos.findByIdcliente", query = "SELECT p FROM Pedidos p WHERE p.idcliente = :idcliente")
    , @NamedQuery(name = "Pedidos.findBySituacao", query = "SELECT p FROM Pedidos p WHERE p.situacao = :situacao")})
public class Pedidos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private Integer idpedido;
    @Basic(optional = false)
    @Column(name = "DTVENDA")
    @Temporal(TemporalType.DATE)
    private Date dtvenda;
    @Basic(optional = false)
    @Column(name = "IDVENDEDOR")
    private int idvendedor;
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private int idcliente;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private String situacao;

    public Pedidos() {
    }

    public Pedidos(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidos(Integer idpedido, Date dtvenda, int idvendedor, int idcliente, String situacao) {
        this.idpedido = idpedido;
        this.dtvenda = dtvenda;
        this.idvendedor = idvendedor;
        this.idcliente = idcliente;
        this.situacao = situacao;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        Integer oldIdpedido = this.idpedido;
        this.idpedido = idpedido;
        changeSupport.firePropertyChange("idpedido", oldIdpedido, idpedido);
    }

    public Date getDtvenda() {
        return dtvenda;
    }

    public void setDtvenda(Date dtvenda) {
        Date oldDtvenda = this.dtvenda;
        this.dtvenda = dtvenda;
        changeSupport.firePropertyChange("dtvenda", oldDtvenda, dtvenda);
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        int oldIdvendedor = this.idvendedor;
        this.idvendedor = idvendedor;
        changeSupport.firePropertyChange("idvendedor", oldIdvendedor, idvendedor);
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        int oldIdcliente = this.idcliente;
        this.idcliente = idcliente;
        changeSupport.firePropertyChange("idcliente", oldIdcliente, idcliente);
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
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vendas.Gui.Pedidos[ idpedido=" + idpedido + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
