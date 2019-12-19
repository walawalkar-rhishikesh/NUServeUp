/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medical;

import Business.NEUServeUp;
import Business.Util.Helper;
import Business.Work.MedicalCostEstimate;
import Business.Work.MedicalWorkRequest;
import Business.Work.Work;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author rwalawalkar
 */
public class MedicalWorkEstimate extends javax.swing.JPanel {

    private Work work;
    public NEUServeUp neuServeUp;
    MedicalCostEstimate medicalCostEstimate;
    Helper helper;
    /**
     * Creates new form MedicalWorkEstimate
     */
    public MedicalWorkEstimate(Work work) {
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
        
        textFieldNoOfAnalgesics.setText(work.getMedicalWorkRequest().getNumberOfAnalgesics()+"");
        textFieldNoOfAntibiotics.setText(work.getMedicalWorkRequest().getNumberOfAntibiotics()+"");
        textFieldNoOfAntiflue.setText(work.getMedicalWorkRequest().getNumberOfAntiFlue()+"");
        textFieldNoOfAntipyretics.setText(work.getMedicalWorkRequest().getNumberOfAntipyretics()+"");
        textFieldNoOfAntiseptics.setText(work.getMedicalWorkRequest().getNumberOfAntiseptics()+"");
        
        medicalCostEstimate = work.getMedicalCostEstimate();
        if(medicalCostEstimate != null){
            textEstimateAnalgesics.setText(medicalCostEstimate.getCostPerAnalgesics()+"");
            textEstimateAntibiotics.setText(medicalCostEstimate.getCostPerAntibiotics()+"");
            textEstimateAntiflue.setText(medicalCostEstimate.getCostPerAntiFlue()+"");
            textEstimateAntipyretics.setText(medicalCostEstimate.getCostPerAntipyretics()+"");
            textEstimateAntiseptics.setText(medicalCostEstimate.getCostPerAntiseptics()+"");
        }
    }
    
    public void setDefaultButton(){
        if(work.getMedicalCostEstimate() != null && work.getMedicalCostEstimate().isIsMedQuotationSent()){
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
        textEstimateAnalgesics.setEnabled(flag);
        textEstimateAntibiotics.setEnabled(flag);
        textEstimateAntipyretics.setEnabled(flag);
        textEstimateAntiseptics.setEnabled(flag);
        textEstimateAntiflue.setEnabled(flag);
    }
    
    public void setEstimate(boolean isSent){
        if(!helper.isValidQuantity(textEstimateAnalgesics.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Analgesics cost");
            return;
        }
        if(!helper.isValidQuantity(textEstimateAntibiotics.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Antibiotics cost");
            return;
        }
        if(!helper.isValidQuantity(textEstimateAntipyretics.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Antipyretics cost");
            return;
        }
        if(!helper.isValidQuantity(textEstimateAntiseptics.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Antiseptics cost");
            return;
        }
        if(!helper.isValidQuantity(textEstimateAntiflue.getText()) ){
            JOptionPane.showMessageDialog(null, "Please enter valid Antiflue cost");
            return;
        }
        
        
        if(medicalCostEstimate == null){
            medicalCostEstimate = new MedicalCostEstimate();
        }
        
        medicalCostEstimate.setCostPerAnalgesics(helper.stringToInteger(textEstimateAnalgesics.getText()));
        medicalCostEstimate.setCostPerAntiFlue(helper.stringToInteger(textEstimateAntiflue.getText()));
        medicalCostEstimate.setCostPerAntibiotics(helper.stringToInteger(textEstimateAntibiotics.getText()));
        medicalCostEstimate.setCostPerAntipyretics(helper.stringToInteger(textEstimateAntipyretics.getText()));
        medicalCostEstimate.setCostPerAntiseptics(helper.stringToInteger(textEstimateAntiseptics.getText()));
        
        if(isSent){
            medicalCostEstimate.setIsMedQuotationSent(isSent);
            medicalCostEstimate.setEstimateBy(neuServeUp.getuUser());
        }
        
        work.setMedicalCostEstimate(medicalCostEstimate);
        JOptionPane.showMessageDialog(null, "Response recorded");
        setValuesInFields();
        setDefaultButton();
    }
    
    public void toPreviousScreen(){
        CardLayout layout = (CardLayout) this.neuServeUp.getPanelBody().getLayout();
        neuServeUp.getPanelBody().remove(this);
        Component[] comps =  neuServeUp.getPanelBody().getComponents();
        for(Component comp:comps){
            if(comp instanceof MedicalDashboard){
                MedicalDashboard panel = (MedicalDashboard)comp;
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldNoOfAnalgesics = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldNoOfAntiflue = new javax.swing.JTextField();
        textFieldNoOfAntibiotics = new javax.swing.JTextField();
        textFieldNoOfAntiseptics = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textFieldNoOfAntipyretics = new javax.swing.JTextField();
        btnSentEstimate = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        textWorkID = new javax.swing.JTextField();
        textFieldNoOfPeople = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textEstimateAntipyretics = new javax.swing.JTextField();
        textEstimateAnalgesics = new javax.swing.JTextField();
        textEstimateAntiflue = new javax.swing.JTextField();
        textEstimateAntibiotics = new javax.swing.JTextField();
        textEstimateAntiseptics = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSaveEstimate = new javax.swing.JButton();

        setBackground(new java.awt.Color(38, 54, 68));

        jLabel2.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 150, 149));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Medicine List:");

        jLabel3.setFont(new java.awt.Font("Monaco", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 150, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("WORK ESTIMATE");

        jLabel4.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(148, 150, 149));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("No. of Antiflue:");

        textFieldNoOfAnalgesics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfAnalgesics.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfAnalgesics.setEnabled(false);
        textFieldNoOfAnalgesics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfAnalgesicsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(148, 150, 149));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("No. of Antipyretics:");

        jLabel6.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(148, 150, 149));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("No. of Analgesics:");

        jLabel7.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(148, 150, 149));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("No. of Antibiotics:");

        jLabel8.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(148, 150, 149));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("No. of Antiseptics:");

        textFieldNoOfAntiflue.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfAntiflue.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfAntiflue.setEnabled(false);
        textFieldNoOfAntiflue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfAntiflueActionPerformed(evt);
            }
        });

        textFieldNoOfAntibiotics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfAntibiotics.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfAntibiotics.setEnabled(false);
        textFieldNoOfAntibiotics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfAntibioticsActionPerformed(evt);
            }
        });

        textFieldNoOfAntiseptics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfAntiseptics.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfAntiseptics.setEnabled(false);
        textFieldNoOfAntiseptics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfAntisepticsActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(148, 150, 149));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("No. of People:");

        textFieldNoOfAntipyretics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfAntipyretics.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfAntipyretics.setEnabled(false);
        textFieldNoOfAntipyretics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfAntipyreticsActionPerformed(evt);
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

        textFieldNoOfPeople.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textFieldNoOfPeople.setForeground(new java.awt.Color(83, 81, 85));
        textFieldNoOfPeople.setEnabled(false);
        textFieldNoOfPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNoOfPeopleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(148, 150, 149));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Estimate:");

        jLabel10.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(148, 150, 149));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Antiseptics:");

        jLabel11.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(148, 150, 149));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Antibiotics:");

        jLabel12.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(148, 150, 149));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Antiflue:");

        jLabel13.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(148, 150, 149));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Analgesics:");

        jLabel14.setFont(new java.awt.Font("Monaco", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(148, 150, 149));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Antipyretics:");

        textEstimateAntipyretics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textEstimateAntipyretics.setForeground(new java.awt.Color(83, 81, 85));
        textEstimateAntipyretics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstimateAntipyreticsActionPerformed(evt);
            }
        });

        textEstimateAnalgesics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textEstimateAnalgesics.setForeground(new java.awt.Color(83, 81, 85));
        textEstimateAnalgesics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstimateAnalgesicsActionPerformed(evt);
            }
        });

        textEstimateAntiflue.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textEstimateAntiflue.setForeground(new java.awt.Color(83, 81, 85));
        textEstimateAntiflue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstimateAntiflueActionPerformed(evt);
            }
        });

        textEstimateAntibiotics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textEstimateAntibiotics.setForeground(new java.awt.Color(83, 81, 85));
        textEstimateAntibiotics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstimateAntibioticsActionPerformed(evt);
            }
        });

        textEstimateAntiseptics.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        textEstimateAntiseptics.setForeground(new java.awt.Color(83, 81, 85));
        textEstimateAntiseptics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstimateAntisepticsActionPerformed(evt);
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

        btnSaveEstimate.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveEstimate.setFont(new java.awt.Font("Monaco", 0, 13)); // NOI18N
        btnSaveEstimate.setForeground(new java.awt.Color(83, 81, 85));
        btnSaveEstimate.setText("Save Estimates");
        btnSaveEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEstimateActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSentEstimate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textFieldNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldNoOfAnalgesics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNoOfAntiflue, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNoOfAntibiotics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNoOfAntiseptics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNoOfAntipyretics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textWorkID))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textEstimateAnalgesics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEstimateAntiflue, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEstimateAntibiotics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEstimateAntiseptics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEstimateAntipyretics, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(243, 243, 243))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(textFieldNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textFieldNoOfAntipyretics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldNoOfAnalgesics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldNoOfAntiflue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFieldNoOfAntibiotics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textFieldNoOfAntiseptics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(textWorkID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(textEstimateAntipyretics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textEstimateAnalgesics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textEstimateAntiflue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textEstimateAntibiotics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textEstimateAntiseptics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveEstimate)
                    .addComponent(btnSentEstimate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNoOfAnalgesicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfAnalgesicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfAnalgesicsActionPerformed

    private void textFieldNoOfAntiflueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfAntiflueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfAntiflueActionPerformed

    private void textFieldNoOfAntibioticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfAntibioticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfAntibioticsActionPerformed

    private void textFieldNoOfAntisepticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfAntisepticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfAntisepticsActionPerformed

    private void textFieldNoOfAntipyreticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfAntipyreticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfAntipyreticsActionPerformed

    private void btnSentEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSentEstimateActionPerformed
        // TODO add your handling code here:
        setEstimate(true);
    }//GEN-LAST:event_btnSentEstimateActionPerformed

    private void textWorkIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWorkIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWorkIDActionPerformed

    private void textFieldNoOfPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNoOfPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNoOfPeopleActionPerformed

    private void textEstimateAntipyreticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstimateAntipyreticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstimateAntipyreticsActionPerformed

    private void textEstimateAnalgesicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstimateAnalgesicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstimateAnalgesicsActionPerformed

    private void textEstimateAntiflueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstimateAntiflueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstimateAntiflueActionPerformed

    private void textEstimateAntibioticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstimateAntibioticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstimateAntibioticsActionPerformed

    private void textEstimateAntisepticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstimateAntisepticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstimateAntisepticsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        toPreviousScreen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEstimateActionPerformed
        // TODO add your handling code here:
        setEstimate(false);
    }//GEN-LAST:event_btnSaveEstimateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveEstimate;
    private javax.swing.JButton btnSentEstimate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textEstimateAnalgesics;
    private javax.swing.JTextField textEstimateAntibiotics;
    private javax.swing.JTextField textEstimateAntiflue;
    private javax.swing.JTextField textEstimateAntipyretics;
    private javax.swing.JTextField textEstimateAntiseptics;
    private javax.swing.JTextField textFieldNoOfAnalgesics;
    private javax.swing.JTextField textFieldNoOfAntibiotics;
    private javax.swing.JTextField textFieldNoOfAntiflue;
    private javax.swing.JTextField textFieldNoOfAntipyretics;
    private javax.swing.JTextField textFieldNoOfAntiseptics;
    private javax.swing.JTextField textFieldNoOfPeople;
    private javax.swing.JTextField textWorkID;
    // End of variables declaration//GEN-END:variables
}
