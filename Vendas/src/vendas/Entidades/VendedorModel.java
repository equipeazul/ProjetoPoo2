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
public class VendedorModel implements IEntityModel{
    
    private Vendedor vendedor;
    
    public static final String IDVENDEDOR = "IDVENDEDOR";
    public static final String NOME = "NOME";
    public static final String COMISSAO = "COMISSAO";
    
    public VendedorModel(Vendedor vendedor) {
        this.vendedor = vendedor;        
    }
    
    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDVENDEDOR: return this.vendedor.getIdVendedor();
            case NOME: return this.vendedor.getNome();
            case COMISSAO: return this.vendedor.getComissao();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDVENDEDOR: 
                this.vendedor.setIdVendedor((Integer) value);
                break;
            case NOME:
                this.vendedor.setNome((String) value);
                break;
            case COMISSAO:
                this.vendedor.setComissao((Double) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Vendedor> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Vendedor item : lista) {
            listModel.add(new VendedorModel(item));
        }
        return listModel;
    }    
}
