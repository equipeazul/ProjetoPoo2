/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Daniel
 */
public abstract class TelaPesquisa extends JInternalFrame{
        
    protected static java.awt.Component componente;
    protected static javax.swing.JDesktopPane proprietario;
    
    public TelaPesquisa() {
        addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
               fechar();                
            }
        });
    }
        
    public void show(int largura, int altura) {
        this.setResizable(true);
        this.setClosable(true);   
        this.setSize(largura,altura);
        this.setLocation(280, 50);
        this.setVisible(true);
        this.setResizable(false);
        this.setFocusable(true);
        try {
            this.setSelected(true);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Janela foi fechada.");
        } 
    }
      
    
    
    public abstract void fechar();
    
}
