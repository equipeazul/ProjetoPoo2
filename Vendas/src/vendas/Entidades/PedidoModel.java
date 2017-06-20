/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Entidades;

import java.util.ArrayList;
import java.util.Date;
import vendas.Entidades.Pedido;
import vendas.util.IEntityModel;

/**
 *
 * @author aluno
 */
public class PedidoModel implements IEntityModel {
    
    private Pedido pedido;
    
    public static final String IDPEDIDO = "IDPEDIDO";
    public static final String DTVENDA = "DTVENDA";
    public static final String NOMECLIENTE = "NOMECLIENTE";
    public static final String NOMEVENDEDOR = "NOMEVENDEDOR";
    public static final String SITUACAO = "SITUACAO";
    
    public PedidoModel(Pedido pedido){
      this.pedido = pedido;
    }

    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDPEDIDO: return this.pedido.getIdPedido();
            case DTVENDA: return this.pedido.getDtVenda();
            case NOMECLIENTE: return this.pedido.getCliente().getNome();
            case NOMEVENDEDOR: return this.pedido.getVendedor().getNome();
            case SITUACAO: return this.pedido.getSituacao();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDPEDIDO: 
                this.pedido.setIdPedido((Integer) value);
                break;
            case DTVENDA:
                this.pedido.setDtVenda((Date) value);
                break;
            case NOMECLIENTE:
                this.pedido.getCliente().setNome((String) value);
                break;
            case NOMEVENDEDOR:
                this.pedido.getVendedor().setNome((String) value);
                break;
            case SITUACAO:
                this.pedido.setSituacao((String) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Pedido> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Pedido item : lista) {
            listModel.add(new PedidoModel(item));
        }
        return listModel;
    }    
}
