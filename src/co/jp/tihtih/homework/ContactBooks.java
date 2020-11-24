/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jp.tihtih.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ContactBooks extends javax.swing.JFrame {

    /**
     * Creates new form ContactBooks
     */
    public ContactBooks() {
        initComponents();
        readcsv();
    }

    public void readcsv() {
        FileReader reader;
        List<Contact> con = new ArrayList<>();

        try {

            reader = new FileReader("C:\\Users\\user\\Desktop\\contact.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String str = line.replace("\"", "");
                String[] vs = str.split(",");

                Contact contact = new Contact();
                contact.setCompany(vs[0]);
                contact.setKatagaki(vs[1]);
                contact.setName(vs[2]);
                contact.setEmail(vs[3]);
                con.add(contact);
//                System.out.println(con);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tableModel = (DefaultTableModel) tblContacts.getModel();
//        クリアもう一回読み取り
        tableModel.setRowCount(0);
        for (Contact c : con) {
            tableModel.addRow(new Object[]{c.getCompany(), c.getKatagaki(), c.getName(), c.getEmail()});

        }

    }

    public void importCsv() {

        ContactBookDB db = new ContactBookDB();
        try {
            db.getDBcon();
            FileReader reader;
            reader = new FileReader("C:\\Users\\user\\Desktop\\contact.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String str = line.replace("\"", "");
                String[] vs = str.split(",");

                Contact contact = new Contact();
                contact.setCompany(vs[0]);
                contact.setKatagaki(vs[1]);
                contact.setName(vs[2]);
                contact.setEmail(vs[3]);
                db.addContactBook(contact);
            }
            db.closeDBcon();
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Contact contact) {
        FileReader reader;
        List<Contact> cons = new ArrayList<>();
        ContactBookDB db = new ContactBookDB();
        try {

            reader = new FileReader("C:\\Users\\user\\Desktop\\contact.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String str = line.replace("\"", "");
                String[] vs = str.split(",");

                Contact contacts = new Contact();
                contacts.setCompany(vs[0]);
                contacts.setKatagaki(vs[1]);
                contacts.setName(vs[2]);
                contacts.setEmail(vs[3]);
                cons.add(contacts);
            }

            FileWriter in = new FileWriter("C:\\Users\\user\\Desktop\\contact.csv");
//改csv
            for (Contact co : cons) {
                if (co.getCompany().equals(contact.getCompany())) {
                    co.setCompany(contact.getCompany());
                    co.setKatagaki(contact.getKatagaki());
                    co.setName(contact.getName());
                    co.setEmail(contact.getEmail());
                }
                in.append("\"");
                in.append(co.getCompany());
                in.append("\",\"");
                in.append(co.getKatagaki());
                in.append("\",\"");
                in.append(co.getName());
                in.append("\",\"");
                in.append(co.getEmail());
                in.append("\"");
                in.append("\n");
            }
            in.flush();
            in.close();

            db.getDBcon();
            db.update(contact);

            db.closeDBcon();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        readcsv();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        textCompany = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textKatakaki = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("会社情報管理システム");

        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "会社名", "肩書き", "お名前", "Ｅｍａｉｌ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContacts);

        jLabel1.setText("会社名");

        jLabel2.setText("お名前");

        jLabel3.setText("肩書き");

        jLabel4.setText("Ｅｍａｉｌ");

        btnEdit.setText("編集");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jButton1.setText("追加");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(20, 20, 20)
                        .addComponent(btnEdit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(textName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textKatakaki, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(textKatakaki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(9, 9, 9)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        Contact contact = new Contact();
        contact.setCompany(textCompany.getText());
        contact.setKatagaki(textKatakaki.getText());
        contact.setName(textName.getText());
        contact.setEmail(textEmail.getText());
        ContactBookDB db = new ContactBookDB();

        File csv = new File("C:\\Users\\user\\Desktop\\contact.csv");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(csv));
            String line;

            while ((line = br.readLine()) != null) {
                String str = line.replace("\"", "");
                String[] vs = str.split(",");
                if (!vs[0].equals(contact.getCompany())) {
                    csvAddCols(contact);
                    break;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        int result;
        try {
            db.getDBcon();
//
            result = db.selectCompany(contact.getCompany());
            if (result == 1) {
                jTextField2.setText("sssss");

            } else {
                jTextField2.setText("");
                db.addContactBook(contact);

            }
            db.closeDBcon();
        } catch (SQLException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        readcsv();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void csvAddCols(Contact contact) {

        FileWriter writeCsvLine = null;
        try {
            writeCsvLine = new FileWriter("C:\\Users\\user\\Desktop\\contact.csv", true);
            writeCsvLine.append("\n");
            writeCsvLine.append("\"");
            writeCsvLine.append(contact.getCompany());
            writeCsvLine.append("\",\"");
            writeCsvLine.append(contact.getKatagaki());
            writeCsvLine.append("\",\"");
            writeCsvLine.append(contact.getName());
            writeCsvLine.append("\",\"");
            writeCsvLine.append(contact.getEmail());
            writeCsvLine.append("\"");

            writeCsvLine.flush();
            writeCsvLine.close();
        } catch (IOException ex) {
            Logger.getLogger(ContactBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
//        String id = "1001";
//        //1. result id = select * from userinfo where id = "1001"
//
//        int res = selectUserId(id);
//        if (res == 0) {
//            //2. insert
//            addContactBook();
//        } else {
//            jLabel5.setText("ユーザーが存在しています。");
//        }

        Contact contact = new Contact();
        contact.setCompany(textCompany.getText());
        contact.setKatagaki(textKatakaki.getText());
        contact.setName(textName.getText());
        contact.setEmail(textEmail.getText());
        update(contact);

//        jLabel5.setText("更新完了。");
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMouseClicked
        // TODO add your handling code here:
        textCompany.setText((String) tblContacts.getValueAt(tblContacts.getSelectedRow(), 0));
        textKatakaki.setText((String) tblContacts.getValueAt(tblContacts.getSelectedRow(), 1));
        textName.setText((String) tblContacts.getValueAt(tblContacts.getSelectedRow(), 2));
        textEmail.setText((String) tblContacts.getValueAt(tblContacts.getSelectedRow(), 3));
    }//GEN-LAST:event_tblContactsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        importCsv();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ContactBooks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactBooks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactBooks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactBooks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblContacts;
    private javax.swing.JTextField textCompany;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textKatakaki;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
}
