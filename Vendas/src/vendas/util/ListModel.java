/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class ListModel  extends AbstractTableModel {

    private ArrayList<ColumnModel> column = new ArrayList<ColumnModel>();
    private ArrayList<IEntityModel> lista;
    
    public ListModel(ArrayList<IEntityModel> lista) {
        this.lista = lista;
    }    
    
    public void addColumn(ColumnModel column) {
        this.column.add(column);  
    }
    
    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }    

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return this.lista.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return this.column.size();
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return this.column.get(indice).getTitle();
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.column.get(columnIndex).getType();
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IEntityModel entity = this.lista.get(rowIndex);
        return null; //entity.getColumn(columnIndex).getValue();

    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        IEntityModel entity = this.lista.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        //entity.getColumn(columnIndex).setValue(aValue));
        
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }    
    
}
