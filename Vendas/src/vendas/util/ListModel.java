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
public class ListModel extends AbstractTableModel {

    private ArrayList<IEntityModel> lista;
    private ArrayList<String> nameColumn;
    private ArrayList<String> titleColumn;
    private ArrayList<Class> typeColumn;
    
    public ListModel(ArrayList<IEntityModel> lista) {
        this.lista = lista;
        nameColumn = new ArrayList<String>();
        titleColumn = new ArrayList<String>();
        typeColumn = new ArrayList<Class>();
    }    
    
    public void addColumn(String nameColumn, String titleColumn, Class typeColumn) {
        this.nameColumn.add(nameColumn);  
        this.titleColumn.add(titleColumn);  
        this.typeColumn.add(typeColumn);  
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
        return this.nameColumn.size();
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return this.titleColumn.get(indice);
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.typeColumn.get(columnIndex);
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IEntityModel entity = this.lista.get(rowIndex);
        return entity.get(this.nameColumn.get(columnIndex));

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
        entity.set(this.nameColumn.get(columnIndex), aValue);
        
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }    
    
}
