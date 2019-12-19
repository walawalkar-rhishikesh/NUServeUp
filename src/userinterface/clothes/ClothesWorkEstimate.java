/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.clothes;

import Business.NEUServeUp;
import Business.Util.Helper;
import Business.Work.ClothesCostEstimate;
import Business.Work.MedicalCostEstimate;
import Business.Work.Work;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author rwalawalkar
 */
public class ClothesWorkEstimate extends javax.swing.JPanel {

    private Work work;
    public NEUServeUp neuServeUp;
    ClothesCostEstimate clothesCostEstimate;
    Helper helper;
    /**
     * Creates new form ClothesWorkEstimate
     */
    public ClothesWorkEstimate(Work work) {
        initComponents();
        this.work = work;
        neuServeUp = NEUServeUp.getInstance();
        setValuesInFields();
        setDefaultButton();
        helper = new Helper();
    }
    
    public void setValuesInFields(){
        
        textFieldNoOfPeople.setText(work.getNumberOfPeople()+"");
        textWorkID.setText(work.getWorkId()+"");
        
        textFieldNoOfPantsL.setText(work.getMedicalWorkRequest().getNumberOfAnalgesics()+"");
        textFieldNoOfPantsM.setText(work.getMedicalWorkRequest().getNumberOfAntibiotics()+"");
        textFieldNoOfPantsS.setText(work.getMedicalWorkRequest().getNumberOfAntiFlue()+"");
        textFieldNoOfShirtsL.setText(work.getMedicalWorkRequest().getNumberOfAntipyretics()+"");
        textFieldNoOfShirtsM.setText(work.getMedicalWorkRequest().getNumberOfAntiseptics()+"");
        textFieldNoOfShirtsS.setText(work.getMedicalWorkRequest().getNumberOfAntiseptics()+"");
        
        clothesCostEstimate = work.getClothesCostEstimate();
        if(clothesCostEstimate != null){
            textFieldPantsEstimate.setText(clothesCostEstimate.getCostPerPants()+"");
            textFieldShirtsEstimate.setText(clothesCostEstimate.getCostPerShirts()+"");
        }
    }
    
    public void setDefaultButton(){
        if(work.getClothesCostEstimate()!= null && work.getClothesCostEstimate().isIsClothesQuotationSent()){
            setMedicalButtons(false);
        }else{
            setMedicalButtons(true);
        }
    }
    
    public void setMedicalButtons(boolean flag){
        btnSaveEstimate.setEnabled(flag);
        btnSentEstimate.setEnabled(flag);
        setEstimateFields(flag);
    }
    
    public void setEstimateFields(boolean flag){
        textFieldPantsEstimate.setEnabled(flag);
        textFieldShirtsEstimate.setEnabled(flag);
    }
    
    public void setEstimate(boolean isSent){
        if(!helper.isValidQuantity(textFieldPantsEstimate.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Pants cost");
            return;
        }
        if(!helper.isValidQuantity(textFieldShirtsEstimate.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Shirts cost");
            return;
        }
        
        
        if(clothesCostEstimate == null){
            clothesCostEstimate = new ClothesCostEstimate();
        }
        
        clothesCostEstimate.setCostPerPants(helper.stringToInteger(textFieldPantsEstimate.getText()));
        clothesCostEstimate.setCostPerShirts(helper.stringToInteger(textFieldShirtsEstimate.getText()));
        
        if(isSent){
            clothesCostEstimate.setIsClothesQuotationSent(isSent);
            clothesCostEstimate.setEstimateBy(neuServeUp.getuUser());
        }
        
        work.setClothesCostEstimate(clothesCostEstimate);
        JOptionPane.showMessageDialog(null, "Response recorded");
        setValuesInFields();
        setDefaultButton();
    }
    
    public void toPreviousScreen(){
        CardLayout layout = (CardLayout) this.neuServeUp.getPanelBody().getLayout();
        neuServeUp.getPanelBody().remove(this);
        Component[] comps =  neuServeUp.getPanelBody().getComponents();
        for(Component comp:comps){
            if(comp instanceof ClothesDashboard){
                ClothesDashboard panel = (ClothesDashboard)comp;
                panel.populateWorkRequeststable();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textFieldNoOfPantsL = new javax.swing.JTextField();
        textFieldNoOfPantsM = new javax.swing.JTextField();
        textFieldNoOfPantsS = new javax.swing.JTextField();
        textFieldNoOfShirtsL = new javax.swing.JTextField();
        textFieldNoOfShirtsM = new javax.swing.JTextField();
        textFieldNoOfShirtsS = new javax.swing.JTextField();
        textWorkID = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textFieldShirtsEstimate = new javax.swing.JTextField();
        textFieldPantsEstimate = new javax.swing.JTextField();
        btnSentEstimate = new javax.swing.JButton();
        btnSaveEstimate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(38, 54, 68));
        setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Monaco", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 150, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("WORK ESTIMATE");

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

        jLabel14.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(148, 150, 149));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Clothes List:");

        jLabel10.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(148, 150, 149));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("No. of Shirt (S):");

        jLabel11.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(148, 150, 149));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("No. of Shirt (M):");

        jLabel9.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(148, 150, 149));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("No. of Shirt (L):");

        jLabel12.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(148, 150, 149));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("No. of Pants (S):");

        jLabel13.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(148, 150, 149));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("No. of Pants (M):");

        jLabel15.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(148, 150, 149));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("No. of Pants (L):");

        textFieldNoOfPantsL.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfPantsL.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfPantsL.setEnabled(false);
        textFieldNoOfPantsL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfPantsLActionPerformed(evt);
            }
        });

        textFieldNoOfPantsM.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfPantsM.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfPantsM.setEnabled(false);
        textFieldNoOfPantsM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfPantsMActionPerformed(evt);
            }
        });

        textFieldNoOfPantsS.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfPantsS.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfPantsS.setEnabled(false);
        textFieldNoOfPantsS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfPantsSActionPerformed(evt);
            }
        });

        textFieldNoOfShirtsL.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfShirtsL.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfShirtsL.setEnabled(false);
        textFieldNoOfShirtsL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfShirtsLActionPerformed(evt);
            }
        });

        textFieldNoOfShirtsM.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfShirtsM.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfShirtsM.setEnabled(false);
        textFieldNoOfShirtsM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfShirtsMActionPerformed(evt);
            }
        });

        textFieldNoOfShirtsS.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfShirtsS.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfShirtsS.setEnabled(false);
        textFieldNoOfShirtsS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfShirtsSActionPerformed(evt);
            }
        });

        textWorkID.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textWorkID.setForeground(new java.awt.Color(83, 81, 85));
        textWorkID.setEnabled(false);
        textWorkID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWorkIDActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(148, 150, 149));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Work ID:");

        jLabel17.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(148, 150, 149));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Estimate");

        jLabel18.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(148, 150, 149));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Per Pants Cost:");

        jLabel20.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(148, 150, 149));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Per Shirts Cost:");

        textFieldShirtsEstimate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldShirtsEstimate.setForeground(new java.awt.Color(83, 81, 85));
        textFieldShirtsEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldShirtsEstimateActionPerformed(evt);
            }
        });

        textFieldPantsEstimate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldPantsEstimate.setForeground(new java.awt.Color(83, 81, 85));
        textFieldPantsEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPantsEstimateActionPerformed(evt);
            }
        });

        btnSentEstimate.setBackground(new java.awt.Color(255, 255, 255));
        btnSentEstimate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnSentEstimate.setForeground(new java.awt.Color(83, 81, 85));
        btnSentEstimate.setText("Send Estimate");
        btnSentEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSentEstimateActionPerformed(evt);
            }
        });

        btnSaveEstimate.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveEstimate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnSaveEstimate.setForeground(new java.awt.Color(83, 81, 85));
        btnSaveEstimate.setText("Save Estimates");
        btnSaveEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEstimateActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNoOfPeople)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textWorkID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldNoOfPantsM, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNoOfPantsS, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNoOfPantsL, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldNoOfShirtsM, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldNoOfShirtsS, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldNoOfShirtsL, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textFieldShirtsEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textFieldPantsEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSentEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(254, 254, 254))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(textFieldNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(textWorkID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textFieldNoOfShirtsS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNoOfShirtsM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNoOfShirtsL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(textFieldPantsEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldShirtsEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(textFieldNoOfPantsS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldNoOfPantsM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldNoOfPantsL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveEstimate)
                    .addComponent(btnSentEstimate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNoOfPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPeopleActionPerformed

    private void textFieldNoOfPantsLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPantsLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPantsLActionPerformed

    private void textFieldNoOfPantsMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPantsMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPantsMActionPerformed

    private void textFieldNoOfPantsSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPantsSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPantsSActionPerformed

    private void textFieldNoOfShirtsLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfShirtsLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfShirtsLActionPerformed

    private void textFieldNoOfShirtsMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfShirtsMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfShirtsMActionPerformed

    private void textFieldNoOfShirtsSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfShirtsSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfShirtsSActionPerformed

    private void textWorkIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWorkIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWorkIDActionPerformed

    private void textFieldShirtsEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldShirtsEstimateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldShirtsEstimateActionPerformed

    private void textFieldPantsEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPantsEstimateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPantsEstimateActionPerformed

    private void btnSentEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSentEstimateActionPerformed
        // TODO add your handling code here:
        setEstimate(true);
    }//GEN-LAST:event_btnSentEstimateActionPerformed

    private void btnSaveEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEstimateActionPerformed
        // TODO add your handling code here:
        setEstimate(false);
    }//GEN-LAST:event_btnSaveEstimateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        toPreviousScreen();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveEstimate;
    private javax.swing.JButton btnSentEstimate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textFieldNoOfPantsL;
    private javax.swing.JTextField textFieldNoOfPantsM;
    private javax.swing.JTextField textFieldNoOfPantsS;
    private javax.swing.JTextField textFieldNoOfPeople;
    private javax.swing.JTextField textFieldNoOfShirtsL;
    private javax.swing.JTextField textFieldNoOfShirtsM;
    private javax.swing.JTextField textFieldNoOfShirtsS;
    private javax.swing.JTextField textFieldPantsEstimate;
    private javax.swing.JTextField textFieldShirtsEstimate;
    private javax.swing.JTextField textWorkID;
    // End of variables declaration//GEN-END:variables
}
