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
public class Produtos {
    
    private int idproduto;
    private String descricao;
    private String unidade;
    private double precovenda;
    private Fabricantes fabricantes;
    
    public Produtos(){
        Fabricantes c = new Fabricantes();
        
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
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

    public double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public Fabricantes getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(Fabricantes fabricantes) {
        this.fabricantes = fabricantes;
    }
}
