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
 * @author aluno
 */
public class FabricanteModel implements IEntityModel{
    
    private Fabricante fabricante;
    
    public static final String IDFABRICANTE = "IDFABRICANTE";
    public static final String RAZAOSOCIAL = "RAZAOSOCIAL";
    public static final String TELEFONE = "TELEFONE";
    
    public FabricanteModel(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDFABRICANTE: return this.fabricante.getIdFabricante();
            case RAZAOSOCIAL: return this.fabricante.getRazaoSocial();
            case TELEFONE: return this.fabricante.getTelefone();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDFABRICANTE: 
                this.fabricante.setIdFabricante((Integer) value);
                break;
            case RAZAOSOCIAL:
                this.fabricante.setRazaoSocial((String) value);
                break;
            case TELEFONE:
                this.fabricante.setTelefone((String) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Fabricante> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Fabricante item : lista) {
            listModel.add(new FabricanteModel(item));
        }
        return listModel;
    }    
}
