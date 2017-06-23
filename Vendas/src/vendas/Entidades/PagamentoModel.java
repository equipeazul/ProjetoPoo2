/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Entidades;

import java.sql.Date;
import java.util.ArrayList;
import vendas.util.IEntityModel;

/**
 *
 * @author Daniel
 */
public class PagamentoModel implements IEntityModel {
    
    public static final String IDPAGAMENTO = "IDPAGAMENTO";
    public static final String FORMAPAGAMENTO = "FORMAPAGAMENTO";
    public static final String DTVENCIMENTO = "DTVENCIMENTO";
    public static final String VALOR = "VALOR";
    public static final String DTPAGAMENTO = "DTPAGAMENTO";
    public static final String VALORPAGO = "VALORPAGO";
    public static final String SITUACAO = "SITUACAO";

    private Pagamento pagamento = null;
    
    public PagamentoModel(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    @Override
    public Object get(String name) {
        switch (name.toUpperCase()) {
            case IDPAGAMENTO: return this.pagamento.getIdPagamento();
            case FORMAPAGAMENTO: return this.pagamento.getFormaPagamento();
            case DTVENCIMENTO: return this.pagamento.getDtVencimento();
            case VALOR: return this.pagamento.getValor();
            case DTPAGAMENTO: return this.pagamento.getDtPagamento();
            case VALORPAGO: return this.pagamento.getValorPago();
            case SITUACAO: return this.pagamento.getSituacao();
        }
        return null; 
    }

    @Override
    public void set(String name, Object value) {
        switch (name.toUpperCase()) {
            case IDPAGAMENTO: 
                this.pagamento.setIdPagamento((Integer) value);
                break;
            case FORMAPAGAMENTO:
                this.pagamento.setFormaPagamento((String) value);
                break;
            case DTVENCIMENTO:
                this.pagamento.setDtVencimento((Date) value);
                break;
            case VALOR:
                this.pagamento.setValor((Double) value);
                break;
            case DTPAGAMENTO:
                this.pagamento.setDtVencimento((Date) value);
                break;
            case VALORPAGO:
                this.pagamento.setValorPago((Double) value);
                break;
            case SITUACAO:
                this.pagamento.setSituacao((String) value);
                break;
        }
    }
    
    public static ArrayList<IEntityModel> adapterList(ArrayList<Pagamento> lista) {
        ArrayList<IEntityModel> listModel = new ArrayList<IEntityModel>();
        for (Pagamento item : lista) {
            listModel.add(new PagamentoModel(item));
        }
        return listModel;
    }
}
