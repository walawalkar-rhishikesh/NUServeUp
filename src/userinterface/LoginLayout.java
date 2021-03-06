/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.NEUServeUp;
import Business.NOrganization.NOrganization;
import Business.NOrganization.NOrganization.NOrganizationType;
import Business.NUserAccount.NUser;
import Business.Util.Helper;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import userinterface.admin.AdminDashboard;
import userinterface.aegis.AegisDashboard;
import userinterface.clothes.ClothesDashboard;
import userinterface.fiduciary.FiduciaryDashboard;
import userinterface.medical.MedicalDashboard;
import userinterface.survey.SurveyDashboard;

/**
 *
 * @author rwalawalkar
 */
public class LoginLayout extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    
    public NEUServeUp neuServeUp;
    public Helper helper;
    public LoginLayout() {
        initComponents();
        neuServeUp = NEUServeUp.getInstance();
        helper = new Helper();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        txtFieldPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();

        setBackground(new java.awt.Color(38, 54, 68));

        jLabel2.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 150, 149));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Monaco", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 150, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("LOGIN");

        jLabel4.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(148, 150, 149));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");

        txtFieldEmail.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        txtFieldEmail.setForeground(new java.awt.Color(83, 81, 85));
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });

        txtFieldPassword.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        txtFieldPassword.setForeground(new java.awt.Color(83, 81, 85));
        txtFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPasswordActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(83, 81, 85));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtFieldEmail)))
                .addContainerGap(666, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(914, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btnLogin)
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel3)
                    .addContainerGap(546, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        NUser nUser;
        if(!helper.isValidString(txtFieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "Please enter email");
            return;
        }
        if(!helper.isValidEmail(txtFieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "Please enter valid email");
            return;
        }
        
        if(!helper.isValidString(txtFieldPassword.getText())){
            JOptionPane.showMessageDialog(null, "Please enter password");
            return;
        }
        if(txtFieldEmail.getText().equals("admin@neu.com") ){
            if(txtFieldPassword.getText().equals("admin@neu")){
                NOrganization nOrganization = new NOrganization("Admin", NOrganizationType.Admin);
                nUser = new NUser("admin@neu.com","admin@neu.com","admin@neu",nOrganization);  
                neuServeUp.setuUser(nUser);
                AdminDashboard adminDashboard= new AdminDashboard();
                neuServeUp.getPanelBody().add("AdminDashboard", adminDashboard);
                CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
                layout.next(neuServeUp.getPanelBody());
                return;
            }else{
                JOptionPane.showMessageDialog(null, "Password is incorrect");
                return;
            }
        }
        
        if(!neuServeUp.getUserDirectory().checkIfUserExists(txtFieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "Email address is not registered");
            return;
        }
        if(neuServeUp.getUserDirectory().checkIfUserIsDeleted(txtFieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "User was previously deleted, please contact admin");
            return;
        }
        nUser = neuServeUp.getUserDirectory().userAuthentication(txtFieldEmail.getText(), txtFieldPassword.getText());
        if(nUser == null){
            JOptionPane.showMessageDialog(null, "Password is invalid");
            return;
        }
        neuServeUp.setuUser(nUser);
        
        if(nUser.getnOrganization().getnOrganizationType().getValue().equals("Survey")){
            SurveyDashboard surveyDashboard= new SurveyDashboard();
            neuServeUp.getPanelBody().add("SurveyDashboard", surveyDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        } else if(nUser.getnOrganization().getnOrganizationType().getValue().equals("Fiduciary")){
            FiduciaryDashboard fiduciaryDashboard= new FiduciaryDashboard();
            neuServeUp.getPanelBody().add("FiduciaryDashboard", fiduciaryDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        } else if(nUser.getnOrganization().getnOrganizationType().getValue().equals("Aegis")){
            AegisDashboard aegisDashboard= new AegisDashboard();
            neuServeUp.getPanelBody().add("AegisDashboard", aegisDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        }else if(nUser.getnOrganization().getnOrganizationType().getValue().equals("MedicalAid")){
            MedicalDashboard medicalDashboard= new MedicalDashboard();
            neuServeUp.getPanelBody().add("MedicalDashboard", medicalDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        } else if(nUser.getnOrganization().getnOrganizationType().getValue().equals("ClothesAid")){
            ClothesDashboard clothesDashboard= new ClothesDashboard();
            neuServeUp.getPanelBody().add("ClothesDashboard", clothesDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        } else if(nUser.getnOrganization().getnOrganizationType().getValue().equals("Admin")){
            AdminDashboard adminDashboard= new AdminDashboard();
            neuServeUp.getPanelBody().add("AdminDashboard", adminDashboard);
            CardLayout layout = (CardLayout) neuServeUp.getPanelBody().getLayout();
            layout.next(neuServeUp.getPanelBody());
        } 
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPasswordActionPerformed

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldPassword;
    // End of variables declaration//GEN-END:variables
}
