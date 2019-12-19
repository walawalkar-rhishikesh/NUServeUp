/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.fiduciary;

import Business.NEUServeUp;
import Business.Work.Work;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author rwalawalkar
 */
public class FiduciaryDeliveryStatus extends javax.swing.JPanel {

    private Work work;
    public NEUServeUp neuServeUp;
    /**
     * Creates new form FiduciaryDeliveryStatus
     */
    public FiduciaryDeliveryStatus(Work work) {
        initComponents();
        this.work = work;
        neuServeUp = NEUServeUp.getInstance();
        setValuesInFields();
    }
    
    public void setValuesInFields(){
        
        textFieldNoOfPeople.setText(work.getNumberOfPeople()+"");
        textWorkID.setText(work.getWorkId()+"");
        
        textMedicalStatus.setText(work.getMedicalDeliveryStatus().trim().isEmpty()? "No status" : work.getMedicalDeliveryStatus());
        textClothesStatus.setText(work.getClothesDeliveryStatus().trim().isEmpty()? "No status" : work.getClothesDeliveryStatus());
    
        if(textClothesStatus.getText().contains("CLOTHES:AWAITING")){
            setClothesDeliverable(true);
        }else{
            setClothesDeliverable(false);
        }
        
        if(textMedicalStatus.getText().contains("MEDICAL:AWAITING")){
            setMedicalDeliverable(true);
        }else{
            setMedicalDeliverable(false);
        }
    }
    
    public void setMedicalDeliverable(boolean flag){
        btnMedDelivered.setEnabled(flag);
    }
    
    public void setClothesDeliverable(boolean flag){
        textClothesDelivered.setEnabled(flag);
    }
    
    public void toPreviousScreen(){
        CardLayout layout = (CardLayout) this.neuServeUp.getPanelBody().getLayout();
        neuServeUp.getPanelBody().remove(this);
        Component[] comps =  neuServeUp.getPanelBody().getComponents();
        for(Component comp:comps){
            if(comp instanceof FiduciaryDashboard){
                FiduciaryDashboard panel = (FiduciaryDashboard)comp;
                panel.populateAllTables();
            }
        }
        layout.previous(neuServeUp.getPanelBody());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textFieldNoOfPeople = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        textWorkID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textMedicalStatus = new javax.swing.JTextField();
        btnMedDelivered = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textClothesStatus = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        textClothesDelivered = new javax.swing.JButton();

        setBackground(new java.awt.Color(38, 54, 68));

        jLabel3.setFont(new java.awt.Font("Monaco", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 150, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("WORK DELIVERY STATUS");

        jLabel16.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(148, 150, 149));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("No. of People:");

        textFieldNoOfPeople.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfPeople.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfPeople.setEnabled(false);
        textFieldNoOfPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfPeopleActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(148, 150, 149));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Work ID:");

        textWorkID.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textWorkID.setForeground(new java.awt.Color(83, 81, 85));
        textWorkID.setEnabled(false);
        textWorkID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWorkIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 150, 149));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Medicine");

        jLabel5.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(148, 150, 149));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Status:");

        textMedicalStatus.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textMedicalStatus.setForeground(new java.awt.Color(83, 81, 85));
        textMedicalStatus.setEnabled(false);
        textMedicalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMedicalStatusActionPerformed(evt);
            }
        });

        btnMedDelivered.setBackground(new java.awt.Color(255, 255, 255));
        btnMedDelivered.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnMedDelivered.setForeground(new java.awt.Color(83, 81, 85));
        btnMedDelivered.setText("Delivered");
        btnMedDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedDeliveredActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(148, 150, 149));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Clothes");

        jLabel6.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(148, 150, 149));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Status:");

        textClothesStatus.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textClothesStatus.setForeground(new java.awt.Color(83, 81, 85));
        textClothesStatus.setEnabled(false);
        textClothesStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClothesStatusActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(83, 81, 85));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        textClothesDelivered.setBackground(new java.awt.Color(255, 255, 255));
        textClothesDelivered.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textClothesDelivered.setForeground(new java.awt.Color(83, 81, 85));
        textClothesDelivered.setText("Delivered");
        textClothesDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClothesDeliveredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textWorkID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textMedicalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMedDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textClothesStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textClothesDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(textWorkID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textMedicalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMedDelivered))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textClothesStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textClothesDelivered))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNoOfPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPeopleActionPerformed

    private void textWorkIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWorkIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWorkIDActionPerformed

    private void textMedicalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMedicalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMedicalStatusActionPerformed

    private void btnMedDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedDeliveredActionPerformed
        // TODO add your handling code here:
        work.getMedicalCostEstimate().setIsMedReceived(true);
        setValuesInFields();
        JOptionPane.showMessageDialog(null, "Response recorded");
    }//GEN-LAST:event_btnMedDeliveredActionPerformed

    private void textClothesStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClothesStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textClothesStatusActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        toPreviousScreen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void textClothesDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClothesDeliveredActionPerformed
        // TODO add your handling code here:
        work.getClothesCostEstimate().setIsClothesReceived(true);
        setValuesInFields();
        JOptionPane.showMessageDialog(null, "Response recorded");
    }//GEN-LAST:event_textClothesDeliveredActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMedDelivered;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton textClothesDelivered;
    private javax.swing.JTextField textClothesStatus;
    private javax.swing.JTextField textFieldNoOfPeople;
    private javax.swing.JTextField textMedicalStatus;
    private javax.swing.JTextField textWorkID;
    // End of variables declaration//GEN-END:variables
}
