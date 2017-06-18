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
public class Produto  implements IEntityModel{
    
    private Integer idProduto;
    private String descricao;
    private String unidade;
    private Double precoVenda;
    private Fabricante fabricante;
    
    public Produto(){
        this.fabricante = new Fabricante();
    }

@Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case "IDPRODUTO": return getIdproduto();
            case "DESCRICAO": return getDescricao();
            case "UNIDADE": return getUnidade();
            case "PRECOVENDA": return getPrecoVenda();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case "IDPRODUTO": 
                setIdProduto((Integer) value);
                break;
            case "DESCRICAO":
                setDescricao((String) value);
                break;
            case "UNIDADE":
                setUnidade((String) value);
                break;
            case "PRECOVENDA":
                setPrecoVenda((Double) value);
                break;
        }
    }
        
    public Integer getIdproduto() {
        return this.idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPrecoVenda() {
        return this.precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
