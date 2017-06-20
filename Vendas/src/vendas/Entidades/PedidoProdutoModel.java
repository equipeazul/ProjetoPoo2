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
public class PedidoProdutoModel implements IEntityModel {

    private PedidoProduto pedidoProduto;
    
    public static final String IDPRODUTO = "IDPRODUTO";
    public static final String DESCRICAO = "DESCRICAO";
    public static final String UNIDADE = "UNIDADE";
    public static final String VALOR = "VALOR";
    public static final String QUANTIDADE = "QUANTIDADE";
    
    public PedidoProdutoModel(PedidoProduto pedidoProduto){
        this.pedidoProduto = pedidoProduto;
    }

    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDPRODUTO: return this.pedidoProduto.getProduto().getIdProduto();
            case DESCRICAO: return this.pedidoProduto.getProduto().getDescricao();
            case UNIDADE: return this.pedidoProduto.getProduto().getUnidade();
            case VALOR: return this.pedidoProduto.getValor();
            case QUANTIDADE: return this.pedidoProduto.getQuantidade();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDPRODUTO: 
                this.pedidoProduto.getProduto().setIdProduto((Integer) value);
                break;
            case DESCRICAO:
                this.pedidoProduto.getProduto().setDescricao((String) value);
                break;
            case UNIDADE:
                this.pedidoProduto.getProduto().setUnidade((String) value);
                break;
            case VALOR:
                this.pedidoProduto.setValor((Double) value);
                break;
            case QUANTIDADE:
                this.pedidoProduto.setQuantidade((Integer) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<PedidoProduto> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (PedidoProduto item : lista) {
            listModel.add(new PedidoProdutoModel(item));
        }
        return listModel;
    }    
}
