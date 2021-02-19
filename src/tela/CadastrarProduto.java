/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import QueryesPesonalizadas.QueryesFornecedor;
import QueryesPesonalizadas.QueryesProduto;
import QueryesPesonalizadas.QueryesUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import modellosUteis.ValidarJanelas;
import modellosUteis.VerificacaoLoginUsuario;
import modelos.Acesso;
import modelos.Factory;
import modelos.Fornecedor;
import modelos.Produto;
import modelos.Usuario;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.eclipse.persistence.queries.InsertObjectQuery;

/**
 *
 * @author Max Cell
 */
public class CadastrarProduto extends javax.swing.JFrame {

    EntityManager em;
    Factory factory = new Factory();
    private static CadastrarProduto CP;
    List<JCheckBox> nova = new ArrayList<>();
    Produto produto = new Produto();
    Acesso acesso = new Acesso();

    public static CadastrarProduto getInstancia() {
        if (CP == null) {

            CP = new CadastrarProduto();
        }
        return CP;
    }

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarProduto() {
        initComponents();
        setLocationRelativeTo(null);
        em = factory.retornaEntidadegerenciada();
        jtfDescriçãoProduto.grabFocus();
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setBackground(Color.getHSBColor(50, 1, 30));
        tableCellRenderer.setForeground(Color.WHITE);
        jSrcolpaneInterno.getViewport().setBackground(Color.WHITE);

        jtableProduto.setRowHeight(28);
        jTableFornecedor.setRowHeight(28);
        ImageIcon iconEmp = new ImageIcon("src/images/growthcode.png");
        iconEmp.setImage(iconEmp.getImage().getScaledInstance(391, 260, 1));
        jlbImgImp.setIcon(iconEmp);
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "salvar");
        jtfPesquisaPorNomeFornecedor.grabFocus();
        jtfDescriçãoProduto.grabFocus();
        
        if(VerificacaoLoginUsuario.userStatic.getAcesso().getId()== VerificacaoLoginUsuario.ADM_SISTEMA ){
            
        }else{
            bloquearItens(false);
        }
        jtfValorVendaProduto.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
               DecimalFormat format = new DecimalFormat();
                  NumberFormatter formatter = new NumberFormatter(format);
                try{
               
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.UNNECESSARY);
               
                formatter.setAllowsInvalid(false);
                formatter.setMaximum(0.00);
                formatter.setMaximum(999999999.99);
               
                }catch(ArithmeticException e){
                    
                }
                 return formatter;
            }
        });
        jtfValorCustoProduto.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                 DecimalFormat format = new DecimalFormat();
                  NumberFormatter formatter = new NumberFormatter(format);
                try{
               
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.UNNECESSARY);
               
                formatter.setAllowsInvalid(false);
                formatter.setMaximum(0.00);
                formatter.setMaximum(999999999.99);
               
                }catch(ArithmeticException e){
                    
                }
                 return formatter;
            }
        });
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRoot = new javax.swing.JPanel();
        PanelPesquisar = new javax.swing.JPanel();
        jbtVoltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfPesquisaPorNomoProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jSrcolpaneInterno = new javax.swing.JScrollPane();
        jtableProduto = new javax.swing.JTable();
        jbtExcluir = new javax.swing.JButton();
        jtfPesquisaPorCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PanelSalvar = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jtfDescriçãoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtSalvar = new javax.swing.JButton();
        jbtPesquisar = new javax.swing.JButton();
        jlbImgImp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfCodigoFornecedor = new javax.swing.JTextField();
        jbtPesquisarForncedor = new javax.swing.JButton();
        jtfQuantidadeEmEstoque = new javax.swing.JTextField();
        jtfValorCustoProduto = new javax.swing.JFormattedTextField();
        jtfValorVendaProduto = new javax.swing.JFormattedTextField();
        panelPesquisaRapida = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtfPesquisaPorNomeFornecedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jSrcolpaneInterno1 = new javax.swing.JScrollPane();
        jTableFornecedor = new javax.swing.JTable();
        jbtVoltarParaSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelRoot.setPreferredSize(new java.awt.Dimension(920, 600));
        PanelRoot.setLayout(new java.awt.CardLayout());

        jbtVoltar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setText("Pesquisa por descrição do produto:");

        jtfPesquisaPorNomoProduto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jtfPesquisaPorNomoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfPesquisaPorNomoProdutoFocusGained(evt);
            }
        });
        jtfPesquisaPorNomoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaPorNomoProdutoKeyPressed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jSrcolpaneInterno.setBackground(new java.awt.Color(102, 102, 255));
        jSrcolpaneInterno.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jSrcolpaneInterno.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSrcolpaneInterno.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N

        jtableProduto.setAutoCreateRowSorter(true);
        jtableProduto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jtableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Descrição do Produto", "Preço de custo", "Preço de venda", "Estoques", "Fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableProduto.setDoubleBuffered(true);
        jtableProduto.setDragEnabled(true);
        jtableProduto.setFillsViewportHeight(true);
        jtableProduto.setFocusCycleRoot(true);
        jtableProduto.setFocusTraversalPolicyProvider(true);
        jtableProduto.setGridColor(new java.awt.Color(0, 51, 255));
        jtableProduto.setInheritsPopupMenu(true);
        jtableProduto.setSurrendersFocusOnKeystroke(true);
        jtableProduto.getTableHeader().setReorderingAllowed(false);
        jtableProduto.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jtableProdutoHierarchyChanged(evt);
            }
        });
        jtableProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtableProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtableProdutoFocusLost(evt);
            }
        });
        jtableProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtableProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtableProdutoKeyReleased(evt);
            }
        });
        jSrcolpaneInterno.setViewportView(jtableProduto);
        if (jtableProduto.getColumnModel().getColumnCount() > 0) {
            jtableProduto.getColumnModel().getColumn(0).setResizable(false);
            jtableProduto.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtableProduto.getColumnModel().getColumn(1).setResizable(false);
            jtableProduto.getColumnModel().getColumn(1).setPreferredWidth(230);
            jtableProduto.getColumnModel().getColumn(2).setResizable(false);
            jtableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtableProduto.getColumnModel().getColumn(3).setResizable(false);
            jtableProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtableProduto.getColumnModel().getColumn(4).setResizable(false);
            jtableProduto.getColumnModel().getColumn(5).setResizable(false);
            jtableProduto.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSrcolpaneInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSrcolpaneInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jbtExcluir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jtfPesquisaPorCodigo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel8.setText("Codigo do Produto:");

        javax.swing.GroupLayout PanelPesquisarLayout = new javax.swing.GroupLayout(PanelPesquisar);
        PanelPesquisar.setLayout(PanelPesquisarLayout);
        PanelPesquisarLayout.setHorizontalGroup(
            PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPesquisarLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPesquisarLayout.createSequentialGroup()
                        .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
                        .addComponent(jbtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(PanelPesquisarLayout.createSequentialGroup()
                        .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPesquisaPorCodigo)
                            .addGroup(PanelPesquisarLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesquisaPorNomoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(75, 75, 75))
        );
        PanelPesquisarLayout.setVerticalGroup(
            PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPesquisarLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPesquisarLayout.createSequentialGroup()
                        .addComponent(jtfPesquisaPorNomoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(PanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtVoltar)
                            .addComponent(jbtExcluir))
                        .addGap(134, 134, 134))
                    .addGroup(PanelPesquisarLayout.createSequentialGroup()
                        .addComponent(jtfPesquisaPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        PanelRoot.add(PanelPesquisar, "pesquisar");

        PanelSalvar.setPreferredSize(new java.awt.Dimension(920, 590));

        jtfDescriçãoProduto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jtfDescriçãoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescriçãoProdutoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Fornecedor do Produto:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Valor de Venda Produto:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Quantidade em Estoque: ");

        jbtSalvar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jbtSalvar.setText("Salvar");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });
        jbtSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtSalvarKeyPressed(evt);
            }
        });

        jbtPesquisar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Descrição do Produto:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Valor de custo do Produto:");

        jtfCodigoFornecedor.setEditable(false);
        jtfCodigoFornecedor.setBackground(new java.awt.Color(153, 255, 255));
        jtfCodigoFornecedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jtfCodigoFornecedor.setDisabledTextColor(new java.awt.Color(51, 51, 255));
        jtfCodigoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoFornecedorActionPerformed(evt);
            }
        });
        jtfCodigoFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodigoFornecedorKeyPressed(evt);
            }
        });

        jbtPesquisarForncedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jbtPesquisarForncedor.setText("Pesquisar");
        jbtPesquisarForncedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarForncedorActionPerformed(evt);
            }
        });
        jbtPesquisarForncedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtPesquisarForncedorKeyPressed(evt);
            }
        });

        jtfQuantidadeEmEstoque.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jtfQuantidadeEmEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQuantidadeEmEstoqueKeyPressed(evt);
            }
        });

        jtfValorCustoProduto.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jtfValorCustoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorCustoProdutoKeyPressed(evt);
            }
        });

        jtfValorVendaProduto.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jtfValorVendaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorVendaProdutoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelSalvarLayout = new javax.swing.GroupLayout(PanelSalvar);
        PanelSalvar.setLayout(PanelSalvarLayout);
        PanelSalvarLayout.setHorizontalGroup(
            PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalvarLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSalvarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSalvarLayout.createSequentialGroup()
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDescriçãoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSalvarLayout.createSequentialGroup()
                                .addComponent(jtfCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtPesquisarForncedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelSalvarLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelSalvarLayout.createSequentialGroup()
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSalvarLayout.createSequentialGroup()
                                .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(PanelSalvarLayout.createSequentialGroup()
                                .addComponent(jtfQuantidadeEmEstoque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jlbImgImp, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSalvarLayout.createSequentialGroup()
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jtfValorCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSalvarLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfValorVendaProduto))))
                .addGap(174, 174, 174))
        );
        PanelSalvarLayout.setVerticalGroup(
            PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalvarLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescriçãoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtPesquisarForncedor))
                .addGap(12, 12, 12)
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorVendaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSalvarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtfQuantidadeEmEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addGroup(PanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtPesquisar)
                            .addComponent(jbtSalvar)))
                    .addGroup(PanelSalvarLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jlbImgImp, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );

        PanelRoot.add(PanelSalvar, "salvar");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setText("Pesquisa por nome:");

        jtfPesquisaPorNomeFornecedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jtfPesquisaPorNomeFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaPorNomeFornecedorActionPerformed(evt);
            }
        });
        jtfPesquisaPorNomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaPorNomeFornecedorKeyPressed(evt);
            }
        });

        jSrcolpaneInterno1.setBackground(new java.awt.Color(102, 102, 255));
        jSrcolpaneInterno1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N

        jTableFornecedor.setAutoCreateRowSorter(true);
        jTableFornecedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo ", "Nome do  Forncedor", "Cidade", "Cpf / cnpj", "Contato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFornecedor.setDoubleBuffered(true);
        jTableFornecedor.setDragEnabled(true);
        jTableFornecedor.setFillsViewportHeight(true);
        jTableFornecedor.setFocusCycleRoot(true);
        jTableFornecedor.setFocusTraversalPolicyProvider(true);
        jTableFornecedor.setGridColor(new java.awt.Color(0, 51, 255));
        jTableFornecedor.setInheritsPopupMenu(true);
        jTableFornecedor.setSurrendersFocusOnKeystroke(true);
        jTableFornecedor.getTableHeader().setReorderingAllowed(false);
        jTableFornecedor.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTableFornecedorHierarchyChanged(evt);
            }
        });
        jTableFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableFornecedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableFornecedorFocusLost(evt);
            }
        });
        jTableFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableFornecedorMousePressed(evt);
            }
        });
        jTableFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableFornecedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableFornecedorKeyReleased(evt);
            }
        });
        jSrcolpaneInterno1.setViewportView(jTableFornecedor);
        if (jTableFornecedor.getColumnModel().getColumnCount() > 0) {
            jTableFornecedor.getColumnModel().getColumn(0).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(1).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(2).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(3).setResizable(false);
            jTableFornecedor.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSrcolpaneInterno1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSrcolpaneInterno1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        jbtVoltarParaSalvar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jbtVoltarParaSalvar.setText("Voltar");
        jbtVoltarParaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarParaSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPesquisaRapidaLayout = new javax.swing.GroupLayout(panelPesquisaRapida);
        panelPesquisaRapida.setLayout(panelPesquisaRapidaLayout);
        panelPesquisaRapidaLayout.setHorizontalGroup(
            panelPesquisaRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisaRapidaLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(panelPesquisaRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtfPesquisaPorNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPesquisaRapidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPesquisaRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtVoltarParaSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        panelPesquisaRapidaLayout.setVerticalGroup(
            panelPesquisaRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisaRapidaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPesquisaPorNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jbtVoltarParaSalvar)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        PanelRoot.add(panelPesquisaRapida, "pesquisaRapida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelRoot.getAccessibleContext().setAccessibleName("root");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "salvar");
        jtfDescriçãoProduto.grabFocus();
        
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jtfPesquisaPorNomoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaPorNomoProdutoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            List<Produto> lista = new ArrayList<>();
            lista = pesquisaPorNomeProduto(jtfPesquisaPorNomoProduto.getText());

            DefaultTableModel dtm = (DefaultTableModel) jtableProduto.getModel();
            for (int i = jtableProduto.getRowCount() - 1; i >= 0; i--) {
                dtm.removeRow(i);
            }
            for (int i = 0; i < lista.size(); i++) {
                dtm.addRow(new Object[]{
                    lista.get(i).getId_produto(),
                    lista.get(i).getDescricao_produto(),
                    lista.get(i).getPreco_custo_produto(),
                    lista.get(i).getPreco_venda_produto(),
                    lista.get(i).getEstoque_produto(),
                    lista.get(i).getFornecedor().getId()

                });

            }

        }
    }//GEN-LAST:event_jtfPesquisaPorNomoProdutoKeyPressed

    private void jtableProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableProdutoKeyPressed

    }//GEN-LAST:event_jtableProdutoKeyPressed

    private void jtableProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtableProdutoFocusLost

    }//GEN-LAST:event_jtableProdutoFocusLost

    private void jtableProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtableProdutoFocusGained


    }//GEN-LAST:event_jtableProdutoFocusGained

    private void jtableProdutoHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jtableProdutoHierarchyChanged

    }//GEN-LAST:event_jtableProdutoHierarchyChanged

    private void jtableProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableProdutoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linha = jtableProduto.getSelectedRow();
            int coluna = jtableProduto.getSelectedColumn();
            editarProduto(linha, coluna);

        }

    }//GEN-LAST:event_jtableProdutoKeyReleased

    private void jtfPesquisaPorNomoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPesquisaPorNomoProdutoFocusGained
        if (jtableProduto.isEditing()) {
            jtableProduto.getCellEditor().stopCellEditing();
        }
    }//GEN-LAST:event_jtfPesquisaPorNomoProdutoFocusGained

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        try {

            int linha = jtableProduto.getSelectedRow();

            int id = Integer.parseInt(jtableProduto.getValueAt(linha, 0).toString());

          Produto produto = new Produto();
            produto = em.find(Produto.class, id);
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir o Produto?", "Janela de confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                 DefaultTableModel dtm = (DefaultTableModel) jtableProduto.getModel();
                
                 dtm.removeRow(linha);
                jtfPesquisaPorNomoProduto.grabFocus();
                jtfPesquisaPorNomoProduto.setText("");
            }
            if (resposta == JOptionPane.NO_OPTION) {
                jtfPesquisaPorNomoProduto.grabFocus();
                jtfPesquisaPorNomoProduto.selectAll();
            }

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum usuario selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
            jtfPesquisaPorNomoProduto.grabFocus();
            jtfPesquisaPorNomoProduto.selectAll();
        }
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarActionPerformed
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "pesquisar");
        jtfPesquisaPorNomoProduto.grabFocus();
    }//GEN-LAST:event_jbtPesquisarActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed

        cadastrar();

    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jtfDescriçãoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescriçãoProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           jbtPesquisarForncedor.grabFocus();
        }
    }//GEN-LAST:event_jtfDescriçãoProdutoKeyPressed

    private void jbtPesquisarForncedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarForncedorActionPerformed
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "pesquisaRapida");
        jtfPesquisaPorNomeFornecedor.grabFocus();
        jtfValorCustoProduto.grabFocus();
    }//GEN-LAST:event_jbtPesquisarForncedorActionPerformed

    private void jtfCodigoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoFornecedorActionPerformed

    }//GEN-LAST:event_jtfCodigoFornecedorActionPerformed

    private void jtfCodigoFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoFornecedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfValorCustoProduto.grabFocus();
        }
    }//GEN-LAST:event_jtfCodigoFornecedorKeyPressed

    private void jtfQuantidadeEmEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeEmEstoqueKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbtSalvar.grabFocus();
        }
    }//GEN-LAST:event_jtfQuantidadeEmEstoqueKeyPressed

    private void jtfPesquisaPorNomeFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaPorNomeFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisaPorNomeFornecedorActionPerformed

    private void jtfPesquisaPorNomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaPorNomeFornecedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            List<Fornecedor> lista = new ArrayList<>();
            lista = pesquisaPorNomeForncedor(jtfPesquisaPorNomeFornecedor.getText());

            DefaultTableModel dtm = (DefaultTableModel) jTableFornecedor.getModel();
            dtm.setNumRows(0);
            for (int i = 0; i < lista.size(); i++) {
                dtm.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNome(),
                    lista.get(i).getCidade(),
                    lista.get(i).getCpfCnpj(),
                    lista.get(i).getContato()
                });

            }

        }
    }//GEN-LAST:event_jtfPesquisaPorNomeFornecedorKeyPressed

    private void jTableFornecedorHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTableFornecedorHierarchyChanged

    }//GEN-LAST:event_jTableFornecedorHierarchyChanged

    private void jTableFornecedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableFornecedorFocusGained

    }//GEN-LAST:event_jTableFornecedorFocusGained

    private void jTableFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableFornecedorFocusLost

    }//GEN-LAST:event_jTableFornecedorFocusLost

    private void jTableFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFornecedorMousePressed
        try {

            int linha = jTableFornecedor.getSelectedRow();
            int resposta = JOptionPane.showConfirmDialog(null, "Forncedor selelionado: " + jTableFornecedor.getValueAt(linha, 1).toString() + "", "Escolha de Fornecedor", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {

                //FornecedorUtil.setForncedorUtil(em.find(Fornecedor.class,jTableFornecedor.getValueAt(linha,0) ));
                jtfCodigoFornecedor.setText(jTableFornecedor.getValueAt(linha, 0).toString());
                CardLayout card = (CardLayout) PanelRoot.getLayout();
                card.show(PanelRoot, "salvar");
                 jtfValorCustoProduto.grabFocus();
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (IndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jTableFornecedorMousePressed

    private void jTableFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFornecedorKeyPressed

    }//GEN-LAST:event_jTableFornecedorKeyPressed

    private void jTableFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFornecedorKeyReleased

    }//GEN-LAST:event_jTableFornecedorKeyReleased

    private void jbtVoltarParaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarParaSalvarActionPerformed
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "salvar");

        jtfDescriçãoProduto.grabFocus();
    }//GEN-LAST:event_jbtVoltarParaSalvarActionPerformed

    private void jbtPesquisarForncedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPesquisarForncedorKeyPressed
          if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        CardLayout card = (CardLayout) PanelRoot.getLayout();
        card.show(PanelRoot, "pesquisaRapida");
        jtfPesquisaPorNomeFornecedor.grabFocus();
        jtfValorCustoProduto.grabFocus();
          }
    }//GEN-LAST:event_jbtPesquisarForncedorKeyPressed

    private void jbtSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSalvarKeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        cadastrar();
       }
    }//GEN-LAST:event_jbtSalvarKeyPressed

    private void jtfValorCustoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorCustoProdutoKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfValorVendaProduto.grabFocus();
        }
    }//GEN-LAST:event_jtfValorCustoProdutoKeyPressed

    private void jtfValorVendaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorVendaProdutoKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfQuantidadeEmEstoque.grabFocus();
        }
    }//GEN-LAST:event_jtfValorVendaProdutoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarProduto().setVisible(true);
            }
        });
    }

    public void cadastrar() {
        int x = 0;
        try {

            produto.setDescricao_produto(jtfDescriçãoProduto.getText());
            produto.setPreco_venda_produto(Double.parseDouble(jtfValorVendaProduto.getText().replaceAll(",", ".")));
            produto.setPreco_custo_produto(Double.parseDouble(jtfValorCustoProduto.getText().replaceAll(",", ".")));

            produto.setEstoque_produto(Integer.parseInt(jtfQuantidadeEmEstoque.getText()));

            produto.setFornecedor(em.find(Fornecedor.class, Integer.parseInt(jtfCodigoFornecedor.getText())));

        } catch (NumberFormatException e) {
            x = 2;
            JOptionPane.showMessageDialog(null, "Existem alguns campos que não foram preenchidos corretamente \n ", "Alerta!", JOptionPane.WARNING_MESSAGE);

        }

        if (jtfDescriçãoProduto.getText().length() <= 0 || jtfValorCustoProduto.getText().length() <= 0
                || jtfValorVendaProduto.getText().length() <= 0 || jtfCodigoFornecedor.getText().length() <= 0
                || jtfQuantidadeEmEstoque.getText().length() <= 0 || jtfCodigoFornecedor.getText().length() <= 0
                || x == 2) {
            JOptionPane.showMessageDialog(null, "Tente corrigir os valores dos campos de acordo com o que se pede!", "Alerta!", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                em.getTransaction().begin();
                em.persist(produto);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Produto Criado com Sucesso!", "alerta", JOptionPane.INFORMATION_MESSAGE);
                em.clear();

                jtfDescriçãoProduto.grabFocus();
                limparCampos();
                produto = new Produto();

            } catch (RollbackException e) {

                JOptionPane.showMessageDialog(null, "Não é possivel cadastrar Produtos  descrição Iguais ", "alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void limparCampos() {
        jtfValorVendaProduto.setText("");
        jtfDescriçãoProduto.setText("");
        jtfValorCustoProduto.setText("");
        jtfQuantidadeEmEstoque.setText("");
        jtfCodigoFornecedor.setText("");
    }

    public void prencherPorId(Produto produto) {
        produto = em.find(Produto.class, produto.getId_produto());
        DefaultTableModel dtm = (DefaultTableModel) jtableProduto.getModel();
        dtm.setNumRows(0);
        dtm.addRow(new Object[]{
            produto.getId_produto(),
            produto.getDescricao_produto(),
            produto.getPreco_custo_produto(),
            produto.getPreco_venda_produto(),
            produto.getEstoque_produto(),
            produto.getFornecedor().getId()
        });
    }

    public List<Usuario> pesquisaPorNome(String nome) {
        QueryesUsuario qu = new QueryesUsuario();
        return qu.retornaUsuariosPorNome(nome);
    }

    public void editarProduto(int linha, int coluna) {

        String conteudo = jtableProduto.getValueAt(linha, coluna) + "";
        Produto produto = new Produto();
        produto.setId_produto(Integer.parseInt(jtableProduto.getValueAt(linha, 0).toString()));
        produto.setDescricao_produto(jtableProduto.getValueAt(linha, 1).toString());
        produto.setPreco_custo_produto(Double.parseDouble(jtableProduto.getValueAt(linha, 2).toString()));
        produto.setPreco_venda_produto(Double.parseDouble(jtableProduto.getValueAt(linha, 3).toString()));
        produto.setEstoque_produto(Integer.parseInt(jtableProduto.getValueAt(linha, 4).toString()));

        produto.setFornecedor(em.find(Fornecedor.class, Integer.parseInt( jtableProduto.getValueAt(linha, 5).toString())));

        try {

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar este Produto?", "Janela de Confimação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.NO_OPTION) {
                prencherPorId(produto);
                jtfPesquisaPorNomoProduto.grabFocus();
                jtfPesquisaPorNomoProduto.selectAll();
            }
            if (resposta == JOptionPane.YES_OPTION) {
                em.getTransaction().begin();
                em.merge(produto);
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Produto Editado com Sucesso!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                prencherPorId(produto);
                jtfPesquisaPorNomoProduto.grabFocus();
                jtfPesquisaPorNomoProduto.selectAll();
            }

        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro na tentativa de edição!");
            jtfPesquisaPorNomoProduto.grabFocus();
        }
    }

    public void zerarLinhasdaTebela() {
        DefaultTableModel dtm = (DefaultTableModel) jtableProduto.getModel();
        dtm.setNumRows(0);
    }

    public List<Fornecedor> pesquisaPorNomeForncedor(String nome) {
        QueryesFornecedor qf = new QueryesFornecedor();
        return qf.retornaForncedorPorNome(nome);
    }

    public List<Produto> pesquisaPorNomeProduto(String nome) {
        QueryesProduto qp = new QueryesProduto();
        return qp.retornaProdutoPorNome(nome);
    }
    public void bloquearItens(boolean b){
        jtfCodigoFornecedor.setEnabled(b);
        jtfDescriçãoProduto.setEnabled(b);
        
        jtfQuantidadeEmEstoque.setEnabled(b);
        jtfValorCustoProduto.setEnabled(b);
        jtfValorVendaProduto.setEnabled(b);
        jbtExcluir.setEnabled(b);
        jbtSalvar.setEnabled(b);
       
        jtableProduto.setEnabled(b);
        jTableFornecedor.setEnabled(b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPesquisar;
    private javax.swing.JPanel PanelRoot;
    private javax.swing.JPanel PanelSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane jSrcolpaneInterno;
    private javax.swing.JScrollPane jSrcolpaneInterno1;
    private javax.swing.JTable jTableFornecedor;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JButton jbtPesquisarForncedor;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JButton jbtVoltarParaSalvar;
    private javax.swing.JLabel jlbImgImp;
    private javax.swing.JTable jtableProduto;
    private javax.swing.JTextField jtfCodigoFornecedor;
    private javax.swing.JTextField jtfDescriçãoProduto;
    private javax.swing.JTextField jtfPesquisaPorCodigo;
    private javax.swing.JTextField jtfPesquisaPorNomeFornecedor;
    private javax.swing.JTextField jtfPesquisaPorNomoProduto;
    private javax.swing.JTextField jtfQuantidadeEmEstoque;
    private javax.swing.JFormattedTextField jtfValorCustoProduto;
    private javax.swing.JFormattedTextField jtfValorVendaProduto;
    private javax.swing.JPanel panelPesquisaRapida;
    // End of variables declaration//GEN-END:variables
}
