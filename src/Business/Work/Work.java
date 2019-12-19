/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Work;

import Business.NUserAccount.NUser;
import java.sql.Timestamp;
/**
 *
 * @author rwalawalkar
 */
public class Work {
    
    private long workId;
    private int numberOfPeople; 
    ClothesWorkRequest clothesWorkRequest;
    MedicalWorkRequest medicalWorkRequest;

    FiduciaryMedicalDecission fiduciaryMedicalDecission;
    FiduciaryClothesDecission fiduciaryClothesDecission;  

    ClothesCostEstimate clothesCostEstimate;
    MedicalCostEstimate medicalCostEstimate;

    private NUser createdBy;
    private Timestamp createdOn;
    private Timestamp updateOn;

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public ClothesWorkRequest getClothesWorkRequest() {
        return clothesWorkRequest;
    }

    public void setClothesWorkRequest(ClothesWorkRequest clothesWorkRequest) {
        this.clothesWorkRequest = clothesWorkRequest;
    }

    public MedicalWorkRequest getMedicalWorkRequest() {
        return medicalWorkRequest;
    }

    public void setMedicalWorkRequest(MedicalWorkRequest medicalWorkRequest) {
        this.medicalWorkRequest = medicalWorkRequest;
    }

    public FiduciaryMedicalDecission getFiduciaryMedicalDecission() {
        return fiduciaryMedicalDecission;
    }

    public void setFiduciaryMedicalDecission(FiduciaryMedicalDecission fiduciaryMedicalDecission) {
        this.fiduciaryMedicalDecission = fiduciaryMedicalDecission;
    }

    public FiduciaryClothesDecission getFiduciaryClothesDecission() {
        return fiduciaryClothesDecission;
    }

    public void setFiduciaryClothesDecission(FiduciaryClothesDecission fiduciaryClothesDecission) {
        this.fiduciaryClothesDecission = fiduciaryClothesDecission;
    }

    public ClothesCostEstimate getClothesCostEstimate() {
        return clothesCostEstimate;
    }

    public void setClothesCostEstimate(ClothesCostEstimate clothesCostEstimate) {
        this.clothesCostEstimate = clothesCostEstimate;
    }

    public MedicalCostEstimate getMedicalCostEstimate() {
        return medicalCostEstimate;
    }

    public void setMedicalCostEstimate(MedicalCostEstimate medicalCostEstimate) {
        this.medicalCostEstimate = medicalCostEstimate;
    }

    public NUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(NUser createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Timestamp updateOn) {
        this.updateOn = updateOn;
    }
    
    @Override
    public String toString() {
        return workId+"";
    } 
    
    public void setFiduciaryMedDescission(String comment, NUser nUser, boolean flag){
        fiduciaryMedicalDecission = new FiduciaryMedicalDecission();
        fiduciaryMedicalDecission.setCommentOnMedicinesByFiduciary(comment);
        fiduciaryMedicalDecission.setFiduciaryDecissionBy(nUser);
        fiduciaryMedicalDecission.setFiduciaryMedicalDecission(flag ? "APPROVED": "REJECTED");
    }
    
    public void setFiduciaryClothesDescission(String comment, NUser nUser, boolean flag){
        fiduciaryClothesDecission = new FiduciaryClothesDecission();
        fiduciaryClothesDecission.setCommentOnClothesByFiduciary(comment);
        fiduciaryClothesDecission.setFiduciaryDecissionBy(nUser);
        fiduciaryClothesDecission.setFiduciaryClothesDecission(flag ? "APPROVED": "REJECTED");
    }
    
    public void setAegisMedicalDecision(NUser nUser, boolean isApproved){
        medicalCostEstimate.setEstimateApprovedBy(nUser);
        medicalCostEstimate.setIsMedQuotationApproved(isApproved ? "APPROVED" : "REJECTED");
    }
    
    public void setAegisClothesDecision(NUser nUser, boolean isApproved){
        clothesCostEstimate.setEstimateApprovedBy(nUser);
        clothesCostEstimate.setIsCLothesQuotationApproved(isApproved ? "APPROVED" : "REJECTED");
    }
    
    public int getTotalMedicalEstimatedCost(){
        int total =0;
        if(medicalCostEstimate != null){
            total += medicalCostEstimate.getCostPerAnalgesics() * medicalWorkRequest.getNumberOfAnalgesics()
                + medicalCostEstimate.getCostPerAntiFlue() * medicalWorkRequest.getNumberOfAntiFlue()
                + medicalCostEstimate.getCostPerAntibiotics() * medicalWorkRequest.getNumberOfAntibiotics()
                + medicalCostEstimate.getCostPerAntipyretics() * medicalWorkRequest.getNumberOfAntipyretics()
                + medicalCostEstimate.getCostPerAntiseptics() * medicalWorkRequest.getNumberOfAntiseptics();
        }
        return total;
    }
    
    public int getTotalClothesEstimatedCost(){
        int total =0;
        if(clothesCostEstimate != null){
            total += clothesCostEstimate.getCostPerPants() * (clothesWorkRequest.getNumberOfLargePants() + clothesWorkRequest.getNumberOfMediumPants() + clothesWorkRequest.getNumberOfSmallPants())
                + clothesCostEstimate.getCostPerShirts() * (clothesWorkRequest.getNumberOfLargeShirts() + clothesWorkRequest.getNumberOfMediumShirts() + clothesWorkRequest.getNumberOfSmallShirts());
        }
        return total;
    }
    
    public String getAegisApprovalStatusMed(){
        String message = "No estimate from Medical aid";
        if(medicalCostEstimate != null ){
            message = getMedicalCostEstimate().isIsMedQuotationApproved() == null ? "PENDING" : getMedicalCostEstimate().isIsMedQuotationApproved();
        }
        return message;
        
    }
    
    public String getAegisApprovalStatusClothes(){
        String message = "No estimate from Clothes aid";
        if(clothesCostEstimate != null ){
            message = getClothesCostEstimate().isIsCLothesQuotationApproved() == null ? "PENDING" : getClothesCostEstimate().isIsCLothesQuotationApproved();
        }
        return message;
    }
    
    public String getBothDeliveryStatus(){
        String message = "";
        message = getMedicalDeliveryStatus()+" "+getClothesDeliveryStatus();
        return message;
    }
    public String getMedicalDeliveryStatus(){
        String message = "";
        if(medicalCostEstimate != null && medicalCostEstimate.isIsMedQuotationApproved() != null){
            if(medicalCostEstimate.isIsMedQuotationApproved().equalsIgnoreCase("APPROVED")){
                if(medicalCostEstimate.isIsMedReceived()){
                    message = "MEDICAL:RECEIVED";
                }else{
                    message = "MEDICAL:AWAITING";
                }
            }
        }
        return message;
    }
    
    public String getClothesDeliveryStatus(){
        String message = "";
        if(clothesCostEstimate != null && clothesCostEstimate.isIsCLothesQuotationApproved() != null){
            if(clothesCostEstimate.isIsCLothesQuotationApproved().equalsIgnoreCase("APPROVED")){
                if(clothesCostEstimate.isIsClothesReceived()){
                    message = "CLOTHES:RECEIVED";
                }else{
                    message = "CLOTHES:AWAITING";
                }
            }
        }
        return message;
    }
}
