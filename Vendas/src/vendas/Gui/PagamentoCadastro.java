/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Entidades.Cliente;
import vendas.Entidades.Pagamento;
import vendas.Entidades.PagamentoModel;
import vendas.Entidades.Pedido;
import vendas.fachada.Fachada;
import vendas.util.ListModel;

/**
 *
 * @author Felipe
 */
public class PagamentoCadastro extends TelaCadastro {

    private static TelaCadastro instancia;
    
    private final String DESEJA_EXCLUIR = "Deseja excluir o cliente ?";
    private final String ATENCAO = "Atenção";
    
    private final String FOI_EXCLUSO = "Cliente foi  excluso";
    private final String FOI_CADASTRADO = "Cliente foi cadastrado";
    private final String FOI_ALTERADO = "Cliente foi alterado";
    private final String DIGITE_ID = "Digite o ID do cliente";
    private final String VALOR_ID_PEDIDO_INVALIDO = "ID do pedido é invalido";
    
    private int itemAtual;
    
    /**
     * Creates new form IFrameClientes
     */
    private PagamentoCadastro(){
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
            instancia = new PagamentoCadastro();
            componente = principal.add(instancia);
        }
        instancia.show(1040, 600, 140, 20, modal);
        return instancia;
    }
    
    private void configurar(String ac) {
        
        if(ac.equals(CONSULTA)){
            try
            {
                Integer id = 0;
                if (txtIDPedido.getText().equals(VAZIO)) {
                   id = 0; 
                } else {
                    id = Integer.parseInt(txtIDPedido.getText());
                }
                
                //Criar DAO
                Fachada fachada = Fachada.getInstancia();

                //Criar Objeto Basico
                Pedido pedido = new Pedido();
                
                if (id != 0) {
                    pedido = fachada.consultarPedido(id, false);
                    if(pedido != null)
                    {
                        txtIDPedido.setText(pedido.getIdPedido().toString());  
                        txtNomeCliente.setText(pedido.getCliente().getNome());
                        txtSituacaoPedido.setText(pedido.getSituacao());
                       
                        ListModel model = new ListModel(PagamentoModel.adapterList(pedido.getListaPagamento()));
                        model.addColumn(PagamentoModel.IDPAGAMENTO, "Id", Integer.class);
                        model.addColumn(PagamentoModel.FORMAPAGAMENTO, "Forma de pagamento", String.class);
                        model.addColumn(PagamentoModel.DTVENCIMENTO, "Data de vencimento", Date.class);
                        model.addColumn(PagamentoModel.VALOR, "Valor", Double.class);
                        model.addColumn(PagamentoModel.DTPAGAMENTO, "Data de pagamento", Date.class);
                        model.addColumn(PagamentoModel.VALORPAGO, "Valor pago", Double.class);
                        model.addColumn(PagamentoModel.SITUACAO, "Situacao", String.class);
            
                        jTable1.setModel(model);
            
                        TableColumnModel columnModel = jTable1.getColumnModel();
                        columnModel.getColumn(0).setMaxWidth(100);
                        
                        if (pedido.getListaPedidoProduto().size() > 0) {
                           if (itemAtual < 0) 
                               itemAtual = 0;
                           
                           if (itemAtual > pedido.getListaPedidoProduto().size()-1)
                               itemAtual = pedido.getListaPedidoProduto().size()-1;
                        } else {
                           itemAtual = -1; 
                        }
                        
                        if (itemAtual > -1) {
                            Pagamento pagamento = pedido.getListaPagamento().get(itemAtual);

                            txtIdPagamento.setText(pagamento.getIdPagamento().toString());
                            txtFormaPagamento.setText(pagamento.getFormaPagamento());
                            txtDtVencimento.setText(pagamento.getDtVencimento().toString());
                            txtValor.setText(pagamento.getValor().toString());
                            txtDtPagamento.setText(pagamento.getDtPagamento().toString());
                            txtValorPago.setText(pagamento.getValorPago().toString());
                            txtSituacao.setText(pagamento.getSituacao());
                            
                            jTable1.setRowSelectionInterval(itemAtual, itemAtual);
                        }
                     
                    }
                }
                  
            }catch(ExcecaoRegras ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
           
        }
        
        if (ac.equals(INCLUSAO) || itemAtual < 0){
           // Limpando os campos
            txtIdPagamento.setText(VAZIO);
        }
        
        if (txtIdPagamento.getText().equals(VAZIO)){
            txtFormaPagamento.setText(VAZIO);
            txtDtVencimento.setText(VAZIO);
            txtValor.setText(VAZIO);
            txtDtPagamento.setText(VAZIO);
            txtValorPago.setText(VAZIO);
            txtSituacao.setText(VAZIO);
        }
        
        btnBuscar.setEnabled(ac.equals(CONSULTA));
        btnIncluir.setEnabled(ac.equals(CONSULTA));
        btnEditar.setEnabled(ac.equals(CONSULTA) && !txtIdPagamento.getText().equals(VAZIO));
        btnExcluir.setEnabled(ac.equals(CONSULTA) && !txtIdPagamento.getText().equals(VAZIO));
        btnSalvar.setEnabled(!ac.equals(CONSULTA));
        btnCancelar.setEnabled(!ac.equals(CONSULTA));
        
        txtFormaPagamento.setEnabled(!ac.equals(CONSULTA));
        txtDtVencimento.setEnabled(!ac.equals(CONSULTA));
        txtValor.setEnabled(!ac.equals(CONSULTA));
        txtDtPagamento.setEnabled(!ac.equals(CONSULTA));
        txtValorPago.setEnabled(!ac.equals(CONSULTA));
        txtSituacao.setEnabled(!ac.equals(CONSULTA));
        
        jTable1.setEnabled(ac.equals(CONSULTA));
        
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
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIdPagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFormaPagamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDtPagamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDtVencimento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSituacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIDPedido = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnPesqPedido = new javax.swing.JButton();
        txtNomeCliente = new javax.swing.JTextField();
        txtSituacaoPedido = new javax.swing.JTextField();
        txtValorTotalPedido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cadastro de pagamentos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("ID");

        txtIdPagamento.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Forma de Pagamento");

        txtFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormaPagamentoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Data Pagamento");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Data Vencimento");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Valor");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Valor Pago");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Situação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtIdPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDtVencimento))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Pedido");

        txtIDPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDPedidoFocusLost(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnPesqPedido.setText("...");
        btnPesqPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqPedidoActionPerformed(evt);
            }
        });

        txtNomeCliente.setEnabled(false);

        txtSituacaoPedido.setEnabled(false);

        txtValorTotalPedido.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Nome cliente");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Situação");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText("Valor total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnPesqPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSituacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtValorTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqPedido)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSituacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btnIncluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaPagamentoActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        configurar(INCLUSAO);
        itemAtual = -1;
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Integer dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, DESEJA_EXCLUIR,ATENCAO,dialogButton);
       
        Cliente cliente = new Cliente();
        cliente.setIdCliente(Integer.parseInt(txtIdPagamento.getText()));
        cliente.setNome(txtFormaPagamento.getText());
        cliente.setCpf(txtDtPagamento.getText()); 
        
         Fachada fachada = Fachada.getInstancia();
        if(dialogButton == JOptionPane.YES_OPTION){
          try{  
               fachada.excluirCliente(cliente);
           
            txtIdPagamento.setText(VAZIO);
            configurar(CONSULTA);            
            JOptionPane.showMessageDialog(null, FOI_EXCLUSO);
          }catch(ExcecaoRegras ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
          }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    
        Cliente cliente = new Cliente();
        cliente.setNome(txtFormaPagamento.getText());
        cliente.setCpf(txtDtPagamento.getText()); 
        
        Fachada fachada = Fachada.getInstancia();
              
        try{
            if (txtIdPagamento.getText().equals(VAZIO)){
                fachada.incluirCliente(cliente);
               JOptionPane.showMessageDialog(null, FOI_CADASTRADO);

            
            }else{
                cliente.setIdCliente(Integer.parseInt(txtIdPagamento.getText()));
                fachada.alterarCliente(cliente);
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        configurar(CONSULTA);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPesqPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqPedidoActionPerformed
        PedidoPesquisa.abrir(proprietario, true); 
        Integer id = PedidoPesquisa.getId();
        if (id > 0) {
            txtIDPedido.setText(id.toString());
            txtNomeCliente.setText(PedidoPesquisa.getNomeCliente());
            txtSituacaoPedido.setText(PedidoPesquisa.getSituacao());
            configurar(CONSULTA);
        }
    }//GEN-LAST:event_btnPesqPedidoActionPerformed

    private void txtIDPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDPedidoFocusLost
        Fachada fachada = Fachada.getInstancia();
        
        try
        {
            if (!txtIDPedido.getText().equals(VAZIO)) {
                Integer id = Integer.parseInt(txtIDPedido.getText());

                Pedido pedido = fachada.consultarPedido(id, false);
                txtNomeCliente.setText(pedido.getCliente().getNome());
                txtSituacaoPedido.setText(pedido.getSituacao());
            }
        } catch (ExcecaoRegras ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
            txtIDPedido.setText(VAZIO);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, VALOR_ID_PEDIDO_INVALIDO);
            txtIDPedido.setText(VAZIO);
        }
    }//GEN-LAST:event_txtIDPedidoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesqPedido;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDtPagamento;
    private javax.swing.JTextField txtDtVencimento;
    private javax.swing.JTextField txtFormaPagamento;
    private javax.swing.JTextField txtIDPedido;
    private javax.swing.JTextField txtIdPagamento;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtSituacao;
    private javax.swing.JTextField txtSituacaoPedido;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorPago;
    private javax.swing.JTextField txtValorTotalPedido;
    // End of variables declaration//GEN-END:variables
}
