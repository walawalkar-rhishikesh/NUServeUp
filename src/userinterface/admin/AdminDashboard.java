/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.admin;

import Business.NEUServeUp;
import Business.NEUServeUpConfiguration;
import Business.Util.Helper;
import Business.NUserAccount.NUser;
import Business.NUserAccount.NUserDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import userinterface.survey.CreateRequest;


/**
 *
 * @author rwalawalkar
 */
public class AdminDashboard extends javax.swing.JPanel {

    /**
     * Creates new form AdminDashboard
     */
    NEUServeUp neuServeUp;
    public AdminDashboard() {
        initComponents();
        neuServeUp =  NEUServeUp.getInstance();
        populateAdminTable();
    }
    
    
    public void populateAdminTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblAdmin.getModel();
        dtm.setRowCount(0);
        
        for(NUser user : neuServeUp.getUserDirectory().getUserList()){
            if(!user.isIsDeleted()){
                Object[] row = new Object[dtm.getColumnCount()];
                row[0]=user;
                row[1]= user.getnOrganization().getnOrganizationType();

                dtm.addRow(row);
            }
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

        btnCreate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(38, 54, 68));

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(83, 81, 85));
        btnCreate.setText("Create Users");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monaco", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 150, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ADMIN DASHBOARD");

        tblAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        tblAdmin.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        tblAdmin.setForeground(new java.awt.Color(83, 81, 85));
        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Organization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdmin.setGridColor(new java.awt.Color(83, 81, 85));
        tblAdmin.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tblAdmin);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(83, 81, 85));
        btnDelete.setText("Delete Users");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnDelete))
                .addContainerGap(244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        CreateUserLogin createUseerLogin= new CreateUserLogin();
        neuServeUp.getPanelBody().add("CreateUserLogin", createUseerLogin);
        CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
        layout.next(neuServeUp.getPanelBody());
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        if(tblAdmin.getSelectedRow() >= 0){
            NUser user = (NUser) tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0);
            user.setIsDeleted(true);
            populateAdminTable();
            JOptionPane.showMessageDialog(null, "User deleted successfully");
//            AegisWorkDecision clothesWorkEstimate= new AegisWorkDecision(work);
//            neuServeUp.getPanelBody().add("AegisWorkDecision", clothesWorkEstimate);
//            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
//            layout.next(neuServeUp.getPanelBody());
        }else{
            JOptionPane.showMessageDialog(null, "Please select a user");
        }
//        NUserDirectory nUserDirectory = NEUServeUp.getInstance().getUserDirectory();
//        System.out.println(tblAdmin.getColumnName(0));
//        nUserDirectory.userDeletion(tblAdmin.getValueAt(tblAdmin.getRowCount(), 0).toString());
//        populateAdminTable();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdmin;
    // End of variables declaration//GEN-END:variables
}
