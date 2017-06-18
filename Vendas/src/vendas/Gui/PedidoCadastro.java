/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;


import java.util.Date;
import javax.swing.JOptionPane;
import vendas.Excecoes.ExcecaoRegras;
import vendas.entidades.Cliente;
import vendas.entidades.Pedido;
import vendas.entidades.Vendedor;
import vendas.fachada.Fachada;
import vendas.util.Funcao;


/**
 *
 * @author Felipe
 */
public class PedidoCadastro extends TelaCadastro {

    private static TelaCadastro instancia;
    
    private final String DESEJA_EXCLUIR = "Deseja excluir o Pedido ?";
    private final String ATENCAO = "Atenção";
    private final String FOI_EXCLUSO = "Pedido foi  excluso";
    private final String FOI_CADASTRADO = "Pedido foi cadastrado";
    private final String FOI_ALTERADO = "Pedido foi alterado";
    private final String DIGITE_ID = "Digite o ID do pedido";
    private final String VALOR_ID_PEDIDO_INVALIDO = "ID do pedido é invalido";
    private final String VALOR_ID_CLIENTE_INVALIDO = "ID do cliente é invalido";
    private final String VALOR_ID_VENDEDOR_INVALIDO = "ID do vendedor é invalido";
    
        
    /**
     * Creates new form IFrameClientes
     */
    private PedidoCadastro(){
        initComponents();
        configurar(CONSULTA);
    }
    
    @Override
    public void fechar() {
        super.fechar();
        instancia = null;
    }

    public static TelaCadastro abrir(javax.swing.JDesktopPane principal, Boolean modal) {
        proprietario = principal;
        if (instancia == null) {
            instancia = new PedidoCadastro();
            componente = principal.add(instancia);
        }
        instancia.show(800, 450, 140, 20, modal);
        return instancia;
    }
    
    private void configurar(String ac) {
        
        if(ac.equals(CONSULTA)){
            try
            {
                
                Integer id = 0;
                
                //Criar DAO
                Fachada fachada = Fachada.getInstancia();

                if (txtID.getText().equals(VAZIO)) {
                    id = fachada.ultimoPedido();
                }
                else
                {
                    id = Integer.parseInt(txtID.getText());
                }
                
                //Criar Objeto Basico
                Pedido pedido = new Pedido();
                
                if (id != 0) {
                    pedido = fachada.consultarPedido(id);
                    if(pedido != null)
                    {
                       txtID.setText(pedido.getIdPedido().toString());  
                       txtIdCliente.setText(pedido.getCliente().getIdCliente().toString());
                       txtNomeCliente.setText(pedido.getCliente().getNome());
                       txtIdVendedor.setText(pedido.getVendedor().getIdVendedor().toString());
                       txtNomeVendedor.setText(pedido.getVendedor().getNome());
                       txtSituacao.setText(pedido.getSituacao());
                       txtDtVenda.setText(Funcao.DateToString(pedido.getDtVenda()));
                     
                    }
                }
                  
            }catch(ExcecaoRegras ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
           
        }
        
        if (ac.equals(INCLUSAO)){
           // Limpando os campos
            txtID.setText(VAZIO);
        }
        
        if (txtID.getText().equals(VAZIO)){
            txtSituacao.setText(VAZIO);
            txtIdCliente.setText(VAZIO);
            txtNomeCliente.setText(VAZIO);
            txtIdVendedor.setText(VAZIO);
            txtNomeVendedor.setText(VAZIO);
            txtDtVenda.setText(VAZIO);
        }
        
        btnIncluir.setEnabled(ac.equals(CONSULTA));
        btnEditar.setEnabled(ac.equals(CONSULTA) && !txtID.getText().equals(VAZIO));
        btnExcluir.setEnabled(ac.equals(CONSULTA) && !txtID.getText().equals(VAZIO));
        btnSalvar.setEnabled(!ac.equals(CONSULTA));
        btnCancelar.setEnabled(!ac.equals(CONSULTA));
        btnIrPara.setEnabled(ac.equals(CONSULTA));
        btnPesquisar.setEnabled(ac.equals(CONSULTA));
        
        txtIdCliente.setEnabled(!ac.equals(CONSULTA));
        txtDtVenda.setEnabled(!ac.equals(CONSULTA));
        txtIdCliente.setEnabled(!ac.equals(CONSULTA));
        btnPesqCliente.setEnabled(!ac.equals(CONSULTA));
        txtIdVendedor.setEnabled(!ac.equals(CONSULTA));
        btnPesqVendedor.setEnabled(!ac.equals(CONSULTA));
        txtSituacao.setEnabled(!ac.equals(CONSULTA));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnIncluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnIrPara = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSituacao = new javax.swing.JTextField();
        txtDtVenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdVendedor = new javax.swing.JTextField();
        btnPesqCliente = new javax.swing.JButton();
        txtNomeCliente = new javax.swing.JTextField();
        btnPesqVendedor = new javax.swing.JButton();
        txtNomeVendedor = new javax.swing.JTextField();

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnIrPara.setText("Ir para");
        btnIrPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrParaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cadastro de Pedidos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("ID");

        txtID.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Cliente");

        txtSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSituacaoActionPerformed(evt);
            }
        });

        txtDtVenda.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Data da venda");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Vendedor");

        txtIdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdClienteFocusLost(evt);
            }
        });
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setText("Situação");

        txtIdVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdVendedorFocusLost(evt);
            }
        });
        txtIdVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVendedorActionPerformed(evt);
            }
        });

        btnPesqCliente.setText("...");
        btnPesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqClienteActionPerformed(evt);
            }
        });

        txtNomeCliente.setEnabled(false);

        btnPesqVendedor.setText("...");
        btnPesqVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqVendedorActionPerformed(evt);
            }
        });

        txtNomeVendedor.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(276, 276, 276))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesqVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 177, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqCliente)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqVendedor)
                            .addComponent(txtNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        jDesktopPane1.setLayer(btnIncluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnIrPara, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIrPara, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrPara)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(432, 432, 432))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSituacaoActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        configurar(INCLUSAO);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Integer dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, DESEJA_EXCLUIR,ATENCAO,dialogButton);
       
        Pedido pedido = new Pedido();
        pedido.setIdPedido(Integer.parseInt(txtID.getText()));
        pedido.setDtVenda(Funcao.StringToDate(txtDtVenda.getText()));
        pedido.getCliente().setIdCliente(Integer.parseInt(txtIdCliente.getText())); 
        pedido.getVendedor().setIdVendedor(Integer.parseInt(txtIdVendedor.getText())); 
        pedido.setSituacao(txtSituacao.getText());
        
         Fachada fachada = Fachada.getInstancia();
        if(dialogButton == JOptionPane.YES_OPTION){
            try{  
               fachada.excluirPedido(pedido);
           
                txtID.setText(VAZIO);
                configurar(CONSULTA);            
                JOptionPane.showMessageDialog(null, FOI_EXCLUSO);
          }catch(ExcecaoRegras ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
          }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        configurar(ALTERACAO);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    
        Pedido pedido = new Pedido();
        pedido.setDtVenda(Funcao.StringToDate(txtDtVenda.getText()));
        pedido.getCliente().setIdCliente(Integer.parseInt(txtIdCliente.getText())); 
        pedido.getVendedor().setIdVendedor(Integer.parseInt(txtIdVendedor.getText())); 
        pedido.setSituacao(txtSituacao.getText());
        
        Fachada fachada = Fachada.getInstancia();
              
        try{
            if (txtID.getText().equals(VAZIO)){
                fachada.incluirPedido(pedido);
               JOptionPane.showMessageDialog(null, FOI_CADASTRADO);

            
            }else{
                pedido.setIdPedido(Integer.parseInt(txtID.getText()));
                fachada.alterarPedido(pedido);
                JOptionPane.showMessageDialog(null, FOI_ALTERADO);
            }
        }catch(ExcecaoRegras ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        configurar(CONSULTA);
         
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configurar(CONSULTA);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIrParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrParaActionPerformed
        
        Fachada fachada = Fachada.getInstancia();
        
        String strId = JOptionPane.showInputDialog(null, DIGITE_ID);
        
        try
        {
            if (strId != null) {
                Integer id = Integer.parseInt(strId);

                fachada.consultarPedido(id);
                txtID.setText(id.toString());
                configurar(CONSULTA);
            }
        } catch (ExcecaoRegras ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, VALOR_ID_PEDIDO_INVALIDO);
        }
        
    }//GEN-LAST:event_btnIrParaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       //
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtIdVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVendedorActionPerformed

    private void btnPesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqClienteActionPerformed
        ClientePesquisa.abrir(proprietario, true); 
        Integer id = ClientePesquisa.getId();
        if (id > 0) {
            txtIdCliente.setText(id.toString());
            txtNomeCliente.setText(ClientePesquisa.getNome());
        }
    }//GEN-LAST:event_btnPesqClienteActionPerformed

    private void btnPesqVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqVendedorActionPerformed
        VendedorPesquisa.abrir(proprietario, true); 
        Integer id = VendedorPesquisa.getId();
        if (id > 0) {
            txtIdVendedor.setText(id.toString());
            txtNomeVendedor.setText(VendedorPesquisa.getNome());
        }
    }//GEN-LAST:event_btnPesqVendedorActionPerformed

    private void txtIdClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdClienteFocusLost
        Fachada fachada = Fachada.getInstancia();
        
        try
        {
            if (!txtIdCliente.getText().equals(VAZIO)) {
                Integer id = Integer.parseInt(txtIdCliente.getText());

                Cliente cliente = fachada.consultarCliente(id);
                txtNomeCliente.setText(cliente.getNome());
            }
        } catch (ExcecaoRegras ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, VALOR_ID_CLIENTE_INVALIDO);
        } finally {
            txtIdCliente.setText(VAZIO);
        }
    }//GEN-LAST:event_txtIdClienteFocusLost

    private void txtIdVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdVendedorFocusLost
        Fachada fachada = Fachada.getInstancia();
        
        try
        {
            if (!txtIdVendedor.getText().equals(VAZIO)) {
                Integer id = Integer.parseInt(txtIdVendedor.getText());

                Vendedor vendedor = fachada.consultarVendedor(id);
                txtNomeVendedor.setText(vendedor.getNome());
            }
        } catch (ExcecaoRegras ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, VALOR_ID_VENDEDOR_INVALIDO);
        } finally {
            txtIdVendedor.setText(VAZIO);
        }
    }//GEN-LAST:event_txtIdVendedorFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIrPara;
    private javax.swing.JButton btnPesqCliente;
    private javax.swing.JButton btnPesqVendedor;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDtVenda;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdVendedor;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeVendedor;
    private javax.swing.JTextField txtSituacao;
    // End of variables declaration//GEN-END:variables
}
