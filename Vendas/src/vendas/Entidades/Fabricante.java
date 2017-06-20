/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Entidades;

/**
 *
 * @author aluno
 */
public class Fabricante {
    
    private Integer idFabricante;
    private String razaoSocial;
    private String telefone;

    public Object get(String name) {
        switch (name.toUpperCase()) {
            case "IDFABRICANTE": return getIdFabricante();
            case "RAZAOSOCIAL": return getRazaoSocial();
            case "TELEFONE": return getTelefone();
        }
        return null; 
    }

    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case "IDFABRICANTE": 
                setIdFabricante((Integer) value);
                break;
            case "RAZAOSOCIAL":
                setRazaoSocial((String) value);
                break;
            case "TELEFONE":
                setTelefone((String) value);
                break;
        }
    }
    
    public Integer getIdFabricante() {
        return this.idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
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
