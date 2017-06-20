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
public class ProdutoModel implements IEntityModel {

    private Produto produto;
    
    public static final String IDPRODUTO = "IDPRODUTO";
    public static final String DESCRICAO = "DESCRICAO";
    public static final String UNIDADE = "UNIDADE";
    public static final String PRECOVENDA = "PRECOVENDA";
    public static final String RAZAOSOCIALFABRICANTE = "RAZAOSOCIALFABRICANTE";
    
    public ProdutoModel(Produto produto){
        this.produto = produto;
    }

    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDPRODUTO: return this.produto.getIdProduto();
            case DESCRICAO: return this.produto.getDescricao();
            case UNIDADE: return this.produto.getUnidade();
            case PRECOVENDA: return this.produto.getPrecoVenda();
            case RAZAOSOCIALFABRICANTE: return this.produto.getFabricante().getRazaoSocial();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDPRODUTO: 
                this.produto.setIdProduto((Integer) value);
                break;
            case DESCRICAO:
                this.produto.setDescricao((String) value);
                break;
            case UNIDADE:
                this.produto.setUnidade((String) value);
                break;
            case PRECOVENDA:
                this.produto.setPrecoVenda((Double) value);
                break;
            case RAZAOSOCIALFABRICANTE:
                this.produto.getFabricante().setRazaoSocial((String) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Produto> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Produto item : lista) {
            listModel.add(new ProdutoModel(item));
        }
        return listModel;
    }    
}
