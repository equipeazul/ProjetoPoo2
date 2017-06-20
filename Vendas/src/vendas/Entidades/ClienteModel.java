/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Entidades;

import java.util.ArrayList;
import vendas.util.IEntityModel;

/**
 *
 * @author Daniel
 */
public class ClienteModel implements IEntityModel {
    
    public static final String IDCLIENTE = "IDCLIENTE";
    public static final String NOME = "NOME";
    public static final String CPF = "CPF";

    private Cliente cliente = null;
    
    public ClienteModel(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDCLIENTE: return this.cliente.getIdCliente();
            case NOME: return this.cliente.getNome();
            case CPF: return this.cliente.getCpf();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDCLIENTE: 
                this.cliente.setIdCliente((Integer) value);
                break;
            case NOME:
                this.cliente.setNome((String) value);
                break;
            case CPF:
                this.cliente.setCpf((String) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Cliente> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Cliente item : lista) {
            listModel.add(new ClienteModel(item));
        }
        return listModel;
    }
}
