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
public class Cliente implements IEntityModel{
    
    private Integer idCliente;
    private String nome;
    private String cpf;

    public Object get(String name) {
        switch (name.toUpperCase()) {
            case "IDCLIENTE": return getIdCliente();
            case "NOME": return getNome();
            case "CPF": return getCpf();
        }
        return null; 
    }

    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case "IDCLIENTE": 
                setIdCliente((Integer) value);
                break;
            case "NOME":
                setNome((String) value);
                break;
            case "CPF":
                setCpf((String) value);
                break;
        }
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
