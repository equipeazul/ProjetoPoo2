/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.entidades;

import vendas.util.IEntityModel;

/**
 *
 * @author aluno
 */
public class Vendedor implements IEntityModel{
    
    private Integer idVendedor;
    private String nome;
    private Double comissao;

    public Object get(String name) {
        switch (name.toUpperCase()) {
            case "IDVENDEDOR": return getIdVendedor();
            case "NOME": return getNome();
            case "COMISSAO": return getComissao();
        }
        return null; 
    }

    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case "IDVENDEDOR": 
                setIdVendedor((Integer) value);
                break;
            case "NOME":
                setNome((String) value);
                break;
            case "COMISSAO":
                setComissao((Double) value);
                break;
        }
    }
    
    public Integer getIdVendedor() {
        return this.idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComissao() {
        return this.comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    
}
