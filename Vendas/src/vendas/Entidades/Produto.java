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
    
    private Integer idproduto;
    private String descricao;
    private String unidade;
    private Double precovenda;
    private Fabricante fabricante;
    
    public Produto(){
        Fabricante fabricante = new Fabricante();
        
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(Double precovenda) {
        this.precovenda = precovenda;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricantes(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
