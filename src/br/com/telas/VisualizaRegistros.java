/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.SqlConection.ConexaoSql;
import br.com.SqlConection.JTableScroll;
import br.com.SqlConection.ModeloGrid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author welin
 */
public class VisualizaRegistros extends javax.swing.JFrame {

    ConexaoSql conexao = new ConexaoSql(); 
    private JasperPrint jasperPrint;
    
    
    public VisualizaRegistros() {
        initComponents();
        montarTabela("select * from MDGlicemica Order by ID");
        JTableScroll primeiroItem = new JTableScroll();
        primeiroItem.first(jTabela);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        botaoEsquerdo = new javax.swing.JButton();
        botaoDireito = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medições");

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabela);

        botaoEsquerdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/seta_esquerda.png"))); // NOI18N
        botaoEsquerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEsquerdoActionPerformed(evt);
            }
        });

        botaoDireito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/seta_direita.png"))); // NOI18N
        botaoDireito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDireitoActionPerformed(evt);
            }
        });

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botao_Fechar_Novo.png"))); // NOI18N
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botao_Excluir_Novo.png"))); // NOI18N
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone_relatorios.png"))); // NOI18N
        jButton1.setText("Gerar Relatório");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botaoEsquerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(botaoDireito, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addComponent(jScrollPane1)
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoDireito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("VISUALIZAR MEDIÇÕES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(524, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        
      ModeloGrid modelo = (ModeloGrid) jTabela.getModel();
      int index = jTabela.getSelectedRow();
      int id = (int) jTabela.getValueAt(index,0);
      if( index >= 0){
          modelo.removeRow(index);
          jTabela.setModel(modelo);
          conexao.removeRegistro(id);
          JOptionPane.showMessageDialog(null,"Registro Excluido Com Sucesso! ");
      }
      else
          JOptionPane.showMessageDialog(null,"Favor Selecionar uma Linha! ");               
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoEsquerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEsquerdoActionPerformed
        // TODO add your handling code here:
        JTableScroll anterior = new JTableScroll();
        anterior.previous(jTabela);
    }//GEN-LAST:event_botaoEsquerdoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //conexao.geraRelatorio(jasperPrint);
        FiltroRelatorio filtro = new FiltroRelatorio();
        filtro.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoDireitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDireitoActionPerformed
        // TODO add your handling code here:
        JTableScroll proximo = new JTableScroll();
        proximo.next(jTabela);
    }//GEN-LAST:event_botaoDireitoActionPerformed

    public void montarTabela(String SQL){
        
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Manha_Jejum","Manha_Pos","Antes_Almoco","Depois_Almoco","Antes_Jantar","Depois_Jantar","Data"};
        conexao.chamaComandoSQL(SQL);
        
        try {
              conexao.rs.first();
              do{
                  dados.add(new Object[]{conexao.rs.getInt("ID"),conexao.rs.getString("manhajejum"),conexao.rs.getString("manhapos"),conexao.rs.getString("antesalmoco"),conexao.rs.getString("depoisalmoco"),conexao.rs.getString("antesjantar"),conexao.rs.getString("depoisjantar"),conexao.rs.getString("datamedicao")});
                }while(conexao.rs.next());
        } catch (SQLException ex) {
              System.out.println("Não Foi Possível Preencher os Dados do ArrayList!"+ ex);
        }
        
        ModeloGrid modelo = new ModeloGrid(dados, Colunas);
        jTabela.setModel(modelo);
        
        jTabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabela.getColumnModel().getColumn(0).setResizable(false);
        jTabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(1).setResizable(false);
        jTabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(2).setResizable(false);
        jTabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(3).setResizable(false);
        jTabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(4).setResizable(false);
        jTabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(5).setResizable(false);
        jTabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTabela.getColumnModel().getColumn(6).setResizable(false);
        jTabela.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabela.getColumnModel().getColumn(7).setResizable(false);
        jTabela.getTableHeader().setReorderingAllowed(false);
        jTabela.setAutoResizeMode(jTabela.AUTO_RESIZE_OFF);
        jTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
     
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
            java.util.logging.Logger.getLogger(VisualizaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizaRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoDireito;
    private javax.swing.JButton botaoEsquerdo;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    // End of variables declaration//GEN-END:variables
}
