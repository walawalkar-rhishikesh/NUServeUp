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
public class ClothesCostEstimate {
    private int costPerShirts;
    private int costPerPants;
    private int costPerInners;
    private NUser estimateBy;
    private boolean isClothesQuotationSent;
    private String isCLothesQuotationApproved;
    private boolean isClothesReceived;
    private NUser estimateApprovedBy;

    public int getCostPerShirts() {
        return costPerShirts;
    }

    public void setCostPerShirts(int costPerShirts) {
        this.costPerShirts = costPerShirts;
    }

    public int getCostPerPants() {
        return costPerPants;
    }

    public void setCostPerPants(int costPerPants) {
        this.costPerPants = costPerPants;
    }

    public int getCostPerInners() {
        return costPerInners;
    }

    public void setCostPerInners(int costPerInners) {
        this.costPerInners = costPerInners;
    }
    
    public NUser getEstimateBy() {
        return estimateBy;
    }

    public void setEstimateBy(NUser estimateBy) {
        this.estimateBy = estimateBy;
    }
    
    public boolean isIsClothesQuotationSent() {
        return isClothesQuotationSent;
    }

    public void setIsClothesQuotationSent(boolean isClothesQuotationSent) {
        this.isClothesQuotationSent = isClothesQuotationSent;
    }

    public String isIsCLothesQuotationApproved() {
        return isCLothesQuotationApproved;
    }

    public void setIsCLothesQuotationApproved(String isCLothesQuotationApproved) {
        this.isCLothesQuotationApproved = isCLothesQuotationApproved;
    }

    public boolean isIsClothesReceived() {
        return isClothesReceived;
    }

    public void setIsClothesReceived(boolean isClothesReceived) {
        this.isClothesReceived = isClothesReceived;
    }

    public NUser getEstimateApprovedBy() {
        return estimateApprovedBy;
    }

    public void setEstimateApprovedBy(NUser estimateApprovedBy) {
        this.estimateApprovedBy = estimateApprovedBy;
    }
}
