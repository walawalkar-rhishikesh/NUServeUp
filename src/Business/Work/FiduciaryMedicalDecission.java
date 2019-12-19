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
public class FiduciaryMedicalDecission {
    private String fiduciaryMedicalDecission; // APPROVED REJECTED OR NULL
    private String commentOnMedicinesByFiduciary;
    private NUser fiduciaryDecissionBy;

    public String getFiduciaryMedicalDecission() {
        return fiduciaryMedicalDecission;
    }

    public void setFiduciaryMedicalDecission(String fiduciaryMedicalDecission) {
        this.fiduciaryMedicalDecission = fiduciaryMedicalDecission;
    }

    public String getCommentOnMedicinesByFiduciary() {
        return commentOnMedicinesByFiduciary;
    }

    public void setCommentOnMedicinesByFiduciary(String commentOnMedicinesByFiduciary) {
        this.commentOnMedicinesByFiduciary = commentOnMedicinesByFiduciary;
    }
    
    public NUser getFiduciaryDecissionBy() {
        return fiduciaryDecissionBy;
    }

    public void setFiduciaryDecissionBy(NUser fiduciaryDecissionBy) {
        this.fiduciaryDecissionBy = fiduciaryDecissionBy;
    }
    
}
