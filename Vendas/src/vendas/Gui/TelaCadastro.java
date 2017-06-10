/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import javax.swing.JInternalFrame;

/**
 *
 * @author Daniel
 */
public abstract class TelaCadastro extends javax.swing.JInternalFrame{
    
    protected static java.awt.Component componente;
    
    protected final String CONSULTA = "C";
    protected final String INCLUSAO = "I";
    protected final String ALTERACAO = "A";
    protected final String EXCLUSAO = "E";
    protected final String VAZIO = "";
    
    public void show(int largura, int altura) {
        this.setResizable(true);
        this.setIconifiable(true);
        this.setClosable(true);   
        this.setSize(largura,altura);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(140, 20);  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void fechar() {
        componente = null;
        this.dispose();
    }
}
