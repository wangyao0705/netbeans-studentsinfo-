/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Tstudentmarks extends javax.swing.JFrame {

    /**
     * Creates new form Ｔｓｔｕｄｅｎｔｍａｒｋｓ
     */
    public Tstudentmarks() {
        initComponents();
    }

    public void setid(String id) {
        jLabel6.setText(id);
        Dbstudentinfo db = new Dbstudentinfo();
        List<TeachersLoad> tsl = new ArrayList<>();
        List<TeachersLoad> ts = new ArrayList<>();
        try {
            if (jLabel6.getText().isEmpty()) {
                jComboBox2.addItem("101");
                jComboBox2.addItem("102");
                jComboBox2.addItem("103");
                jComboBox2.addItem("104");
                jComboBox1.addItem("数学");
                jComboBox1.addItem("英語");
                jComboBox1.addItem("国語");
//            } else if (jLabel6.getText().substring(3).equals("00")) {
//                db.getDBcon();
//                tsl = db.selectT(Integer.valueOf(id));
//                for (TeachersLoad tlo : tsl) {
//                    jComboBox2.addItem(tlo.getKurasu());
//                    if (jLabel6.getText().substring(0, 3).equals(tlo.getKurasu())) {
//                        jComboBox1.addItem("数学");
//                        jComboBox1.addItem("英語");
//                        jComboBox1.addItem("国語");
////                    } else {
////                        ts = db.selectTs(Integer.valueOf(id));
////                        for (TeachersLoad tl : ts) {
////                            jComboBox1.addItem(tl.getSubject());
////                        }
//                    }
//                }
//                db.closeDBcon();
            } else {
                db.getDBcon();
                tsl = db.selectT(Integer.valueOf(id));
                ts = db.selectTs(Integer.valueOf(id));
                List<String> sload = new ArrayList<>();

                for (TeachersLoad teachersLoad : tsl) {
                    if (!sload.contains(teachersLoad.getKurasu())) {
                        sload.add(teachersLoad.getKurasu());
                    }
                }
                for (String string : sload) {
                    jComboBox2.addItem(string);
                }
                for (TeachersLoad tl : ts) {
                    jComboBox1.addItem(tl.getSubject());
                }
                db.closeDBcon();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("students成績");

        jLabel1.setText("クラス");

        jLabel2.setText("ＩＤ");

        jButton1.setText("検索");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("成績更新");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("戻る");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        jCheckBox1.setText("期末");

        jCheckBox2.setText("中間テスト");

        jLabel8.setText("科目");

        jLabel3.setText("点数");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "test", "数学", "英語", "国語", "合計"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(484, 484, 484))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jComboBox1, 0, 77, Short.MAX_VALUE)))
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(16, 16, 16)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jLabel6.getText().isEmpty()) {
            Teacher t = new Teacher();
            this.dispose();
            t.setVisible(true);
        }
        if (jLabel6.getText().substring(3).equals("00")) {
            Teacher t = new Teacher();
            t.set(jLabel6.getText());
            this.dispose();
            t.setVisible(true);
        } else {
            Teachers ts = new Teachers();
            ts.set(jLabel6.getText());
            this.dispose();
            ts.setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /*
    検索
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Dbstudentinfo db = new Dbstudentinfo();
        TeachersLoad sl = new TeachersLoad();
        if (!jTextField2.getText().isEmpty()) {
            sl.setId(Integer.valueOf(jTextField2.getText()));
        }
        sl.setKurasu((String) jComboBox2.getSelectedItem());
        List<TeachersLoad> tsl = new ArrayList<>();
        try {
//            idある　idで検索
            if (!jTextField2.getText().isEmpty()) {
                db.getDBcon();
                tsl = db.seisekis(sl.getId());
                if (!tsl.isEmpty()) {
//                    tsl = db.selectstudentseiseki(sl.getId());
                    db.closeDBcon();
//                     if (!tsl.isEmpty()) {
                    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                    tableModel.setRowCount(0);
                    for (TeachersLoad tload : tsl) {
                        tableModel.addRow(new Object[]{tload.getId(), tload.getTest(), tload.getMath(), tload.getEnglish(), tload.getLanguage(), tload.getSum()});
//                    }
                        jLabel7.setText("検索完了");
                    }
                } else {
                    jLabel7.setText("ID存在していません");
                }
            } else {
//                ID入力なし、classで検索
                db.getDBcon();
                tsl = db.joinseiseki(sl.getKurasu());
                db.closeDBcon();
                if (!tsl.isEmpty()) {
                    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                    tableModel.setRowCount(0);
                    for (TeachersLoad tload : tsl) {
                        tableModel.addRow(new Object[]{tload.getId(), tload.getTest(), tload.getMath(), tload.getEnglish(), tload.getLanguage(), tload.getSum()});
                    }
                    jLabel7.setText("検索完了");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /*
    成績検索
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        TeachersLoad tl = new TeachersLoad();
        Dbstudentinfo db = new Dbstudentinfo();
        tl.setId(Integer.valueOf(jTextField2.getText()));
        if (jCheckBox1.isSelected() && !jCheckBox2.isSelected()) {
            tl.setTest(jCheckBox1.getText());
        } else if (jCheckBox2.isSelected() && !jCheckBox1.isSelected()) {
            tl.setTest(jCheckBox2.getText());
        } else if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected()) {
            jLabel7.setText("testが選択してください");
        } else if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            jLabel7.setText("一つtestが選択してください");
        }
        if (Integer.valueOf(jTextField1.getText()) <= 100 && Integer.valueOf(jTextField1.getText()) >= 0) {
            if (jComboBox1.getSelectedItem().equals("数学")) {
                tl.setMath(Integer.valueOf(jTextField1.getText()));
            } else if (jComboBox1.getSelectedItem().equals("英語")) {

                tl.setEnglish(Integer.valueOf(jTextField1.getText()));

            } else if (jComboBox1.getSelectedItem().equals("国語")) {
                tl.setLanguage(Integer.valueOf(jTextField1.getText()));
            }
        } else {
            jLabel7.setText("範囲越え");
        }
//        slo.setSum(slo.getEnglish() + slo.getLanguage() + slo.getMath());
//        List<TeachersLoad> tsl = new ArrayList<>();
//        tsl.add(slo);
        try {
            db.getDBcon();
            int result;
            int res;
            int re;
//            id値ある
            result = db.selectsinfo(tl.getId());
            res = db.selectseiseki(tl.getId(), tl.getTest());
            re = db.selectsinfos(tl.getId());
            if (Integer.valueOf(jTextField1.getText()) <= 100 && Integer.valueOf(jTextField1.getText()) >= 0) {
                if (!tl.getTest().isEmpty()) {
                    if (res == 1) {
                        if (jComboBox1.getSelectedItem().equals("数学")) {
                            db.updatemarkm(tl);
                            db.selectsum(tl.getId(), tl.getTest());
                            jLabel7.setText("更新完了");

                        } else if (jComboBox1.getSelectedItem().equals("英語")) {

                            db.updatemarke(tl);
                            db.selectsum(tl.getId(), tl.getTest());
                            jLabel7.setText("更新完了");

                        } else if (jComboBox1.getSelectedItem().equals("国語")) {

                            db.updatemarkl(tl);
                            db.selectsum(tl.getId(), tl.getTest());
                            jLabel7.setText("更新完了");

                        }

                    } else {
                        if (re == 0) {
                            db.addseisekis(tl);
                            db.selectsum(tl.getId(), tl.getTest());
                            jLabel7.setText("更新完了");

                        } else {

                            db.addSeiseki(tl);
                            db.selectsum(tl.getId(), tl.getTest());
                            jLabel7.setText("更新完了");
                        }
                    }
                    List<TeachersLoad> ts = new ArrayList<>();

                    ts = db.seisekiid(tl.getId());
//                    db.deleteseisekis(tl.getId());

                    if (!ts.isEmpty()) {
                        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                        tableModel.setRowCount(0);
                        for (TeachersLoad tload : ts) {
                            tableModel.addRow(new Object[]{tload.getId(), tload.getTest(), tload.getMath(), tload.getEnglish(), tload.getLanguage(), tload.getSum()});
                            db.closeDBcon();
                        }
                        jLabel7.setText("更新完了");
                    }
                } else {
                    jLabel7.setText("testが選択してください");
                }
            } else {
                jLabel7.setText("範囲超え");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        Dbstudentinfo db = new Dbstudentinfo();
        List<TeachersLoad> tsl = new ArrayList<>();
        try {
            db.getDBcon();
            if (!jLabel6.getText().isEmpty()) {
                tsl = db.selectTsi(Integer.valueOf(jLabel6.getText()), jComboBox2.getSelectedItem().toString());
                jComboBox1.removeAllItems();
                for (TeachersLoad tl : tsl) {
                    jComboBox1.addItem(tl.getSubject());
                }
            }
            db.closeDBcon();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
//        Dbstudentinfo db = new Dbstudentinfo();
//        List<TeachersLoad> tsl = new ArrayList<>();
//        List<TeachersLoad> ts = new ArrayList<>();
//
//        try {
//            db.getDBcon();
//            tsl = db.selectT(Integer.valueOf(jLabel6.getText()));
//            ts = db.selectTs(Integer.valueOf(jLabel6.getText()));
//            for (TeachersLoad tlo : tsl) {
//                jComboBox2.addItem(tlo.getKurasu());
//            }
//            for (TeachersLoad tl : ts) {
//                jComboBox1.addItem(tl.getSubject());
//            }
//            db.closeDBcon();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Tstudentmarks.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jTextField2.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        if (jComboBox1.getSelectedItem().equals(jTable2.getColumnName(2))) {
            jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        }
        if (jComboBox1.getSelectedItem().equals(jTable2.getColumnName(3))) {
            jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        }
        if (jComboBox1.getSelectedItem().equals(jTable2.getColumnName(4))) {
            jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Tstudentmarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tstudentmarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tstudentmarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tstudentmarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Tstudentmarks().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}