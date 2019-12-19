/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Work;

import Business.NUserAccount.NUser;

/**
 *
 * @author rwalawalkar
 */
public class MedicalCostEstimate {
    private int costPerAntipyretics;
    private int costPerAnalgesics;
    private int costPerAntiFlue;
    private int costPerAntibiotics;
    private int costPerAntiseptics;
    private NUser estimateBy;
    private boolean isMedQuotationSent;
    private String isMedQuotationApproved;// APPROVED || REJECTED
    private boolean isMedReceived;
    private NUser estimateApprovedBy;

    public int getCostPerAntipyretics() {
        return costPerAntipyretics;
    }

    public void setCostPerAntipyretics(int costPerAntipyretics) {
        this.costPerAntipyretics = costPerAntipyretics;
    }

    public int getCostPerAnalgesics() {
        return costPerAnalgesics;
    }

    public void setCostPerAnalgesics(int costPerAnalgesics) {
        this.costPerAnalgesics = costPerAnalgesics;
    }

    public int getCostPerAntiFlue() {
        return costPerAntiFlue;
    }

    public void setCostPerAntiFlue(int costPerAntiFlue) {
        this.costPerAntiFlue = costPerAntiFlue;
    }

    public int getCostPerAntibiotics() {
        return costPerAntibiotics;
    }

    public void setCostPerAntibiotics(int costPerAntibiotics) {
        this.costPerAntibiotics = costPerAntibiotics;
    }

    public int getCostPerAntiseptics() {
        return costPerAntiseptics;
    }

    public void setCostPerAntiseptics(int costPerAntiseptics) {
        this.costPerAntiseptics = costPerAntiseptics;
    }
    
    public NUser getEstimateBy() {
        return estimateBy;
    }

    public void setEstimateBy(NUser estimateBy) {
        this.estimateBy = estimateBy;
    }
    
    public boolean isIsMedQuotationSent() {
        return isMedQuotationSent;
    }

    public void setIsMedQuotationSent(boolean isMedQuotationSent) {
        this.isMedQuotationSent = isMedQuotationSent;
    }

    public String isIsMedQuotationApproved() {
        return isMedQuotationApproved;
    }

    public void setIsMedQuotationApproved(String isMedQuotationApproved) {
        this.isMedQuotationApproved = isMedQuotationApproved;
    }

    public boolean isIsMedReceived() {
        return isMedReceived;
    }

    public void setIsMedReceived(boolean isMedReceived) {
        this.isMedReceived = isMedReceived;
    }

    public NUser getEstimateApprovedBy() {
        return estimateApprovedBy;
    }

    public void setEstimateApprovedBy(NUser estimateApprovedBy) {
        this.estimateApprovedBy = estimateApprovedBy;
    }
}
