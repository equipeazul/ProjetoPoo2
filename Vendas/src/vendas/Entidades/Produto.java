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
public class Produto {
    
    private Integer idProduto;
    private String descricao;
    private String unidade;
    private Double precoVenda;
    private Fabricante fabricante;
    
    public Produto(){
        this.fabricante = new Fabricante();
    }

    public Integer getIdproduto() {
        return this.idProduto;
    }

    public void setIdproduto(Integer idProduto) {
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

    public Double getPrecovenda() {
        return this.precoVenda;
    }

    public void setPrecovenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public void setFabricantes(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
