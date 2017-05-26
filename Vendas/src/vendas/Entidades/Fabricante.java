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
public class Fabricante {
    
    private Integer idFabricante;
    private String razaoSocial;
    private String telefone;

    public Integer getidFabricante() {
        return this.idFabricante;
    }

    public void setidFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
